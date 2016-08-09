/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.srestoque.testesunitarios;

import br.edu.ifpb.praticas.srestoque.regrasnegocio.exceptions.ErroValidacaoProduto;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Produto;
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
    
    
    @Test(expected = ErroValidacaoProduto.class)
    public void inserirProdutoNull() throws ErroValidacaoProduto{
        cp.setProduto(null);
        cp.salvarProduto();
        verify(gp).salvarProduto(null);
    }
    
    @Test(expected = ErroValidacaoProduto.class)
    public void inserirProdutoEstoqueNegativo() throws ErroValidacaoProduto{
        Produto p = new Produto();
        p.setEstoque(-10);
        p.setId(0);
        p.setValor(10);
        p.setDescricao("dksjdls");
         cp.setProduto(p);
        cp.salvarProduto();
        verify(gp).salvarProduto(p);
    }
    
    @Test(expected = ErroValidacaoProduto.class)
    public void inserirProdutoValorNegativo() throws ErroValidacaoProduto{
        Produto p = new Produto();
        p.setEstoque(10);
        p.setId(0);
        p.setValor(-10);
        p.setDescricao("dksjdls");
         cp.setProduto(p);
        cp.salvarProduto();
        verify(gp).salvarProduto(p);
    }
    
    @Test(expected = ErroValidacaoProduto.class)
    public void inserirProdutoDescricaoNula() throws ErroValidacaoProduto{
        
        Produto p = new Produto();
        p.setEstoque(10);
        p.setId(0);
        p.setValor(10);
        //p.setDescricao();
        cp.setProduto(p);
        cp.salvarProduto();
        verify(gp).salvarProduto(p);
        
    }
    
    @Test(expected = ErroValidacaoProduto.class)
    public void inserirProdutoDescricaoVazia() throws ErroValidacaoProduto{
        Produto p = new Produto();
        p.setEstoque(10);
        p.setId(0);
        p.setValor(10);
        p.setDescricao("    ");
        cp.setProduto(p);
        cp.salvarProduto();
        verify(gp).salvarProduto(p);
    }
    
}
