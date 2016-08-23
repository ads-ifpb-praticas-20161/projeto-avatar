/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticas.srestoque.web;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import praticas.srestoque.entidades.Cliente;
import praticas.srestoque.entidades.Endereco;

/**
 *
 * @author vmvini
 */

@Named
@RequestScoped
public class PesquisaMB {
    
    private List<Cliente> clientes;
    
    public PesquisaMB(){
        clientes = new ArrayList<>();
        clientes.add(new Cliente("321312312", "marcus viniv"));
        clientes.add(new Cliente("3212221111", "vmvini"));
        clientes.add(new Cliente("88888832328", "Jose Antonio Da Sila"));
        clientes.add(new Cliente("323123121", "Mariana Luciana"));
        
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    
    
    
}
