package model;

import exception.SaldoInsuficienteException;

public class ContaPoupanca extends Conta{
private double rendimento;

public ContaPoupanca( double rendimento, String numeroDaConta, String agencia, Cliente titular){
    super(numeroDaConta, agencia, titular );
    this.rendimento = rendimento;
}
@Override
public void depositar(double valor){
    creditar(valor);
}
@Override
public void sacar(double valor){
    if(getSaldo() < valor){
        throw new SaldoInsuficienteException("Saldo insuficiente. Saldo disponivel: " + getSaldo());
    }
    else debitar(valor);
}
public void aplicarRendimento(){
     double valorRendimento = getSaldo() * rendimento;
     creditar(valorRendimento);
}
public double getRendimento(){
    return rendimento;
}
}