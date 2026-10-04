package model;

public class ContaPoupanca extends Conta{
private double rendimento;

public ContaPoupanca( double rendimento, String numeroDaConta, String agencia, Cliente titular){
    super(numeroDaConta, agencia, titular );
    this.rendimento = rendimento;
}
public void depositar(double valor){
    creditar(valor);
}
@Override
public void sacar(double valor){
    if(getSaldo() < valor){
        System.out.println("Saldo insuficiente. Saldo disponivel: " + getSaldo());
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