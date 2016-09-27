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
 * Document   Itementrada
 * @Date  22/08/2016 @Time 20:13:53
 * @author Wellington Lins Claudino Duarte   
 * @mail wellingtonlins2013@gmail.com
 */ 
@Entity
@NamedQueries({
    @NamedQuery(name = "Itementrada.findAll", query = "SELECT i FROM Itementrada i"),
    @NamedQuery(name = "Itementrada.findByCoditementrada", query = "SELECT i FROM Itementrada i WHERE i.coditementrada = :coditementrada"),
    @NamedQuery(name = "Itementrada.findByLote", query = "SELECT i FROM Itementrada i WHERE i.lote = :lote"),
    @NamedQuery(name = "Itementrada.findByQtde", query = "SELECT i FROM Itementrada i WHERE i.qtde = :qtde"),
    @NamedQuery(name = "Itementrada.findByValor", query = "SELECT i FROM Itementrada i WHERE i.valor = :valor")})
@SequenceGenerator(name = "sequencia_itementrada",sequenceName = "sequencia_itementrada",
                    allocationSize = 1,initialValue = 1)
public class Itementrada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequencia_itementrada")
    private Integer coditementrada;

    private String lote;

    private Integer qtde;

    private Float valor;
    @JoinColumn(name = "entrada_codentrada", referencedColumnName = "codentrada")
    @ManyToOne(optional = false)
    private Entrada entradaCodentrada;
    @JoinColumn(name = "produto_codproduto", referencedColumnName = "codproduto")
    @ManyToOne(optional = false)
    private Produto produtoCodproduto;

    public Itementrada() {
    }

    public Itementrada(Integer coditementrada) {
        this.coditementrada = coditementrada;
    }

    public Integer getCoditementrada() {
        return coditementrada;
    }

    public void setCoditementrada(Integer coditementrada) {
        this.coditementrada = coditementrada;
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

    public Entrada getEntradaCodentrada() {
        return entradaCodentrada;
    }

    public void setEntradaCodentrada(Entrada entradaCodentrada) {
        this.entradaCodentrada = entradaCodentrada;
    }

    public Produto getProdutoCodproduto() {
        return produtoCodproduto;
    }

    public void setProdutoCodproduto(Produto produtoCodproduto) {
        this.produtoCodproduto = produtoCodproduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coditementrada != null ? coditementrada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itementrada)) {
            return false;
        }
        Itementrada other = (Itementrada) object;
        if ((this.coditementrada == null && other.coditementrada != null) || (this.coditementrada != null && !this.coditementrada.equals(other.coditementrada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Itementrada{" + "coditementrada=" + coditementrada + ", lote=" + lote + ", qtde=" + qtde + ", valor=" + valor + ", entradaCodentrada=" + entradaCodentrada + ", produtoCodproduto=" + produtoCodproduto + '}';
    }

   

}