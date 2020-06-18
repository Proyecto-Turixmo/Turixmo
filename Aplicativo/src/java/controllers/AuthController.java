/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "AuthController", urlPatterns = {"/login", "/forgotPassword", "/forgotPassword", "/registerOwner", "/registerTourist",
    "/validate","/createUser"})
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
            case "/createUser":
                this.create(request, response);
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
            case "/registerOwner":
                request.setAttribute("role",1);
                request.getRequestDispatcher("views/pages/user/createOwner.jsp").forward(request, response);
                break;
           case "/registerTourist":
               request.setAttribute("role",3);
                request.getRequestDispatcher("views/pages/user/createTourist.jsp").forward(request, response);
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

    
        private void create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Date fecha = new Date();
        DateFormat formateador = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        UserModel user = new UserModel();
        UserVO userVO = new UserVO();

        userVO.setIdtipodocumento(request.getParameter("tipoDocumento"));
        userVO.setNumerodocumento(request.getParameter("numeroDocumento"));
        userVO.setIdpais("1");
        userVO.setIdrol(request.getParameter("rol"));
        userVO.setNombre(request.getParameter("nombre"));
        userVO.setApellido(request.getParameter("apellido"));
        userVO.setCorreo(request.getParameter("correo"));
        userVO.setContrasena(request.getParameter("contrasena"));
        userVO.setCelular(request.getParameter("celular"));
        userVO.setFechanacimiento(request.getParameter("fechaNacimiento") == null ? "" : request.getParameter("fechaNacimiento"));
        userVO.setFecharegistro(formateador.format(fecha));

        if (user.create(userVO)) {

            this.type = "success";
            this.message = "El usuario se ha registrado correctamente";
        } else {
            this.type = "danger";
            this.message = "Lo sentimos el usuario no se pudo registrar";
        }
        request.setAttribute("message", this.message);
        request.setAttribute("type", this.type);
        
        if(userVO.getIdrol().equals("1")){
           request.setAttribute("role",userVO.getIdrol());
           request.getRequestDispatcher("views/pages/user/createOwner.jsp").forward(request, response);
        }else{
           request.setAttribute("role",userVO.getIdrol());
           request.getRequestDispatcher("views/pages/user/createTourist.jsp").forward(request, response);
        }
        

    }


}
