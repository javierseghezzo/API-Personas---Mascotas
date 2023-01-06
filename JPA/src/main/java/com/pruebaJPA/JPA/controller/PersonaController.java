
package com.pruebaJPA.JPA.controller;

import com.pruebaJPA.JPA.model.Persona;
import com.pruebaJPA.JPA.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController  //acá se van a recibir cada una de las peticiones
public class PersonaController {
    //VAMOS A ARMAR CADA UNO DE LOS ENDPOINTS
    
    @Autowired
    private IPersonaService persoServ; //acá el controller llama al service
    
    //endppoint para traer todas las personas.
    @GetMapping ("/personas/traer")
    public List<Persona> getPersonas(){
        
        return persoServ.getPersonas();
    }
    
    @PostMapping("/personas/crear") //en el método se pone String par que devuelva //texto para saber que se guardó el post.
            
    public String savePersona(@RequestBody Persona perso){
        persoServ.savePersona(perso);
        
        return "La persona fue creada correctamente.";//solo a modo de aviso.
        
    }
    
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        persoServ.deletePersona(id);
        return "La persona se borró correctamnte";
    }
    
    //para la edición vamos a usar el PUT
    @PutMapping ("/personas/editar/{id_original}")
    public Persona editPersona(@PathVariable Long id_original,
            @RequestParam(required = false,name = "id") Long nuevaId,
            @RequestParam(required = false,name = "nombre") String nuevoNombre,
            @RequestParam(required = false,name = "apellido") String nuevoApellido,
            @RequestParam(required = false,name = "edad") int nuevaEdad){
            
        persoServ.editPersona(id_original, nuevaId, nuevoNombre, nuevoApellido, nuevaEdad);
        Persona perso = persoServ.findPersona(nuevaId);
        
        return perso;
        }
    //con id original
    @PutMapping("/personas/editar")
    public Persona editPersona(@RequestBody Persona per){
        persoServ.editPersona(per);
        
        return persoServ.findPersona(per.getId());
    
    }
        
    }   
    

