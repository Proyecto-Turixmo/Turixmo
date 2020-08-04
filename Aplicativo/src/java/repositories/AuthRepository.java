

package repositories;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.UserModel;
import util.Config;
import util.Message;
import util.Session;
import util.Util;
import vo.UserVO;

public class AuthRepository {
    

    public AuthRepository() {
    }

    public void doValidate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ruta = "login";
        UserVO userVO = new UserVO();
        userVO.setCorreo(request.getParameter("correo"));
        userVO.setContrasena(request.getParameter("contrasena"));

        if (!userVO.getCorreo().equals("")) {
            if (!userVO.getContrasena().equals("")) {
                UserModel user = new UserModel();
                UserVO userResult = user.validate(userVO.getCorreo(),userVO.getContrasena());
                  if(userResult != null){
                      Session.add(request,userResult);
                      ruta = "user-all";
                  }else{
                     Message.set(request,"type" , "danger");
                     Message.set(request,"message" , "Usuario y/o contraseña Incorrectos.");
                  }
            } else {
                Message.set(request,"type" , "danger");
                Message.set(request,"message" , "Debes rellenar todos campos.");
            }
        }else{
                Message.set(request,"type" , "danger");
                Message.set(request,"message" , "Debes rellenar todos campos.");
        }
        response.sendRedirect(Config.getURL_PROJECT()+ruta);
    }

    
       public void create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String type = "";
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
        
        if(userVO.getIdrol().equals("1")){
           request.setAttribute("role",userVO.getIdrol());
           type = "views/pages/user/addOwner.jsp";
        }else{
           request.setAttribute("role",userVO.getIdrol());
           type = "views/pages/user/addTourist.jsp";
        }
        request.getRequestDispatcher(type).forward(request, response);
    }
}
