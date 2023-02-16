package com.cursoentregar.cursoentregar.controllers;

import com.cursoentregar.cursoentregar.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @RequestMapping(value = "usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id) {
        Usuario u = new Usuario();
        u.setId(id);
        u.setNombre("Matias");
        u.setApellido("Portus");
        u.setEmail("matiasportus@gmail.com");
        u.setTelefono("601223205");
        return u;
    }

    @RequestMapping(value = "usuarios")
    public List<Usuario> getUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        Usuario u = new Usuario();
        u.setId(234L);
        u.setNombre("Matias");
        u.setApellido("Portus");
        u.setEmail("matiasportus@gmail.com");
        u.setTelefono("601223205");

        Usuario u2 = new Usuario();
        u2.setId(432L);
        u2.setNombre("Mat");
        u2.setApellido("Por");
        u2.setEmail("matpor@gmail.com");
        u2.setTelefono("601052232");

        Usuario u3 = new Usuario();
        u3.setId(342L);
        u3.setNombre("m");
        u3.setApellido("p");
        u3.setEmail("mp@gmail.com");
        u3.setTelefono("620122305");

        usuarios.add(u);
        usuarios.add(u2);
        usuarios.add(u3);

        return usuarios;
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

    @RequestMapping(value = "usuario2")
    public Usuario eliminar() {
        Usuario u = new Usuario();
        u.setNombre("Matias");
        u.setApellido("Portus");
        u.setEmail("matiasportus@gmail.com");
        u.setTelefono("601223205");
        return u;
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
