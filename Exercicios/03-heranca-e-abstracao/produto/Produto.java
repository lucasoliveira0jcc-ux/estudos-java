package estudos.exercicios.heranca.produto;

public abstract class Produto {

    private String nome;
    private String codigo;
    protected double precoBase;

    public Produto(String nome, String codigo, double precoBase) {
        this.nome = nome;
        this.codigo = codigo;
        this.precoBase = precoBase;
    }

    public abstract double calcularPrecoFinal();

}