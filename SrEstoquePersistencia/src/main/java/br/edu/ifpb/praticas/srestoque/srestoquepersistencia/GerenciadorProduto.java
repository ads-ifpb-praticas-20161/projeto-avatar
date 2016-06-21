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
/**
 *
 * @author Marcus Vinícius
 */
public interface GerenciadorProduto {
    
    public void salvarProduto(Produto produto);
    
    /*Método atualizar removido pois o metodo salvar atualiza caso já exista no banco*/
    
    public void removerProduto(Produto produto) throws ProdutoNaoEncontrado;
    
    public Produto buscarPorId(int id) throws ProdutoNaoEncontrado;
    
    public List<Produto> buscarPorDescricao(String descricao) throws ProdutoNaoEncontrado;
    
    public List<Produto> listarProdutos() throws NenhumProdutoCadastrado;
    
}
