/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package www.group.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import www.group.dto.ProvedorDTO;

/**
 *
 * @author alexc
 */
public class ProvedorDAO {
    private static final String SQL_INSERT = "insert into provedor(nombre, calle, colonia, delegacion, interior, exterior," + 
            " website, telefono1, telefono2) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    private static final String SQL_UPDATE = "update provedor set nombre = ?, calle = ?, colonia = ?, delegacion = ?, interior = ?, exterior = ?, " +
            "website = ?, telefono1 = ?, telefono2 = ? where idProvedor = ? ";
    
    private static final String SQL_DELETE = "delete from provedor where idProvedor = ?";
    private static final String SQL_READ = "select * from provedor where idProvedor = ?";
    private static final String SQL_READ_ALL = "select * from provedor";
    
    private Connection conexion;
    
    private void conectar(){
        String usuario = "root";
        String clave = "AsunaYuuki17";
        String url = "jdbc:mysql://localhost:3306/proyectoweb";
        //?serverTimezone=America/Mexico_City&allowPublicKeyRetrieval=true&useSSL=false
        String driver = "com.mysql.cj.jdbc.Driver";

        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, usuario, clave);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProvedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //private static final String SQL_INSERT = "insert into provedor(nombre, calle, colonia, delegacion, interior, exterior," + 
    //        " website, telefono1, telefono2) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public void create(ProvedorDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getEntidad().getNombre());
            ps.setString(2, dto.getEntidad().getCalle());
            ps.setString(3, dto.getEntidad().getColonia());
            ps.setString(4, dto.getEntidad().getDelegacion());
            ps.setInt(5, dto.getEntidad().getInterior());
            ps.setInt(6, dto.getEntidad().getExterior());
            ps.setString(7, dto.getEntidad().getWebsite());
            ps.setInt(8, dto.getEntidad().getTelefono1());
            ps.setInt(9, dto.getEntidad().getTelefono2());
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }
    
    //private static final String SQL_UPDATE = "update provedor set nombre = ?, calle = ?, colonia = ?, delegacion = ?, interior = ?, exterior = ?, " +
    //        "website = ?, telefono1 = ?, telefono2 = ? where idProvedor = ? ";
    public void update(ProvedorDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getEntidad().getNombre());
            ps.setString(2, dto.getEntidad().getCalle());
            ps.setString(3, dto.getEntidad().getColonia());
            ps.setString(4, dto.getEntidad().getDelegacion());
            ps.setInt(5, dto.getEntidad().getInterior());
            ps.setInt(6, dto.getEntidad().getExterior());
            ps.setString(7, dto.getEntidad().getWebsite());
            ps.setInt(8, dto.getEntidad().getTelefono1());
            ps.setInt(9, dto.getEntidad().getTelefono2());
            ps.setInt(10, dto.getEntidad().getIdProvedor());
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }
    
    //"delete from provedor where idProvedor = ?";
    public void delete(ProvedorDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getIdProvedor());
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }
    
    //"select * from provedor where idProvedor = ?";
    public ProvedorDTO read(ProvedorDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement(SQL_READ);
            ps.setInt(1, dto.getEntidad().getIdProvedor());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return (ProvedorDTO) resultados.get(0);
            } else {
                return null;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }
    
    //"select * from provedor";
    public List readAll() throws SQLException {
        conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement(SQL_READ_ALL);
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return resultados;
            } else {
                return null;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }
    
    
    private List obtenerResultados(ResultSet rs) throws SQLException {
        List resultado = new ArrayList();
        while (rs.next()) {
            ProvedorDTO dto = new ProvedorDTO();
            dto.getEntidad().setIdProvedor(rs.getInt("idProvedor"));
            dto.getEntidad().setNombre(rs.getString("nombre"));
            dto.getEntidad().setCalle(rs.getString("calle"));
            dto.getEntidad().setColonia(rs.getString("colonia"));
            dto.getEntidad().setDelegacion(rs.getString("delegacion"));
            dto.getEntidad().setInterior(rs.getInt("interior"));
            dto.getEntidad().setExterior(rs.getInt("exterior"));
            dto.getEntidad().setWebsite(rs.getString("website"));
            dto.getEntidad().setTelefono1(rs.getInt("telefono1"));
            dto.getEntidad().setTelefono2(rs.getInt("telefono2"));
            resultado.add(dto);
        }
        return resultado;
    }
    
    /*
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
    */
}
