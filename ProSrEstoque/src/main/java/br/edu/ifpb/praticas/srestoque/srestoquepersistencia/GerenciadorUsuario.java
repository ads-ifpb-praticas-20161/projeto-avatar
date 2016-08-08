package br.edu.ifpb.praticas.srestoque.srestoquepersistencia;

import br.edu.ifpb.praticas.srestoque.exceptions.NenhumUsuarioCadastrado;
import br.edu.ifpb.praticas.srestoque.exceptions.UsuarioNaoEncontrado;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Usuario;
import java.util.List;

/**
 * Document GerenciadorUsuario
 *
 * @Date 08/08/2016 @Time 15:44:37
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */
public interface GerenciadorUsuario {

    public void salvarUsuario(Usuario usuario);
    public void atualizarUsuario(Usuario usuario) throws UsuarioNaoEncontrado;
    public void removerUsuario(Usuario usuario) throws UsuarioNaoEncontrado;
    public Usuario buscarPorId(int id) throws UsuarioNaoEncontrado;
    public List<Usuario> buscarPorEmail(String email) throws UsuarioNaoEncontrado;
    public List<Usuario> listarUsuarios() throws NenhumUsuarioCadastrado;

}
