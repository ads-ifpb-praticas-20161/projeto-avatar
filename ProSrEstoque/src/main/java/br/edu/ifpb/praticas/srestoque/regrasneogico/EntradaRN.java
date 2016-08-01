package br.edu.ifpb.praticas.srestoque.regrasneogico;

import br.edu.ifpb.praticas.srestoque.exceptions.EntradaNaoEncontrada;
import br.edu.ifpb.praticas.srestoque.exceptions.NenhumaEntradaRealizada;
import br.edu.ifpb.praticas.srestoque.regrasnegocio.exceptions.EstoqueNaoSuficiente;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Entrada;
import java.util.Date;
import java.util.List;

/**
 *
 * @author vmvini
 * @author Wellington Lins Claudino Duarte   @mail wellingtonlins2013@gmail.com
 */
public interface EntradaRN {
    
    public void salvarEntrada(Entrada entrada) throws EstoqueNaoSuficiente;
    
    public void atualizarEntrada(Entrada entrada) throws EntradaNaoEncontrada;
    
    public List<Entrada> listarEntradas() throws NenhumaEntradaRealizada;
    
    public List<Entrada> pesquisarPorData(Date date) throws EntradaNaoEncontrada;
    
    public List<Entrada> pesquisarPorProdutoId(int produtoId) throws EntradaNaoEncontrada;
    
    public List<Entrada> pesquisarPorProdutoDescricao(String produtoDescricao) throws EntradaNaoEncontrada;
    
    public List<Entrada> pesquisarPorQuantidade(int quantidade) throws EntradaNaoEncontrada;
    
    public void removerEntrada(Entrada entrada) throws EntradaNaoEncontrada;
    
}
