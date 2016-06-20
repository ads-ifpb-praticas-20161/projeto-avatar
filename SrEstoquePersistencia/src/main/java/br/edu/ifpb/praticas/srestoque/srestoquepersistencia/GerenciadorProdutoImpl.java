/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.srestoque.srestoquepersistencia;

import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Marcus Vinícius
 */
public class GerenciadorProdutoImpl implements GerenciadorProduto {

    private EntityManager em;
    
    public GerenciadorProdutoImpl(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("srEstoquePU");
        em = emf.createEntityManager();
    }
    
    
    @Override
    public void salvarProduto(Produto produto) {
        em.getTransaction().begin();
        if(!em.contains(produto)){
            em.persist(produto);
            em.flush();
        }
        em.getTransaction().commit();
    }

    @Override
    public void atualizarProduto(Produto produto) {
        em.getTransaction().begin();
        if(!em.contains(produto)){
            em.refresh(produto);
            em.flush();
        }
        em.getTransaction().commit();
    
    }

    @Override
    public void removerProduto(Produto produto) {
        em.getTransaction().begin();
        if(!em.contains(produto)){
            em.remove(produto);
            em.flush();
        }
        em.getTransaction().commit();
    
    }

    @Override
    public Produto buscarPorId(int id) {
        em.getTransaction().begin();
        Produto produto = em.getReference(Produto.class, id);
        em.getTransaction().commit();
        return produto;
    
    }

    @Override
    public List<Produto> buscarPorDescricao(String descricao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produto> listarProdutos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
