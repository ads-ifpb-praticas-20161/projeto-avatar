/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.srestoque.testesunitarios;

import br.edu.ifpb.praticas.srestoque.exceptions.ProdutoNaoEncontrado;
import br.edu.ifpb.praticas.srestoque.regrasnegocio.exceptions.ErroValidacaoEntrada;
import br.edu.ifpb.praticas.srestoque.regrasnegocio.exceptions.EstoqueNaoSuficiente;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Entrada;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Produto;
import br.edu.ifpb.praticas.srestoque.srestoquepersistencia.GerenciadorEntrada;
import br.edu.ifpb.praticas.srestoque.srestoquepersistencia.GerenciadorProduto;
import br.edu.ifpb.praticas.srestoque.srestoqueweb.ControleEntrada;
import java.time.LocalDate;
import java.time.Month;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;


/**
 *
 * @author vmvini
 */


public class TestesEntrada {

    private ControleEntrada ce;
    
    private Entrada entrada;
    private Produto produto;
    
    @Mock 
    private GerenciadorProduto gp; //criar um mock do gerenciadorProduto
    
    @Mock 
    private GerenciadorEntrada ge;
    
    //diz ao mockito para criar o mock acima através da anotação @Mock
    @Rule public  MockitoRule mockitoRule = MockitoJUnit.rule();
    
    @Before
    public void createControleEntrada(){
        ce = new ControleEntrada();
        ce.setGerenciadorProdutoImpl(gp);
        ce.setGerenciadorEntradaImpl(ge);
        
        entrada = new Entrada();
        
        produto = new Produto();
        entrada.setProduto(produto);
        
    }
    
    @Test(expected = NullPointerException.class)
    public void inserirEntradaNula()throws EstoqueNaoSuficiente, ErroValidacaoEntrada, ProdutoNaoEncontrado{
       
        ce.setEntrada(null);
        ce.salvarEntrada();
        verify(ge).salvarEntrada(null);
    
    }
    
    @Test(expected = NullPointerException.class)
    public void inserirEntradaSemData() throws EstoqueNaoSuficiente, ErroValidacaoEntrada, ProdutoNaoEncontrado{
        entrada.setQuantidade(10);
        entrada.setData(null);
        ce.setEntrada(entrada);
        ce.salvarEntrada();
        verify(ge).salvarEntrada(entrada);
       
    }
    
    @Test(expected = NullPointerException.class)
    public void inserirEntradaSemProduto() throws EstoqueNaoSuficiente, ErroValidacaoEntrada, ProdutoNaoEncontrado{
        
        entrada.setQuantidade(19);
        entrada.setData(new java.util.Date());
        entrada.setProduto(null);
        ce.setEntrada(entrada);
        ce.salvarEntrada();
        verify(ge).salvarEntrada(entrada);
     
    }
    
    @Test(expected = EstoqueNaoSuficiente.class)
    public void inserirEntradaComQuantidadeInvalida() throws EstoqueNaoSuficiente, ErroValidacaoEntrada, ProdutoNaoEncontrado{
        
        entrada.setQuantidade(-10);
        entrada.setData(new java.util.Date());
        ce.setEntrada(entrada);
        ce.salvarEntrada();
        verify(ge).salvarEntrada(entrada);
        
    }
    
    @Test(expected = ErroValidacaoEntrada.class)
    public void inserirEntradaComDataAntiga() throws EstoqueNaoSuficiente, ErroValidacaoEntrada, ProdutoNaoEncontrado{
        LocalDate localDate = LocalDate.of( 2011 , Month.JULY , 3 ); 
        entrada.setQuantidade(12);
        entrada.setData(java.sql.Date.valueOf(localDate));
        ce.setEntrada(entrada);
        ce.salvarEntrada();
        verify(ge).salvarEntrada(entrada);
    }
    
    
    
    //inserirEntradaSemProdutoNoBanco -> colocar em teste de integração
    
       
    
    
    
}
