package com.cursoentregar.cursoentregar.dao;

import com.cursoentregar.cursoentregar.models.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Usuario> getUsuarios() {
        String query = "FROM Usuario";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(Long id) {
        Usuario u = entityManager.find(Usuario.class, id);
        entityManager.remove(u);
    }

    @Override
    public void registrar(Usuario u) {
        entityManager.merge(u);
    }

    @Override
    public boolean verificarCredenciales(Usuario u) {
        String query = "FROM Usuario WHERE email = :email AND password = :password ";
        List<Usuario> lista = entityManager.createQuery(query, Usuario.class)
                .setParameter("email", u.getEmail())
                .setParameter("password", u.getPassword())
                .getResultList();
        return !lista.isEmpty();
    }

}
