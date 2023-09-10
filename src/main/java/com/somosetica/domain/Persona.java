package com.somosetica.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "persona")
public class Persona implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    //1. ID
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long idPersona;
    
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String apellido;
    
    @NotEmpty
    private String contrasena;
    
    @NotEmpty
    @Email
    private String email;
    
    @NotEmpty
    private String estado;
    
    @NotEmpty
    private String telefono;
}
