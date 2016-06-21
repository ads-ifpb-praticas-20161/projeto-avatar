/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.srestoque.srestoquepersistencia;

import br.edu.ifpb.praticas.srestoque.exceptions.NenhumProdutoCadastrado;
import br.edu.ifpb.praticas.srestoque.exceptions.ProdutoNaoEncontrado;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Marcus Vinícius
 */
public class GerenciadorProdutoImpl implements GerenciadorProduto {

    private EntityManager em;
    
    public GerenciadorProdutoImpl(){
        em = EntityManagerCreator.getInstance().getEntityManager();
    }
    
    
    @Override
    public void salvarProduto(Produto produto) {
        em.getTransaction().begin();
        em.persist(produto);
        em.flush();
        em.getTransaction().commit();
    }

    

    @Override
    public void removerProduto(Produto produto) throws ProdutoNaoEncontrado{
        em.getTransaction().begin();
        if(em.contains(produto)){
            em.remove(produto);
            em.flush();
        }
        else
            throw new ProdutoNaoEncontrado("Produto " + produto.getDescricao() + " id: " + produto.getId() + " não encontrado");
        em.getTransaction().commit();
    
    }

    @Override
    public Produto buscarPorId(int id) throws ProdutoNaoEncontrado {
        try{
            em.getTransaction().begin();
            Produto produto = em.getReference(Produto.class, id);
            em.getTransaction().commit();
            return produto;
        }
        catch(EntityNotFoundException e){
            throw new ProdutoNaoEncontrado("Produto de id " + id + " não encontrado");
        }
        
        
    
    }

    @Override
    public List<Produto> buscarPorDescricao(String descricao) throws ProdutoNaoEncontrado{
        
        Query query = em.createQuery("SELECT p FROM Produto p WHERE p.descricao LIKE CONCAT('%', ?1, '%')");
        query.setParameter(1, descricao);
        List<Produto> produtos = query.getResultList();
        if(produtos.isEmpty())
            throw new ProdutoNaoEncontrado("Produto de descricao '" + descricao + "' não encontrado");
        return produtos;
    
    }

    @Override
    public List<Produto> listarProdutos() throws NenhumProdutoCadastrado {
            
        Query query = em.createQuery("SELECT p FROM Produto p");
        List<Produto> produtos = query.getResultList();
        if(produtos.isEmpty())
            throw new NenhumProdutoCadastrado("Não existe nenhum produto cadastrado.");
        return produtos;
    }
    
}
