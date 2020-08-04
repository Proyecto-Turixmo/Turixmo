 package controllers;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repositories.UserRepository;
import util.Session;

@WebServlet(name = "UserController",
        urlPatterns = {"/userAdd", "/userAll", "/userEdit", "/closeSession",
                       "/userCreate", "/userUpdate", "/userDisabled"})

public class UserController extends HttpServlet {

      private UserRepository  user = null;
    
    public UserController() {
         this.user = new UserRepository();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
     Session.validateHome(request, response);
 
        switch(request.getMethod()){
            case "GET":
                this.doGet(request, response);
            break;
            case "POST":
                this.doPost(request, response);
            break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        switch (request.getServletPath()) {
            case "/userAdd":
                this.user.add(request, response);
                break;
            case "/userAll":
                this.user.all(request, response);
                break;
            case "/userEdit":
                this.user.get(request, response);
                break;
            case "/closeSession":
                this.user.closeSession(request, response);
                break;
            default:
                request.getRequestDispatcher("views/error404.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        switch (request.getServletPath()) {
            case "/userCreate":
                this.user.create(request, response);
                break;
            case "/userUpdate":
                this.user.update(request, response);
                break;
            case "/userDisable":
                this.user.disable(request, response);
                break;
            default:
                request.getRequestDispatcher("views/error404.jsp").forward(request, response);
        }

    }


}
