package service;

import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Conta;

public class Banco{
    private String superBanco;
    private List<Cliente> clientes;
    private List<Conta> contas;

    public Banco( String superBanco ){
        this.clientes = new ArrayList<>();
        this.contas = new ArrayList<>();
        this.superBanco = superBanco;
       
    }

    public void adicionarCliente(Cliente cliente){
        this.clientes.add(cliente);
    }
    public void adicionarConta(Conta conta){
        this.contas.add(conta);
    }
public Conta buscarContaPorNumero(String numero){
    for (Conta conta : contas){
    if (conta.getNumeroDaConta().equals(numero)){
        return conta;
    }
    }
    return null;
}

public void listarContas(){
    for (Conta conta : contas){
        System.out.println(conta);
    }
 }
public void listarClientes(){
    for (Cliente cliente : clientes){
        System.out.println(cliente);
    }
}
}