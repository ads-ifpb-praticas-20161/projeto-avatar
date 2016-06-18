/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.srestoque.srestoquepersistencia;

import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Produto;

/**
 *
 * @author Marcus Vinícius
 */
public class Main {
    
    public static void main(String[] args){
        GerenciadorProduto gp = new GerenciadorProdutoImpl();
        
        Produto p = new Produto();
        p.setDescricao("teste");
        p.setEstoque(12);
        p.setValor((float) 32.2);
        p.setId(0);
        
        gp.salvarProduto(p);
        System.out.println("salvou");
    }
    
}
