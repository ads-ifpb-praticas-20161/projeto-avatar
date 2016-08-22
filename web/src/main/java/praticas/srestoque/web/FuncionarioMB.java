/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticas.srestoque.web;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.print.attribute.standard.Severity;
import praticas.srestoque.entidades.Funcionario;
import praticas.srestoque.entidades.TipoFuncionario;
import praticas.srestoque.excecoes.ChavePrimariaException;
import praticas.srestoque.excecoes.ValidacaoFormularioException;
import praticas.srestoque.sessionbeans.FuncionarioStateless;

/**
 *
 * @author vmvini
 */

@Named
@RequestScoped
public class FuncionarioMB {
    
    @EJB
    private FuncionarioStateless fs;
    
    private TipoFuncionario[] tipos;
    
    private Funcionario novoFuncionario;

    
    public FuncionarioMB(){
        tipos = new TipoFuncionario[2];
        tipos[0] = TipoFuncionario.ADMINISTRADOR;
        tipos[1] = TipoFuncionario.ATENDENTE;
        novoFuncionario = new Funcionario();
    }
    
    public void cadastrar(){
        try{
            fs.cadastrar(novoFuncionario);
            String result = "Sucesso ao cadastrar funcionário";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, result, result));
        }
        catch(ValidacaoFormularioException | ChavePrimariaException e){
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
            
        }
        finally{
            novoFuncionario = null;
        }
       
    }
    
    public FuncionarioStateless getFs() {
        return fs;
    }

    public void setFs(FuncionarioStateless fs) {
        this.fs = fs;
    }

    public TipoFuncionario[] getTipos() {
        return tipos;
    }

    public void setTipos(TipoFuncionario[] tipos) {
        this.tipos = tipos;
    }

    public Funcionario getNovoFuncionario() {
        return novoFuncionario;
    }

    public void setNovoFuncionario(Funcionario novoFuncionario) {
        this.novoFuncionario = novoFuncionario;
    }
    
    
    
    
}
