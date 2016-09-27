package com.mycompany.contrloedeestoque.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;

/**
 * Document Cidade
 *
 * @Date 22/08/2016 @Time 20:13:52
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Cidade.findAll", query = "SELECT c FROM Cidade c"),
    @NamedQuery(name = "Cidade.findByCodcidade", query = "SELECT c FROM Cidade c WHERE c.codcidade = :codcidade"),
    @NamedQuery(name = "Cidade.findByCidade", query = "SELECT c FROM Cidade c WHERE c.cidade = :cidade"),
    @NamedQuery(name = "Cidade.findByUf", query = "SELECT c FROM Cidade c WHERE c.uf = :uf")})
@SequenceGenerator(name = "sequence_cidade", sequenceName = "sequence_cidade",
        allocationSize = 1, initialValue = 1)
public class Cidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_cidade")
    private Integer codcidade;
    private String cidade;
    @Size(max = 2)
    private String uf;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cidadeCodcidade")
    private Collection<Loja> lojaCollection = Collections.EMPTY_LIST;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cidadeCodcidade")
    private Collection<Fornecedor> fornecedorCollection = Collections.EMPTY_LIST;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cidadeCodcidade")
    private Collection<Transportadora> transportadoraCollection = Collections.EMPTY_LIST;

    public Cidade() {
        lojaCollection = new ArrayList();
        fornecedorCollection = new ArrayList();
        transportadoraCollection = new ArrayList();
    }

    public Cidade(Integer codcidade) {
        this.codcidade = codcidade;
    }

    public Integer getCodcidade() {
        return codcidade;
    }

    public void setCodcidade(Integer codcidade) {
        this.codcidade = codcidade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Collection<Loja> getLojaCollection() {
        return lojaCollection;
    }

    public void setLojaCollection(Collection<Loja> lojaCollection) {
        this.lojaCollection = lojaCollection;
    }

    public void addLojaCollection(Loja loja) {
        lojaCollection.add(loja);
    }

    public void removeLojaCollection(Loja loja) {
        lojaCollection.remove(loja);
    }

    public Collection<Fornecedor> getFornecedorCollection() {
        return fornecedorCollection;
    }

    public void setFornecedorCollection(Collection<Fornecedor> fornecedorCollection) {
        this.fornecedorCollection = fornecedorCollection;
    }

    public void addFornecedorCollection(Fornecedor fornecedor) {
        fornecedorCollection.add(fornecedor);
    }

    public void removeFornecedorCollection(Fornecedor fornecedor) {
        fornecedorCollection.remove(fornecedor);
    }

    public Collection<Transportadora> getTransportadoraCollection() {
        return transportadoraCollection;
    }

    public void setTransportadoraCollection(Collection<Transportadora> transportadoraCollection) {
        this.transportadoraCollection = transportadoraCollection;
    }

    public void addTransportadoraCollection(Transportadora transportadora) {
        transportadoraCollection.add(transportadora);
    }

    public void removeTransportadoraCollection(Transportadora transportadora) {
        transportadoraCollection.remove(transportadora);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcidade != null ? codcidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cidade)) {
            return false;
        }
        Cidade other = (Cidade) object;
        if ((this.codcidade == null && other.codcidade != null) || (this.codcidade != null && !this.codcidade.equals(other.codcidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Código = " + codcidade + ", cidade = " + cidade + ", UF = " + uf;
    }

}
