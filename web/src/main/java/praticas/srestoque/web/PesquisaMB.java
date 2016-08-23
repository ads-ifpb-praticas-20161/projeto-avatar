/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticas.srestoque.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import praticas.srestoque.entidades.Cliente;
import praticas.srestoque.entidades.Endereco;
import praticas.srestoque.repositorio.ClienteRepository;
import praticas.srestoque.repositorio.FuncionarioRepository;
import praticas.srestoque.repositorio.Repository;
import praticas.srestoque.repositorio.SearchStrategy;

/**
 *
 * @author vmvini
 */

@Named
@RequestScoped
public class PesquisaMB {
    
    private SearchStrategy[] searchStrategies;
    
    private Repository[] repositorios;
    
    private ObjectToMap objectToMap;
    
    private List<Map> results;
    
    private RepositoryType[] repositoryTypes;
    
    private RepositoryType repositoryType;
    
    
    @EJB
    private FuncionarioRepository fr;
    @EJB
    private ClienteRepository cr;
    
    @Produces
    public Repository fr(){
        return fr;
    }
    
    @Produces 
    public Repository cr(){
        return cr;
    }
    
    private Repository getEscolhido(){
        for(int i = 0; i < repositorios.length; i++){
            /*if( repositorios[i].getClass().equals(repositoryType.getRepositoryClass() ) ){
                return repositorios[i];
            }*/
            if( repositoryType.getRepositoryClass().isAssignableFrom( repositorios[i].getClass() ) ){
                return repositorios[i];
            }
        }
        return null;
        
    }
    
    @PostConstruct
    public void postConstruct(){
        repositorios = new Repository[2];
        repositorios[0] =fr();
        repositorios[1] = cr();
        
    }
    
    public PesquisaMB(){
        objectToMap = new ObjectToMap();
        repositoryTypes = RepositoryType.class.getEnumConstants();
        
    }
    
    public void pesquisar(){
        try{
            Repository escolhido = getEscolhido();
        System.out.println("chamou pesquisar");
        if(escolhido == null){
            System.out.println("REPOSITORIO NULO");
            
        }
        else{
            System.out.println("PESQUISAR");
            List<Object> objs = escolhido.listar();
            results = objectToMap.toMapList(objs);
            System.out.println("Resultados: " + results.size());
            System.out.println(results);
        }
        }
        catch(NullPointerException e){
            
        }
        
    }

    public RepositoryType getRepositoryType() {
        return repositoryType;
    }

    public void setRepositoryType(RepositoryType repositoryType) {
        this.repositoryType = repositoryType;
    }
    
    

    public SearchStrategy[] getSearchStrategies() {
        return searchStrategies;
    }

    public RepositoryType[] getRepositoryTypes() {
        return repositoryTypes;
    }

    public void setRepositoryTypes(RepositoryType[] repositoryTypes) {
        this.repositoryTypes = repositoryTypes;
    }
    
    

    public void setSearchStrategies(SearchStrategy[] searchStrategies) {
        this.searchStrategies = searchStrategies;
    }

    public Repository[] getRepositorios() {
        return repositorios;
    }

    public void setRepositorios(Repository[] repositorios) {
        this.repositorios = repositorios;
    }

    public List<Map> getResults() {
        return results;
    }

    public void setResults(List<Map> results) {
        this.results = results;
    }
    
    
    
    
}
