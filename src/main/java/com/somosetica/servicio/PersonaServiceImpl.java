package com.somosetica.servicio;

import java.util.List;
import com.somosetica.dao.PersonaDao;
import com.somosetica.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;//Dado que cuando trabajamos con una capa DAO manejamos el concepto de TRANSACCIONES, esto quiere decir que SI OCURRE ALGUN ERROR EN UNA OPERACION CON LA BASE DE DATOS se debe hacer un ROLLBACK y en el caso de que TODO SALE OK se debe hacer un COMMIT. Para ello, utilizamos la anotacion @Transactional.

@Service//Para que SPRING pueda reconocer esta clase como una "clase servicio"
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaDao personaDao;
    
    @Override
    @Transactional(readOnly = true)//Utilizamos el atributo de <<readOnly>> ya que solo se va a leer informacion
    public List<Persona> listarPersonas() {
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) {
        return personaDao.findById(persona.getIdPersona())//retornamos el resultado de la busqueda mediante el ID
                .orElse(null);//Como el metodo .findById retorna un tipo Optional usamos el metodo orElse() para retornar un null en caso de que no encuentre ningun dato
        
    }
}
