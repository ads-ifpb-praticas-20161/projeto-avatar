/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticas.srestoque.testes.integracao;

import javax.inject.Inject;
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
import praticas.srestoque.repositorio.ClienteRepository;
import org.jboss.arquillian.persistence.UsingDataSet;

/**
 *
 * @author vmvini
 */

@RunWith(Arquillian.class)
public class ClienteTest {
    
    @Inject 
    private ClienteRepository clienteRepository;
    
    @Deployment
    public static JavaArchive createTestArchive() {
        return ShrinkWrap.create(JavaArchive.class, "test.jar" )
                .addPackage(ClienteRepository.class.getPackage())
                .addPackage(Cliente.class.getPackage())
                //.addClass(ControleLogin.class)
                //.addClass(GerenciadorUsuario.class)
                //.addClass(GerenciadorUsuarioImpl.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"))
                .addAsResource("META-INF/persistence.xml");
    }
    
    @Test()
    @UsingDataSet("datasets/clientes.xml")
    public void BuscarCliente() {
        Cliente cliente = clienteRepository.getById("01753059437");
        System.out.println(cliente);
        assertEquals("vmvinisds", cliente.getNome());
        assertEquals("Jose Dantas Nobre", cliente.getEndereco().getRua());
    }
    
    
}
