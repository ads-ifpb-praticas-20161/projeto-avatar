/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.srestoque.regrasneogico;

import br.edu.ifpb.praticas.srestoque.exceptions.NenhumaSaidaRealizada;
import br.edu.ifpb.praticas.srestoque.exceptions.ProdutoNaoEncontrado;
import br.edu.ifpb.praticas.srestoque.exceptions.SaidaNaoEncontrada;
import br.edu.ifpb.praticas.srestoque.regrasnegocio.exceptions.ErroValidacaoSaida;
import br.edu.ifpb.praticas.srestoque.regrasnegocio.exceptions.EstoqueNaoSuficiente;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Produto;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Saida;
import br.edu.ifpb.praticas.srestoque.srestoquepersistencia.GerenciadorProduto;
import br.edu.ifpb.praticas.srestoque.srestoquepersistencia.GerenciadorProdutoImpl;
import br.edu.ifpb.praticas.srestoque.srestoquepersistencia.GerenciadorSaida;
import br.edu.ifpb.praticas.srestoque.srestoquepersistencia.GerenciadorSaidaImpl;
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
        gs = new GerenciadorSaidaImpl();
    }
    
    @Override
    public void salvarSaida(Saida saida) throws EstoqueNaoSuficiente, ErroValidacaoSaida {
        if (saida.getQuantidade() <=0){
            throw  new ErroValidacaoSaida("Saída deve ter uma quantidade positiva e maior que zero.");
        }
        int q =0;
        try {
            q = gp.buscarPorId(saida.getProduto().getId()).getEstoque();
        } catch (ProdutoNaoEncontrado ex) {
            throw new ErroValidacaoSaida("Produto referenciado por essa saída não existe!");
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
            throw new ErroValidacaoSaida("Produto referenciado por essa saída não existe!");
        }
        
    }

    @Override
    public void atualizarSaida(Saida saida) throws EstoqueNaoSuficiente, ErroValidacaoSaida {
        if (saida.getQuantidade() <=0){
            throw  new ErroValidacaoSaida("Saída deve ter uma quantidade positiva e maior que zero.");
        }
        int q =0;
        try {
            //pegando o estoque do produto antes de ter sido incrementado pela saida antes de ser atualizada
            q = gp.buscarPorId(saida.getProduto().getId()).getEstoque() + gs.buscarPorId(saida.getId()).getQuantidade();
        } catch (ProdutoNaoEncontrado ex) {
            throw new ErroValidacaoSaida("Produto referenciado por essa saída não existe!");
        } catch(SaidaNaoEncontrada ex){
            throw new ErroValidacaoSaida("Saída inválida!");
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
            throw new ErroValidacaoSaida("Produto referenciado por essa saída não existe!");
        }
    }

    @Override
    public List<Saida> listarSaidas() throws NenhumaSaidaRealizada {
        return gs.listarSaidas();
    }

    @Override
    public List<Saida> pesquisarPorData(Date date) throws SaidaNaoEncontrada {
        return gs.pesquisarPorData(date);
    }

    @Override
    public List<Saida> pesquisarPorProdutoId(int produtoId) throws SaidaNaoEncontrada {
        return gs.pesquisarPorProdutoId(produtoId);
    }

    @Override
    public List<Saida> pesquisarPorProdutoDescricao(String produtoDescricao) throws SaidaNaoEncontrada {
        return gs.pesquisarPorProdutoDescricao(produtoDescricao);
    }

    @Override
    public List<Saida> pesquisarPorQuantidade(int quantidade) throws SaidaNaoEncontrada {
        return gs.pesquisarPorQuantidade(quantidade);
    }

    @Override
    public void removerSaida(Saida saida) throws SaidaNaoEncontrada {
        try {
            Produto p = gp.buscarPorId(saida.getProduto().getId());
            p.setEstoque(p.getEstoque() + saida.getQuantidade());
            gs.removerSaida(saida);
        } catch (ProdutoNaoEncontrado ex) {
            Logger.getLogger(SaidaRNImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
