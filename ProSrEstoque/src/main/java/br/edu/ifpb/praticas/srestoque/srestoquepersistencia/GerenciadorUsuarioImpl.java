package br.edu.ifpb.praticas.srestoque.srestoquepersistencia;

import br.edu.ifpb.praticas.srestoque.exceptions.NenhumUsuarioCadastrado;
import br.edu.ifpb.praticas.srestoque.exceptions.UsuarioNaoEncontrado;
import br.edu.ifpb.praticas.srestoque.srestoqueentidades.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Document GerenciadorUsuarioImpl
 *
 * @Date 08/08/2016 @Time 15:54:45
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */
@Stateless
public class GerenciadorUsuarioImpl implements GerenciadorUsuario {

    @PersistenceContext(unitName = "ProSrEstoque_PU")
    private EntityManager em;

    @Override
    public void salvarUsuario(Usuario usuario) {
        em.persist(usuario);
    }

    @Override
    public void atualizarUsuario(Usuario usuario) throws UsuarioNaoEncontrado {
        em.merge(usuario);

    }

    @Override
    public void removerUsuario(Usuario usuario) throws UsuarioNaoEncontrado {
        if (em.contains(usuario)) {
            em.remove(usuario);
        } else {
            em.remove(buscarPorEmail(usuario.getEmail()));
        }
    }

    @Override
    public Usuario buscarPorEmail(String email) throws UsuarioNaoEncontrado {
        Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.email = ?1");
        query.setParameter(1, email);
        List<Usuario> usuarios = query.getResultList();
        if (usuarios.isEmpty()) {
            throw new UsuarioNaoEncontrado("Usuario de  '" + email + "' não encontrado");
        }
        return usuarios.get(0);
    }

    @Override
    public List<Usuario> listarUsuarios() throws NenhumUsuarioCadastrado {
        return em.createQuery("select u from Usuario u").getResultList();

    }

    @Override
    public Usuario buscarPorId(int id) throws UsuarioNaoEncontrado {
        Usuario usuario = em.find(Usuario.class, id);
        if (usuario == null) {
            throw new UsuarioNaoEncontrado("Usuario de id: " + id + " não encontrado!");
        }
        return usuario;
    }
}
