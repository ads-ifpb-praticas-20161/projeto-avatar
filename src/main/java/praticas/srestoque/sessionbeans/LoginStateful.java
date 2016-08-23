/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticas.srestoque.sessionbeans;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.naming.AuthenticationException;
import praticas.srestoque.entidades.Funcionario;
import praticas.srestoque.repositorio.FuncionarioAutenticacao;
import praticas.srestoque.repositorio.FuncionarioRepository;

/**
 *
 * @author vmvini
 */

@Stateful
public class LoginStateful implements Serializable {

    private Funcionario logado;
    
    @EJB
    private FuncionarioRepository frp;
    
    @EJB
    private FuncionarioAutenticacao fa;
    
    
    public void logar(String email, String senha) throws AuthenticationException{
        logado = fa.login(email, senha);
    }
    
    public void deslogar(){
        logado = null;
    }
    
    public boolean estaLogado(){
        return logado != null;
    }
    
    
    public Funcionario getLogado() {
        return logado;
    }

    public void setLogado(Funcionario logado) {
        this.logado = logado;
    }

    public FuncionarioRepository getFrp() {
        return frp;
    }

    public void setFrp(FuncionarioRepository frp) {
        this.frp = frp;
    }
    
}
