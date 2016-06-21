/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.srestoque.srestoquepersistencia;

import br.edu.ifpb.praticas.srestoque.exceptions.EntradaNaoEncontrada;
import br.edu.ifpb.praticas.srestoque.exceptions.NenhumProdutoCadastrado;
import br.edu.ifpb.praticas.srestoque.exceptions.NenhumaEntradaRealizada;
import br.edu.ifpb.praticas.srestoque.exceptions.ProdutoNaoEncontrado;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Entrada;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Produto;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author vmvini
 */
public class GerenciadorEntradaImpl implements GerenciadorEntrada {

    private EntityManager em;
    
    public GerenciadorEntradaImpl(){
        em = EntityManagerCreator.getInstance().getEntityManager();
    }
    
    @Override
    public void salvarEntrada(Entrada entrada) {
        em.getTransaction().begin();
        em.persist(entrada);
        em.flush();
        em.getTransaction().commit();
    }

    

    @Override
    public List<Entrada> listarEntradas() throws NenhumaEntradaRealizada {
        
        Query query = em.createQuery("SELECT p FROM Entrada p");
        List<Entrada> entrada = query.getResultList();
        if(entrada.isEmpty())
            throw new NenhumaEntradaRealizada("Não existe nenhuma entrada realizada.");
        return entrada;
    
    }

    @Override
    public void removerEntrada(Entrada entrada) throws EntradaNaoEncontrada {
        em.getTransaction().begin();
        if(em.contains(entrada)){
            em.remove(entrada);
            em.flush();
        }
        else
            throw new EntradaNaoEncontrada("Entrada " + entrada.getData() + " id: " + entrada.getId() + " não encontrado");
        em.getTransaction().commit();
    }

    @Override
    public List<Entrada> pesquisarPorData(Date date) throws EntradaNaoEncontrada {
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        Query query = em.createQuery("SELECT e FROM Entrada e WHERE e.data between '" + sqlDate.toString() + "' and e.data");
        List<Entrada> entradas = query.getResultList();
        if(entradas.isEmpty())
            throw new EntradaNaoEncontrada("Entrada de data '" + sqlDate.toString() + "' não encontrada");
        return entradas;
    
    }

    @Override
    public List<Entrada> pesquisarPorProdutoId(int produtoid) throws EntradaNaoEncontrada {
        Query query = em.createQuery("SELECT e FROM Entrada e WHERE e.produto.id = ?1");
        query.setParameter(1, produtoid);
        List<Entrada> entradas = query.getResultList();
        if(entradas.isEmpty())
            throw new EntradaNaoEncontrada("Entrada de produto '" + produtoid + "' não encontrada");
        return entradas;
    }

    @Override
    public List<Entrada> pesquisarPorProdutoDescricao(String produtoDescricao) throws EntradaNaoEncontrada {
        Query query = em.createQuery("SELECT e FROM Entrada e WHERE e.produto.descricao LIKE CONCAT('%', ?1, '%')");
        query.setParameter(1, produtoDescricao);
        List<Entrada> entradas = query.getResultList();
        if(entradas.isEmpty())
            throw new EntradaNaoEncontrada("Entrada de produto '" + produtoDescricao + "' não encontrada");
        return entradas;
    
    }

    @Override
    public List<Entrada> pesquisarPorQuantidade(int quantidade) throws EntradaNaoEncontrada {
        Query query = em.createQuery("SELECT e FROM Entrada e WHERE e.quantidade = ?1");
        query.setParameter(1, quantidade);
        List<Entrada> entradas = query.getResultList();
        if(entradas.isEmpty())
            throw new EntradaNaoEncontrada("Entrada de quantidade '" + quantidade + "' não encontrada");
        return entradas;
    
    }

   
    
    
}
