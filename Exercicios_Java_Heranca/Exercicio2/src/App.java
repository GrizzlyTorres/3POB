public class App {
    public static void main(String[] args) throws Exception {
        Gerente gerentezinho = new Gerente("Joao", 1000, "Informatica");
        gerentezinho.exibirDados();
        gerentezinho.calcularBonificacao();
        gerentezinho.exibirDados();
    }
}
