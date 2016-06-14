/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.srestoque.srestoquepersistencia;

import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Saida;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Marcus Vinícius
 */
public interface GerenciadorSaida {
    
    public void salvarSaida(Saida entrada);
    
    public void atualizarSaida(Saida entrada);
    
    public List<Saida> pesquisarPorData(Date date);
    
    public List<Saida> pesquisarPorProdutoId(int produtoId);
    
    public List<Saida> pesquisarPorProdutoDescricao(String produtoDescricao);
    
    public List<Saida> pesquisarPorQuantidade(int quantidade);
    
    public void removerSaida(Saida entrada);
    
}
