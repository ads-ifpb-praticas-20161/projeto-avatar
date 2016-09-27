package com.mycompany.contrloedeestoque.classesVO;

/**
 * Document   FreteVO
 * @Date  05/09/2016
 * @author Wellington Lins Claudino Duarte   
 * @mail wellingtonlins2013@gmail.com
 */ 
public class FreteVO {
  private String transportadora;
  private Double soma;
  private String evento;

    public FreteVO(String transportadora, Double soma, String evento) {
        this.transportadora = transportadora;
        this.soma = soma;
        this.evento = evento;
    }

    public String getTransportadora() {
        return transportadora;
    }

    public void setTransportadora(String transportadora) {
        this.transportadora = transportadora;
    }

    public Double getSoma() {
        return soma;
    }

    public void setSoma(Double soma) {
        this.soma = soma;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    @Override
    public String toString() {
        return "FreteVO{" + "transportadora=" + transportadora + ", soma=" + soma + ", evento=" + evento + '}';
    }
  
    
  
}
