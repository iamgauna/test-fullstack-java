package com.somosetica.domain;

import java.io.Serializable;
import javax.persistence.*;
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
    //2. Nombre completo
    private String nombre;
    private String apellido;
    
    //3. Contraseña: Encriptado
    private String contrasena;
    
    //4. Correo
    private String email;
    
    //5. Estado: Los usuarios inactivos no pueden iniciar sesion
    private String estado;
    
    private String telefono;
}
