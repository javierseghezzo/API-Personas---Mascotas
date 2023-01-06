
package com.pruebaJPA.JPA.service;

import com.pruebaJPA.JPA.model.Persona;
import com.pruebaJPA.JPA.repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService {
    
    @Autowired
    private IPersonaRepository persoRepo; //persoRepo, es la inyección al repositorio
    //Declaro el nombre de la interface
    //de repository

    @Override
    public List<Persona> getPersonas() {
        //acá tiene que obtener la lista de todas las personas y devolver 
        //a nuestro controlador que es quien hizo la consulta
        //creamos la lista de personas
        List<Persona> listaPersonas = persoRepo.findAll();
        return listaPersonas;
        
        
    }

    @Override
    public void savePersona(Persona perso) {
        //acá vamos a guardar un bojeto persona para almacenarlo en la BD
        persoRepo.save(perso);
    }

    @Override
    public void deletePersona(Long id) {
        persoRepo.deleteById(id);//no es la única forma de usar el delete.
        //Acá nos pasarían un id del controller y se borraria la persona
    }

    @Override
    public Persona findPersona(Long id) {
        //acá se va a instanciar un objeto de la clase persona
        Persona perso = persoRepo.findById(id).orElse(null);
        return perso;
    }

    @Override
    public void editPersona(Long idOriginal, Long idNueva, String nuevoNombre,
                            String nuevoApellido, int nuevaEdad) {
        //primero vamos a tener la id original con la cual vamos a buscar en la
        //DB si existe la persona, para eso usamos el método findPersona()
        
        Persona perso = this.findPersona(idOriginal);
        //acá busca por id, y la asigna al objeto perso.
        //perso va a venir con los valores originarios de la DB.
        
        //proceso de modificación a nivel lógico
        perso.setId(idNueva);
        perso.setNombre(nuevoNombre);
        perso.setApellido(nuevoApellido);
        perso.setEdad(nuevaEdad);
        
        //esto hay que pasarlo a la DB,¿como? mediante el método save, así nos
        //aseguramos de que no haya objetos repetidos.
        
        //guardo la persona modificada
        this.savePersona(perso);
        
        // el método savePersona recibe el objeto perso con las modificaciones,
        //savePersona llama al repositorio y mandarlo a la DB.
    }

    @Override
    public void editPersona(Persona per) {
        this.savePersona(per);
    }
}
