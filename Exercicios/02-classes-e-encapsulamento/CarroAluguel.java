public class CarroAluguel {


    private String modelo;
    private String placa;
    private double quilometragem;

    
    public CarroAluguel(String modelo, String placa) {
        this.modelo = modelo;
        this.placa = placa;
        this.quilometragem = 0.0;
    }

    
    public void rodar(double kmRodados) {
        if (kmRodados > 0) {
            this.quilometragem += kmRodados;
            System.out.println("Viagem registrada com sucesso.");
        } else {
            System.out.println("Quilometragem inválida.");
        }
    }

    public void realizarManutencao(double kmAtual) {
        if (kmAtual < this.quilometragem) {
            System.out.println("Quilometragem informada menor que a atual.");
        } else {
            this.quilometragem = kmAtual;
            System.out.println("Manutenção registrada.");
        }
    }
    
    public String getModelo() {
        return this.modelo;
    }

    public String getPlaca() {
        return this.placa;
    }

    public double getQuilometragem() {
        return this.quilometragem;
    }
}