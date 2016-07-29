/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.srestoque.srestoqueweb;
import br.edu.ifpb.praticas.srestoque.exceptions.ProdutoNaoEncontrado;
import br.edu.ifpb.praticas.srestoque.regrasnegocio.exceptions.ErroValidacaoEntrada;
import br.edu.ifpb.praticas.srestoque.regrasnegocio.exceptions.EstoqueNaoSuficiente;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Entrada;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Produto;
import br.edu.ifpb.praticas.srestoque.srestoquepersistencia.GerenciadorEntrada;
import br.edu.ifpb.praticas.srestoque.srestoquepersistencia.GerenciadorProduto;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.apache.commons.lang3.time.DateUtils;
/**
 *
 * @author vmvini
 */

@Named
@RequestScoped
public class ControleEntrada implements Serializable {
    
    private Entrada entrada;
    
    @EJB 
    private GerenciadorProduto gerenciadorProdutoImpl;
    
    @EJB
    private GerenciadorEntrada gerenciadorEntradaImpl;
    
    public ControleEntrada(){
        entrada = new Entrada();
    }

    public Entrada getEntrada() {
        return entrada;
    }

    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }

    public GerenciadorEntrada getGerenciadorEntradaImpl() {
        return gerenciadorEntradaImpl;
    }

    public void setGerenciadorEntradaImpl(GerenciadorEntrada gerenciadorEntradaImpl) {
        this.gerenciadorEntradaImpl = gerenciadorEntradaImpl;
    }
    
    
    public String salvarEntrada() throws EstoqueNaoSuficiente, ErroValidacaoEntrada, ProdutoNaoEncontrado{
        
        if(entrada == null){
            throw new NullPointerException("Entrada nula");
        }
        
        if (entrada.getQuantidade() <=0){
            throw new EstoqueNaoSuficiente("Quantidade da entrada deve ser um valor positivo maior que zero.");
        }
        
        if( entrada.getProduto() == null){
            throw new NullPointerException("Produto da entrada está nulo!");
        }
        
        if( entrada.getData() == null ){
            throw new NullPointerException("Data da entrada está nula!");
        }
        
        //entrada nao pode ser lançada com data anterior à atual
        if( !DateUtils.isSameDay(entrada.getData(), new java.util.Date()) ){
            throw new ErroValidacaoEntrada("entrada nao pode ser lançada com data anterior à atual");
        }
        
        //para testar se o produto da nova entrada existe no banco
        //se nao existir, vai lançar exceção P'rodutoNaoEncontrado
        entrada.setProduto(getProduto( entrada.getProduto() ) );
        
        Produto p = entrada.getProduto();
        int estoque = p.getEstoque();
        p.setEstoque(estoque + entrada.getQuantidade());
        gerenciadorProdutoImpl.atualizarProduto(p);
        
        gerenciadorEntradaImpl.salvarEntrada(entrada);
        
        return "index.html";
        
    } 

    public GerenciadorProduto getGerenciadorProdutoImpl() {
        return gerenciadorProdutoImpl;
    }

    public void setGerenciadorProdutoImpl(GerenciadorProduto gerenciadorProdutoImpl) {
        this.gerenciadorProdutoImpl = gerenciadorProdutoImpl;
    }
    
    private Produto getProduto(Produto produto) throws ProdutoNaoEncontrado{
        
        Produto p = gerenciadorProdutoImpl.buscarPorId(produto.getId());
        return p;
    }
    
}
