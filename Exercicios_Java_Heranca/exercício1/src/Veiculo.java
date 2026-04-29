public abstract class Veiculo {
    protected String marca;
    protected String modelo;

    public Veiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public void exibirDados(){
        System.out.println("marca: " + marca);
        System.out.println("modelo: " + modelo);
    }
    
}
