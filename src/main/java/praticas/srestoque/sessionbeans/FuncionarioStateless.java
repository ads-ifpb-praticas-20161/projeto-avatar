/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticas.srestoque.sessionbeans;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import praticas.srestoque.entidades.Funcionario;
import praticas.srestoque.excecoes.ChavePrimariaException;
import praticas.srestoque.excecoes.ValidacaoFormularioException;
import praticas.srestoque.repositorio.FuncionarioRepository;

/**
 *
 * @author vmvini
 */

@Stateless
public class FuncionarioStateless {
    
    @EJB
    private FuncionarioRepository fr;

    public void cadastrar(Funcionario funcionario) throws ValidacaoFormularioException, ChavePrimariaException{
        
        validar(funcionario);
        fr.salvar(funcionario);
    }
    
    private void validar(Funcionario f) throws ValidacaoFormularioException{
        if(f.getEmail() == null){
            throw new ValidacaoFormularioException("Email não fornecido");
        }
        if(f.getEmail().isEmpty()){
            throw new ValidacaoFormularioException("O email não pode estar vazio!");
        }
        if(f.getSenha() == null){
             throw new ValidacaoFormularioException("Senha não fornecida");
        }
        if(f.getSenha().isEmpty()){
            throw new ValidacaoFormularioException("A senha não pode estar vazia!");
        }
        if(f.getTipo() == null){
            throw new ValidacaoFormularioException("Tipo de funcionário não foi fornecido!");
        }
    }
        
    public void remover(Funcionario funcionario){
        fr.remover(funcionario);
    }
    
    public Funcionario buscarPorId(String email){
        return fr.getById(email);
    }
    
    public List<Funcionario> listar(){
        return fr.listar();
    }
    
    public FuncionarioRepository getFr() {
        return fr;
    }

    public void setFr(FuncionarioRepository fr) {
        this.fr = fr;
    }

}
