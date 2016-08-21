/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticas.srestoque.testes.integracao;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import praticas.srestoque.entidades.Cliente;
import praticas.srestoque.repositorio.ClienteRepository;
import praticas.srestoque.sessionbeans.FuncionarioStateless;

/**
 *
 * @author vmvini
 */
public class TesteIntegracao {
    
    @Deployment
    public static JavaArchive createTestArchive() {
        return ShrinkWrap.create(JavaArchive.class, "test.jar" )
                .addPackage(ClienteRepository.class.getPackage())
                .addPackage(Cliente.class.getPackage())
                .addPackage(FuncionarioStateless.class.getPackage())
                .addAsManifestResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"))
                .addAsResource("META-INF/persistence.xml");
    }
    
}
