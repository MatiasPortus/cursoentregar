package com.cursoentregar.cursoentregar.dao;

import com.cursoentregar.cursoentregar.models.Usuario;

import java.util.List;

public interface UsuarioDao {

    List<Usuario> getUsuarios();

    void eliminar(Long id);

    void registrar(Usuario u);
}
