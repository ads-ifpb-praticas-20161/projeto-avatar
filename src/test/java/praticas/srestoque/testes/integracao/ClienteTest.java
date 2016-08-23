/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticas.srestoque.testes.integracao;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.DataSource;
import org.jboss.arquillian.persistence.PersistenceTest;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import praticas.srestoque.entidades.Cliente;
import praticas.srestoque.repositorio.ClienteRepository;
import org.jboss.arquillian.persistence.UsingDataSet;
import static org.junit.Assert.assertThat;
import static org.junit.internal.matchers.IsCollectionContaining.hasItem;
import praticas.srestoque.entidades.Endereco;
import praticas.srestoque.excecoes.ChavePrimariaException;

/**
 *
 * @author vmvini
 */

@RunWith(Arquillian.class)
public class ClienteTest  extends TesteIntegracao {
    
    @Inject 
    private ClienteRepository clienteRepository;
    
    @Test 
    public void inserirOutroCliente() throws ChavePrimariaException{
        List<String> telefones = new ArrayList<>();
        telefones.add("1234567");
        telefones.add("6543217");
        
        Endereco e = new Endereco("rua1", "bairro1", "cep1", 212, "caicó", "RN");
        
        Cliente cliente = new Cliente("01753059433", "VMVINI", telefones, e);
        
        clienteRepository.salvar(cliente);
        
        
        //verificar se cliente foi persistido
        Cliente encontrado = clienteRepository.getById("01753059433");
        assertEquals("VMVINI", cliente.getNome());
        
        assertEquals("rua1", encontrado.getEndereco().getRua());
        assertEquals("bairro1", encontrado.getEndereco().getBairro());
        assertEquals("cep1", encontrado.getEndereco().getCep() );
        assertEquals(212, encontrado.getEndereco().getNumero());
        //assertEquals(1, encontrado.getEndereco().getId());
        assertEquals("caicó", encontrado.getEndereco().getCidade());
        assertEquals("RN", encontrado.getEndereco().getEstado());
        
        assertEquals(2, encontrado.getTelefones().size());
        
       assertThat(encontrado.getTelefones(),
                          hasItem("1234567"));
       
       assertThat(encontrado.getTelefones(),
                          hasItem("6543217"));
       
       
        clienteRepository.salvar(new Cliente("0125329433", "joao"));
        
        Cliente encontrado2 = clienteRepository.getById("0125329433");
        assertEquals("joao", encontrado2.getNome());
        
        encontrado = clienteRepository.getById("01753059433");
        assertEquals("VMVINI", encontrado.getNome());
       
       
    }
    
    
    @Test
    public void inserirCliente() throws ChavePrimariaException{
        //instanciar novo cliente
        List<String> telefones = new ArrayList<>();
        telefones.add("123456");
        telefones.add("654321");
        
        Endereco e = new Endereco("rua1", "bairro1", "cep1", 212, "caicó", "RN");
        
        Cliente cliente = new Cliente("01753059422", "Pedro Arthur", telefones, e);
        
        clienteRepository.salvar(cliente);
        
        
        //verificar se cliente foi persistido
        Cliente encontrado = clienteRepository.getById("01753059422");
        assertEquals("Pedro Arthur", cliente.getNome());
        
        assertEquals("rua1", encontrado.getEndereco().getRua());
        assertEquals("bairro1", encontrado.getEndereco().getBairro());
        assertEquals("cep1", encontrado.getEndereco().getCep() );
        assertEquals(212, encontrado.getEndereco().getNumero());
        //assertEquals(1, encontrado.getEndereco().getId());
        assertEquals("caicó", encontrado.getEndereco().getCidade());
        assertEquals("RN", encontrado.getEndereco().getEstado());
        
        assertEquals(2, encontrado.getTelefones().size());
        
       assertThat(encontrado.getTelefones(),
                          hasItem("123456"));
       
       assertThat(encontrado.getTelefones(),
                          hasItem("654321"));
        
    }
    
    /*
    @Test()
    @UsingDataSet("datasets/clientes.xml")
    public void BuscarCliente() {
        Cliente cliente = clienteRepository.getById("01753059437");
        System.out.println(cliente);
        assertEquals("vmvini", cliente.getNome());
        
        assertEquals("Jose Dantas Nobre", cliente.getEndereco().getRua());
        assertEquals("Jardim Oasis", cliente.getEndereco().getBairro());
        assertEquals(371, cliente.getEndereco().getNumero());
        assertEquals(1, cliente.getEndereco().getId());
        assertEquals("Cajazeiras", cliente.getEndereco().getCidade());
        assertEquals("PB", cliente.getEndereco().getEstado());
        
        assertEquals(2, cliente.getTelefones().size());
        
       assertThat(cliente.getTelefones(),
                          hasItem("5583999469464"));
       
       assertThat(cliente.getTelefones(),
                          hasItem("5583999469465"));
        
    }*/
    
    
}
