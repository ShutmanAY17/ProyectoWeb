package www.group.dto;

import java.io.Serializable;
import www.group.entidades.Producto;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alexc
 */
public class ProductoDTO implements Serializable{
    
    private Producto entidad;

    public ProductoDTO() {
        entidad = new Producto();
    }

    public Producto getEntidad() {
        return entidad;
    }

    public void setEntidad(Producto entidad) {
        this.entidad = entidad;
    }
    
    
}
