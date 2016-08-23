/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticas.srestoque.testes.unidade;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import praticas.srestoque.repositorio.ProdutoRepository;
import praticas.srestoque.web.ProdutosMB;

/**
 *
 * @author vmvini
 */
public class ProdutoTest {
    
    private ProdutosMB produtosMB;
    
    @Mock
    private ProdutoRepository pr;
    
    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
    
    @Before
    public void createProdutosMB(){
        produtosMB = new ProdutosMB();
        produtosMB.setPr(pr);
        
    }
    
    @Test(expected = NullPointerException.class)
    public void inserirProdutoNulo(){
        produtosMB.setProduto(null);
        produtosMB.cadastrarProduto();
    }
    
    @Test(expected = RuntimeException.class)
    public void inserirProdutoComNomeVazio(){
        produtosMB.getProduto().setEstoque(12);
        produtosMB.getProduto().setValor(new Float(2.4));
        produtosMB.getProduto().setDescricao("desc");
        produtosMB.getProduto().setNome("");
        produtosMB.cadastrarProduto();
    }
    
    @Test(expected = NullPointerException.class)
    public void inserirProdutoComValorNulo(){
        produtosMB.getProduto().setEstoque(12);
        produtosMB.getProduto().setDescricao("desc");
        produtosMB.getProduto().setNome("nome");
        produtosMB.cadastrarProduto();
    }
    
}
