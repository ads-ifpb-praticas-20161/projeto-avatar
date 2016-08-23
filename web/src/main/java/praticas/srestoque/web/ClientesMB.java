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
import praticas.srestoque.entidades.Cliente;
import praticas.srestoque.entidades.Endereco;
import praticas.srestoque.excecoes.ChavePrimariaException;
import praticas.srestoque.repositorio.ClienteRepository;

/**
 *
 * @author vmvini
 */

@Named
@RequestScoped
public class ClientesMB {
    
    private Cliente cliente;
    
    private String tel1, tel2;
    
    public ClientesMB(){
        cliente = new Cliente();
        cliente.setEndereco(new Endereco());
        tel1 = new String();
        tel2 = new String();
    }
    
    @EJB
    private ClienteRepository cr;
    
    private void inserirTelefones(List<String> tels){
        if(tel1 != null){
            tels.add(tel1);
        }
        if(tel2 != null){
            tels.add(tel2);
        }
    }
    
    private void resetModel(){
        tel1 = new String();
        tel2 = new String();
        cliente = new Cliente();
    }
    
    public void cadastrarCliente(){
        try{
            List<String> tels = new ArrayList<>();
            inserirTelefones(tels);
            cr.salvar(cliente);
            String result = "Cliente salvo com sucesso!";
            FacesContext.getCurrentInstance().addMessage("clienteForm", new FacesMessage(FacesMessage.SEVERITY_INFO, result, result));
            resetModel();
        }
        catch(ChavePrimariaException e){
             FacesContext.getCurrentInstance().addMessage("clienteForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
        }
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ClienteRepository getCr() {
        return cr;
    }

    public void setCr(ClienteRepository cr) {
        this.cr = cr;
    }
    
    
    
}
