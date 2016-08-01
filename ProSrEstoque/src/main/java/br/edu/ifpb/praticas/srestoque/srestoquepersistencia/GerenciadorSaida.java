package br.edu.ifpb.praticas.srestoque.srestoquepersistencia;

import br.edu.ifpb.praticas.srestoque.exceptions.NenhumaSaidaRealizada;
import br.edu.ifpb.praticas.srestoque.exceptions.SaidaNaoEncontrada;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Saida;
import java.util.Date;
import java.util.List;

/**
 * @author Marcus Vinícius
 * @author Wellington Lins Claudino Duarte   @mail wellingtonlins2013@gmail.com
 */
public interface GerenciadorSaida {
    
    public void salvarSaida(Saida saida);
    
    public void atualizarSaida(Saida saida);
    
    public List<Saida> listarSaidas() throws NenhumaSaidaRealizada;
    
    public List<Saida> pesquisarPorData(Date date) throws SaidaNaoEncontrada;
    
    public List<Saida> pesquisarPorProdutoId(int produtoId) throws SaidaNaoEncontrada;
    
    public List<Saida> pesquisarPorProdutoDescricao(String produtoDescricao) throws SaidaNaoEncontrada;
    
    public List<Saida> pesquisarPorQuantidade(int quantidade) throws SaidaNaoEncontrada;
    
    public void removerSaida(Saida saida) throws SaidaNaoEncontrada;
    
    public Saida buscarPorId(int id) throws SaidaNaoEncontrada;
    
}
