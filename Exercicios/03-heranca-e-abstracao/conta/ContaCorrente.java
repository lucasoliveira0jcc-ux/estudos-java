public class ContaCorrente extends Conta {

    private double limite;

    public ContaCorrente(String titular, int numero, double saldo, double limite) {
        super(titular, numero, saldo);
        this.limite = limite;
       
    }

    
    @Override
    public double aplicarTaxaMensal() {
        this.saldo -= 15.0;
        return this.saldo;
    }

}