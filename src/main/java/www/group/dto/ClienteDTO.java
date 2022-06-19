/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package www.group.dto;

import java.io.Serializable;
import www.group.entidades.Cliente;

/**
 *
 * @author alexc
 */
public class ClienteDTO implements Serializable{
    
    private Cliente entidad;

    public ClienteDTO() {
        entidad = new Cliente();
    }

    public Cliente getEntidad() {
        return entidad;
    }

    public void setEntidad(Cliente entidad) {
        this.entidad = entidad;
    }
    
    
}
