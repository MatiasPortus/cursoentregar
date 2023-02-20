package com.cursoentregar.cursoentregar.dao;

import com.cursoentregar.cursoentregar.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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
        String query = "FROM Usuario WHERE email = :email";
        List<Usuario> lista = entityManager.createQuery(query, Usuario.class)
                .setParameter("email", u.getEmail())
                .getResultList();

        if (lista.isEmpty()) {
            return false;
        }

        String passwordHashed = lista.get(0).getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        return argon2.verify(passwordHashed, u.getPassword());
    }

}
