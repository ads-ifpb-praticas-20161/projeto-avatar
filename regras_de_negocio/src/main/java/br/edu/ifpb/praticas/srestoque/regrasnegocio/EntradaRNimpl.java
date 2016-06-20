/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.srestoque.regrasnegocio;

import br.edu.ifpb.praticas.srestoque.exceptions.EntradaNaoEncontrada;
import br.edu.ifpb.praticas.srestoque.exceptions.NenhumaEntradaRealizada;
import br.edu.ifpb.praticas.srestoque.regrasneogico.EntradaRN;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Entrada;
import br.edu.ifpb.praticas.srestoque.srestoquepersistencia.GerenciadorEntrada;
import java.util.Date;
import java.util.List;

/**
 *
 * @author laerton
 */
public class EntradaRNimpl implements EntradaRN{

    private GerenciadorEntrada ge;

    public EntradaRNimpl() {
        
    }
    
    
    @Override
    public void salvarEntrada(Entrada entrada) throws EstoqueNaoSuficiente {
        if (entrada.getQuantidade() <=0){
            throw new EstoqueNaoSuficiente("Quantidade da entrada deve ser um valor positivo maior que zero.");
        } 
        ge.salvarEntrada(entrada);
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
    }
    
}
