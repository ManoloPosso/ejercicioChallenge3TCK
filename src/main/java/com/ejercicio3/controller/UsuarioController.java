package com.ejercicio3.controller;


import com.ejercicio3.entity.Usuario;
import com.ejercicio3.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@Validated
public class UsuarioController {

    private UsuarioService usuarioService;

    @PostMapping
    private ResponseEntity<Usuario> crearUsuario(@Valid @RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.crearUsuario(usuario));
    }
}
