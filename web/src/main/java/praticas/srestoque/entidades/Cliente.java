/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticas.srestoque.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author vmvini
 */
@Entity
public class Cliente implements Serializable {
    
    @Id
    private int cpf;
    
    private String nome;
    
    @ElementCollection()
    private List<String> telefones;  
    
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Endereco endereco;

    public Cliente(){}
    
    public Cliente(int cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    
    
    public Cliente(int cpf, String nome, Endereco endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
    }

    
    
    public Cliente(int cpf, String nome, List<String> telefones, Endereco endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefones = telefones;
        this.endereco = endereco;
    }

    
    
    @Override
    public String toString() {
        return "Cliente{" + "cpf=" + cpf + ", nome=" + nome + ", telefones=" + telefones + ", endereco=" + endereco + '}';
    }
    
    

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<String> telefones) {
        this.telefones = telefones;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    
    
}
