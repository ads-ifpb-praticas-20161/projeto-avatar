package com.mycompany.contrloedeestoque.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 * Document Produto
 *
 * @Date 22/08/2016 @Time 20:13:53
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByCodproduto", query = "SELECT p FROM Produto p WHERE p.codproduto = :codproduto"),
    @NamedQuery(name = "Produto.findByDescricao", query = "SELECT p FROM Produto p WHERE p.descricao = :descricao"),
    @NamedQuery(name = "Produto.findByPeso", query = "SELECT p FROM Produto p WHERE p.peso = :peso"),
    @NamedQuery(name = "Produto.findByQtdemin", query = "SELECT p FROM Produto p WHERE p.qtdemin = :qtdemin")})
@SequenceGenerator(name = "sequencia_produto", sequenceName = "sequencia_produto",
        allocationSize = 1, initialValue = 1)
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequencia_produto")
    private Integer codproduto;

    private String descricao;
    private Float peso;
    private Integer qtdemin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produtoCodproduto")
    private Collection<Itementrada> itementradaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produtoCodproduto")
    private Collection<Itemsaida> itemsaidaCollection;
    @JoinColumn(name = "categoria_codcategoria", referencedColumnName = "codcategoria")
    @ManyToOne(optional = false)
    private Categoria categoriaCodcategoria;
    @JoinColumn(name = "fornecedor_codfornecedor", referencedColumnName = "codfornecedor")
    @ManyToOne(optional = false)
    private Fornecedor fornecedorCodfornecedor;

    public Produto() {

        itementradaCollection = new ArrayList();

        itemsaidaCollection = new ArrayList();

    }

    public Produto(Integer codproduto) {
        this.codproduto = codproduto;
    }

    public Integer getCodproduto() {
        return codproduto;
    }

    public void setCodproduto(Integer codproduto) {
        this.codproduto = codproduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Integer getQtdemin() {
        return qtdemin;
    }

    public void setQtdemin(Integer qtdemin) {
        this.qtdemin = qtdemin;
    }

    public Collection<Itementrada> getItementradaCollection() {
        return itementradaCollection;
    }

    public void setItementradaCollection(Collection<Itementrada> itementradaCollection) {
        this.itementradaCollection = itementradaCollection;
    }

    public Collection<Itemsaida> getItemsaidaCollection() {
        return itemsaidaCollection;
    }

    public void setItemsaidaCollection(Collection<Itemsaida> itemsaidaCollection) {
        this.itemsaidaCollection = itemsaidaCollection;
    }

    public Categoria getCategoriaCodcategoria() {
        return categoriaCodcategoria;
    }

    public void setCategoriaCodcategoria(Categoria categoriaCodcategoria) {
        this.categoriaCodcategoria = categoriaCodcategoria;
    }

    public Fornecedor getFornecedorCodfornecedor() {
        return fornecedorCodfornecedor;
    }

    public void setFornecedorCodfornecedor(Fornecedor fornecedorCodfornecedor) {
        this.fornecedorCodfornecedor = fornecedorCodfornecedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codproduto != null ? codproduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.codproduto == null && other.codproduto != null) || (this.codproduto != null && !this.codproduto.equals(other.codproduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Código = " + codproduto + ", descricao = " + descricao;
    }

}
