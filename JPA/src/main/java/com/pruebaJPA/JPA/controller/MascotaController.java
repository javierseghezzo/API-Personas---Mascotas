
package com.pruebaJPA.JPA.controller;

import com.pruebaJPA.JPA.model.Mascota;
import com.pruebaJPA.JPA.service.IMascotaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MascotaController {
    
    @Autowired
    private IMascotaService mascoServ;
    
    @GetMapping ("/mascotas/traer")
    public List<Mascota> getMascota(){
        
        return mascoServ.getMascota();
    }
    
    @PostMapping("/mascotas/crear") //en el método se pone String par que devuelva
            //texto para saber que se guardó el post
    public String saveMascota(@RequestBody Mascota masco){
        mascoServ.saveMascota(masco);
        
        return "La mascota fue creada correctamente";
    } 
    
    @DeleteMapping("/mascotas/borrar/{id}")
    public String deleteMascota(@PathVariable Long id){
        mascoServ.deleteMascota(id);
        return "La mascota fue borrada correctamente";
    }
      
    
    //con id original
    @PutMapping("/mascotas/editar")
    public Mascota editMascota(@RequestBody Mascota masco){
        mascoServ.editMascota(masco);
        
        return mascoServ.findMascota(masco.getId_mascota());
    
    }
    
}
