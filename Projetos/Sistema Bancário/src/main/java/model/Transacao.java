package model;

import java.time.LocalDateTime;

public class Transacao {
    private TipoTransacao tipo;
    private double valor;
    private LocalDateTime data;    

    public Transacao(TipoTransacao tipo, double valor){
this.tipo = tipo;
this.valor = valor;
this.data = LocalDateTime.now();

    }
    public TipoTransacao getTipo(){
        return tipo;
    }
    public double getValor(){
        return valor;
    }
    public LocalDateTime getData(){
        return data;
    }
    @Override
    public String toString(){
        return "tipo transação:" + tipo + "valor: " + valor + "hora: " + data;
    }
}