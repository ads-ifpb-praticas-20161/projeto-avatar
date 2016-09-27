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
import javax.validation.constraints.Size;

/**
 * Document   Transportadora
 * @Date  22/08/2016 @Time 20:13:53
 * @author Wellington Lins Claudino Duarte   
 * @mail wellingtonlins2013@gmail.com
 */ 
@Entity

@NamedQueries({
    @NamedQuery(name = "Transportadora.findAll", query = "SELECT t FROM Transportadora t"),
    @NamedQuery(name = "Transportadora.findByCodtransportadora", query = "SELECT t FROM Transportadora t WHERE t.codtransportadora = :codtransportadora"),
    @NamedQuery(name = "Transportadora.findByTransportadora", query = "SELECT t FROM Transportadora t WHERE t.transportadora = :transportadora"),
    @NamedQuery(name = "Transportadora.findByEndereco", query = "SELECT t FROM Transportadora t WHERE t.endereco = :endereco"),
    @NamedQuery(name = "Transportadora.findByNum", query = "SELECT t FROM Transportadora t WHERE t.num = :num"),
    @NamedQuery(name = "Transportadora.findByBairro", query = "SELECT t FROM Transportadora t WHERE t.bairro = :bairro"),
    @NamedQuery(name = "Transportadora.findByCep", query = "SELECT t FROM Transportadora t WHERE t.cep = :cep"),
    @NamedQuery(name = "Transportadora.findByCnpj", query = "SELECT t FROM Transportadora t WHERE t.cnpj = :cnpj"),
    @NamedQuery(name = "Transportadora.findByInsc", query = "SELECT t FROM Transportadora t WHERE t.insc = :insc"),
    @NamedQuery(name = "Transportadora.findByContato", query = "SELECT t FROM Transportadora t WHERE t.contato = :contato"),
    @NamedQuery(name = "Transportadora.findByTel", query = "SELECT t FROM Transportadora t WHERE t.tel = :tel")})
@SequenceGenerator(name = "sequencia_transportadora", sequenceName = "sequencia_transportadora",
        allocationSize = 1, initialValue = 1)
public class Transportadora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequencia_transportadora")
    private Integer codtransportadora;
 
    private String transportadora;
  
    private String endereco;
    private Integer num;
 
    private String bairro;
    @Size(max = 9)
    private String cep;
    @Size(max = 18)
    private String cnpj;
  
    private String insc;
  
    private String contato;
    @Size(max = 14)
    private String tel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transportadoraCodtransportadora")
    private Collection<Entrada> entradaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transportadoraCodtransportadora")
    private Collection<Saida> saidaCollection;
    @JoinColumn(name = "cidade_codcidade", referencedColumnName = "codcidade")
    @ManyToOne(optional = false)
    private Cidade cidadeCodcidade;

    public Transportadora() {
    }

    public Transportadora(Integer codtransportadora) {
        this.codtransportadora = codtransportadora;
    }

    public Integer getCodtransportadora() {
        return codtransportadora;
    }

    public void setCodtransportadora(Integer codtransportadora) {
        this.codtransportadora = codtransportadora;
    }

    public String getTransportadora() {
        return transportadora;
    }

    public void setTransportadora(String transportadora) {
        this.transportadora = transportadora;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInsc() {
        return insc;
    }

    public void setInsc(String insc) {
        this.insc = insc;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Collection<Entrada> getEntradaCollection() {
        return entradaCollection;
    }

    public void setEntradaCollection(Collection<Entrada> entradaCollection) {
        this.entradaCollection = entradaCollection;
    }

    public Collection<Saida> getSaidaCollection() {
        return saidaCollection;
    }

    public void setSaidaCollection(Collection<Saida> saidaCollection) {
        this.saidaCollection = saidaCollection;
    }

    public Cidade getCidadeCodcidade() {
        return cidadeCodcidade;
    }

    public void setCidadeCodcidade(Cidade cidadeCodcidade) {
        this.cidadeCodcidade = cidadeCodcidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtransportadora != null ? codtransportadora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transportadora)) {
            return false;
        }
        Transportadora other = (Transportadora) object;
        if ((this.codtransportadora == null && other.codtransportadora != null) || (this.codtransportadora != null && !this.codtransportadora.equals(other.codtransportadora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Código = " + codtransportadora + ", Nome = " +   transportadora ;
    }


}