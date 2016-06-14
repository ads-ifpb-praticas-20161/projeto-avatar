/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.srestoque.srestoquepersistencia;


import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Entrada;
import java.util.List;
import java.util.Date;

/**
 *
 * @author Marcus Vinícius
 */
public interface GerenciadorEntrada {
    
    public void salvarEntrada(Entrada entrada);
    
    public void atualizarEntrada(Entrada entrada);
    
    public List<Entrada> pesquisarPorData(Date date);
    
    public List<Entrada> pesquisarPorProdutoId(int produtoId);
    
    public List<Entrada> pesquisarPorProdutoDescricao(String produtoDescricao);
    
    public List<Entrada> pesquisarPorQuantidade(int quantidade);
    
    public void removerEntrada(Entrada entrada);
    
}
