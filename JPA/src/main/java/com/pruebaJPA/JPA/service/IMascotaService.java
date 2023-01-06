
package com.pruebaJPA.JPA.service;

import com.pruebaJPA.JPA.model.Mascota;
import java.util.List;

public interface IMascotaService {
    
    // METODO PARA TRAER TODAS LAS MASCOTAS, es una List porque devuelve una lista de MASCOTAS
    //esta es una operación de lectura para todas las MASCOTAS.
    public List<Mascota> getMascota();
    
    
    //este método es para el alta
    public void saveMascota(Mascota masco);
    
    //BAJA
    public void deleteMascota(Long id_mascota);
    
    //lectura de un solo objeto
    public Mascota findMascota (Long id_mascota);
    
    //EDICION/MODIFICACIÓN
    public void editMascota(Long idOriginal, Long id_mascotaNueva,
                            String nuevoNombre, String nuevaEspecie,
                            String nuevaRaza, String nuevoColor);    

    public void editMascota(Mascota masco);
    
}
