/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticas.srestoque.repositorio;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import praticas.srestoque.entidades.Funcionario;

/**
 *
 * @author vmvini
 */
@Stateless
public class FuncionarioRepository extends Repository<Funcionario, String> {

    @PersistenceContext
    private EntityManager em;
    
    public FuncionarioRepository(){
        searchStrategy = FuncionarioSearchStrategy.TODOS;
    }
    
    @Override
    protected EntityManager getEM() {
        return em;
    }
    
    protected  String getPrimaryKeyConstraintViolationMsg(){
        return "Já existe funcionário com esse email!";
    }
    
    protected SearchStrategy[] getAvailableStrategies(){
       SearchStrategy[] tipos = FuncionarioSearchStrategy.class.getEnumConstants();
       return tipos;
    }
    
    public String toString(){
        return "Funcionario";
    }
    
}
