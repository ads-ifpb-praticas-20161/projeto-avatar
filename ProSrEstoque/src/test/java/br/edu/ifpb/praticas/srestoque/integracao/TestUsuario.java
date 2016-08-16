/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.srestoque.integracao;

import br.edu.ifpb.praticas.srestoque.exceptions.UsuarioNaoEncontrado;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Usuario;
import br.edu.ifpb.praticas.srestoque.srestoquepersistencia.GerenciadorUsuario;
import br.edu.ifpb.praticas.srestoque.srestoquepersistencia.GerenciadorUsuarioImpl;
import br.edu.ifpb.praticas.srestoque.srestoqueweb.ControleLogin;
//import br.edu.ifpb.praticas.srestoque.srestoqueweb.ControleLogin;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.security.sasl.AuthenticationException;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.PersistenceTest;
import org.jboss.arquillian.persistence.TransactionMode;
import org.jboss.arquillian.persistence.Transactional;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author vmvini
 */


@RunWith(Arquillian.class)
@PersistenceTest
@Transactional(TransactionMode.ROLLBACK)
public class TestUsuario {
    
    
    @Inject 
    private ControleLogin controleLogin;
    
    //@EJB
    //private GerenciadorUsuario gerenciadorUsuarioImpl;
    
    @Deployment
    public static JavaArchive createTestArchive() {
        return ShrinkWrap.create(JavaArchive.class, "test.jar" )
                .addPackages(true, "br.edu.ifpb.praticas.srestoque.exceptions", "br.edu.ifpb.praticas.srestoque.regrasnegocio.exceptions", "br.edu.ifpb.praticas.srestoque.srestoqueentidades", "br.edu.ifpb.praticas.srestoque.srestoquepersistencia", "br.edu.ifpb.praticas.srestoque.srestoqueweb")
                //.addPackage(NaoEhFuncionario.class.getPackage())
                //.addClass(ControleLogin.class)
                //.addClass(GerenciadorUsuario.class)
                //.addClass(GerenciadorUsuarioImpl.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"))
                .addAsResource("META-INF/persistence.xml");
    }
    
    @Test()
    @UsingDataSet("datasets/usuarios.xml")
    public void logar() throws UsuarioNaoEncontrado {
        
        //Usuario user = controleLogin.login("root@hotmail.com", "123456dsds");
        Usuario user = controleLogin.login("root@hotmail.com", "fdf");
        assertEquals("vmvini", user.getNome());
    }
    
}
