/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticas.srestoque.web;

import praticas.srestoque.repositorio.ClienteRepository;
import praticas.srestoque.repositorio.FuncionarioRepository;
import praticas.srestoque.repositorio.ProdutoRepository;

/**
 *
 * @author vmvini
 */
public enum RepositoryType {

    PRODUTO{

        @Override
        public Class getRepositoryClass() {
            return ProdutoRepository.class;
        }
        
    },
    
    FUNCIONARIO{

        @Override
        public Class getRepositoryClass() {
            return FuncionarioRepository.class;
        }
        
    },
    
    CLIENTE{

        @Override
        public Class getRepositoryClass() {
            return ClienteRepository.class;
        }
        
    };
    
    public abstract Class getRepositoryClass();

}
