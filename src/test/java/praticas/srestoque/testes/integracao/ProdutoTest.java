/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticas.srestoque.testes.integracao;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasProperty;
import org.jboss.arquillian.junit.Arquillian;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import praticas.srestoque.entidades.Produto;
import praticas.srestoque.excecoes.ChavePrimariaException;
import praticas.srestoque.repositorio.ClienteRepository;
import praticas.srestoque.repositorio.ProdutoRepository;
import praticas.srestoque.web.ProdutosMB;
import praticas.srestoque.web.SessaoFuncionario;

/**
 *
 * @author vmvini
 */
@RunWith(Arquillian.class)
public class ProdutoTest extends TesteIntegracao {

    

    @EJB
    private ProdutoRepository produtoRepository;



    @Test
    public void inserirProduto() throws IOException, ChavePrimariaException {
        
        Produto p = new Produto();
        
        p.setDescricao("notebook da apple");
        p.setNome("macbook pro");
        p.setEstoque(12);
        p.setValor(3999.90);
        produtoRepository.salvar(p);
        
        List<Produto> produtos = produtoRepository.listar();

        assertThat(produtos, contains(
              
                hasProperty("valor", is(3999.90))
                
        ));

    }

}
