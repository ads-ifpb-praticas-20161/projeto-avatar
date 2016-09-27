package com.mycompany.contrloedeestoque.classesVO;

/**
 * Document   LojaSaidaVO
 * @Date  05/09/2016
 * @author Wellington Lins Claudino Duarte   
 * @mail wellingtonlins2013@gmail.com
 */ 
public class LojaSaidaVO {
 private String nome;
 private double soma;

    public LojaSaidaVO(String nome, double soma) {
        this.nome = nome;
        this.soma = soma;
    }

 
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSoma() {
        return soma;
    }

    public void setSoma(double soma) {
        this.soma = soma;
    }

    @Override
    public String toString() {
        return "LojaSaidaVO{" + "nome=" + nome + ", soma=" + soma + '}';
    }
 
 
}
