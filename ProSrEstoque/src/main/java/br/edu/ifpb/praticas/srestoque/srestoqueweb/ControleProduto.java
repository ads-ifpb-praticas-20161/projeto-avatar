package br.edu.ifpb.praticas.srestoque.srestoqueweb;


import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Produto;
import br.edu.ifpb.praticas.srestoque.srestoquepersistencia.GerenciadorProduto;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Document  ControleProduto
 * @Date  22/07/2016 @Time 14:02:25
 * @author Wellington Lins Claudino Duarte   @mail wellingtonlins2013@gmail.com
 * @author Marcus Vinícius
 */ 
@Named
@RequestScoped
public class ControleProduto implements Serializable {

    private Produto produto;
    @EJB
    private GerenciadorProduto gerenciadorProdutoImpl;

    public ControleProduto() {
        produto = new Produto();
    }

    public String salvarProduto() {
        gerenciadorProdutoImpl.salvarProduto(produto);

        return "home.html";
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public GerenciadorProduto getGerenciadorProdutoImpl() {
        return gerenciadorProdutoImpl;
    }

    public void setGerenciadorProdutoImpl(GerenciadorProduto gerenciadorProdutoImpl) {
        this.gerenciadorProdutoImpl = gerenciadorProdutoImpl;
    }

}