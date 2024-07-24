package com.ejercicio3;

import com.ejercicio3.entity.Usuario;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class UsuarioValidacionesTest {

    private static Validator validator;

    @BeforeEach
    public void setUpValidator(){
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Test
    void nombreNulo(){
        Usuario usuario = new Usuario();
        usuario.setNombre(null);
        usuario.setEmail("manuel@gmail.com");
        usuario.setEdad(30);

        Set<ConstraintViolation<Usuario>> error = validator.validate(usuario);
        assertFalse(error.isEmpty());
    }

    @Test
    void nombreVacio(){
        Usuario usuario = new Usuario();
        usuario.setNombre("");
        usuario.setEmail("manuel@gmail.com");
        usuario.setEdad(30);

        Set<ConstraintViolation<Usuario>> error = validator.validate(usuario);
        assertFalse(error.isEmpty());
    }

    @Test
    void emailErroneo(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Manuel");
        usuario.setEmail("manuel.gmail.com");
        usuario.setEdad(30);

        Set<ConstraintViolation<Usuario>> error = validator.validate(usuario);
        assertFalse(error.isEmpty());
    }

    @Test
    void edadErroneaMenor(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Manuel");
        usuario.setEmail("manuel@gmail.com");
        usuario.setEdad(10);

        Set<ConstraintViolation<Usuario>> error = validator.validate(usuario);
        assertFalse(error.isEmpty());
    }

    @Test
    void edadErroneaMayor(){

        Usuario usuario = new Usuario();
        usuario.setNombre("Manuel");
        usuario.setEmail("manuel@gmail.com");
        usuario.setEdad(120);

        Set<ConstraintViolation<Usuario>> error = validator.validate(usuario);
        assertFalse(error.isEmpty());
    }


}
