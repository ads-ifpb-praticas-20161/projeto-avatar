/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticas.srestoque.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

/**
 *
 * @author vmvini
 */
@Entity
public class Funcionario implements Serializable {
    
    @Id
    private String email;
    private String senha;
    
    @Enumerated(EnumType.STRING)
    private TipoFuncionario tipo;

    public Funcionario(){}
    
    public Funcionario(String email, String senha, TipoFuncionario tipo) {
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Funcionario{"  + ", login=" + email + ", senha=" + senha + ", tipo=" + tipo + '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
