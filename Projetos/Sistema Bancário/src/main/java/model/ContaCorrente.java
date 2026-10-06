package model;

import exception.SaldoInsuficienteException;

public class ContaCorrente extends Conta {
   private double limite;
public ContaCorrente( double limite, String numeroDaConta, String agencia, Cliente titular){
    super( numeroDaConta, agencia, titular);
    this.limite = limite;
}
@Override
public void depositar(double valor){
    creditar(valor);
}
@Override
public void sacar(double valor){
    if(valor > getSaldo() + limite){
        throw new SaldoInsuficienteException("Saldo insuficiente. Saldo disponivel: " + getSaldo());
    }
    else debitar(valor);
}
public double getLimite(){
    return limite;
}

}




