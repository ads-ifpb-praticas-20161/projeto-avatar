/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.srestoque.regrasneogico;

import br.edu.ifpb.praticas.srestoque.exceptions.EntradaNaoEncontrada;
import br.edu.ifpb.praticas.srestoque.exceptions.NenhumaEntradaRealizada;
import br.edu.ifpb.praticas.srestoque.exceptions.ProdutoNaoEncontrado;
import br.edu.ifpb.praticas.srestoque.regrasnegocio.exceptions.EstoqueNaoSuficiente;
import br.edu.ifpb.praticas.srestoque.regrasneogico.EntradaRN;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Entrada;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Produto;
import br.edu.ifpb.praticas.srestoque.srestoquepersistencia.GerenciadorEntrada;
import br.edu.ifpb.praticas.srestoque.srestoquepersistencia.GerenciadorProduto;
import br.edu.ifpb.praticas.srestoque.srestoquepersistencia.GerenciadorProdutoImpl;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author laerton
 */
public class EntradaRNimpl implements EntradaRN{

    private GerenciadorEntrada ge;
    private GerenciadorProduto gp;
    public EntradaRNimpl() {
        gp = new GerenciadorProdutoImpl();
    }
    
    
    @Override
    public void salvarEntrada(Entrada entrada) throws EstoqueNaoSuficiente {
        if (entrada.getQuantidade() <=0){
            throw new EstoqueNaoSuficiente("Quantidade da entrada deve ser um valor positivo maior que zero.");
        } 
        ge.salvarEntrada(entrada);
        try {
            Produto p = gp.buscarPorId(entrada.getProduto().getId());
            p.setEstoque(p.getEstoque() + entrada.getQuantidade());
            gp.salvarProduto(p);
        } catch (ProdutoNaoEncontrado ex) {
            Logger.getLogger(EntradaRNimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void atualizarEntrada(Entrada entrada) throws EntradaNaoEncontrada {
        if (entrada.getQuantidade() <=0){
            throw new EntradaNaoEncontrada("Quantidade da entrada deve ser um valor positivo maior que zero.");
        } 
        ge.atualizarEntrada(entrada);
    }

    @Override
    public List<Entrada> listarEntradas() throws NenhumaEntradaRealizada {
           List<Entrada> lista = ge.listarEntradas();
           if (lista.size() == 0){
               throw  new NenhumaEntradaRealizada("Não existe entradas cadastradas.");
           }
           return lista;
    }

    @Override
    public List<Entrada> pesquisarPorData(Date date) throws EntradaNaoEncontrada {
        List<Entrada> lista = ge.pesquisarPorData(date);
           if (lista.size() == 0){
               throw  new EntradaNaoEncontrada("Não existe entradas cadastradas.");
           }
           return lista;
    }

    @Override
    public List<Entrada> pesquisarPorProdutoId(int produtoId) throws EntradaNaoEncontrada {
        List<Entrada> lista = ge.pesquisarPorProdutoId(produtoId);
        if (lista.size()==0){
            throw  new  EntradaNaoEncontrada("Não existe entradas cadastradas para esse produto.");
        }
        return lista;
    }

    @Override
    public List<Entrada> pesquisarPorProdutoDescricao(String produtoDescricao) throws EntradaNaoEncontrada {
        List<Entrada> lista = ge.pesquisarPorProdutoDescricao(produtoDescricao);
        if (lista.size()==0){
            throw  new  EntradaNaoEncontrada("Não existe entradas cadastradas para esse produto.");
        }
        return lista;
    }

    @Override
    public List<Entrada> pesquisarPorQuantidade(int quantidade) throws EntradaNaoEncontrada {
        List<Entrada> lista = ge.pesquisarPorQuantidade(quantidade);
        if (lista.size()==0){
            throw  new  EntradaNaoEncontrada("Não existe entradas cadastradas para esse produto.");
        }
        return lista;
    }

    @Override
    public void removerEntrada(Entrada entrada) throws EntradaNaoEncontrada {
        ge.removerEntrada(entrada);
        try {
            Produto p = gp.buscarPorId(entrada.getProduto().getId());
            p.setEstoque(p.getEstoque()- entrada.getQuantidade());
        } catch (ProdutoNaoEncontrado ex) {
            Logger.getLogger(EntradaRNimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
