package br.edu.ifpb.praticas.srestoque.srestoqueentidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 *
 * @author Marcus Vinícius
 * @author Wellington Lins Claudino Duarte   @mail wellingtonlins2013@gmail.com
 */

@Entity
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String descricao;
    private int estoque;
    private float valor;

    @Override
    public String toString(){
        return "Id:" + id + "; descricao:" + descricao + "; estoque: " + estoque + "; valor:" + valor;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    
}
