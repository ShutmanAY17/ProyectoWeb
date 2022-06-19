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
import www.group.dto.CategoriaDTO;

/**
 *
 * @author alexc
 */
public class CategoriaDAO {
    
    private static final String SQL_INSERT = "insert into Categoria(nombreProducto, descripcion, caracteristicasTecnicas, idProvedor) values (? ,? ,? ,?)";
    private static final String SQL_UPDATE = "update Categoria set nombreProducto = ?, descripcion = ?, caracteristicasTecnicas = ?, idProvedor = ? where idCategoria= ? ";
    private static final String SQL_DELETE = "delete from Categoria where idCategoria = ?";
    private static final String SQL_READ = "select * from Categoria where idCategoria = ?";
    private static final String SQL_READ_ALL = "select * from Categoria";
    
    
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
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //"insert into Categoria(nombreProducto, descripcion, caracteristicasTecnicas, idProvedor) values (? ,? ,? ,?)";
    
    public void create(CategoriaDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getEntidad().getNombreProducto());
            ps.setString(2, dto.getEntidad().getDescripcion());
            ps.setString(3, dto.getEntidad().getCaracteristicasTecnicas());
            ps.setInt(4, dto.getEntidad().getIdProvedor());
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
    
    //"update Categoria set nombreProducto = ?, descripcion = ?, caracteristicasTecnicas = ?, idProvedor = ? where idCategoria= ? ";
    public void update(CategoriaDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getEntidad().getNombreProducto());
            ps.setString(2, dto.getEntidad().getDescripcion());
            ps.setString(3, dto.getEntidad().getCaracteristicasTecnicas());
            ps.setInt(4, dto.getEntidad().getIdProvedor());
            ps.setInt(5, dto.getEntidad().getIdCategoria());
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
    
    //"delete from Categoria where idCategoria = ?";
    public void delete(CategoriaDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getIdCategoria());
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
    
    //"select * from Categoria where idCategoria = ?";
    public CategoriaDTO read(CategoriaDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement(SQL_READ);
            ps.setInt(1, dto.getEntidad().getIdCategoria());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return (CategoriaDTO) resultados.get(0);
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
    
    //"select * from Categoria";
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
    
    /*
    private int idCategoria;
    private String nombreProducto;
    private String descripcion;
    private String caracteristicasTecnicas;
    private int idProvedor;
    */
    private List obtenerResultados(ResultSet rs) throws SQLException {
        List resultado = new ArrayList();
        while (rs.next()) {
            CategoriaDTO dto = new CategoriaDTO();
            dto.getEntidad().setIdCategoria(rs.getInt("idCategoria"));
            dto.getEntidad().setNombreProducto(rs.getString("nombreProducto"));
            dto.getEntidad().setDescripcion(rs.getString("descripcion"));
            dto.getEntidad().setCaracteristicasTecnicas(rs.getString("caracteristicasTecnicas"));
            dto.getEntidad().setIdProvedor(rs.getInt("idProvedor"));
            resultado.add(dto);
        }
        return resultado;
    }
}
