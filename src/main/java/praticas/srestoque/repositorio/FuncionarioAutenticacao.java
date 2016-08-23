/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticas.srestoque.repositorio;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import praticas.srestoque.entidades.Funcionario;
import javax.naming.AuthenticationException;

/**
 *
 * @author vmvini
 */
@Stateless
public class FuncionarioAutenticacao {
    
    @PersistenceContext
    private EntityManager em;
    
    public Funcionario login(String email, String senha) throws AuthenticationException{
        try{
            TypedQuery<Funcionario> query = em.createQuery("SELECT f FROM Funcionario f WHERE f.email =:email AND f.senha =:senha", Funcionario.class);
            query.setParameter("email", email);
            query.setParameter("senha", senha);
            return query.getSingleResult();
        }
        catch(NoResultException e){
            throw new AuthenticationException("Login ou senha incorretos");
        }
        
    }
    
}
