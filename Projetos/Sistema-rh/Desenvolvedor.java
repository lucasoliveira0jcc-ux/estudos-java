public class Desenvolvedor extends Funcionario {

    private int horasExtras;

    public Desenvolvedor(String nome, String cpf, double salarioBase, int horasExtras){

        super( nome, cpf, salarioBase);
        this.horasExtras = horasExtras;
    }
    @Override
    public double calcularSalarioFinal(){
        
        return salarioBase + (horasExtras * 50);
    }
}
