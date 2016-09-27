package com.mycompany.contrloedeestoque.classesVO;

/**
 * Document   EstoqueVO
 * @Date  04/09/2016
 * @author Wellington Lins Claudino Duarte   
 * @mail wellingtonlins2013@gmail.com
 */ 
public class EstoqueVO {
    private int codigo;
    private Long quantidade;
    private String descricao;

    public EstoqueVO() {
    }
    
     public EstoqueVO(int codigo,String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public EstoqueVO(int codigo, Long quantidade ,String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

 

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
   
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "EstoqueVO{" + "codigo=" + codigo + ", quantidade=" + quantidade + ", descricao=" + descricao + '}';
    }
  
}