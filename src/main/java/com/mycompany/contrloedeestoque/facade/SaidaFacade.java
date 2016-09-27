package com.mycompany.contrloedeestoque.facade;

import com.mycompany.contrloedeestoque.entidades.Saida;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Document   SaidaFacade
 * @Date  23/08/2016 @Time 20:53:26
 * @author Wellington Lins Claudino Duarte   
 * @mail wellingtonlins2013@gmail.com
 */ 
@Stateless
public class SaidaFacade extends AbstractFacade<Saida> {

    @PersistenceContext(unitName = "com.mycompany_ContrloeDeEstoque_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SaidaFacade() {
        super(Saida.class);
    }

}