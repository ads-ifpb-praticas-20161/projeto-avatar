package com.mycompany.contrloedeestoque.facade;

import com.mycompany.contrloedeestoque.entidades.Itemsaida;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Document   ItemsaidaFacade
 * @Date  26/08/2016 @Time 01:22:46
 * @author Wellington Lins Claudino Duarte   
 * @mail wellingtonlins2013@gmail.com
 */ 
@Stateless
public class ItemsaidaFacade extends AbstractFacade<Itemsaida> {

    @PersistenceContext(unitName = "com.mycompany_ContrloeDeEstoque_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ItemsaidaFacade() {
        super(Itemsaida.class);
    }

}