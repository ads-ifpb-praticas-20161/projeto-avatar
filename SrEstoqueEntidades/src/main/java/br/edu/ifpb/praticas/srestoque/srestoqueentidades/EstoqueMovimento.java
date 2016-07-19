/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.srestoque.srestoqueentidades;
import java.io.Serializable;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.criteria.Fetch;

/**
 *
 * @author Marcus Vinícius
 */
@MappedSuperclass
public abstract class EstoqueMovimento implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "produto", nullable=false)
    private Produto produto;
    private int quantidade;
    
    
    
    @Temporal(TemporalType.DATE)
    @Column(name = "dataa")
    private Date data;
    
    @Override
    public String toString(){
        return "Id: " + id + "; produto_Id: " + produto.getId() + "; quantidade: " + quantidade + "; data: " + data.toString();
    }
    
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
    
   
    
}
