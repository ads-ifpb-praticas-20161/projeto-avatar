/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticas.srestoque.web;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import praticas.srestoque.entidades.Produto;
import praticas.srestoque.excecoes.ChavePrimariaException;
import praticas.srestoque.repositorio.ProdutoRepository;

/**
 *
 * @author vmvini
 */

@Named
@RequestScoped
public class ProdutosMB {
    
    @EJB
    private ProdutoRepository pr;
    
    private Produto produto;
    
    public ProdutosMB(){
        produto = new Produto();
    }
    
    public void cadastrarProduto(){
        try{
            pr.salvar(produto);
            String result = "Produto cadastrado com sucesso!";
            FacesContext.getCurrentInstance().addMessage("produtoForm", new FacesMessage(FacesMessage.SEVERITY_INFO, result, result));
            produto = new Produto();
        }
        catch(ChavePrimariaException e){
             FacesContext.getCurrentInstance().addMessage("produtoForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
        }
    }

    public ProdutoRepository getPr() {
        return pr;
    }

    public void setPr(ProdutoRepository pr) {
        this.pr = pr;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    
    
    
}
