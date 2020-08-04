package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repositories.HotelRepository;
import util.Session;



@WebServlet(name = "/HotelController",
        urlPatterns = {"/hotelAdd", "/hotelAll", "/hotelEdit",
                       "/hotelCreate", "/hotelUpdate", "/hotelDisable"})
public class HotelController extends HttpServlet {

    private HotelRepository  hotel = null;
    
    public HotelController() {
         this.hotel = new HotelRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Session.validateHome(request, response);

        switch (request.getServletPath()) {
            case "/hotelAdd":
                request.getRequestDispatcher("views/pages/hotel/add.jsp").forward(request, response);
                break;
            case "/hotelAll":
                  request.getRequestDispatcher("views/pages/hotel/list.jsp").forward(request, response);
                break;
            case "/hotelEdit":
                this.hotel.edit(request, response);
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
            case "/hotelCreate":
                this.hotel.create(request, response);
                break;
            case "/hotelUpdate":
                this.hotel.update(request, response);
                break;
            case "/hotelDisable":
                this.hotel.disable(request, response);
                break;
            default:
                request.getRequestDispatcher("views/error404.jsp").forward(request, response);
        }

    }
    
}