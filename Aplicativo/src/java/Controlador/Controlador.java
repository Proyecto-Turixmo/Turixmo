
package Controlador;

import vo.HotelVO;
import dao.HotelDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Controlador extends HttpServlet {

    String listar="vistas/listar.jsp";
    String add="vistas/add.jsp";
    String edit="vistas/edit.jsp";
    HotelVO h=new HotelVO();
    HotelDAO dao=new HotelDAO();
    int idhotel;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso="";
        
        String action=request.getParameter("accion");
        if(action.equalsIgnoreCase("listar")){
            acceso=listar;            
        }else if(action.equalsIgnoreCase("add")){
            acceso=add;
        }
        else if(action.equalsIgnoreCase("Agregar")){
            
         
          
            String idusuario=request.getParameter("txtidusuario");
            String idciudad=request.getParameter("txtidciudad");
            String estrella=request.getParameter("txtestrella");
            
            
            String nombre=request.getParameter("txtnombre");
           
            
            
            String direccion=request.getParameter("txtdireccion");
            String telefono=request.getParameter("txttelefono");
            String celular=request.getParameter("txtcelular");
            String correo=request.getParameter("txtcorreo");
            String sitioweb=request.getParameter("txtsitioweb");
            String descripcion=request.getParameter("txtdescripcion");
            String fecharegistro=request.getParameter("txtfecharegistro");
            
            h.setIdusuario(idusuario);
            h.setIdciudad(idciudad);
            h.setEstrella(estrella);
         
            
            
            
            h.setNombre(nombre);
            h.setDireccion(direccion);
            h.setCelular(celular);
            h.setCorreo(correo);
            h.setSitioweb(sitioweb);
            h.setDescripcion(descripcion);
            h.setFecharegistro(fecharegistro);
            
            
            dao.add(h);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idhotel",request.getParameter("idhotel"));
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            idhotel=Integer.parseInt(request.getParameter("txtidhotel"));
            String nom=request.getParameter("txtnombre");
            String dir=request.getParameter("txtdireccion");
            h.setIdhotel(idhotel);
            h.setNombre(nom);
            h.setDireccion(dir);
            dao.edit(h);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            idhotel=Integer.parseInt(request.getParameter("idhotel"));
            h.setIdhotel(idhotel);
            dao.eliminar(idhotel);
            acceso=listar;
        }
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
