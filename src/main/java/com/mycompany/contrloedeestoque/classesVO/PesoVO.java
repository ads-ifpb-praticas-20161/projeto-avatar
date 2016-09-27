package com.mycompany.contrloedeestoque.classesVO;

/**
 * Document   EstoqueVO
 * @Date  04/09/2016
 * @author Wellington Lins Claudino Duarte   
 * @mail wellingtonlins2013@gmail.com
 */ 
public class PesoVO {
    private Integer codigo;
    private Double soma;
    private String evento;

    public PesoVO() {
    }

    public PesoVO(Integer codigo, Double soma, String evento) {
        this.codigo = codigo;
        this.soma = soma;
        this.evento = evento;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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
        return "PesoVO{" + "codigo=" + codigo + ", soma=" + soma + ", evento=" + evento + '}';
    }
    
  
}