package br.com.necroterio.dao;

import br.com.necroterio.dao.util.JpaUtil;
import br.com.necroterio.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class UsuarioDao extends GenericDao<Usuario, Integer> {

    public UsuarioDao() {
        super(Usuario.class);
    }

    public Usuario verificaLogin(String email, String senha) {
        EntityManager manager = JpaUtil.getEntityManager();

        String jpql = "select u from Usuario u where email = :email and senha = :senha";

        TypedQuery<Usuario> query = manager.createQuery(jpql, Usuario.class);

        query.setParameter("email", email);
        query.setParameter("senha", senha);

        try {
            return query.getSingleResult();
        }catch (NoResultException e) {
            return null;
        } finally {
            manager.close();
        }
    }
}
