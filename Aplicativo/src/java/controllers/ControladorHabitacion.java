/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.HabitacionDAO;
import vo.HabitacionVO;

/**
 *
 * @author ACER
 */
@WebServlet(name = "ControladorHabitacion", urlPatterns = {"/ControladorHabitacion"})
public class ControladorHabitacion extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        String idhabitacion = request.getParameter("Idhabitacion");
        String idtipohabitacion = request.getParameter("tipohabitacion");
        String idserviciohabitacion = request.getParameter("serviciohabitacion");
        String idhotel = request.getParameter("idhotel");
        String numerohabitacion = request.getParameter("numerohabitacion");
        String cantidadpersonas = request.getParameter("cantidadpersonas");
        String precio = request.getParameter("precio");
        String numeropiso = request.getParameter("numeropiso");
        String descripcion = request.getParameter("descripcion");
        String disponibilidad = request.getParameter("disponibilidad");
        String fechacreacion = request.getParameter("fechacreacion");
        
        HabitacionVO HabVO = new HabitacionVO(idhabitacion, idtipohabitacion,
                                               idserviciohabitacion, idhotel, 
                                               numerohabitacion, cantidadpersonas,
                                               precio, numeropiso, descripcion, 
                                               disponibilidad, fechacreacion);
        HabitacionDAO HabDAO = new HabitacionDAO(HabVO);
        
        switch (opcion){
            case 1:
                if (HabDAO.agregarHabitacion()){
                    request.setAttribute("mensajeExito", "La Habitacion Se Registro Correctamente");
                }else{
                    request.setAttribute("mensajeError", "La habitacion NO Se Registro Correctamente");
                }
            request.getRequestDispatcher("registrarHabitacion.jsp").forward(request, response);
                break;
            case 2:
                request.setAttribute("mensajeError", "Se ha cancelado el registro");
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
