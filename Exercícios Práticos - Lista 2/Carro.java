public class Carro extends Veiculo implements Tributavel {
    private int quantidadePortas;

    public Carro(String placa, String marca, String modelo, int quantidadePortas) {
        super(placa, marca, modelo);
        if (quantidadePortas <= 0) throw new DomainException("Quantidade de portas inválida.");
        this.quantidadePortas = quantidadePortas;
    }

    @Override
    public double calcularImposto() {
        return 1500.00;
    }

    @Override
    public String formatarParaArquivo() {
        return String.format("CARRO;%s;%s;%s;%d", getPlaca(), getMarca(), getModelo(), quantidadePortas);
    }

    public int getQuantidadePortas() { return quantidadePortas; }
}
