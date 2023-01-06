
package com.pruebaJPA.JPA.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity //esta es annotation de Hibernate se va a mapear todas las clases que se van a convertir en entidades en una nueva DB
public class Mascota {
    
    @Id //se utiliza para mapear el id de cada clase, las cuales se van a reflejar en la DB como primary key.
    @GeneratedValue(strategy=GenerationType.SEQUENCE)//permite establecer el tipo de frecuencia o generación que va a tener la id.
    private Long id_mascota;
    
    private String nombre;
    private String especie;
    private String raza;
    private String color;

    public Mascota() {
    }

    public Mascota(Long id_mascota, String nombre, String especie, String raza, String color) {
        this.id_mascota = id_mascota;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.color = color;
    }
    
}
