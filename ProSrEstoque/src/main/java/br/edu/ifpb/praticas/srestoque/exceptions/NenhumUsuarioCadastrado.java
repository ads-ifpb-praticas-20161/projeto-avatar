package br.edu.ifpb.praticas.srestoque.exceptions;

/**
 * Document   NenhumUsuarioCadastrado
 * @Date  08/08/2016 @Time 15:50:53
 * @author Wellington Lins Claudino Duarte   
 * @mail wellingtonlins2013@gmail.com
 */ 
public class NenhumUsuarioCadastrado extends Exception {
    public NenhumUsuarioCadastrado(String mensagem){
        super(mensagem);
    }
}