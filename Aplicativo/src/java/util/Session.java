package util;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import vo.UserSessionVO;

public class Session {

    private static String redirectToSuccess = "views/pages/user/list.jsp";
    private static String redirectToError = "views/pages/auth/login.jsp";
    private static String name = "user";

    public static void validateHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            if (!check(request)) {
                request.getRequestDispatcher(redirectToError).forward(request, response);
            }
        } catch (Exception e) {
            Logger.getLogger(Session.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static void validateOutside(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            if (check(request)) {
                request.getRequestDispatcher(redirectToSuccess).forward(request, response);
            }
        } catch (Exception e) {
            Logger.getLogger(Session.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static boolean add(HttpServletRequest request, String idusuario, String idrol, String correo, String imagen)
            throws ServletException, IOException {

        boolean estado = false;
        try {
            HttpSession session = (HttpSession) request.getSession(true);

            UserSessionVO usersession = new UserSessionVO();

            usersession.setIdusuario(idusuario);
            usersession.setIdrol(idrol);
            usersession.setCorreo(correo);
            usersession.setImagen(imagen);

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
