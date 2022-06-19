/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package www.grupo.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import www.group.dao.ProductoDAO;
import www.group.dto.ProductoDTO;

/**
 *
 * @author alexc
 */
@WebServlet(name = "AcutalizarProducto", urlPatterns = {"/AcutalizarProducto"})
public class AcutalizarProducto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet' />");
            out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js' ></script>");
            out.println("<title>Servlet ActualizarEstado</title>");
            out.println("</head>");
            out.println("<body>");

            ProductoDTO dto = new ProductoDTO();
            ProductoDAO dao = new ProductoDAO();

            dto.getEntidad().setIdProducto(Integer.parseInt(request.getParameter("id")));
            
            try {
                /*
                private int idProducto;
    private float precio;
    private String modelo;
    private String descripción;
    private int idCategoria;
                */
                
                dto = dao.read(dto);
                out.println("<div class='container'>");
                out.println("<div class='mb-3'></div>");
                out.println("<div class='card text-primary'>");
                out.println("<div class='card-header text-center'>");
                out.println("<h1 class='card-title'>Actualizar Estado</h1>");
                out.println("</div>");
                out.println("<div class='card-body'>");
                out.println("<form name = 'datos' method='post' action='AlmacenarActualizacion'>");
                
                out.println("<label for='txtClave' class='form-label'> Clvae Producto </label>");
                out.println("<input type='text' class='form-control' id='id' name='id' value='" + dto.getEntidad().getIdProducto()+ "' readonly/>");
                
                out.println("<label for='txtPrecio' class='form-label'> Precio </label>");
                out.println("<input type='text' class='form-control' id='txtPrecio' name='txtPrecio' value='" + dto.getEntidad().getPrecio()+ "' />");
                
                out.println("<label for='txtModelo' class='form-label'> Modelo </label>");
                out.println("<input type='text' class='form-control' id='txtModelo' name='txtModelo' value='" + dto.getEntidad().getModelo()+ "' />");
                
                out.println("<label for='txtDescripcion' class='form-label'> Descripcion </label>");
                out.println("<input type='text' class='form-control' id='txtDescripcion' name='txtDescripcion' value='" + dto.getEntidad().getDescripción()+ "' />");
                
                out.println("<label for='txtCategoria' class='form-label'> Categoria </label>");
                out.println("<input type='text' class='form-control' id='txtCategoria' name='txtCategoria' value='" + dto.getEntidad().getIdCategoria()+ "' />");
                
                
                out.println("<div class='mb-3'></div>");
                out.println("<input type='submit' class='btn btn-primary' value='Actualizar' name='btnActualizar'/>");
                out.println("</form>");
                out.println("</div>");
                out.println("</div>");
                out.println("</div>");
                
            } catch (SQLException e) {
                Object ex = null;
                Logger.getLogger(AcutalizarProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
