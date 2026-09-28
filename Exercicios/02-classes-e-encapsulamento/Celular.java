
public class Celular {

    // 1. ATRIBUTOS PRIVADOS
    private String marca ;
    private String modelo ;
    private int bateria ;

    // Construtor para inicializar os dados
    public Celular(String marca, String modelo, int bateriaInicial) {
        this.marca = marca;
        this.modelo = modelo;
        this.bateria = bateriaInicial;
    }

    // 2. MÉTODO: usarAplicativo
    public void usarAplicativo(int consumo) {
        // SEU CÓDIGO AQUI:
        // 1. Checar se a bateria já é 0
        if (this.bateria == 0) {
            System.out.println("Impossível usar aplicativo. Celular desligado. ");
            return;
        
        }

        this.bateria -= consumo;
        if (this.bateria < 0) {
            System.out.println("recarregue a bateria. Celular desligado.");
            this.bateria = 0;
        }
      
    
    }

    // 3. MÉTODO: carregar
    public void carregar(int quantidade) {
        // SEU CÓDIGO AQUI:
        this.bateria += quantidade;

        if (this.bateria >= 100) {
            System.out.println("Bateria carregada ao máximo.");
            this.bateria = 100;
        }
    }

    // 4. GETTERS (Apenas leitura)
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getBateria() {
        return bateria;
    }
}