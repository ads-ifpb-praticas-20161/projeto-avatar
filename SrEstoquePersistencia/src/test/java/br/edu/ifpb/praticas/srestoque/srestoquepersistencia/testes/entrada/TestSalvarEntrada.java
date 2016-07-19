/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.srestoque.srestoquepersistencia.testes.entrada;

import br.edu.ifpb.praticas.srestoque.exceptions.entrada.SalvarEntradaNulaException;
import br.edu.ifpb.praticas.srestoque.exceptions.entrada.SalvarEntradaSemAtributoException;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Entrada;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Produto;
import br.edu.ifpb.praticas.srestoque.srestoquepersistencia.EntityManagerCreator;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.junit.Before;
import org.junit.Test;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.Persistence;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;

/**
 *
 * @author vmvini
 */



public class TestSalvarEntrada {
    
    
    private static final String DB_DIALECT = "org.hibernate.dialect.HSQLDialect";
private static final String DB_DRIVER = "org.hsqldb.jdbcDriver";
private static final String DB_URL = "jdbc:hsqldb:mem:testdb";
private static final String DB_USER = "sa";
private static final String DB_PASSWORD = "";
    
   private EntityManager em;
    @Before
    public void setUp() throws IOException, DataSetException, DatabaseUnitException, Exception{
        
        em = Persistence.createEntityManagerFactory("teste").createEntityManager();
        
        FlatXmlDataSetBuilder aBuilder = new FlatXmlDataSetBuilder();
        
        FileInputStream aDataStream = new FileInputStream("src/test/resources/META-INF/entradas.xml");
        
        IDataSet dataSet = aBuilder.build(aDataStream);
        
        final IDatabaseConnection connection = new DatabaseConnection(getDatabaseConnection());

        try{
            DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
        }
        finally{
            connection.close();
        }

    }
    
    private Connection getDatabaseConnection() throws Exception{
        Class.forName(DB_DRIVER);
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
    
    
    @Test
    public void testEntradaJaExistente(){
        Entrada e = em.find(Entrada.class, 0);
        
        
        
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        
    }
    /*
    @Test(expected = IllegalArgumentException.class)
    public void entradaNull(){
        
    }
    
    @Test(expected = PersistenceException.class)
    public void entradaSemProduto(){
        
    }
    
    @Test(expected = PersistenceException.class)
    public void entradaSemData(){
        
    }
    
    @Test(expected = PersistenceException.class)
    public void entradaSemQuantidade(){
        
    }   
    */
    
    
    @After
    public void tearDown() throws Exception{
        em.close();

        final Connection connection = getDatabaseConnection();
        try{
            connection.createStatement().execute("SHUTDOWN");
        }
        finally{
            connection.close();
        }
    }
    
}
