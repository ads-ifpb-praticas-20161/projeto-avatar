/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.srestoque.srestoquepersistencia;


import br.edu.ifpb.praticas.srestoque.exceptions.EntradaNaoEncontrada;
import br.edu.ifpb.praticas.srestoque.exceptions.NenhumaEntradaRealizada;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Entrada;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Produto;
import java.util.List;
import java.util.Date;

/**
 *
 * @author Marcus Vinícius
 */
public interface GerenciadorEntrada {
    
    public void salvarEntrada(Entrada entrada);
    
    /*Método atualizar removido pois o metodo salvar atualiza caso já exista no banco*/
    
    public Entrada buscarPorId(int id) throws EntradaNaoEncontrada;
    
    public List<Entrada> listarEntradas() throws NenhumaEntradaRealizada;
    
    public List<Entrada> pesquisarPorData(Date date) throws EntradaNaoEncontrada;
    
    public List<Entrada> pesquisarPorProdutoId(int produtoId) throws EntradaNaoEncontrada;
    
    public List<Entrada> pesquisarPorProdutoDescricao(String produtoDescricao) throws EntradaNaoEncontrada;
    
    public List<Entrada> pesquisarPorQuantidade(int quantidade) throws EntradaNaoEncontrada;
    
    public void removerEntrada(Entrada entrada) throws EntradaNaoEncontrada;
    
}
