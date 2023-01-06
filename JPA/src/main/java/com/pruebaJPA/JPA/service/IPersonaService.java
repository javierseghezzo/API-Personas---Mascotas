//
package com.pruebaJPA.JPA.service;

import com.pruebaJPA.JPA.model.Persona;
import java.util.List;


public interface IPersonaService {
    
    // METODO PARA TRAER TODAS LAS PERSONAS, es una List porque devuelve una lista de personas
    //esta es una operación de lectura para todas las personas.
    public List<Persona> getPersonas();
    
    
    //este método es para el alta
    public void savePersona(Persona perso);
    
    //BAJA
    public void deletePersona(Long id);
    
    //lectura de un solo objeto
    public Persona findPersona (Long id);
    
    //EDICION/MODIFICACIÓN
    public void editPersona(Long idOriginal, Long idNueva,
                            String nuevoNombre, String nuevoApellido,
                            int nuevaEdad);

    public void editPersona(Persona per);
    
    
    
}
