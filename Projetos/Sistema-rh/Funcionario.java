public abstract class Funcionario {

    private String nome;
    private String cpf;
    protected double salarioBase;

public Funcionario(String nome, String cpf, double salarioBase ){

        this.nome = nome;
        this.cpf = cpf;
        this.salarioBase = salarioBase;
}

public abstract double calcularSalarioFinal();

}
    

