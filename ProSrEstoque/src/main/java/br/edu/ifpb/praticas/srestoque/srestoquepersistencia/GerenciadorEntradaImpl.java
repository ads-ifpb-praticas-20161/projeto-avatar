/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.srestoque.srestoquepersistencia;
import br.edu.ifpb.praticas.srestoque.exceptions.EntradaNaoEncontrada;
import br.edu.ifpb.praticas.srestoque.exceptions.NenhumProdutoCadastrado;
import br.edu.ifpb.praticas.srestoque.exceptions.NenhumaEntradaRealizada;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Entrada;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Produto;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
/**
 *
 * @author vmvini
 */

@Stateless
public class GerenciadorEntradaImpl implements GerenciadorEntrada {
    
    @PersistenceContext(unitName = "ProSrEstoque_PU")
    private EntityManager em;

    @Override
    public void salvarEntrada(Entrada entrada) {
        
        em.persist(entrada);
        
        
    }

    @Override
    public void atualizarEntrada(Entrada entrada) throws EntradaNaoEncontrada {
        em.merge(entrada);
    }

    @Override
    public List<Entrada> listarEntradas() throws NenhumaEntradaRealizada {
        Query query = em.createQuery("SELECT e FROM entrada e");
        List<Entrada> entradas = query.getResultList();
        if (entradas.isEmpty()) {
            throw new NenhumaEntradaRealizada("Não existe nenhum produto cadastrado.");
        }
        return entradas;
    }

    @Override
    public List<Entrada> pesquisarPorData(Date date) throws EntradaNaoEncontrada {
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        Query query = em.createQuery("SELECT e FROM Entrada e WHERE e.data between '" + sqlDate.toString() + "' AND e.data");
        List<Entrada> entradas = query.getResultList();
        if(entradas.isEmpty())
            throw new EntradaNaoEncontrada("Entrada de data '" + sqlDate.toString() + "' não encontrada");
        return entradas;
    }

    @Override
    public List<Entrada> pesquisarPorProdutoId(int produtoId) throws EntradaNaoEncontrada {
        
        Query query = em.createQuery("SELECT e FROM Entrada e WHERE e.produto.id = ?1");
        query.setParameter(1, produtoId);
        List<Entrada> entradas = query.getResultList();
        if(entradas.isEmpty())
            throw new EntradaNaoEncontrada("Entrada de produto '" + produtoId + "' não encontrada");
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

    @Override
    public void removerEntrada(Entrada entrada) throws EntradaNaoEncontrada {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entrada buscarPorId(int id) throws EntradaNaoEncontrada {
        
        Entrada e = em.find(Entrada.class, id);
        if(e == null){
            throw new EntradaNaoEncontrada("Entrada de id: " + id + " não encontrada");
        }
        return e;
    
    }
    
    
    
    
    
}
