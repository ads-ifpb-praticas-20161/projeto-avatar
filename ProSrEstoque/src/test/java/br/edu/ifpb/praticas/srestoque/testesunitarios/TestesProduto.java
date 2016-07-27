/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.srestoque.testesunitarios;

import br.edu.ifpb.praticas.srestoque.srestoquepersistencia.GerenciadorProduto;
import br.edu.ifpb.praticas.srestoque.srestoqueweb.ControleProduto;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
/**
 *
 * @author vmvini
 */
public class TestesProduto {
    
    private ControleProduto cp;
    
    @Mock 
    private GerenciadorProduto gp; //criar um mock do gerenciadorProduto
    
    //diz ao mockito para criar o mock acima através da anotação @Mock
    @Rule public  MockitoRule mockitoRule = MockitoJUnit.rule();
    
    @Before
    public void createControleProduto(){
        cp = new ControleProduto();
        cp.setGerenciadorProdutoImpl(gp);
    }
    
    
    @Test(expected = NullPointerException.class)
    public void inserirProdutoNull(){
        cp.setProduto(null);
        cp.salvarProduto();
        verify(gp).salvarProduto(null);
    }
    
}
