/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticas.srestoque.repositorio;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import praticas.srestoque.entidades.Cliente;

/**
 *
 * @author vmvini
 */
@Stateless
public class ClienteRepository extends Repository<Cliente, String> {
    
    @PersistenceContext
    private EntityManager em;
    
    public ClienteRepository(){
        searchStrategy = ClienteSearchStrategy.TODOS;
    }
    
    @Override
    protected EntityManager getEM() {
        return em;
    }

    protected  String getPrimaryKeyConstraintViolationMsg(){
        return "Já existe cliente com esse cpf!";
    }
    
    protected SearchStrategy[] getAvailableStrategies(){
       SearchStrategy[] tipos = ClienteSearchStrategy.class.getEnumConstants();
       return tipos;
    }
    
    public String toString(){
        return "Cliente";
    }
    
    
}
