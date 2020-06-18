package util;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import vo.UserSessionVO;
import vo.UserVO;

public class Session {

    private static String redirectToSuccessOnwer = "views/pages/user/list.jsp";
    private static String redirectToSuccessTourist = "index.jsp";
    private static String redirectToError = "views/pages/auth/login.jsp";
    private static String name = "user";

    public static void validateHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            if (!check(request)) {
                request.setAttribute("type", "warning");
                request.setAttribute("message", "Parece que no has iniciado sesion!");
                request.getRequestDispatcher(redirectToError).forward(request, response);
            }
        } catch (Exception e) {
            Logger.getLogger(Session.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static void validateOutside(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            if (check(request)) {
                if(get(request).getIdrol().equals("1")){
                    request.getRequestDispatcher(redirectToSuccessOnwer).forward(request, response);
                }else{
                    request.getRequestDispatcher(redirectToSuccessTourist).forward(request, response);
                }
            }
        } catch (Exception e) {
            Logger.getLogger(Session.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static boolean add(HttpServletRequest request,UserVO user)
            throws ServletException, IOException {

        boolean estado = false;
        try {
            HttpSession session = (HttpSession) request.getSession(true);

            UserSessionVO usersession = new UserSessionVO();

            usersession.setIdusuario(user.getIdusuario());
            usersession.setIdrol(user.getIdrol());
            usersession.setNombre(user.getNombre());
            usersession.setApellido(user.getApellido());
            usersession.setCorreo(user.getCorreo());
            usersession.setImagen(Util.nullToSpace(user.getImagen()));

            if (session.getAttribute(name) == null) {
                session.setAttribute(name, usersession);
                estado = true;
            }
        } catch (Exception e) {
            Logger.getLogger(Session.class.getName()).log(Level.SEVERE, null, e);
        }
        return estado;
    }

    private static boolean check(HttpServletRequest request) throws ServletException, IOException {
        boolean estado = false;
        try {
            HttpSession session = (HttpSession) request.getSession();
            if (session.getAttribute(name) != null) {
                UserSessionVO miuser = (UserSessionVO) session.getAttribute(name);
                if (!miuser.getIdusuario().equals("")) {
                    estado = true;
                }

            }

        } catch (Exception e) {
            Logger.getLogger(Session.class.getName()).log(Level.SEVERE, null, e);
        }
        return estado;
    }

    
        public static UserSessionVO get(HttpServletRequest request) throws ServletException, IOException {
        UserSessionVO usersession = null;
        try {
            HttpSession session = (HttpSession) request.getSession();
            if (session.getAttribute(name) != null) {
                UserSessionVO miuser = (UserSessionVO) session.getAttribute(name);
                if (!miuser.getIdusuario().equals("")) {
                    usersession = miuser;
                }

            }

        } catch (Exception e) {
            Logger.getLogger(Session.class.getName()).log(Level.SEVERE, null, e);
        }
        return usersession;
    }
        
    public static boolean set(HttpServletRequest request,UserVO user)
            throws ServletException, IOException {

        boolean estado = false;
        try {
            
            HttpSession session = (HttpSession) request.getSession(true); //inicia el objeto de session
            UserSessionVO miuser = (UserSessionVO) session.getAttribute(name); // trae los datos del objeto eb especifico
            UserSessionVO usersession = new UserSessionVO(); //creo el objeto que reinsertare

            usersession.setIdusuario(miuser.getIdusuario());
            usersession.setIdrol(miuser.getIdrol());
            usersession.setNombre(user.getNombre());
            usersession.setApellido(user.getApellido());
            usersession.setCorreo(user.getCorreo());
            usersession.setImagen(Util.nullToSpace(user.getImagen()));

            if (session.getAttribute(name) != null) {
                session.setAttribute(name, usersession);
                estado = true;
            }
        } catch (Exception e) {
            Logger.getLogger(Session.class.getName()).log(Level.SEVERE, null, e);
        }
        return estado;
    }
    
    public static boolean drop(HttpServletRequest request) throws ServletException, IOException {
        boolean estado = false;
        try {
            HttpSession session = (HttpSession) request.getSession();
            session.invalidate();
            estado = true;
        } catch (Exception e) {
            Logger.getLogger(Session.class.getName()).log(Level.SEVERE, null, e);
        }
        return estado;
    }
}
