package br.edu.ifpb.praticas.srestoque.srestoquepersistencia;

import br.edu.ifpb.praticas.srestoque.exceptions.NenhumProdutoCadastrado;
import br.edu.ifpb.praticas.srestoque.exceptions.ProdutoNaoEncontrado;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Produto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Marcus Vinícius
 * @author Wellington Lins Claudino Duarte   @mail wellingtonlins2013@gmail.com
 */
@Stateless
public class GerenciadorProdutoImpl implements GerenciadorProduto {

    @PersistenceContext(unitName = "ProSrEstoque_PU")
    private EntityManager em;

    @Override
    public void salvarProduto(Produto produto) {
        em.persist(produto);
    }

    @Override
    public void atualizarProduto(Produto produto) throws ProdutoNaoEncontrado {
        em.merge(produto);
    }

    @Override
    public void removerProduto(Produto produto) throws ProdutoNaoEncontrado {

        if(em.contains(produto)){
            em.remove(produto);
        }
        else{
            em.remove(buscarPorId(produto.getId()));
        }
        

    }

    @Override
    public Produto buscarPorId(int id) throws ProdutoNaoEncontrado {
        Produto p = em.find(Produto.class, id);
        if(p == null){
            throw new ProdutoNaoEncontrado("Produto de id: " + id + " nao encontrado!");
        }
        return p;

    }

    @Override
    public List<Produto> buscarPorDescricao(String descricao) throws ProdutoNaoEncontrado {

        Query query = em.createQuery("SELECT p FROM produto p WHERE p.descricao LIKE CONCAT('%', ?1, '%')");
        query.setParameter(1, descricao);
        List<Produto> produtos = query.getResultList();
        if (produtos.isEmpty()) {
            throw new ProdutoNaoEncontrado("Produto de descricao '" + descricao + "' não encontrado");
        }
        return produtos;
    }

    @Override
    public List<Produto> listarProdutos() throws NenhumProdutoCadastrado {

        Query query = em.createQuery("SELECT p FROM produto p");
        List<Produto> produtos = query.getResultList();
        if (produtos.isEmpty()) {
            throw new NenhumProdutoCadastrado("Não existe nenhum produto cadastrado.");
        }
        return produtos;
    }
}