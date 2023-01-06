//caso particular donde se, donde se extiende desde la clase,
// la interfaz va a ser el repository
package com.pruebaJPA.JPA.repository;

import com.pruebaJPA.JPA.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//esta interfaz extiende de JpaRepository
// dos parámetros 1)la clase a mapear 2-tipo de dato del Id de la clase

@Repository
public interface IPersonaRepository extends JpaRepository <Persona, Long> {
    //el Long es el tipo de dato dde la Primary Key de la clase Persona
}
