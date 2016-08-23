/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticas.srestoque.repositorio;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import praticas.srestoque.excecoes.ChavePrimariaException;

/**
 *
 * @author vmvini
 */
public abstract class Repository<E, T> {
    
    protected abstract EntityManager getEM();
    
    //protected abstract String getListAllQuery();
    
    protected abstract String getPrimaryKeyConstraintViolationMsg();
    
    protected abstract SearchStrategy[] getAvailableStrategies();
    
    protected SearchStrategy searchStrategy;
    
    public void setSearchStrategy(SearchStrategy searchStrategy){
        this.searchStrategy = searchStrategy;
    }
    
    private Class<E> entityClass;
    
    public Repository(){
        //ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        //this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[0];
    
        Type genericSuperClass = getClass().getGenericSuperclass();

        ParameterizedType parametrizedType = null;
        while (parametrizedType == null) {
           if ((genericSuperClass instanceof ParameterizedType)) {
               parametrizedType = (ParameterizedType) genericSuperClass;
           } else {
               genericSuperClass = ((Class<?>) genericSuperClass).getGenericSuperclass();
           }
        }

        this.entityClass = (Class<E>) parametrizedType.getActualTypeArguments()[0];

    }
    
    public E salvar(E e) throws ChavePrimariaException{
        try{
            getEM().persist(e);
            getEM().flush();
            return e;
        }
        catch(PersistenceException ex){
            throw new ChavePrimariaException(getPrimaryKeyConstraintViolationMsg());
        }
    }
    
    public E atualizar(E e){
        return getEM().merge(e);
    }
    
    
    public E getById(T id){
         E encontrado = getEM().find(entityClass, id);
         return encontrado;
    }
    
    public List<E> listar(){
        try{
            TypedQuery<E> query = getEM().createQuery(searchStrategy.getQuery(), entityClass);
            searchStrategy.setParameter(query);
            List<E> list = query.getResultList();
            return list;
        }
        catch(Exception e){
            System.out.println("OCORREU ERRO!!!");
            System.out.println(e.getMessage());
        }
        return null;
        
    }
    
    public void remover(E e){
        getEM().remove(getEM().merge(e));
    }
    
}
