package com.cursoentregar.cursoentregar.controllers;

import com.cursoentregar.cursoentregar.dao.UsuarioDao;
import com.cursoentregar.cursoentregar.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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


    @RequestMapping(value = "api/usuarios")
    public List<Usuario> getUsuarios() {
    return usuarioDao.getUsuarios();
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
