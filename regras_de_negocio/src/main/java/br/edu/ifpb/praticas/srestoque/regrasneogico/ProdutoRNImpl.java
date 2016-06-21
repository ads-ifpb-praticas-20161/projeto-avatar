/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.srestoque.regrasneogico;

import br.edu.ifpb.praticas.srestoque.exceptions.NenhumProdutoCadastrado;
import br.edu.ifpb.praticas.srestoque.exceptions.ProdutoNaoEncontrado;
import br.edu.ifpb.praticas.srestoque.regrasnegocio.exceptions.ErroValidacaoProduto;
import br.edu.ifpb.praticas.srestoque.regrasneogico.ProdutoRN;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Produto;
import br.edu.ifpb.praticas.srestoque.srestoquepersistencia.GerenciadorProdutoImpl;
import java.util.List;

/**
 *
 * @author laerton
 */
public class ProdutoRNImpl implements ProdutoRN{
    private GerenciadorProdutoImpl gp ;

    public ProdutoRNImpl() {
        gp = new GerenciadorProdutoImpl();
    }
    
    

    @Override
    public void salvarProduto(Produto produto) throws ErroValidacaoProduto {
        if (produto.getDescricao().trim().equals("") ){
            throw  new ErroValidacaoProduto("Produto não pode conter descrição vazia ou em branco.");
        }
        if (produto.getDescricao() == null){
            throw  new ErroValidacaoProduto("Produto não pode conter descrição nula.");
        }
        if (produto.getValor() <=0){
            throw  new ErroValidacaoProduto("Produto não pode conter valor negátivos ou zero.");
        }
        
        gp.salvarProduto(produto);
    }

    @Override
    public void atualizarProduto(Produto produto) throws ProdutoNaoEncontrado, ErroValidacaoProduto {
        salvarProduto(produto);
    }

    @Override
    public void removerProduto(Produto produto) throws ProdutoNaoEncontrado {
        gp.removerProduto(produto);
    }

    @Override
    public Produto buscarPorId(int id) throws ProdutoNaoEncontrado {
        return gp.buscarPorId(id);
    }

    @Override
    public List<Produto> buscarPorDescricao(String descricao) throws ProdutoNaoEncontrado {
        return gp.buscarPorDescricao(descricao);
    }

    @Override
    public List<Produto> listarProdutos() throws NenhumProdutoCadastrado {
        return gp.listarProdutos();
    }
    
}
