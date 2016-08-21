/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticas.srestoque.sessionbeans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import praticas.srestoque.entidades.Funcionario;
import praticas.srestoque.entidades.TipoFuncionario;
import praticas.srestoque.repositorio.FuncionarioRepository;

/**
 *
 * @author vmvini
 */

@Startup
@Singleton
public class InicializacaoSB {
    
    @EJB
    private FuncionarioRepository fr;
    
    @PostConstruct
    public void init(){
        cadastrarAdminPadrao();
    }
    
    private void cadastrarAdminPadrao(){
        List<Funcionario> fs = fr.listar();
        if(fs.isEmpty()){
            Funcionario f = new Funcionario("srestoque@admin.com", "admin", TipoFuncionario.ADMINISTRADOR);
            fr.salvar(f);
        }
    }
    
}
