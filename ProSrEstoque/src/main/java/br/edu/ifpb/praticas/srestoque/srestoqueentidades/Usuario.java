package br.edu.ifpb.praticas.srestoque.srestoqueentidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Transient;

/**
 * Document   Usuario
 * @Date  08/08/2016 @Time 15:32:53
 * @author Wellington Lins Claudino Duarte   
 * @mail wellingtonlins2013@gmail.com
 */ 
@Entity
//@Inheritance(strategy=InheritanceType.JOINED)

@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT c FROM Usuario c"),
    @NamedQuery(name = "Usuario.findByEmail", query = "SELECT c FROM Usuario c WHERE c.email = :email"),
    @NamedQuery(name = "Usuario.findByNome", query = "SELECT c FROM Usuario c WHERE c.nome = :nome")})
@SequenceGenerator(name = "usuario_sequencia" , sequenceName = "usuario_sequencia",
   allocationSize =  1 , initialValue = 1)

public class Usuario implements Serializable {
    
    private String email;
    private String nome;
    private String telefone;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Usuario() {
    }

    public Usuario(String email, String nome, String telefone) {
        this.email = email;
        this.nome = nome;
        this.telefone = telefone;
    }

    /*@Transient
    public String getDiscriminatorValue(){
        DiscriminatorValue val = this.getClass().getAnnotation( DiscriminatorValue.class );
        return val == null ? null : val.value();
    }*/
    
  

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", email=" + email + ", nome=" + nome + ", telefone=" + telefone + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    
}