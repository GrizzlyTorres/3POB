public class Funcionario {

    protected String nome;
    protected Double salario;

    public Funcionario(String nome, Double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public double calcularBonificacao(){
        return this.salario * 1.10;
    }
    
    public void exibirDados(){
        System.out.println("----------FUNCIONARIO----------");
        System.out.println("Nome: " + nome);
        System.out.println("Salário: R$" + salario);
    }

}
