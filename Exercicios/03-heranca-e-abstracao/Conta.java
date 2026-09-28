public abstract class Conta {

    private String titular;
    private int numero;
    protected double saldo;

public Conta(String titular, int numero, double saldo){

    this.titular = titular;
    this.numero = numero; 
    this.saldo = saldo;
}

public abstract double aplicarTaxaMensal();

}

