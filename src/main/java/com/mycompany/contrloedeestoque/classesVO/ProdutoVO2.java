package com.mycompany.contrloedeestoque.classesVO;

/**
 * Document   ProdutoVO
 * @Date  05/09/2016
 * @author Wellington Lins Claudino Duarte   
 * @mail wellingtonlins2013@gmail.com
 */ 
public class ProdutoVO2 {
private int codigo ;
private String  descricao;
private  double peso;
private int qauntidadeMinima;
private String categoria;

    public ProdutoVO2() {
    }

    public ProdutoVO2(int codigo, String descricao, double peso, int qauntidadeMinima, String categoria) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.peso = peso;
        this.qauntidadeMinima = qauntidadeMinima;
        this.categoria = categoria;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getQauntidadeMinima() {
        return qauntidadeMinima;
    }

    public void setQauntidadeMinima(int qauntidadeMinima) {
        this.qauntidadeMinima = qauntidadeMinima;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "ProdutoVO2{" + "codigo=" + codigo + ", descricao=" + descricao + ", peso=" + peso + ", qauntidadeMinima=" + qauntidadeMinima + ", categoria=" + categoria + '}';
    }
  
}