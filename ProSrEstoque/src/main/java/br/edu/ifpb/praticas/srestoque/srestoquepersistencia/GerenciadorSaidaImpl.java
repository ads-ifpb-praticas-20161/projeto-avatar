/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.srestoque.srestoquepersistencia;

import br.edu.ifpb.praticas.srestoque.exceptions.NenhumaSaidaRealizada;
import br.edu.ifpb.praticas.srestoque.exceptions.SaidaNaoEncontrada;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Saida;
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
public class GerenciadorSaidaImpl implements GerenciadorSaida {

    @PersistenceContext(unitName = "ProSrEstoque_PU")
    private EntityManager em;
    
    @Override
    public void salvarSaida(Saida saida) {
        em.persist(saida);
    }

    @Override
    public void atualizarSaida(Saida saida) {
        em.merge(saida);
    }

    @Override
    public List<Saida> listarSaidas() throws NenhumaSaidaRealizada {
        
        Query query = em.createQuery("SELECT s FROM Saida s");
        List<Saida> saidas = query.getResultList();
        if(saidas.isEmpty())
            throw new NenhumaSaidaRealizada("Não existe nenhuma saida realizada.");
        return saidas;
    
    }

    @Override
    public List<Saida> pesquisarPorData(Date date) throws SaidaNaoEncontrada {
        
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        Query query = em.createQuery("SELECT e FROM Saida e WHERE e.data between '" + sqlDate.toString() + "' and e.data");
        List<Saida> saidas = query.getResultList();
        if(saidas.isEmpty())
            throw new SaidaNaoEncontrada("Saida de data '" + sqlDate.toString() + "' não encontrada");
        return saidas;
    
    }

    @Override
    public List<Saida> pesquisarPorProdutoId(int produtoId) throws SaidaNaoEncontrada {
        
        Query query = em.createQuery("SELECT e FROM Saida e WHERE e.produto.id = ?1");
        query.setParameter(1, produtoId);
        List<Saida> saidas = query.getResultList();
        if(saidas.isEmpty())
            throw new SaidaNaoEncontrada("Saida de produto '" + produtoId + "' não encontrada");
        return saidas;
        
    }

    @Override
    public List<Saida> pesquisarPorProdutoDescricao(String produtoDescricao) throws SaidaNaoEncontrada {
        
        Query query = em.createQuery("SELECT e FROM Saida e WHERE e.produto.descricao LIKE CONCAT('%', ?1, '%')");
        query.setParameter(1, produtoDescricao);
        List<Saida> saidas = query.getResultList();
        if(saidas.isEmpty())
            throw new SaidaNaoEncontrada("Saida de produto '" + produtoDescricao + "' não encontrada");
        return saidas;
    
    }

    @Override
    public List<Saida> pesquisarPorQuantidade(int quantidade) throws SaidaNaoEncontrada {
        
        Query query = em.createQuery("SELECT e FROM Saida e WHERE e.quantidade = ?1");
        query.setParameter(1, quantidade);
        List<Saida> saidas = query.getResultList();
        if(saidas.isEmpty())
            throw new SaidaNaoEncontrada("Saida de quantidade '" + quantidade + "' não encontrada");
        return saidas;
    
    }

    @Override
    public void removerSaida(Saida saida) throws SaidaNaoEncontrada {
        
        if(em.contains(saida)){
            em.remove(saida);
        }
        else{
            em.remove(buscarPorId(saida.getId()));
        }
    
    }
    
    public Saida buscarPorId(int id) throws SaidaNaoEncontrada {
        Saida s = em.find(Saida.class, id);
        if(s == null){
            throw new SaidaNaoEncontrada("Saida de id: " + id + " nao existe!");
        }
        return s;
    }
    
}
