package model;


import exception.CpfInvalidoException;


public class Cliente {
    
private String nome;
private String cpf; 


public Cliente(String nome, String cpf) {
    String apenasNumeros = cpf.replaceAll("[^0-9]", "");
    if (apenasNumeros.length() != 11) {
        throw new CpfInvalidoException("CPF invalido: deve ter 11 digitos");
    }
    this.nome = nome;
    this.cpf = apenasNumeros;
}

public String getNome(){
    return nome;
}

public String getCpf(){
    return cpf;
}
@Override
public String toString() {
    return "Nome: " + nome + "Cpf: " + cpf;
}

}


