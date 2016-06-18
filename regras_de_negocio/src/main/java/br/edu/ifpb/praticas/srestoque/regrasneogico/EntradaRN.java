/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.srestoque.regrasneogico;

import br.edu.ifpb.praticas.srestoque.exceptions.EntradaNaoEncontrada;
import br.edu.ifpb.praticas.srestoque.exceptions.NenhumaEntradaRealizada;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Entrada;
import java.util.Date;
import java.util.List;

/**
 *
 * @author vmvini
 */
public interface EntradaRN {
    
    public void salvarEntrada(Entrada entrada);
    
    public void atualizarEntrada(Entrada entrada) throws EntradaNaoEncontrada;
    
    public List<Entrada> listarEntradas() throws NenhumaEntradaRealizada;
    
    public List<Entrada> pesquisarPorData(Date date) throws EntradaNaoEncontrada;
    
    public List<Entrada> pesquisarPorProdutoId(int produtoId) throws EntradaNaoEncontrada;
    
    public List<Entrada> pesquisarPorProdutoDescricao(String produtoDescricao) throws EntradaNaoEncontrada;
    
    public List<Entrada> pesquisarPorQuantidade(int quantidade) throws EntradaNaoEncontrada;
    
    public void removerEntrada(Entrada entrada) throws EntradaNaoEncontrada;
    
}
