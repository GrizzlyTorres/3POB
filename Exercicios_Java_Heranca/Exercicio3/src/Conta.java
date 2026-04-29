public abstract class Conta {
    protected int numero;
    protected double saldo;

    public Conta(int numero, double saldoInicial){
        this.numero = numero;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor){
        if(valor > 0){
            this.saldo += valor;
            System.out.println("Depósito de R$ " + valor + " na conta " + numero + " efetuado.");
        }
    }

    public boolean saque(double valor){
        if(valor>0 && this.saldo >= valor){
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public void exibirSaldo(){
        System.out.println("Conta: " + numero + " | Saldo Atual: R$ " + saldo);
    }
}
