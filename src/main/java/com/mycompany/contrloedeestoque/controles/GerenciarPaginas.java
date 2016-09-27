package com.mycompany.contrloedeestoque.controles;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 * Document   GerenciarPaginas
 * @Date  20/08/2016 @Time 15:46:09
 * @author Wellington Lins Claudino Duarte   
 * @mail wellingtonlins2013@gmail.com
 */ 
@Named
@SessionScoped
public class GerenciarPaginas implements Serializable {

    public String irIndex(){   
        return "index.xhtml";
    }
    public String logout(){ 
           FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
         
        return "index.xhtml";
    }

    public String  irLogin(){
         return "/login.xhtml?faces-redirect=true";
    }
    public String  irServico(){
         return "/servico.xhtml?faces-redirect=true";
    }
}
