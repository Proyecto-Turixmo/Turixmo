package repositories;

import dto.UserDTO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.UserModel;
import util.*;
import vo.UserVO;

public class UserRepository {
    
    public void add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserModel user = new UserModel();
        
        request.setAttribute("documentstypes",user.allDocumentsTypes());
        request.setAttribute("roles",user.allRoles());  
        request.getRequestDispatcher("views/pages/user/update.jsp").forward(request, response);

    }
    
    public void create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

  
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
        userVO.setFechanacimiento(Util.nullToSpace(request.getParameter("fechaNacimiento")));
        userVO.setFecharegistro(Util.getDateTime());
        userVO.setInhabilitado("0");

        if (user.create(userVO)) {
              Message.set(request,"type" , "success");
              Message.set(request,"message" , "El usuario se ha registrado correctamente");
        } else {
              Message.set(request,"type" , "danger");
              Message.set(request,"message" , "Lo sentimos el usuario no se pudo registrar");       
        }
        
        response.sendRedirect(Config.getURL_PROJECT()+"UserAdd");

    }

    public void get(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int iduser = Integer.parseInt(request.getParameter("id"));
        UserModel user = new UserModel();
        
        request.setAttribute("documentstypes",user.allDocumentsTypes());
        request.setAttribute("roles",user.allRoles());  
        request.setAttribute("user", user.getById(iduser));
        request.getRequestDispatcher("views/pages/user/update.jsp").forward(request, response);

    }
    
    
   public void all(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserModel user = new UserModel();
        request.setAttribute("users",user.all() );
        request.getRequestDispatcher("views/pages/user/list.jsp").forward(request, response);

    }

    public void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserModel user = new UserModel();
        UserVO userVO = new UserVO();

        userVO.setIdusuario(request.getParameter("id"));
        userVO.setIdtipodocumento(request.getParameter("tipoDocumento"));
        userVO.setIdpais("1");
        userVO.setIdrol(request.getParameter("rol"));
        userVO.setNombre(request.getParameter("nombre"));
        userVO.setApellido(request.getParameter("apellido"));
        userVO.setCorreo(request.getParameter("correo"));
        userVO.setCelular(request.getParameter("celular"));
        userVO.setGenero(request.getParameter("genero"));
        userVO.setFechanacimiento(Util.nullToSpace(request.getParameter("fechaNacimiento")));
        userVO.setFecharegistro(Util.getDateTime());
        userVO.setInhabilitado("0");

        if (user.updateById(userVO)) {
            if (Session.get(request).getIdusuario().equals(userVO.getIdusuario())) {
                Session.set(request, userVO);
            }
              Message.set(request,"type" , "success");
              Message.set(request,"message" , "El usuario se ha Actualizado correctamente");       

        } else {
            Message.set(request,"type" , "danger");
            Message.set(request,"message" , "Lo sentimos el usuario no se pudo actualizar");

        }

            response.sendRedirect(Config.getURL_PROJECT()+"UserGetall");

    }

    public void disable(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int iduser = Integer.parseInt(request.getParameter("id"));
        UserModel user = new UserModel();

        if (user.deleteById(iduser)) {
            Message.set(request,"type" , "info");
            Message.set(request,"message" , "El usuario se ha eliminado correctamente");
        } else {
             Message.set(request,"type" , "danger");
             Message.set(request,"message" , "Lo sentimos el usuario no se puedo eliminar");
        }
        
        response.sendRedirect(Config.getURL_PROJECT()+"UserGetall");
    }

    public void closeSession(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
          Session.drop(request);
            Message.set(request,"type" , "info");
            Message.set(request,"message" , "Sesion cerrada con exito");
            response.sendRedirect(Config.getURL_PROJECT()+"login");
    }

}
