package com.mycompany.contrloedeestoque.classesVO;

/**
 * Document   ProdutoVO
 * @Date  05/09/2016
 * @author Wellington Lins Claudino Duarte   
 * @mail wellingtonlins2013@gmail.com
 */ 
public class ProdutoVO {
private int codigo ;
private String  descricao;
private  double peso;
private int qauntidadeMinima;
private String fornecedor;

    public ProdutoVO() {
    }

    public ProdutoVO(int codigo, String descricao, double peso, int qauntidadeMinima, String fornecedor) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.peso = peso;
        this.qauntidadeMinima = qauntidadeMinima;
        this.fornecedor = fornecedor;
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

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public String toString() {
        return "ProdutoVO{" + "codigo=" + codigo + ", descricao=" + descricao + ", peso=" + peso + ", qauntidadeMinima=" + qauntidadeMinima + ", fornecedor=" + fornecedor + '}';
    }
  
}