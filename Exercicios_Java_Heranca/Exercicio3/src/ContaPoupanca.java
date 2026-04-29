public class ContaPoupanca extends Conta{
    private double taxaSaque = 5.00;

    public ContaPoupanca(int numero, double saldoInicial){
        super(numero, saldoInicial);
    }

    @Override
    public boolean sacar(double valor){
        double valorTotal = valor + taxaSaque;
        
    }
    
}
