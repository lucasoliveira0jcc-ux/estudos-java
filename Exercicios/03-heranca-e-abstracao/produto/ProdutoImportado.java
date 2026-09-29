package produto;
public class ProdutoImportado extends Produto {

    private double taxaInMetro;

    public ProdutoImportado(String nome, String codigo, double precoBase, double taxaInMetro) {
        super(nome, codigo, precoBase);
        this.taxaInMetro = taxaInMetro;
    }

    @Override
    public double calcularPrecoFinal() {
        return (precoBase * 1.60) + this.taxaInMetro;
    }

}