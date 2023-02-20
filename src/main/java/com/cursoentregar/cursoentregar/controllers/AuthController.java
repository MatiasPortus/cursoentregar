package com.cursoentregar.cursoentregar.controllers;

import com.cursoentregar.cursoentregar.dao.UsuarioDao;
import com.cursoentregar.cursoentregar.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario u) {
        if (usuarioDao.verificarCredenciales(u)) {
            return "OK";
        }
        return "FAIL";
    }
}
