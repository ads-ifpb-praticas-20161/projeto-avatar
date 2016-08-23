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
public enum ClienteSearchStrategy implements SearchStrategy {

    TODOS{

        @Override
        public void setParameter(Query query) {}

        @Override
        public void setParametroPesquisa(ParametroPesquisa ParametroPesquisa) {}

        @Override
        public String getQuery() {
            return "SELECT c FROM Cliente c";
        }
        
    }

    
}
