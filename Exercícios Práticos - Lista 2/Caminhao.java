public class Caminhao extends Veiculo implements Tributavel {
    private double capacidadeCargaToneladas;

    public Caminhao(String placa, String marca, String modelo, double capacidadeCargaToneladas) {
        super(placa, marca, modelo);
        if (capacidadeCargaToneladas <= 0) throw new DomainException("Capacidade de carga inválida.");
        this.capacidadeCargaToneladas = capacidadeCargaToneladas;
    }

    @Override
    public double calcularImposto() {
        return 2500.00 + (capacidadeCargaToneladas * 100); // Regra fictícia
    }

    @Override
    public String formatarParaArquivo() {
        return String.format("CAMINHAO;%s;%s;%s;%.2f", getPlaca(), getMarca(), getModelo(), capacidadeCargaToneladas);
    }
    
    public double getCapacidadeCargaToneladas() { return capacidadeCargaToneladas; }
}
