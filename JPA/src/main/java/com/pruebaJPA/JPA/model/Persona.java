
package com.pruebaJPA.JPA.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity//esta clase va a ser entidad es decir que se va a convertir en tabla en un DB
public class Persona {
    @Id // mapeo JPa-Hibernate
    @GeneratedValue(strategy=GenerationType.SEQUENCE)//mapeo JPA
    private Long id;
    private String nombre;
    private String apellido;
    private int edad;
        
    @OneToMany    
    private List<Mascota> listaMascotas;
    
    public Persona() {
    }

    public Persona(Long id, String nombre, String apellido, int edad, List<Mascota> listaMascotas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.listaMascotas = listaMascotas;
    }

    

    
    
    
    
}
