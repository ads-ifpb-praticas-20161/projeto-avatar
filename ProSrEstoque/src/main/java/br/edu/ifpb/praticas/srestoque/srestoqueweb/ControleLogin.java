/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.srestoque.srestoqueweb;

import br.edu.ifpb.praticas.srestoque.exceptions.NaoEhFuncionario;
import br.edu.ifpb.praticas.srestoque.exceptions.UsuarioNaoEncontrado;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Funcionario;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Usuario;
import br.edu.ifpb.praticas.srestoque.srestoquepersistencia.GerenciadorUsuario;
import java.io.Serializable;
//import javax.inject.Named;
//import javax.enterprise.context.SessionScoped;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.security.sasl.AuthenticationException;

/**
 *
 * @author vmvini
 */

@Named
@SessionScoped
public class ControleLogin implements Serializable {

    private Funcionario logado;
    
    @EJB
    private GerenciadorUsuario gerenciadorUsuarioImpl;

    public Usuario login(String email, String senha) throws UsuarioNaoEncontrado{
        
        Usuario usuario = gerenciadorUsuarioImpl.buscarPorEmail(email);
        return usuario;
        /*if( usuario instanceof Funcionario ){
            Funcionario func = (Funcionario)usuario;
            if(! senha.equals( func.getSenha() ) ){
                throw new AuthenticationException("Senha incorreta!");
            }
            else{
                logado = func;
                System.out.println("usuario logado");
            }
        }
        else{
            throw new NaoEhFuncionario("O usuario não é um funcionario!");
        }*/
        
        
    }

    public Funcionario getLogado() {
        return logado;
    }

    public void setLogado(Funcionario logado) {
        this.logado = logado;
    }

    public GerenciadorUsuario getGerenciadorUsuarioImpl() {
        return gerenciadorUsuarioImpl;
    }

    public void setGerenciadorUsuarioImpl(GerenciadorUsuario gerenciadorUsuarioImpl) {
        this.gerenciadorUsuarioImpl = gerenciadorUsuarioImpl;
    }
    
    

}
