/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticas.srestoque.entidades;

import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;

/**
 *
 * @author vmvini
 */

@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class EstoqueMovimento {
    
    @Id
    @GeneratedValue
    private int id;
    
    @ManyToOne
    private Produto produto;
    private int quantidade;
    
    @Temporal(javax.persistence.TemporalType.DATE)
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
    public String toString() {
        return "EstoqueMovimento{" + "id=" + id + ", produto=" + produto + ", quantidade=" + quantidade + ", data=" + data + '}';
    }
    
    
    
    
    
    
}
