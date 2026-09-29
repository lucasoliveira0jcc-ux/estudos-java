package com.estudos.veiculo;

public abstract class Veiculo {

    private String marca;
    private String modelo;
    protected double valorDiaria;

    public Veiculo(String marca, String modelo, double valorDiaria) {
        this.marca = marca;
        this.modelo = modelo;
        this.valorDiaria = valorDiaria;
    }

    public abstract double calcularAluguel(int dias);

}