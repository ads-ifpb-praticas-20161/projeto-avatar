package br.edu.ifpb.praticas.srestoque.regrasnegocio.exceptions;

/**
 *
 * @author vmvini
 * @author Wellington Lins Claudino Duarte   @mail wellingtonlins2013@gmail.com
 */
public class EstoqueNaoSuficiente extends Exception {
    
    public EstoqueNaoSuficiente(String msg){
        super(msg);
    }
    
}
