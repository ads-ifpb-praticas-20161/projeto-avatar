/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticas.srestoque.testes.integracao;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.naming.AuthenticationException;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import praticas.srestoque.entidades.Cliente;
import praticas.srestoque.entidades.Funcionario;
import praticas.srestoque.entidades.TipoFuncionario;
import praticas.srestoque.excecoes.ChavePrimariaException;
import praticas.srestoque.excecoes.ValidacaoFormularioException;
import praticas.srestoque.repositorio.ClienteRepository;
import praticas.srestoque.sessionbeans.FuncionarioStateless;
import praticas.srestoque.sessionbeans.LoginStateful;

/**
 *
 * @author vmvini
 */
@RunWith(Arquillian.class)
public class FuncionarioTest extends TesteIntegracao {
   
    @EJB
    private FuncionarioStateless funcionarioSB;
    
    @EJB
    private LoginStateful loginSB;
    
    @Test(expected = AuthenticationException.class)
    public void cadastrarELogarComSenhaErrada() throws ChavePrimariaException, AuthenticationException, ValidacaoFormularioException{
        
        Funcionario f = new Funcionario("vmvini@hotmail.com", "123", TipoFuncionario.ADMINISTRADOR);
        
        funcionarioSB.cadastrar(f);
        
        loginSB.logar("vmvini@hotmail.com", "13233");
        
    }
    
    @Test
    public void estaLogado() throws AuthenticationException, ValidacaoFormularioException, ChavePrimariaException{
        Funcionario f = new Funcionario("vmvini@hotmail.com", "123", TipoFuncionario.ADMINISTRADOR);
        funcionarioSB.cadastrar(f);
        loginSB.logar("vmvini@hotmail.com", "123");
        
        assertEquals(loginSB.estaLogado(),true);
    }
    
    
}
