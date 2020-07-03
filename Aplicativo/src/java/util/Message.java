/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Message {

    public static void set(HttpServletRequest request, String name, String value) throws ServletException, IOException {
        try {
            HttpSession session = (HttpSession) request.getSession(true);
            session.setAttribute(name, value);

        } catch (Exception e) {
            Logger.getLogger(Session.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static String get(HttpServletRequest request, String name) throws ServletException, IOException {
        String message = null;
        try {
            HttpSession session = (HttpSession) request.getSession();
            if (session.getAttribute(name) != null) {
                message = (String) session.getAttribute(name);

            }

        } catch (Exception e) {
            Logger.getLogger(Session.class.getName()).log(Level.SEVERE, null, e);
        }

        return message;
    }

    public static void destroy(HttpServletRequest request, String[] names) throws ServletException, IOException {
        try {
            HttpSession session = (HttpSession) request.getSession();
            for (String name : names) {
                if (session.getAttribute(name) != null) {
                    session.removeAttribute(name);
                }
            }

        } catch (Exception e) {
            Logger.getLogger(Session.class.getName()).log(Level.SEVERE, null, e);
        }

    }

}
