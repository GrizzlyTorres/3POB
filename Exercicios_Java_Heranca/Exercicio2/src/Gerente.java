public class Gerente extends Funcionario{
    
    private String departamento;

    public Gerente(String nome, double salario, String departamento){
        super(nome, salario);
        this.departamento = departamento;
    }

    @Override
    public double calcularBonificacao(){
        return this.salario = super.calcularBonificacao() + 1000;
    }

    @Override
    public void exibirDados(){
        super.exibirDados();
        System.out.println("Departamento: " + departamento);
    }

}
