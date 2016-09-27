package com.mycompany.contrloedeestoque.entidades;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Document Entrada
 *
 * @Date 22/08/2016 @Time 20:13:53
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Entrada.findAll", query = "SELECT e FROM Entrada e"),
    @NamedQuery(name = "Entrada.findByCodentrada", query = "SELECT e FROM Entrada e WHERE e.codentrada = :codentrada"),
    @NamedQuery(name = "Entrada.findByDataped", query = "SELECT e FROM Entrada e WHERE e.dataped = :dataped"),
    @NamedQuery(name = "Entrada.findByDataentr", query = "SELECT e FROM Entrada e WHERE e.dataentr = :dataentr"),
    @NamedQuery(name = "Entrada.findByTotal", query = "SELECT e FROM Entrada e WHERE e.total = :total"),
    @NamedQuery(name = "Entrada.findByFrete", query = "SELECT e FROM Entrada e WHERE e.frete = :frete"),
    @NamedQuery(name = "Entrada.findByNumnf", query = "SELECT e FROM Entrada e WHERE e.numnf = :numnf"),
    @NamedQuery(name = "Entrada.findByImposto", query = "SELECT e FROM Entrada e WHERE e.imposto = :imposto")})
@SequenceGenerator(name = "sequence_entrada", sequenceName = "sequence_entrada",
        allocationSize = 1, initialValue = 1)
public class Entrada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_entrada")
    private Integer codentrada;

    @Temporal(TemporalType.DATE)
    private Date dataped;

    @Temporal(TemporalType.DATE)
    private Date dataentr;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    private Float total;

    private Float frete;

    private Integer numnf;

    private Float imposto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entradaCodentrada")
    private Collection<Itementrada> itementradaCollection;
    @JoinColumn(name = "transportadora_codtransportadora", referencedColumnName = "codtransportadora")
    @ManyToOne(optional = false)
    private Transportadora transportadoraCodtransportadora;

    public Entrada() {
    }

    public Entrada(Integer codentrada) {
        this.codentrada = codentrada;
    }

    public Integer getCodentrada() {
        return codentrada;
    }

    public void setCodentrada(Integer codentrada) {
        this.codentrada = codentrada;
    }

    public Date getDataped() {
        return dataped;
    }

    public void setDataped(Date dataped) {
        this.dataped = dataped;
    }

    public Date getDataentr() {
        return dataentr;
    }

    public void setDataentr(Date dataentr) {
        this.dataentr = dataentr;
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

    public Integer getNumnf() {
        return numnf;
    }

    public void setNumnf(Integer numnf) {
        this.numnf = numnf;
    }

    public Float getImposto() {
        return imposto;
    }

    public void setImposto(Float imposto) {
        this.imposto = imposto;
    }

    public Collection<Itementrada> getItementradaCollection() {
        return itementradaCollection;
    }

    public void setItementradaCollection(Collection<Itementrada> itementradaCollection) {
        this.itementradaCollection = itementradaCollection;
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
        hash += (codentrada != null ? codentrada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entrada)) {
            return false;
        }
        Entrada other = (Entrada) object;
        if ((this.codentrada == null && other.codentrada != null) || (this.codentrada != null && !this.codentrada.equals(other.codentrada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return "Código" + codentrada + ", pedido = " + df.format(dataped) + ", entrada = " + df.format(dataentr) + ", total=" + total + ", Nota fiscal = " + numnf;
    }
}
