/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package www.group.dto;

import java.io.Serializable;
import www.group.entidades.Categoria;

/**
 *
 * @author alexc
 */
public class CategoriaDTO implements Serializable {
    
    private Categoria entidad;

    public CategoriaDTO() {
        entidad = new Categoria();
    }

    public Categoria getEntidad() {
        return entidad;
    }

    public void setEntidad(Categoria entidad) {
        this.entidad = entidad;
    }
    
    
}
