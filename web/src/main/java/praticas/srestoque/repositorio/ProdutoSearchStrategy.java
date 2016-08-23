/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticas.srestoque.repositorio;

import javax.persistence.Query;

/**
 *
 * @author vmvini
 */
public enum ProdutoSearchStrategy implements SearchStrategy {

    TODOS{
        
        public void setParametroPesquisa(ParametroPesquisa parametroPesquisa){
        }
        
        @Override
        public String getQuery() {
            return "SELECT p From Produto p";
        }
                
        @Override
        public void setParameter(Query query){}
    },
    
    NOME{
        
        private ParametroPesquisa parametroPesquisa;
        
        @Override
        public String getQuery() {
            return "SELECT p From Produto p WHERE p.nome =:nome";
        }
        @Override
        public void setParameter(Query query){
            query.setParameter("nome", parametroPesquisa.getValue() );
        }
        
        public void setParametroPesquisa(ParametroPesquisa parametroPesquisa){
            this.parametroPesquisa = parametroPesquisa;
        }
        
    },
    
    ESTOQUE{
        private ParametroPesquisa parametroPesquisa;
        
        @Override
        public String getQuery() {
            return "SELECT p From Produto p WHERE p.estoque =:estoque";
        }
        @Override
        public void setParameter(Query query){
            query.setParameter("estoque", parametroPesquisa.getValue() );
        }
        
        public void setParametroPesquisa(ParametroPesquisa parametroPesquisa){
            this.parametroPesquisa = parametroPesquisa;
        }
    },
    
    VALOR{
        private ParametroPesquisa parametroPesquisa;
        
        @Override
        public String getQuery() {
            return "SELECT p From Produto p WHERE p.valor =:valor";
        }
        @Override
        public void setParameter(Query query){
            query.setParameter("valor", parametroPesquisa.getValue() );
        }
        
        public void setParametroPesquisa(ParametroPesquisa parametroPesquisa){
            this.parametroPesquisa = parametroPesquisa;
        }
    }
    
    
}
