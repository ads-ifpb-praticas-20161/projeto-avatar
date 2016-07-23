package br.edu.ifpb.praticas.srestoque.srestoquepersistencia;


import br.edu.ifpb.praticas.srestoque.exceptions.EntradaNaoEncontrada;
import br.edu.ifpb.praticas.srestoque.exceptions.NenhumaEntradaRealizada;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Entrada;
import java.util.List;
import java.util.Date;

/**
 *
 * @author Marcus Vinícius
 * @author Wellington Lins Claudino Duarte   @mail wellingtonlins2013@gmail.com
 */
public interface GerenciadorEntrada {
    
    public void salvarEntrada(Entrada entrada);
    
    public void atualizarEntrada(Entrada entrada) throws EntradaNaoEncontrada;
    
    public List<Entrada> listarEntradas() throws NenhumaEntradaRealizada;
    
    public List<Entrada> pesquisarPorData(Date date) throws EntradaNaoEncontrada;
    
    public List<Entrada> pesquisarPorProdutoId(int produtoId) throws EntradaNaoEncontrada;
    
    public List<Entrada> pesquisarPorProdutoDescricao(String produtoDescricao) throws EntradaNaoEncontrada;
    
    public List<Entrada> pesquisarPorQuantidade(int quantidade) throws EntradaNaoEncontrada;
    
    public void removerEntrada(Entrada entrada) throws EntradaNaoEncontrada;
    
}
