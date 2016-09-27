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
import javax.validation.constraints.Size;

/**
 * Document Loja
 *
 * @Date 22/08/2016 @Time 20:13:53
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Loja.findAll", query = "SELECT l FROM Loja l"),
    @NamedQuery(name = "Loja.findByCodloja", query = "SELECT l FROM Loja l WHERE l.codloja = :codloja"),
    @NamedQuery(name = "Loja.findByNome", query = "SELECT l FROM Loja l WHERE l.nome = :nome"),
    @NamedQuery(name = "Loja.findByEndereco", query = "SELECT l FROM Loja l WHERE l.endereco = :endereco"),
    @NamedQuery(name = "Loja.findByNum", query = "SELECT l FROM Loja l WHERE l.num = :num"),
    @NamedQuery(name = "Loja.findByBairro", query = "SELECT l FROM Loja l WHERE l.bairro = :bairro"),
    @NamedQuery(name = "Loja.findByTel", query = "SELECT l FROM Loja l WHERE l.tel = :tel"),
    @NamedQuery(name = "Loja.findByInsc", query = "SELECT l FROM Loja l WHERE l.insc = :insc"),
    @NamedQuery(name = "Loja.findByCnpj", query = "SELECT l FROM Loja l WHERE l.cnpj = :cnpj"),
    @NamedQuery(name = "Loja.findByCep", query = "SELECT l FROM Loja l WHERE l.cep = :cep")})
@SequenceGenerator(name = "sequencia_loja", sequenceName = "sequencia_loja",
        allocationSize = 1, initialValue = 1)
public class Loja implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequencia_loja")
    private Integer codloja;

    private String nome;

    private String endereco;

    private Integer num;

    private String bairro;
    @Size(max = 14)

    private String tel;

    private String insc;
    @Size(max = 18)

    private String cnpj;
    @Size(max = 9)

    private String cep;
    @JoinColumn(name = "cidade_codcidade", referencedColumnName = "codcidade")
    @ManyToOne(optional = false)
    private Cidade cidadeCodcidade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lojaCodloja")
    private Collection<Saida> saidaCollection;

    public Loja() {
        saidaCollection = new ArrayList<>();
    }

    public Loja(Integer codloja) {
        this.codloja = codloja;
    }

    public Integer getCodloja() {
        return codloja;
    }

    public void setCodloja(Integer codloja) {
        this.codloja = codloja;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getInsc() {
        return insc;
    }

    public void setInsc(String insc) {
        this.insc = insc;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Cidade getCidadeCodcidade() {
        return cidadeCodcidade;
    }

    public void setCidadeCodcidade(Cidade cidadeCodcidade) {
        this.cidadeCodcidade = cidadeCodcidade;
    }

    public Collection<Saida> getSaidaCollection() {
        return saidaCollection;
    }

    public void setSaidaCollection(Collection<Saida> saidaCollection) {
        this.saidaCollection = saidaCollection;
    }
    public void addSaidaCollection( Saida saida) {
        saidaCollection.add(saida);
    }
    public void removeSaidaCollection( Saida saida) {
        saidaCollection.remove(saida);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codloja != null ? codloja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loja)) {
            return false;
        }
        Loja other = (Loja) object;
        if ((this.codloja == null && other.codloja != null) || (this.codloja != null && !this.codloja.equals(other.codloja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Código = " + codloja + ", nome = " + nome + ", "  + " endereco = " + endereco;
    }

}
