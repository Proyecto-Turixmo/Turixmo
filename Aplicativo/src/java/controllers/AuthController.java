/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.UserModel;
import util.Session;
import vo.UserVO;

/**
 *
 * @author andre
 */
@WebServlet(name = "AuthController", urlPatterns = {"/auth", "/login","/validate", "/forgotPassword", "/forgotPassword", "/register"})
public class AuthController extends HttpServlet {

    public String message = null, type = "danger";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Session.validateOutside(request, response);

        switch (request.getServletPath()) {
            case "/validate":
                this.doValidate(request, response);
                break;
            default:
                request.getRequestDispatcher("views/error404.jsp").forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Session.validateOutside(request, response);

        switch (request.getServletPath()) {
            case "/login":
                request.getRequestDispatcher("views/pages/auth/login.jsp").forward(request, response);
                break;
            case "/forgotPassword":
                request.getRequestDispatcher("views/pages/auth/forgotPassword.jsp").forward(request, response);
                break;
            case "/register":
                request.getRequestDispatcher("views/pages/auth/fortgotPassword.jsp").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("views/error404.jsp").forward(request, response);

        }

    }

    protected void doValidate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserVO userVO = new UserVO();
        userVO.setCorreo(request.getParameter("correo"));
        userVO.setContrasena(request.getParameter("contrasena"));

        if (!userVO.getCorreo().equals("")) {
            if (!userVO.getContrasena().equals("")) {
                UserModel user = new UserModel();
                UserVO userResult = user.validate(userVO.getCorreo(),userVO.getContrasena());
                  if(userResult != null){
                      Session.add(request,userResult.getIdusuario(),
                                          userResult.getIdrol(), 
                                          userResult.getCorreo(),
                                          userResult.getImagen());
                  Session.validateOutside(request, response);
                  }else{
                     this.message = "Usuario y/o contraseña Incorrectos.";
                  }
            } else {
                this.message = "Debes rellenar todos campos.";
            }
        }else{
        
                this.message = "Debes rellenar todos campos.";
        }
       request.setAttribute("type",this.type);
        request.setAttribute("message",this.message);
       request.getRequestDispatcher("views/pages/auth/login.jsp").forward(request, response);
    }


}
