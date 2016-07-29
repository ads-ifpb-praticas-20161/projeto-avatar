/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.srestoque.srestoqueweb;
import br.edu.ifpb.praticas.srestoque.exceptions.ProdutoNaoEncontrado;
import br.edu.ifpb.praticas.srestoque.regrasnegocio.exceptions.ErroValidacaoSaida;
import br.edu.ifpb.praticas.srestoque.regrasnegocio.exceptions.EstoqueNaoSuficiente;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Produto;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Saida;
import br.edu.ifpb.praticas.srestoque.srestoquepersistencia.GerenciadorProduto;
import br.edu.ifpb.praticas.srestoque.srestoquepersistencia.GerenciadorSaida;
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
public class ControleSaida {
    
    @EJB
    private GerenciadorSaida gerenciadorSaidaImpl;
    
    @EJB
    private GerenciadorProduto gerenciadorProdutoImpl;
    
    private Saida saida;

    public GerenciadorSaida getGerenciadorSaidaImpl() {
        return gerenciadorSaidaImpl;
    }
    
    public ControleSaida(){
        saida = new Saida();
    }
    
    public void salvarSaida() throws ErroValidacaoSaida, ProdutoNaoEncontrado, EstoqueNaoSuficiente{
        if(saida == null){
            throw new NullPointerException("Saída nula!");
        }
        if(saida.getQuantidade() <= 0){
            throw new ErroValidacaoSaida("Quantidade não pode ser menor ou igual a zero!");
        }
        if(saida.getData() == null){
            throw new NullPointerException("Data Nula");
        }
        if( !DateUtils.isSameDay(saida.getData(), new java.util.Date()) ){
            throw new ErroValidacaoSaida("Saida nao pode ser lançada com data anterior à atual");
        }
        if(saida.getProduto() == null){
            throw new NullPointerException("Produto está nulo!");
        }
        
       //se nao houver estoque suficiente...
        if(saida.getProduto().getEstoque() < saida.getQuantidade()){
            throw new EstoqueNaoSuficiente("produto não possui estoque para saida!");
        }
        
         //lança ProdutoNaoENcontrado se produto ainda não tiver sido salvo no banco 
        saida.setProduto( getProduto( saida.getProduto() ) );
        
        gerenciadorSaidaImpl.salvarSaida(saida);
        
        
    }
    

    public void setGerenciadorSaidaImpl(GerenciadorSaida gerenciadorSaidaImpl){
        this.gerenciadorSaidaImpl = gerenciadorSaidaImpl;
    }

    public Saida getSaida() {
        return saida;
    }

    public void setSaida(Saida saida) {
        this.saida = saida;
    }
    
    private Produto getProduto(Produto produto) throws ProdutoNaoEncontrado{
        
        Produto p = gerenciadorProdutoImpl.buscarPorId(produto.getId());
        return p;
    }

    public GerenciadorProduto getGerenciadorProdutoImpl() {
        return gerenciadorProdutoImpl;
    }

    public void setGerenciadorProdutoImpl(GerenciadorProduto gerenciadorProdutoImpl) {
        this.gerenciadorProdutoImpl = gerenciadorProdutoImpl;
    }
    
    
}
