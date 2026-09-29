public class Gerente extends Funcionario {

    private double bonusDesempenho;

    public Gerente(String nome, String cpf, double salarioBase, double bonusDesempenho) {
        super(nome, cpf, salarioBase);
        this.bonusDesempenho = bonusDesempenho;
    }

    @Override
    public double calcularSalarioFinal() {
        return salarioBase + bonusDesempenho;
    }

}