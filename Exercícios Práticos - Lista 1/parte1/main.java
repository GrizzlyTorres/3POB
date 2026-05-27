public class Main{
    public static void main(String[] args) {
        Funcionario f1 = new Gerente("Alice", 5000.00, 2000.00);
        Funcionario f2 = new Desenvolvedor("Bob", 3500.00, 10);

        System.out.println("--- Folha de Pagamento ---");
        System.out.printf("Funcionário: %s | Salário Final: R$ %.2f\n", f1.getNome(), f1.calcularSalario());
        System.out.printf("Funcionário: %s | Salário Final: R$ %.2f\n", f2.getNome(), f2.calcularSalario());
    }
}
