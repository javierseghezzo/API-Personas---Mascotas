//acá voy a implementar cada uno de los metodos
package com.pruebaJPA.JPA.service;

import com.pruebaJPA.JPA.model.Mascota;
import com.pruebaJPA.JPA.repository.IMascotaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MascotaService implements IMascotaService {
    
    @Autowired
    private IMascotaRepository repoMasco;

    @Override
    public List<Mascota> getMascota() {
        List<Mascota> listaMascota = repoMasco.findAll();
        return listaMascota;
    }

    @Override
    public void saveMascota(Mascota masco) {
        repoMasco.save(masco);
    }

    @Override
    public void deleteMascota(Long id_mascota) {
        repoMasco.deleteById(id_mascota);
    }

    @Override
    public Mascota findMascota(Long id_mascota) {
        return repoMasco.findById(id_mascota).orElse(null);
        
    }

    @Override
    public void editMascota(Long idOriginal, Long id_mascotaNueva, String nuevoNombre, 
        String nuevaEspecie, String nuevaRaza, String nuevoColor) {
        
        //busco el objeto original
        Mascota masco = this.findMascota(idOriginal);
        
        //proceso de modificación a nivel lógico
        masco.setId_mascota(id_mascotaNueva);
        masco.setNombre(nuevoNombre);
        masco.setEspecie(nuevaEspecie);
        masco.setRaza(nuevaRaza);
        masco.setColor(nuevoColor);
        
        //guardo los cambios
        this.saveMascota(masco);
    }

    @Override
    public void editMascota(Mascota masco) {
        this.saveMascota(masco);       
        
    }
    
    
    
    
}
