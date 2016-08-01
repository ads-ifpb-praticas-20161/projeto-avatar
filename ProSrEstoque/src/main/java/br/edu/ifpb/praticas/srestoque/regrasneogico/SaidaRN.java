
package br.edu.ifpb.praticas.srestoque.regrasneogico;

import br.edu.ifpb.praticas.srestoque.exceptions.NenhumaSaidaRealizada;
import br.edu.ifpb.praticas.srestoque.exceptions.SaidaNaoEncontrada;
import br.edu.ifpb.praticas.srestoque.regrasnegocio.exceptions.EstoqueNaoSuficiente;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Saida;
import java.util.Date;
import java.util.List;

/**
 *
 * @author vmvini
 * 
 */
public interface SaidaRN {
    
    public void salvarSaida(Saida saida) throws EstoqueNaoSuficiente;
    
    public void atualizarSaida(Saida saida) throws EstoqueNaoSuficiente;
    
    public List<Saida> listarSaidas() throws NenhumaSaidaRealizada;
    
    public List<Saida> pesquisarPorData(Date date) throws SaidaNaoEncontrada;
    
    public List<Saida> pesquisarPorProdutoId(int produtoId) throws SaidaNaoEncontrada;
    
    public List<Saida> pesquisarPorProdutoDescricao(String produtoDescricao) throws SaidaNaoEncontrada;
    
    public List<Saida> pesquisarPorQuantidade(int quantidade) throws SaidaNaoEncontrada;
    
    public void removerSaida(Saida saida) throws SaidaNaoEncontrada;
    
    
}
