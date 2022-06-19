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
import www.group.dto.ClienteDTO;

/**
 *
 * @author alexc
 */
public class ClienteDAO {
    
    private static final String SQL_INSERT = "insert into cliente(nombreCliente, apellidoPaterno, apellidoMaterno, calle, colonia, delegacion, exterior, interior" 
            + "telefono1, telefono2) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    private static final String SQL_UPDATE = "update cliente set nombreCliente = ?, apellidoPaterno = ?, apellidoMaterno = ?, calle = ?, colonia = ?, " + 
            "delegacion= ?, exterior = ?, interior = ?, telefono1 = ?, telefono2 = ? where idCliente = ? ";
    
    private static final String SQL_DELETE = "delete from cliente where idCliente = ?";
    private static final String SQL_READ = "select * from cliente where idCliente = ?";
    private static final String SQL_READ_ALL = "select * from cliente";
    
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
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //private static final String SQL_INSERT = "insert into cliente(nombreCliente, apellidoPaterno, apellidoMaterno, calle, colonia, delegacion, exterior, interior" 
    //        + "telefono1, telefono2) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public void create(ClienteDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getEntidad().getNombreCliente());
            ps.setString(2, dto.getEntidad().getApellidoPaterno());
            ps.setString(3, dto.getEntidad().getApellidoMaterno());
            ps.setString(4, dto.getEntidad().getCalle());
            ps.setString(5, dto.getEntidad().getColonia());
            ps.setString(6, dto.getEntidad().getDelegacion());
            ps.setInt(7, dto.getEntidad().getExterior());
            ps.setInt(8, dto.getEntidad().getInterior());
            ps.setInt(9, dto.getEntidad().getTelefono1());
            ps.setInt(10, dto.getEntidad().getTelefono2());
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
    
    //private static final String SQL_UPDATE = "update cliente set nombreCliente = ?, apellidoPaterno = ?, apellidoMaterno = ?, calle = ?, colonia = ?, " + 
    //        "delegacion= ?, exterior = ?, interior = ?, telefono1 = ?, telefono2 = ? where idCliente = ? ";
    
    public void update(ClienteDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getEntidad().getNombreCliente());
            ps.setString(2, dto.getEntidad().getApellidoPaterno());
            ps.setString(3, dto.getEntidad().getApellidoMaterno());
            ps.setString(4, dto.getEntidad().getCalle());
            ps.setString(5, dto.getEntidad().getColonia());
            ps.setString(6, dto.getEntidad().getDelegacion());
            ps.setInt(7, dto.getEntidad().getExterior());
            ps.setInt(8, dto.getEntidad().getInterior());
            ps.setInt(9, dto.getEntidad().getTelefono1());
            ps.setInt(10, dto.getEntidad().getTelefono2());
            ps.setInt(11, dto.getEntidad().getIdCliente());
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
    
    //"delete from cliente where idCliente = ?";
    public void delete(ClienteDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getIdCliente());
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
    
    //"select * from cliente where idCliente = ?";
    public ClienteDTO read(ClienteDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement(SQL_READ);
            ps.setInt(1, dto.getEntidad().getIdCliente());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return (ClienteDTO) resultados.get(0);
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
    
    //"select * from cliente";
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
            ClienteDTO dto = new ClienteDTO();
            dto.getEntidad().setIdCliente(rs.getInt("idCliente"));
            dto.getEntidad().setNombreCliente(rs.getString("nombreCliente"));
            dto.getEntidad().setApellidoPaterno(rs.getString("apellidoPaterno"));
            dto.getEntidad().setApellidoMaterno(rs.getString("apellidoMaterno"));
            dto.getEntidad().setCalle(rs.getString("calle"));
            dto.getEntidad().setColonia(rs.getString("colonia"));
            dto.getEntidad().setDelegacion(rs.getString("delegacion"));
            dto.getEntidad().setExterior(rs.getInt("exterior"));
            dto.getEntidad().setInterior(rs.getInt("interior"));
            dto.getEntidad().setTelefono1(rs.getInt("telefono1"));
            dto.getEntidad().setTelefono2(rs.getInt("telefono2"));
            resultado.add(dto);
        }
        return resultado;
    }
    /*
    private int idCliente;
    private String nombreCliente;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String calle;
    private String colonia;
    private String delegacion;
    private int exterior;
    private int interior;
    private int telefono1
    private int telefono2;
    */
}
