public class Main {
    public static void main(String[] args) {

        Gerente gerente = new Gerente("Carlos Silva", "123.456.789-00", 8000.0, 2000.0);

        Desenvolvedor dev = new Desenvolvedor("Ana Souza", "987.654.321-11", 5000.0, 10);

    
        System.out.println("=== SISTEMA DE RH ===");
        System.out.println("Salário Final do Gerente: R$ " + gerente.calcularSalarioFinal());
        System.out.println("Salário Final do Desenvolvedor: R$ " + dev.calcularSalarioFinal());
    }
}