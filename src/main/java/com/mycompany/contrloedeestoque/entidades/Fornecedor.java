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
 * Document   Fornecedor
 * @Date  22/08/2016 @Time 20:13:53
 * @author Wellington Lins Claudino Duarte   
 * @mail wellingtonlins2013@gmail.com
 */ 
@Entity
@NamedQueries({
    @NamedQuery(name = "Fornecedor.findAll", query = "SELECT f FROM Fornecedor f"),
    @NamedQuery(name = "Fornecedor.findByCodfornecedor", query = "SELECT f FROM Fornecedor f WHERE f.codfornecedor = :codfornecedor"),
    @NamedQuery(name = "Fornecedor.findByFornecedor", query = "SELECT f FROM Fornecedor f WHERE f.fornecedor = :fornecedor"),
    @NamedQuery(name = "Fornecedor.findByEndereco", query = "SELECT f FROM Fornecedor f WHERE f.endereco = :endereco"),
    @NamedQuery(name = "Fornecedor.findByNum", query = "SELECT f FROM Fornecedor f WHERE f.num = :num"),
    @NamedQuery(name = "Fornecedor.findByBairro", query = "SELECT f FROM Fornecedor f WHERE f.bairro = :bairro"),
    @NamedQuery(name = "Fornecedor.findByCep", query = "SELECT f FROM Fornecedor f WHERE f.cep = :cep"),
    @NamedQuery(name = "Fornecedor.findByContato", query = "SELECT f FROM Fornecedor f WHERE f.contato = :contato"),
    @NamedQuery(name = "Fornecedor.findByCnpj", query = "SELECT f FROM Fornecedor f WHERE f.cnpj = :cnpj"),
    @NamedQuery(name = "Fornecedor.findByInsc", query = "SELECT f FROM Fornecedor f WHERE f.insc = :insc"),
    @NamedQuery(name = "Fornecedor.findByTel", query = "SELECT f FROM Fornecedor f WHERE f.tel = :tel")})
@SequenceGenerator(name = "sequence_fornecedor" ,sequenceName = "sequence_fornecedor",
                   allocationSize = 1,initialValue = 1)
public class Fornecedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequence_fornecedor")
    private Integer codfornecedor;
    private String fornecedor;

    private String endereco;
    private Integer num;
    private String bairro;
    @Size(max = 9)
    private String cep;
    private String contato;
    @Size(max = 18)
    private String cnpj;
    private String insc;
    @Size(max = 14)
    private String tel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fornecedorCodfornecedor")
    private Collection<Produto> produtoCollection;
    @JoinColumn(name = "cidade_codcidade", referencedColumnName = "codcidade")
    @ManyToOne(optional = false)
    private Cidade cidadeCodcidade;

    public Fornecedor() {
    }

    public Fornecedor(Integer codfornecedor) {
        this.codfornecedor = codfornecedor;
    }

    public Integer getCodfornecedor() {
        return codfornecedor;
    }

    public void setCodfornecedor(Integer codfornecedor) {
        this.codfornecedor = codfornecedor;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
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

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
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
        hash += (codfornecedor != null ? codfornecedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornecedor)) {
            return false;
        }
        Fornecedor other = (Fornecedor) object;
        if ((this.codfornecedor == null && other.codfornecedor != null) || (this.codfornecedor != null && !this.codfornecedor.equals(other.codfornecedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Código = " + codfornecedor + ", Nome = " + fornecedor;
    }
}