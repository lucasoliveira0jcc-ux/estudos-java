package model;

public abstract class Conta{

    private String numeroDaConta;
    private String agencia;
    private double saldo;
    private Cliente titular;

public Conta(String numeroDaConta, String agencia, Cliente titular){
    this.numeroDaConta = numeroDaConta;
    this.agencia = agencia;
    this.saldo = 0.0;
    this.titular = titular;
}

public String getNumeroDaConta(){
    return numeroDaConta;
}
public String getAgencia(){
    return agencia;
}
public double getSaldo(){
    return saldo;
}
public Cliente getTitular(){
    return titular;
}
@Override
public String toString(){
    return "numeroDaConta: " + numeroDaConta + " agencia " + agencia + " saldo " + saldo + " cliente " + titular;
}
public abstract void sacar(double valor);

protected void creditar(double valor){
    this.saldo = this.saldo + valor;
}
protected void debitar(double valor){
    this.saldo = this.saldo - valor;
}
}