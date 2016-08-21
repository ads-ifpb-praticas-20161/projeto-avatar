/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticas.srestoque.sessionbeans;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import praticas.srestoque.entidades.Funcionario;
import praticas.srestoque.repositorio.FuncionarioRepository;

/**
 *
 * @author vmvini
 */

@Stateless
public class FuncionarioStateless {
    
    @EJB
    private FuncionarioRepository fr;

    public void cadastrar(Funcionario funcionario){
        fr.salvar(funcionario);
    }
    
    public void remover(Funcionario funcionario){
        fr.remover(funcionario);
    }
    
    public Funcionario buscarPorId(String email){
        return fr.getById(email);
    }
    
    public List<Funcionario> listar(){
        return fr.listar();
    }
    
    public FuncionarioRepository getFr() {
        return fr;
    }

    public void setFr(FuncionarioRepository fr) {
        this.fr = fr;
    }

}
