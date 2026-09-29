package veiculo;

public class CarroEletrico extends Veiculo {

    private double autonomia;

    public CarroEletrico(String marca, String modelo, double valorDiaria, double autonomia) {
        super(marca, modelo, valorDiaria);
        this.autonomia = autonomia;
    }

    @Override
    public double calcularAluguel(int dias) {
        return (valorDiaria * dias) * 0.90;
    }
}