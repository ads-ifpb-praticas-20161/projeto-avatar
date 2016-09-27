package com.mycompany.contrloedeestoque.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

/**
 * Document   Itemsaida
 * @Date  22/08/2016 @Time 20:13:53
 * @author Wellington Lins Claudino Duarte   
 * @mail wellingtonlins2013@gmail.com
 */ 
@Entity
@NamedQueries({
    @NamedQuery(name = "Itemsaida.findAll", query = "SELECT i FROM Itemsaida i"),
    @NamedQuery(name = "Itemsaida.findByCoditemsaida", query = "SELECT i FROM Itemsaida i WHERE i.coditemsaida = :coditemsaida"),
    @NamedQuery(name = "Itemsaida.findByLote", query = "SELECT i FROM Itemsaida i WHERE i.lote = :lote"),
    @NamedQuery(name = "Itemsaida.findByQtde", query = "SELECT i FROM Itemsaida i WHERE i.qtde = :qtde"),
    @NamedQuery(name = "Itemsaida.findByValor", query = "SELECT i FROM Itemsaida i WHERE i.valor = :valor")})
@SequenceGenerator(name = "sequencia_itemsaida",sequenceName = "sequencia_itemsaida",
                    allocationSize = 1,initialValue = 1)
public class Itemsaida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequencia_itemsaida")
    private Integer coditemsaida;

    private String lote;

    private Integer qtde;

    private Float valor;
    @JoinColumn(name = "produto_codproduto", referencedColumnName = "codproduto")
    @ManyToOne(optional = false)
    private Produto produtoCodproduto;
    @JoinColumn(name = "saida_codsaida", referencedColumnName = "codsaida")
    @ManyToOne(optional = false)
    private Saida saidaCodsaida;

    public Itemsaida() {
    }

    public Itemsaida(Integer coditemsaida) {
        this.coditemsaida = coditemsaida;
    }

    public Integer getCoditemsaida() {
        return coditemsaida;
    }

    public void setCoditemsaida(Integer coditemsaida) {
        this.coditemsaida = coditemsaida;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public Integer getQtde() {
        return qtde;
    }

    public void setQtde(Integer qtde) {
        this.qtde = qtde;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Produto getProdutoCodproduto() {
        return produtoCodproduto;
    }

    public void setProdutoCodproduto(Produto produtoCodproduto) {
        this.produtoCodproduto = produtoCodproduto;
    }

    public Saida getSaidaCodsaida() {
        return saidaCodsaida;
    }

    public void setSaidaCodsaida(Saida saidaCodsaida) {
        this.saidaCodsaida = saidaCodsaida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coditemsaida != null ? coditemsaida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itemsaida)) {
            return false;
        }
        Itemsaida other = (Itemsaida) object;
        if ((this.coditemsaida == null && other.coditemsaida != null) || (this.coditemsaida != null && !this.coditemsaida.equals(other.coditemsaida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Código=" + coditemsaida + ", lote=" + lote + ", qtde=" + qtde + ", valor=" + valor + ", produtoCodproduto=" + produtoCodproduto + ", saidaCodsaida=" + saidaCodsaida;
    }

  
}