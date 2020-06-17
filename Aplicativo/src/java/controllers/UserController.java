package controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.UserModel;
import vo.UserSessionVO;
import vo.UserVO;
import util.Session;

@WebServlet(name = "UserController",
        urlPatterns = {"/UserNew", "/UserGetall", "/UserGetbyid", "/mama",
            "/UserCreate", "/UserUpdate", "/UserDelete"})

public class UserController extends HttpServlet {

    public String message = null, type = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Session.validateHome(request, response);

        switch (request.getServletPath()) {
            case "/UserGetall":
                request.getRequestDispatcher("views/pages/user/list.jsp").forward(request, response);
                break;
            case "/UserNew":
                request.getRequestDispatcher("views/pages/user/create.jsp").forward(request, response);
                break;
            case "/UserGetbyid":
                this.getUserById(request, response);
                break;
            default:
                request.getRequestDispatcher("views/error404.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Session.validateHome(request, response);
        
        switch (request.getServletPath()) {
            case "/UserCreate":
                this.create(request, response);
                break;
            case "/UserUpdate":
                this.update(request, response);
                break;
            case "/UserDelete":
                this.delete(request, response);
                break;
            default:
                request.getRequestDispatcher("views/error404.jsp").forward(request, response);
        }

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
            this.message = "Lo sentimos el usuario no se puedo registrar";
        }
        request.setAttribute("message", this.message);
        request.setAttribute("type", this.type);
        request.getRequestDispatcher("views/pages/user/create.jsp").forward(request, response);

    }

    private void getUserById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int iduser = Integer.parseInt(request.getParameter("id"));
        UserModel user = new UserModel();
        request.setAttribute("user", user.getById(iduser));
        request.getRequestDispatcher("views/pages/user/create.jsp").forward(request, response);

    }

    private void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserModel user = new UserModel();
        UserVO userVO = new UserVO();
        userVO.setIdusuario(request.getParameter("id"));
        userVO.setIdtipodocumento(request.getParameter("tipoDocumento"));
        userVO.setIdrol(request.getParameter("rol"));
        userVO.setNombre(request.getParameter("nombre"));
        userVO.setApellido(request.getParameter("apellido"));
        userVO.setCorreo(request.getParameter("correo"));
        userVO.setCelular(request.getParameter("celular"));
        userVO.setFechanacimiento(request.getParameter("fechaNacimiento") == null ? "" : request.getParameter("fechaNacimiento"));

        if (user.updateById(userVO)) {
            type = "success";
            message = "El usuario se ha Actualizado correctamente";
        } else {
            type = "danger";
            message = "Lo sentimos el usuario no se pudo actualizar";
        }
        request.setAttribute("message", message);
        request.setAttribute("type", type);
        request.getRequestDispatcher("views/pages/user/list.jsp").forward(request, response);

    }

    private void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int iduser = Integer.parseInt(request.getParameter("id"));
        UserModel user = new UserModel();

        if (user.deleteById(iduser)) {
            type = "info";
            message = "El usuario se ha eliminado correctamente";
        } else {
            type = "danger";
            message = "Lo sentimos el usuario no se puedo eliminar";
        }
        request.setAttribute("message", message);
        request.setAttribute("type", type);
        request.getRequestDispatcher("views/pages/user/list.jsp").forward(request, response);
    }

}
