package model;

public class ContaCorrente extends Conta {
   private double limite;
public ContaCorrente( double limite, String numeroDaConta, String agencia, Cliente titular){
    super( numeroDaConta, agencia, titular);
    this.limite = limite;
}
public void depositar(double valor){
    creditar(valor);
}
@Override
public void sacar(double valor){
    if(valor > getSaldo() + limite){
        System.out.println("valor insuficiente");
    }
    else debitar(valor);
}
public double getLimite(){
    return limite;
}

}




