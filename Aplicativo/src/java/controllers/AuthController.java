package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.UserModel;
import repositories.AuthRepository;
import util.Session;

@WebServlet(name = "AuthController",
        urlPatterns = {"/login", "/logina", "/forgotPassword", "/forgotPassword",
            "/addOwner", "/addTourist", "/validate", "/createUser"})

public class AuthController extends HttpServlet {

    private AuthRepository auth = null;
    public AuthController() {
        this.auth = new AuthRepository();
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
            case "/addOwner":
                request.setAttribute("role", 1);
                request.getRequestDispatcher("views/pages/user/addOwner.jsp").forward(request, response);
                break;
            case "/addTourist":
                request.setAttribute("role", 3);
                request.getRequestDispatcher("views/pages/user/addTourist.jsp").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("views/error404.jsp").forward(request, response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Session.validateOutside(request, response);
        switch (request.getServletPath()) {
            case "/validate":
                this.auth.doValidate(request, response);
                break;
            case "/createUser":
                this.auth.create(request, response);
                break;
            default:
                request.getRequestDispatcher("views/error404.jsp").forward(request, response);
        }

    }

}
