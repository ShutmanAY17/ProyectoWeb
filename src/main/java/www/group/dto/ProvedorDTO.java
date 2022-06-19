/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package www.group.dto;

import java.io.Serializable;
import www.group.entidades.Provedor;

/**
 *
 * @author alexc
 */
public class ProvedorDTO implements Serializable{
    
    private Provedor entidad;

    public ProvedorDTO() {
        entidad = new Provedor();
    }

    public Provedor getEntidad() {
        return entidad;
    }

    public void setEntidad(Provedor entidad) {
        this.entidad = entidad;
    }
    
    
}
