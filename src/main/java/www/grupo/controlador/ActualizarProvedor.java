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
import www.group.dao.ProvedorDAO;
import www.group.dto.ProvedorDTO;

/**
 *
 * @author alexc
 */
@WebServlet(name = "ActualizarProvedor", urlPatterns = {"/ActualizarProvedor"})
public class ActualizarProvedor extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet' />");
            out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js' ></script>");
            out.println("<title>Servlet ActualizarEstado</title>");
            out.println("</head>");
            out.println("<body>");

            ProvedorDTO dto = new ProvedorDTO();
            ProvedorDAO dao = new ProvedorDAO();

            dto.getEntidad().setIdProvedor(Integer.parseInt(request.getParameter("id")));
            try {
                dto = dao.read(dto);
                out.println("<div class='container'>");
                out.println("<div class='mb-3'></div>");
                out.println("<div class='card text-primary'>");
                out.println("<div class='card-header text-center'>");
                out.println("<h1 class='card-title'>Actualizar Estado</h1>");
                out.println("</div>");
                out.println("<div class='card-body'>");
                out.println("<form name = 'datos' method='post' action='AlmacenarActualizacion'>");
                
                out.println("<label for='txtClave' class='form-label'> Clvae Provedor</label>");
                out.println("<input type='text' class='form-control' id='id' name='id' value='" + dto.getEntidad().getIdProvedor()+ "' readonly/>");
                
                out.println("<label for='txtNombre' class='form-label'> Nombre </label>");
                out.println("<input type='text' class='form-control' id='txtNombre' name='txtNombre' value='" + dto.getEntidad().getNombre()+ "' />");
                
                out.println("<label for='txtCalle' class='form-label'> Calle </label>");
                out.println("<input type='text' class='form-control' id='txtCalle' name='txtCalle' value='" + dto.getEntidad().getCalle()+ "' />");
                
                out.println("<label for='txtColonia' class='form-label'> Colonia </label>");
                out.println("<input type='text' class='form-control' id='txtColonia' name='txtColonia' value='" + dto.getEntidad().getColonia()+ "' />");
                
                out.println("<label for='txtDelegacion' class='form-label'> Delegacion </label>");
                out.println("<input type='text' class='form-control' id='txtDelegacion' name='txtDelegacion' value='" + dto.getEntidad().getDelegacion()+ "' />");
                
                out.println("<label for='txtInterior' class='form-label'> Interior </label>");
                out.println("<input type='text' class='form-control' id='txtInterior' name='txtInterior' value='" + dto.getEntidad().getInterior()+ "' />");
                
                out.println("<label for='txtNombre' class='form-label'> Nombre Estado </label>");
                out.println("<input type='text' class='form-control' id='txtNombre' name='txtNombre' value='" + dto.getEntidad().getExterior()+ "' />");
                
                out.println("<label for='txtWebsite' class='form-label'> Website </label>");
                out.println("<input type='text' class='form-control' id='txtWebsite' name='txtWebsite' value='" + dto.getEntidad().getWebsite()+ "' />");
                
                out.println("<label for='txtTelefono1' class='form-label'> Telefono 1 </label>");
                out.println("<input type='text' class='form-control' id='txtTelefono1' name='txtTelefono1' value='" + dto.getEntidad().getTelefono1()+ "' />");
                
                out.println("<label for='txtTelefono2' class='form-label'> Telefono 2 </label>");
                out.println("<input type='text' class='form-control' id='txtTelefono2' name='txtTelefono2' value='" + dto.getEntidad().getTelefono2()+ "' />");
                
                
                out.println("<div class='mb-3'></div>");
                out.println("<input type='submit' class='btn btn-primary' value='Actualizar' name='btnActualizar'/>");
                out.println("</form>");
                out.println("</div>");
                out.println("</div>");
                out.println("</div>");
                
            } catch (SQLException e) {
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ActualizarProvedor.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ActualizarProvedor.class.getName()).log(Level.SEVERE, null, ex);
        }
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
