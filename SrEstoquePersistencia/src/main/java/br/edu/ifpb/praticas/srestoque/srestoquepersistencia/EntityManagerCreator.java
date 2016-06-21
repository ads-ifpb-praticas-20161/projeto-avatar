/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.srestoque.srestoquepersistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author vmvini
 */
public class EntityManagerCreator {
    
    
    private static EntityManagerCreator emc;
    private EntityManager em;
    
    public EntityManager getEntityManager(){
        if (em == null){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("srEstoquePU");
            em = emf.createEntityManager();
        }
        return em;
            
    }
    
    public static EntityManagerCreator getInstance(){
        if (emc == null)
            return new EntityManagerCreator();
        return emc;
    } 
    
    private EntityManagerCreator(){
        
    }
    
}
