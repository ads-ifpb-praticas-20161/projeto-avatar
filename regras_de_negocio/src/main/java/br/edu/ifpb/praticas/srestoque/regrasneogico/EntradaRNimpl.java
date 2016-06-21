/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.srestoque.regrasneogico;

import br.edu.ifpb.praticas.srestoque.exceptions.EntradaNaoEncontrada;
import br.edu.ifpb.praticas.srestoque.exceptions.NenhumaEntradaRealizada;
import br.edu.ifpb.praticas.srestoque.exceptions.ProdutoNaoEncontrado;
import br.edu.ifpb.praticas.srestoque.regrasnegocio.exceptions.ErroValidacaoEntrada;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Entrada;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Produto;
import br.edu.ifpb.praticas.srestoque.srestoquepersistencia.GerenciadorEntrada;
import br.edu.ifpb.praticas.srestoque.srestoquepersistencia.GerenciadorEntradaImpl;
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
        ge = new GerenciadorEntradaImpl();
        
    }
    
    
    @Override
    public void salvarEntrada(Entrada entrada) throws ErroValidacaoEntrada {
        if (entrada.getQuantidade() <=0){
            throw new ErroValidacaoEntrada("Quantidade da entrada deve ser um valor positivo maior que zero.");
        }
        if(entrada.getData() == null)
            throw new ErroValidacaoEntrada("A data da entrada deve ser informada");
        if(entrada.getProduto() == null)
            throw new ErroValidacaoEntrada("O produto deve ser informado");
        
        ge.salvarEntrada(entrada);
        try {
            Produto p = gp.buscarPorId(entrada.getProduto().getId());
            p.setEstoque(p.getEstoque() + entrada.getQuantidade());
            gp.salvarProduto(p);
        } catch (ProdutoNaoEncontrado ex) {
            throw new ErroValidacaoEntrada("O produto informado não existe");
        }
        
    }

    @Override
    public void atualizarEntrada(Entrada entrada) throws ErroValidacaoEntrada {
        if (entrada.getQuantidade() <=0){
            throw new ErroValidacaoEntrada("Quantidade da entrada deve ser um valor positivo maior que zero.");
        }
        if(entrada.getData() == null)
            throw new ErroValidacaoEntrada("A data da entrada deve ser informada");
        if(entrada.getProduto() == null)
            throw new ErroValidacaoEntrada("O produto deve ser informado");
        
        ge.salvarEntrada(entrada);
        try {
            Produto p = gp.buscarPorId(entrada.getProduto().getId());
            int estoqueSemEssaEntrada = p.getEstoque() - entrada.getQuantidade();
            p.setEstoque(estoqueSemEssaEntrada + entrada.getQuantidade());
            gp.salvarProduto(p);
        } catch (ProdutoNaoEncontrado ex) {
            throw new ErroValidacaoEntrada("O produto informado não existe");
        }
    }

    @Override
    public List<Entrada> listarEntradas() throws NenhumaEntradaRealizada {
           return ge.listarEntradas();
    }

    @Override
    public List<Entrada> pesquisarPorData(Date date) throws EntradaNaoEncontrada {
        return ge.pesquisarPorData(date);
    }

    @Override
    public List<Entrada> pesquisarPorProdutoId(int produtoId) throws EntradaNaoEncontrada {
        return ge.pesquisarPorProdutoId(produtoId);
    }

    @Override
    public List<Entrada> pesquisarPorProdutoDescricao(String produtoDescricao) throws EntradaNaoEncontrada {
        return ge.pesquisarPorProdutoDescricao(produtoDescricao);
    }

    @Override
    public List<Entrada> pesquisarPorQuantidade(int quantidade) throws EntradaNaoEncontrada {
        return ge.pesquisarPorQuantidade(quantidade);
    }

    @Override
    public void removerEntrada(Entrada entrada) throws EntradaNaoEncontrada {
        
        try {
            Produto p = gp.buscarPorId(entrada.getProduto().getId());
            p.setEstoque(p.getEstoque()- entrada.getQuantidade());
            ge.removerEntrada(entrada);
            //atualizar produto no banco
            gp.salvarProduto(p);
            
        } catch (ProdutoNaoEncontrado ex) {
            Logger.getLogger(EntradaRNimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
