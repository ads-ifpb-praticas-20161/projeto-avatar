package com.mycompany.contrloedeestoque.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 * Document   Categoria
 * @Date  22/08/2016 @Time 20:13:53
 * @author Wellington Lins Claudino Duarte   
 * @mail wellingtonlins2013@gmail.com
 */ 
@Entity
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c"),
    @NamedQuery(name = "Categoria.findByCodcategoria", query = "SELECT c FROM Categoria c WHERE c.codcategoria = :codcategoria"),
    @NamedQuery(name = "Categoria.findByCategoria", query = "SELECT c FROM Categoria c WHERE c.categoria = :categoria")})
@SequenceGenerator(name = "sequence_categoria" ,sequenceName = "sequence_categoria",
                   allocationSize = 1,initialValue = 1)
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequence_categoria")
    private Integer codcategoria;
    private String categoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoriaCodcategoria")
    private Collection<Produto> produtoCollection;

    public Categoria() {
    }

    public Categoria(Integer codcategoria) {
        this.codcategoria = codcategoria;
    }

    public Integer getCodcategoria() {
        return codcategoria;
    }

    public void setCodcategoria(Integer codcategoria) {
        this.codcategoria = codcategoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcategoria != null ? codcategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.codcategoria == null && other.codcategoria != null) || (this.codcategoria != null && !this.codcategoria.equals(other.codcategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Codigo = " + codcategoria + "   " + categoria ;
    }
}