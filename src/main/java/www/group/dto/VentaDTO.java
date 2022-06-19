/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package www.group.dto;

import java.io.Serializable;
import www.group.entidades.Venta;

/**
 *
 * @author alexc
 */
public class VentaDTO implements Serializable{
    
    private Venta entidad;

    public VentaDTO() {
    }

    public Venta getEntidad() {
        return entidad;
    }

    public void setEntidad(Venta entidad) {
        this.entidad = entidad;
    }
}
