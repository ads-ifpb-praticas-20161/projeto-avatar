package br.edu.ifpb.praticas.srestoque.regrasneogico;

import br.edu.ifpb.praticas.srestoque.regrasnegocio.exceptions.ErroValidacaoProduto;
import br.edu.ifpb.praticas.srestoque.exceptions.NenhumProdutoCadastrado;
import br.edu.ifpb.praticas.srestoque.exceptions.ProdutoNaoEncontrado;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Produto;

import java.util.List;

/**
 *
 * @author vmvini
 * @author Wellington Lins Claudino Duarte   @mail wellingtonlins2013@gmail.com
 */
public interface ProdutoRN {
    
   public void salvarProduto(Produto produto) throws ErroValidacaoProduto;
    
    public void atualizarProduto(Produto produto) throws ProdutoNaoEncontrado, ErroValidacaoProduto;
    
    public void removerProduto(Produto produto) throws ProdutoNaoEncontrado;
    
    public Produto buscarPorId(int id) throws ProdutoNaoEncontrado;
    
    public List<Produto> buscarPorDescricao(String descricao) throws ProdutoNaoEncontrado;
    
    public List<Produto> listarProdutos() throws NenhumProdutoCadastrado;

}
