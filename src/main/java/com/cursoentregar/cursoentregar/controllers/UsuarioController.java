package com.cursoentregar.cursoentregar.controllers;

import com.cursoentregar.cursoentregar.dao.UsuarioDao;
import com.cursoentregar.cursoentregar.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.GET)
    public Usuario getUsuario(@PathVariable Long id) {
        Usuario u = new Usuario();
        u.setId(id);
        u.setNombre("Matias");
        u.setApellido("Portus");
        u.setEmail("matiasportus@gmail.com");
        u.setTelefono("601223205");
        return u;
    }


    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public List<Usuario> getUsuarios() {
        return usuarioDao.getUsuarios();
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario u) {

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, u.getPassword());
        u.setPassword(hash);

        usuarioDao.registrar(u);
    }

    @RequestMapping(value = "usuario1")
    public Usuario editar() {
        Usuario u = new Usuario();
        u.setNombre("Matias");
        u.setApellido("Portus");
        u.setEmail("matiasportus@gmail.com");
        u.setTelefono("601223205");
        return u;
    }

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id) {
       usuarioDao.eliminar(id);
    }

    @RequestMapping(value = "usuario3")
    public Usuario buscar() {
        Usuario u = new Usuario();
        u.setNombre("Matias");
        u.setApellido("Portus");
        u.setEmail("matiasportus@gmail.com");
        u.setTelefono("601223205");
        return u;
    }
}
