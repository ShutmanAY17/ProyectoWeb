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
import www.group.dto.ProductoDTO;

/**
 *
 * @author alexc
 */
public class ProductoDAO {

    private static final String SQL_INSERT = "insert into producto(precio, modelo, descripción, idCategoria) values (?, ?, ?, ?)";
    private static final String SQL_UPDATE = "update producto set precio = ?, modelo = ?, descripción = ?, idCategoria = ? where idProducto = ? ";
    private static final String SQL_DELETE = "delete from producto where idProducto = ?";
    private static final String SQL_READ = "select * from producto where idProducto = ?";
    private static final String SQL_READ_ALL = "select * from producto";

    private Connection conexion;

    private void conectar() {
        String usuario = "root";
        String clave = "AsunaYuuki17";
        String url = "jdbc:mysql://localhost:3306/proyectoweb";
        //?serverTimezone=America/Mexico_City&allowPublicKeyRetrieval=true&useSSL=false
        String driver = "com.mysql.cj.jdbc.Driver";

        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, usuario, clave);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //"insert into producto(precio, modelo, descripción, idCategoria) values (?, ?, ?, ?)";
    public void create(ProductoDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_INSERT);
            ps.setFloat(1, dto.getEntidad().getPrecio());
            ps.setString(2, dto.getEntidad().getModelo());
            ps.setString(3, dto.getEntidad().getDescripción());
            ps.setInt(4, dto.getEntidad().getIdCategoria());
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
    
    //"update producto set precio = ?, modelo = ?, descripción = ?, idCategoria = ? where idProducto = ? ";
    public void update(ProductoDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_UPDATE);
            ps.setFloat(1, dto.getEntidad().getPrecio());
            ps.setString(2, dto.getEntidad().getModelo());
            ps.setString(3, dto.getEntidad().getDescripción());
            ps.setInt(4, dto.getEntidad().getIdCategoria());
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
    
    //"delete from producto where idProducto = ?";
    public void delete(ProductoDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getIdProducto());
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
    
    //"select * from producto where idProducto = ?";
    public ProductoDTO read(ProductoDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement(SQL_READ);
            ps.setInt(1, dto.getEntidad().getIdProducto());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return (ProductoDTO) resultados.get(0);
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
    
    //"select * from producto";
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
            ProductoDTO dto = new ProductoDTO();
            dto.getEntidad().setIdProducto(rs.getInt("idProducto"));
            dto.getEntidad().setPrecio(rs.getFloat("precio"));
            dto.getEntidad().setModelo(rs.getString("modelo"));
            dto.getEntidad().setDescripción(rs.getString("descripción"));
            dto.getEntidad().setIdCategoria(rs.getInt("idCategoria"));
            resultado.add(dto);
        }
        return resultado;
    }
    
    /*
    private int idProducto;
    private float precio;
    private String modelo;
    private String descripción;
    private int idCategoria;
     */
}
