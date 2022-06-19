/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package www.group.entidades;

import java.io.Serializable;

/**
 *
 * @author alexc
 */
public class Categoria implements Serializable {

    private int idCategoria;
    private String nombreProducto;
    private String descripcion;
    private String caracteristicasTecnicas;
    private int idProvedor;

    public Categoria() {
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCaracteristicasTecnicas() {
        return caracteristicasTecnicas;
    }

    public void setCaracteristicasTecnicas(String caracteristicasTecnicas) {
        this.caracteristicasTecnicas = caracteristicasTecnicas;
    }

    public int getIdProvedor() {
        return idProvedor;
    }

    public void setIdProvedor(int idProvedor) {
        this.idProvedor = idProvedor;
    }
    
    
}
