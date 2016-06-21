/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.srestoque.regrasneogico;

import br.edu.ifpb.praticas.srestoque.exceptions.NenhumaSaidaRealizada;
import br.edu.ifpb.praticas.srestoque.exceptions.ProdutoNaoEncontrado;
import br.edu.ifpb.praticas.srestoque.exceptions.SaidaNaoEncontrada;
import br.edu.ifpb.praticas.srestoque.regrasnegocio.exceptions.EstoqueNaoSuficiente;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Produto;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Saida;
import br.edu.ifpb.praticas.srestoque.srestoquepersistencia.GerenciadorEntrada;
import br.edu.ifpb.praticas.srestoque.srestoquepersistencia.GerenciadorProduto;
import br.edu.ifpb.praticas.srestoque.srestoquepersistencia.GerenciadorProdutoImpl;
import br.edu.ifpb.praticas.srestoque.srestoquepersistencia.GerenciadorSaida;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laerton
 */
public class SaidaRNImpl implements SaidaRN{
    private GerenciadorSaida gs;
    private GerenciadorProduto gp;
    public SaidaRNImpl() {
        gp = new GerenciadorProdutoImpl();
    }
    
    @Override
    public void salvarSaida(Saida saida) throws EstoqueNaoSuficiente {
        if (saida.getQuantidade() <=0){
            throw  new EstoqueNaoSuficiente("Saída deve ter uma quantidade positiva e maior que zero.");
        }
        int q =0;
        try {
            q = gp.buscarPorId(saida.getProduto().getId()).getEstoque();
        } catch (ProdutoNaoEncontrado ex) {
            Logger.getLogger(SaidaRNImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (saida.getQuantidade() > q){
            throw  new EstoqueNaoSuficiente("Estoque insuficiente.");
        }
        gs.salvarSaida(saida);
        try {
            Produto p = gp.buscarPorId(saida.getProduto().getId());
            p.setEstoque(p.getEstoque() - saida.getQuantidade());
            gp.salvarProduto(p);
        } catch (ProdutoNaoEncontrado ex) {
            Logger.getLogger(SaidaRNImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void atualizarSaida(Saida saida) throws EstoqueNaoSuficiente {
        if (saida.getQuantidade() <=0){
            throw  new EstoqueNaoSuficiente("Saída deve ter uma quantidade positiva e maior que zero.");
        }
        gs.atualizarSaida(saida);
    }

    @Override
    public List<Saida> listarSaidas() throws NenhumaSaidaRealizada {
        List<Saida> lista = gs.listarSaidas();
        if (lista.size()== 0){
            throw  new NenhumaSaidaRealizada("Não há registros de saídas.");
        }
        return lista;
    }

    @Override
    public List<Saida> pesquisarPorData(Date date) throws SaidaNaoEncontrada {
        List<Saida> lista = gs.pesquisarPorData(date);
        if (lista.size()== 0){
            throw  new SaidaNaoEncontrada("Não há registros de saídas.");
        }
        return lista;
    }

    @Override
    public List<Saida> pesquisarPorProdutoId(int produtoId) throws SaidaNaoEncontrada {
        List<Saida> lista = gs.pesquisarPorProdutoId(produtoId);
        if (lista.size()== 0){
            throw  new SaidaNaoEncontrada("Não há registros de saídas.");
        }
        return lista;
    }

    @Override
    public List<Saida> pesquisarPorProdutoDescricao(String produtoDescricao) throws SaidaNaoEncontrada {
        List<Saida> lista = gs.pesquisarPorProdutoDescricao(produtoDescricao);
        if (lista.size()== 0){
            throw  new SaidaNaoEncontrada("Não há registros de saídas.");
        }
        return lista;
    }

    @Override
    public List<Saida> pesquisarPorQuantidade(int quantidade) throws SaidaNaoEncontrada {
        List<Saida> lista = gs.pesquisarPorQuantidade(quantidade);
        if (lista.size()== 0){
            throw  new SaidaNaoEncontrada("Não há registros de saídas.");
        }
        return lista;
    }

    @Override
    public void removerSaida(Saida saida) throws SaidaNaoEncontrada {
        gs.removerSaida(saida);
        try {
            Produto p = gp.buscarPorId(saida.getProduto().getId());
            p.setEstoque(p.getEstoque() + saida.getQuantidade());
        } catch (ProdutoNaoEncontrado ex) {
            Logger.getLogger(SaidaRNImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
