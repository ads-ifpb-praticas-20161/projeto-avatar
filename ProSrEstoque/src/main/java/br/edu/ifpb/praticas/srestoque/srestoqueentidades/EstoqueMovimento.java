package br.edu.ifpb.praticas.srestoque.srestoqueentidades;

import java.util.Date;

/**
 *
 * @author Marcus Vinícius
 * @author Wellington Lins Claudino Duarte   @mail wellingtonlins2013@gmail.com
 */
public abstract class EstoqueMovimento {

    private int id;
    private Produto produto;
    private int quantidade;
    private Date data;
    

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    @Override
    public String toString(){
        return "Id: " + id + "; produto_Id: " + produto.getId() + "; quantidade: " + quantidade + "; data: " + data.toString();
    }  
   
    
}
