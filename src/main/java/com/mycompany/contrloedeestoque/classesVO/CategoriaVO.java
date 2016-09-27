package com.mycompany.contrloedeestoque.classesVO;

/**
 * Document   CategoriaVO
 * @Date  05/09/2016
 * @author Wellington Lins Claudino Duarte   
 * @mail wellingtonlins2013@gmail.com
 */ 
public class CategoriaVO {
    private String categoria;
    private Long quantidade;

    public CategoriaVO(String categoria, Long quantidade) {
        this.categoria = categoria;
        this.quantidade = quantidade;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "CategoriaVO{" + "categoria=" + categoria + ", quantidade=" + quantidade + '}';
    }
    
    
}
