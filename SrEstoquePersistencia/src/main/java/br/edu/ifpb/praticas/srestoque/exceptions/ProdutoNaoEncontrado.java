/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.srestoque.exceptions;

/**
 *
 * @author vmvini
 */
public class ProdutoNaoEncontrado extends Exception {
    
    public ProdutoNaoEncontrado(String msg){
        super(msg);
    }
    
}
