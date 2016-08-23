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
public enum FuncionarioSearchStrategy implements SearchStrategy {

    TODOS{
        @Override
        public String getQuery() {
            return "SELECT f FROM Funcionario f";
        }

        @Override
        public void setParameter(Query query) {}

        @Override
        public void setParametroPesquisa(ParametroPesquisa ParametroPesquisa) {}
    }
    
    
    
}
