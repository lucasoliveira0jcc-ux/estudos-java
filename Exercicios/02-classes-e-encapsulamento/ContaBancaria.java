public class ContaBancaria {

    // 1. ATRIBUTOS PRIVADOS
    private String titular;
    private String numeroConta;
    private double saldo;

    // 2. CONSTRUTOR
    public ContaBancaria(String titular, String numeroConta) {
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.saldo = 0.0;
    }

    // 3. MÉTODOS DE NEGÓCIO

    // Método para depositar
    public void depositar(double valor) {
        if (valor > 0 ){
            this.saldo += valor;
            System.out.println("Depósito realizado com sucesso.");
        } else {
            System.out.println("Valor inválido para depósito.");
        }

    }

    // Método para sacar
    public void sacar(double valor) {
        if ( valor > this.saldo ){
            System.out.println("Saldo insuficiente para saque.");}
        else{ 
            this.saldo -= valor;
            System.out.println("Saque realizado com sucesso.");
        }
    }

    // 4. GETTERS (Apenas leitura)
    public String getTitular() {
        return this.titular;
    }

    public String getNumeroConta() {
        return this.numeroConta;
    }

    public double getSaldo() {
        return this.saldo;
    }
}