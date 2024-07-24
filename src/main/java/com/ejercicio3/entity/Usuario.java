package com.ejercicio3.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Debe agregar un nombre")
    private String nombre;

    @Email(message = "El email debe ser correcto")
    @NotBlank(message = "Debe agregar un email")
    private String email;

    @Min(value = 18, message = "La edad no puede ser inferior a 18 años")
    @Max(value =  99, message = "La edad no puede ser superior a 99 años")
    private int edad;


}
