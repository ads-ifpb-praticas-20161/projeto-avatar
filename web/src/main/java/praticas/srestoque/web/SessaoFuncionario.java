/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticas.srestoque.web;

import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.naming.AuthenticationException;
import praticas.srestoque.entidades.Funcionario;
import praticas.srestoque.entidades.TipoFuncionario;
import praticas.srestoque.sessionbeans.LoginStateful;

/**
 *
 * @author vmvini
 */

@Named
@SessionScoped
public class SessaoFuncionario implements Serializable {
    
    @EJB
    private LoginStateful loginSB;
    
    private String email, senha;

    public void logar() throws IOException{
        try{
            loginSB.logar(email, senha);
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.getFlash().put("home", "Something was done successfully");
            ec.redirect("index.xhtml#home");
        }
        catch(AuthenticationException e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
            
        }
        
    }
    
    public boolean isAdministrador(){
        return getLogado().getTipo().equals(TipoFuncionario.ADMINISTRADOR);
    }
    
    public Funcionario getLogado(){
        return loginSB.getLogado();
    }
    
    public boolean estaLogado(){
        return loginSB.estaLogado();
    }
    
    public String logoff(){
        loginSB.deslogar();
        return "/index?faces-redirect=true";
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
    
    
    
    public LoginStateful getLoginSB() {
        return loginSB;
    }

    public void setLoginSB(LoginStateful loginSB) {
        this.loginSB = loginSB;
    }
    
    
    
}
