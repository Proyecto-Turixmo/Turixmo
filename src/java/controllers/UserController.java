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
import models.dao.UserModel;
import models.vo.User;

/**
 *
 * @author andre
 */
@WebServlet(name = "UserController", urlPatterns = {"/user"})
public class UserController extends HttpServlet {

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
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "getAll":
                    request.getRequestDispatcher("views/pages/user/listUser.jsp").forward(request, response); 
                    
                    break;
                case "getById":
                    break;
                case "getByName":
                    break;
            }
         }else{
         
            request.getRequestDispatcher("views/pages/user/createUser.jsp").forward(request, response);   
                                
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

            switch (action) {
                case "save":
                    this.insertUser(request, response);
                    break;
                case "update":
                    break;
                case "delete":
                    this.deleteUser(request, response);
                    break;
                default:
                  
            }
    }

    

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idusuario = null;
        String idtipodocumento = request.getParameter("tipo-documento");
        String numerodocumento = request.getParameter("numero-documento");
        String idrol = request.getParameter("rol");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        String celular = request.getParameter("celular");
        String token = null;
        String imagen = null;
        String fechanacimiento = request.getParameter("fecha-nacimiento");
        String fechacreacion = "2020-06-10 01:40:50";

        User userData = new User(idusuario, idtipodocumento, numerodocumento, idrol, nombre,
                apellido, correo, contrasena, celular, token, imagen, fechanacimiento, fechacreacion);
        UserModel user = new UserModel(userData);
        String message = null, type = null;
        if (user.insertUser()) {
            type = "success";
            message = "El usuario se ha registrado correctamente";
        } else {
            type = "danger";
            message = "Lo sentimos el usuario no se puedo registrar";
        }
        request.setAttribute("message", message);
        request.setAttribute("type", type);
        request.getRequestDispatcher("views/pages/user/createUser.jsp").forward(request, response);
    }

        private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int iduser = Integer.parseInt(request.getParameter("idusuario"));
        UserModel user = new UserModel();
        String message = null, type = null;
        if (user.deleteUserById(iduser)) {
            type = "info";
            message = "El usuario se ha eliminado correctamente";
        } else {
            type = "danger";
            message = "Lo sentimos el usuario no se puedo eliminar";
        }
        request.setAttribute("message", message);
        request.setAttribute("type", type);
        request.getRequestDispatcher("views/pages/user/listUser.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
