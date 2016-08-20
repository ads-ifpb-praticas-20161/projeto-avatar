/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticas.srestoque.entidades;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author vmvini
 */
@Entity
public class Funcionario {
    
    
    @Id
    @GeneratedValue
    private int id;
    
    private String login;
    private String senha;
    
    @Enumerated(EnumType.STRING)
    private TipoFuncionario tipo;

    public Funcionario(){}
    
    public Funcionario(String login, String senha, TipoFuncionario tipo) {
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "id=" + id + ", login=" + login + ", senha=" + senha + ", tipo=" + tipo + '}';
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoFuncionario getTipo() {
        return tipo;
    }

    public void setTipo(TipoFuncionario tipo) {
        this.tipo = tipo;
    }
    
    
    
}
