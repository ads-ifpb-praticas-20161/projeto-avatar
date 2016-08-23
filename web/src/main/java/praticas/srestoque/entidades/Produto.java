/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticas.srestoque.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author vmvini
 */

@Entity
public class Produto {
    
    @Id
    @GeneratedValue
    private int id;
    
    private String nome;
    private String descricao;
    private Integer estoque;
    private Float valor;

    public Produto(String nome, String descricao, Integer estoque, Float valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.estoque = estoque;
        this.valor = valor;
    }
    
    
    public Produto(){}

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", estoque=" + estoque + ", valor=" + valor + '}';
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }
    
    
}
