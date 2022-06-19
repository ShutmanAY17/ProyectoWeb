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
public class Provedor implements Serializable {

    private int idProvedor;
    private String nombre;
    private String calle;
    private String colonia;
    private String delegacion;
    private int interior;
    private int exterior;
    private String website;
    private int telefono1;
    private int telefono2;

    public Provedor() {
    }

    public int getIdProvedor() {
        return idProvedor;
    }

    public void setIdProvedor(int idProvedor) {
        this.idProvedor = idProvedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getDelegacion() {
        return delegacion;
    }

    public void setDelegacion(String delegacion) {
        this.delegacion = delegacion;
    }

    public int getInterior() {
        return interior;
    }

    public void setInterior(int interior) {
        this.interior = interior;
    }

    public int getExterior() {
        return exterior;
    }

    public void setExterior(int exterior) {
        this.exterior = exterior;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public int getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(int telefono1) {
        this.telefono1 = telefono1;
    }

    public int getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(int telefono2) {
        this.telefono2 = telefono2;
    }
    
    
}
