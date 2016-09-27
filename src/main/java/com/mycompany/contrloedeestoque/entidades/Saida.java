package com.mycompany.contrloedeestoque.entidades;

import java.io.Serializable;
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
 * Document   Saida
 * @Date  22/08/2016 @Time 20:13:53
 * @author Wellington Lins Claudino Duarte   
 * @mail wellingtonlins2013@gmail.com
 */ 
@Entity
@NamedQueries({
    @NamedQuery(name = "Saida.findAll", query = "SELECT s FROM Saida s"),
    @NamedQuery(name = "Saida.findByCodsaida", query = "SELECT s FROM Saida s WHERE s.codsaida = :codsaida"),
    @NamedQuery(name = "Saida.findByTotal", query = "SELECT s FROM Saida s WHERE s.total = :total"),
    @NamedQuery(name = "Saida.findByFrete", query = "SELECT s FROM Saida s WHERE s.frete = :frete"),
    @NamedQuery(name = "Saida.findByImposto", query = "SELECT s FROM Saida s WHERE s.imposto = :imposto")})
@SequenceGenerator(name = "sequencia_saida", sequenceName = "sequencia_saida",
        allocationSize = 1, initialValue = 1)
public class Saida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequencia_saida")
    private Integer codsaida;

    private Float total;

    private Float frete;

    private Float imposto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "saidaCodsaida")
    private Collection<Itemsaida> itemsaidaCollection;
    @JoinColumn(name = "loja_codloja", referencedColumnName = "codloja")
    @ManyToOne(optional = false)
    private Loja lojaCodloja;
    @JoinColumn(name = "transportadora_codtransportadora", referencedColumnName = "codtransportadora")
    @ManyToOne(optional = false)
    private Transportadora transportadoraCodtransportadora;

    public Saida() {
    }

    public Saida(Integer codsaida) {
        this.codsaida = codsaida;
    }

    public Integer getCodsaida() {
        return codsaida;
    }

    public void setCodsaida(Integer codsaida) {
        this.codsaida = codsaida;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Float getFrete() {
        return frete;
    }

    public void setFrete(Float frete) {
        this.frete = frete;
    }

    public Float getImposto() {
        return imposto;
    }

    public void setImposto(Float imposto) {
        this.imposto = imposto;
    }

   
    public Collection<Itemsaida> getItemsaidaCollection() {
        return itemsaidaCollection;
    }

    public void setItemsaidaCollection(Collection<Itemsaida> itemsaidaCollection) {
        this.itemsaidaCollection = itemsaidaCollection;
    }

    public Loja getLojaCodloja() {
        return lojaCodloja;
    }

    public void setLojaCodloja(Loja lojaCodloja) {
        this.lojaCodloja = lojaCodloja;
    }

    public Transportadora getTransportadoraCodtransportadora() {
        return transportadoraCodtransportadora;
    }

    public void setTransportadoraCodtransportadora(Transportadora transportadoraCodtransportadora) {
        this.transportadoraCodtransportadora = transportadoraCodtransportadora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codsaida != null ? codsaida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Saida)) {
            return false;
        }
        Saida other = (Saida) object;
        if ((this.codsaida == null && other.codsaida != null) || (this.codsaida != null && !this.codsaida.equals(other.codsaida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Código= " + codsaida + ", total=" + total + ", frete=" + frete +
                ", imposto=" + imposto;
    }
}