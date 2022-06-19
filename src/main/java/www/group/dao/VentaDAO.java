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
import www.group.dto.VentaDTO;

/**
 *
 * @author alexc
 */
public class VentaDAO {
    
    private static final String SQL_INSERT = "insert into venta(fecha, descuento, montoTotal, idCliente, idProducto) values (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "update venta set fecha = ?, descuento = ?, montoTotal = ?, idCliente = ?, idProducto = ? where idVenta = ? ";
    private static final String SQL_DELETE = "delete from venta where idVenta = ?";
    private static final String SQL_READ = "select * from venta where idVenta = ?";
    private static final String SQL_READ_ALL = "select * from venta";
    
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
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //"insert into venta(fecha, descuento, montoTotal, idCliente, idProducto) values (?, ?, ?, ?, ?)";
    public void create(VentaDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_INSERT);
            ps.setDate(1, dto.getEntidad().getFecha());
            ps.setInt(2, dto.getEntidad().getDescuento());
            ps.setString(3, dto.getEntidad().getMontoTotal());
            ps.setInt(4, dto.getEntidad().getIdCliente());
            ps.setInt(5, dto.getEntidad().getIdProducto());
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
    
    
    public void update(VentaDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_UPDATE);
            ps.setDate(1, dto.getEntidad().getFecha());
            ps.setInt(2, dto.getEntidad().getDescuento());
            ps.setString(3, dto.getEntidad().getMontoTotal());
            ps.setInt(4, dto.getEntidad().getIdCliente());
            ps.setInt(5, dto.getEntidad().getIdProducto());
            ps.setInt(6, dto.getEntidad().getIdVenta());
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
    
    
    public void delete(VentaDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getIdVenta());
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
    
    
    public VentaDTO read(VentaDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement(SQL_READ);
            ps.setInt(1, dto.getEntidad().getIdVenta());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return (VentaDTO) resultados.get(0);
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
            VentaDTO dto = new VentaDTO();
            dto.getEntidad().setIdVenta(rs.getInt("idVenta"));
            dto.getEntidad().setFecha(rs.getDate("fecha"));
            dto.getEntidad().setDescuento(rs.getInt("descuento"));
            dto.getEntidad().setMontoTotal(rs.getString("montoTotal"));
            dto.getEntidad().setIdCliente(rs.getInt("idCliente"));
            dto.getEntidad().setIdProducto(rs.getInt("idProducto"));
            resultado.add(dto);
        }
        return resultado;
    }
    /*
    private int idVenta;
    private Date fecha;
    private int descuento;
    private String montoTotal;
    private int idCliente;
    private int idProducto;
    */
}
