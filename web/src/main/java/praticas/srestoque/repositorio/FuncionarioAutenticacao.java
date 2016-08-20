/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticas.srestoque.repositorio;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import praticas.srestoque.entidades.Funcionario;

/**
 *
 * @author vmvini
 */
@Stateless
public class FuncionarioAutenticacao {
    
    @PersistenceContext
    private EntityManager em;
    
    public Funcionario login(String login, String senha){
        TypedQuery<Funcionario> query = em.createQuery("SELECT f FROM Funcionario f WHERE f.login =: login AND f.senha =: senha", Funcionario.class);
        query.setParameter("login", login);
        query.setParameter("senha", senha);
        return query.getSingleResult();
    }
    
}
