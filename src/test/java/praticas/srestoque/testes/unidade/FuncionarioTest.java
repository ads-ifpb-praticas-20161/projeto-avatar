/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticas.srestoque.testes.unidade;

import org.junit.Before;
import org.junit.Rule;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import praticas.srestoque.entidades.TipoFuncionario;
import praticas.srestoque.repositorio.ProdutoRepository;
import praticas.srestoque.sessionbeans.FuncionarioStateless;
import praticas.srestoque.web.FuncionarioMB;
import praticas.srestoque.web.ProdutosMB;

/**
 *
 * @author vmvini
 */
public class FuncionarioTest {
    
     private FuncionarioMB funcionarioMB;
    
    @Mock
    private FuncionarioStateless fs;
    
    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
    
    @Before
    public void createProdutosMB(){
        funcionarioMB = new FuncionarioMB();
        funcionarioMB.setFs(fs);
        
        funcionarioMB.getNovoFuncionario().setEmail("vmvini@hotmail.com");
        funcionarioMB.getNovoFuncionario().setSenha("123");
        funcionarioMB.getNovoFuncionario().setTipo(TipoFuncionario.ATENDENTE);
        
        
    }
    
}
