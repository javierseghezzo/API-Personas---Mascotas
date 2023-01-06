
package com.pruebaJPA.JPA.repository;

import com.pruebaJPA.JPA.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMascotaRepository extends JpaRepository <Mascota, Long>{
         
    //el Long es el tipo de dato de la Primary Key de la clase Mascota
    
}
