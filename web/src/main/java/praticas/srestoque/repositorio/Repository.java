/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticas.srestoque.repositorio;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author vmvini
 */
public abstract class Repository<E, T> {
    
    protected abstract EntityManager getEM();
    
    protected abstract String getListAllQuery();
    
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
    
    public E salvar(E e){
        getEM().persist(e);
        return e;
    }
    
    public E getById(T id){
         E encontrado = getEM().find(entityClass, id);
         return encontrado;
    }
    
    public List<E> listar(){
        Query query = getEM().createNativeQuery(getListAllQuery(), entityClass);
        List<E> list = query.getResultList();
        return list;
    }
    
    public void remover(E e){
        getEM().remove(getEM().merge(e));
    }
    
}
