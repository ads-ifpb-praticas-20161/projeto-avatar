/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.praticas.srestoque.testesunitarios;

import br.edu.ifpb.praticas.srestoque.exceptions.ProdutoNaoEncontrado;
import br.edu.ifpb.praticas.srestoque.regrasnegocio.exceptions.ErroValidacaoSaida;
import br.edu.ifpb.praticas.srestoque.regrasnegocio.exceptions.EstoqueNaoSuficiente;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Entrada;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Produto;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Saida;
import br.edu.ifpb.praticas.srestoque.srestoquepersistencia.GerenciadorEntrada;
import br.edu.ifpb.praticas.srestoque.srestoquepersistencia.GerenciadorProduto;
import br.edu.ifpb.praticas.srestoque.srestoquepersistencia.GerenciadorSaida;
import br.edu.ifpb.praticas.srestoque.srestoqueweb.ControleEntrada;
import br.edu.ifpb.praticas.srestoque.srestoqueweb.ControleSaida;
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


public class TestesSaida {
    private ControleSaida cs;
    
    private Saida saida;
    private Produto produto;
    
    private final int PRODUTO_ESTOQUE = 20;
    
    @Mock 
    private GerenciadorProduto gp; //criar um mock do gerenciadorProduto
    
    @Mock 
    private GerenciadorSaida gs;
    
    //diz ao mockito para criar o mock acima através da anotação @Mock
    @Rule public  MockitoRule mockitoRule = MockitoJUnit.rule();
    
    @Before
    public void createControleEntrada(){
        cs = new ControleSaida();
        cs.setGerenciadorProdutoImpl(gp);
        cs.setGerenciadorSaidaImpl(gs);
        
        saida = new Saida();
        
        produto = new Produto();
        produto.setId(0);
        produto.setDescricao("dasldkj");
        produto.setValor(23);
        produto.setEstoque(PRODUTO_ESTOQUE);
        saida.setProduto(produto);
    }
    
    @Test(expected = NullPointerException.class)
    public void inserirSaidaNula() throws ErroValidacaoSaida, ProdutoNaoEncontrado, EstoqueNaoSuficiente{
        cs.setSaida(null);
        cs.salvarSaida();
    }
    @Test(expected = NullPointerException.class)
    public void inserirSaidaSemData() throws ErroValidacaoSaida, ProdutoNaoEncontrado, EstoqueNaoSuficiente{
        saida.setData(null);
        saida.setQuantidade(PRODUTO_ESTOQUE);
        
        cs.setSaida(saida);
        cs.salvarSaida();
    }
    @Test(expected = NullPointerException.class)
    public void inserirSaidaSemProduto() throws ErroValidacaoSaida, ProdutoNaoEncontrado, EstoqueNaoSuficiente{
        saida.setData(new java.util.Date());
        saida.setQuantidade(PRODUTO_ESTOQUE);
        saida.setProduto(null);
        
        cs.setSaida(saida);
        cs.salvarSaida();
    }
    
    @Test(expected = ErroValidacaoSaida.class)
    public void inserirSaidaDataInvalida()throws ErroValidacaoSaida, ProdutoNaoEncontrado, EstoqueNaoSuficiente{
        LocalDate localDate = LocalDate.of( 2011 , Month.JULY , 3 ); 
        saida.setData(java.sql.Date.valueOf(localDate));
        saida.setQuantidade(PRODUTO_ESTOQUE);
        
        cs.setSaida(saida);
        cs.salvarSaida();
        
    }
    @Test(expected = ErroValidacaoSaida.class)
    public void inserirSaidaQuantidadeInvalida()throws ErroValidacaoSaida, ProdutoNaoEncontrado, EstoqueNaoSuficiente{
        saida.setData(new java.util.Date());
        saida.setQuantidade(-10);
        
        cs.setSaida(saida);
        cs.salvarSaida();
        
    }
    @Test(expected = EstoqueNaoSuficiente.class)
    public void inserirSaidaProdutoSemEstoque()throws ErroValidacaoSaida, ProdutoNaoEncontrado, EstoqueNaoSuficiente{
        saida.setData(new java.util.Date());
        saida.setQuantidade(PRODUTO_ESTOQUE + 10);
        
        cs.setSaida(saida);
        cs.salvarSaida();
        
    }
    
    //teste de integração -> inserirSaidaProdutoNaoExistente
    
}
