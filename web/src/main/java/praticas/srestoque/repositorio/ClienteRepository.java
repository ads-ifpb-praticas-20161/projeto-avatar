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
public class ClienteRepository extends Repository {
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    protected EntityManager getEM() {
        return em;
    }

    @Override
    protected String getListAllQuery() {
        return "SELECT * FROM Cliente";
    }
    
    
    
    
}
