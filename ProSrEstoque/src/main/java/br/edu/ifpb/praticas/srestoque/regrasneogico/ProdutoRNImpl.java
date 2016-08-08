package br.edu.ifpb.praticas.srestoque.regrasneogico;

import br.edu.ifpb.praticas.srestoque.exceptions.NenhumProdutoCadastrado;
import br.edu.ifpb.praticas.srestoque.exceptions.ProdutoNaoEncontrado;
import br.edu.ifpb.praticas.srestoque.regrasnegocio.exceptions.ErroValidacaoProduto;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Produto;
import br.edu.ifpb.praticas.srestoque.srestoquepersistencia.GerenciadorProdutoImpl;
import java.util.List;

/**
 *
 * @author laerton
 * @author Wellington Lins Claudino Duarte   @mail wellingtonlins2013@gmail.com
 */
public class ProdutoRNImpl implements ProdutoRN{
    private GerenciadorProdutoImpl gerenciadorProdutoImpl ;

    public ProdutoRNImpl() {
        gerenciadorProdutoImpl = new GerenciadorProdutoImpl();
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
        
        gerenciadorProdutoImpl.salvarProduto(produto);
    }

    @Override
    public void atualizarProduto(Produto produto) throws ProdutoNaoEncontrado, ErroValidacaoProduto {
        if (produto.getDescricao().trim().equals("")){
            throw  new ErroValidacaoProduto("Produto não pode conter descrição vazia ou em branco.");
        }
        gerenciadorProdutoImpl.atualizarProduto(produto);
    }

    @Override
    public void removerProduto(Produto produto) throws ProdutoNaoEncontrado {
        gerenciadorProdutoImpl.removerProduto(produto);
    }

    @Override
    public Produto buscarPorId(int id) throws ProdutoNaoEncontrado {
        if (id <=0){
            throw  new ProdutoNaoEncontrado("Id para busca deve ser um valor positivo maior que zero.");
        }
        return gerenciadorProdutoImpl.buscarPorId(id);
    }

    @Override
    public List<Produto> buscarPorDescricao(String descricao) throws ProdutoNaoEncontrado {
        if (descricao.trim().equals("")){
            throw  new ProdutoNaoEncontrado("Descrição para buscar produto não pode ser vazia ou em branco.");
        }
            return gerenciadorProdutoImpl.buscarPorDescricao(descricao);
    }

    @Override
    public List<Produto> listarProdutos() throws NenhumProdutoCadastrado {
        List<Produto> lista = gerenciadorProdutoImpl.listarProdutos();
        if (lista.size()==0){
            throw  new NenhumProdutoCadastrado("Não há produtos cadastrados");
        }
        return lista;
    }
    
}