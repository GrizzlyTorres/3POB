public abstract class Veiculo {
    private String placa;
    private String marca;
    private String modelo;

    public Veiculo(String placa, String marca, String modelo) {
        validarPlaca(placa);
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
    }

    private void validarPlaca(String placa) {
        if (placa == null || placa.trim().isEmpty() || placa.length() < 7) {
            throw new DomainException("Placa inválida. A placa deve conter pelo menos 7 caracteres.");
        }
    }

    public String getPlaca() { return placa; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }

    public abstract String formatarParaArquivo();
}
