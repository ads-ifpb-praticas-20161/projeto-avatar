/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.srestoque.srestoquepersistencia;

import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Entrada;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Produto;
import java.util.Date;
import java.util.List;
import java.util.GregorianCalendar;
import java.util.Calendar;
/**
 *
 * @author Marcus Vinícius
 */
public class Main {
    
    public static void main(String[] args){
        GerenciadorProduto gp = new GerenciadorProdutoImpl();
        GerenciadorEntrada ge = new GerenciadorEntradaImpl();
        
        try{
           
           List<Entrada> es = ge.listarEntradas();
           System.out.println(es);
            
        }
        catch(RuntimeException e){
           e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        System.out.println("salvou");
    }
    
}
