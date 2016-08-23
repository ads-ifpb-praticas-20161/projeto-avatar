/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticas.srestoque.repositorio;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import praticas.srestoque.entidades.EstoqueMovimento;

/**
 *
 * @author vmvini
 */
@Stateless
public class EstoqueMovimentoRepository extends Repository<EstoqueMovimento, Integer> {

    @PersistenceContext
    private EntityManager em;
    
    public EstoqueMovimentoRepository(){
    }
    
    @Override
    protected EntityManager getEM() {
        return em;
    }
    
    protected  String getPrimaryKeyConstraintViolationMsg(){
        return "Já existe movimento de estoque com esse id!";
    }
    
    protected SearchStrategy[] getAvailableStrategies(){
       //SearchStrategy[] tipos = ProdutoSearchStrategy.class.getEnumConstants();
       //return tipos;
        throw new UnsupportedOperationException("");
    }
    
    public String toString(){
        return "EstoqueMovimento";
    }

}
