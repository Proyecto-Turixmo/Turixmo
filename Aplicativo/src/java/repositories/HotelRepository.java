

package repositories;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.HotelModel;
import util.Session;
import util.Util;
import vo.HotelVO;


public class HotelRepository {
    
  private String message = null, type = null;
  
  public void create(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        Date fecha = new Date();
        DateFormat formateador = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        HotelModel hotel = new HotelModel();
        HotelVO hotelVO = new HotelVO();
        hotelVO.setIdusuario(Session.get(request).getIdusuario());
        hotelVO.setNombre(request.getParameter("nombre"));
        hotelVO.setDireccion(request.getParameter("direccion"));
        hotelVO.setTelefono(request.getParameter("telefono"));
        hotelVO.setCelular(request.getParameter("celular"));
        hotelVO.setCorreo(request.getParameter("correo"));
        hotelVO.setSitioweb(Util.nullToSpace(request.getParameter("sitioWeb")));
        hotelVO.setDescripcion(Util.nullToSpace(request.getParameter("descripcion")));
        hotelVO.setFecharegistro(formateador.format(fecha));
        hotelVO.setInhabilitado("0");

        if (hotel.create(hotelVO)) {

            this.type = "success";
            this.message = "El Hotel se ha registrado correctamente";
        } else {
            this.type = "danger";
            this.message = "Lo sentimos el Hotel no se pudo registrar";
        }
        request.setAttribute("message", this.message);
        request.setAttribute("type", this.type);
        request.getRequestDispatcher("views/pages/hotel/add.jsp").forward(request, response);
           
        }
        
            
    public void edit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idhotel = Integer.parseInt(request.getParameter("id"));
        HotelModel hotel = new HotelModel();
        request.setAttribute("hotel", hotel.edit(idhotel,Integer.parseInt(Session.get(request).getIdusuario())));
        request.getRequestDispatcher("views/pages/hotel/add.jsp").forward(request, response);

    }
      
   public void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HotelModel hotel = new HotelModel();
        HotelVO hotelVO = new HotelVO();
        hotelVO.setIdhotel(request.getParameter("id"));
        hotelVO.setIdusuario(Session.get(request).getIdusuario());
        hotelVO.setNombre(request.getParameter("nombre"));
        hotelVO.setDireccion(request.getParameter("direccion"));
        hotelVO.setTelefono(request.getParameter("telefono"));
        hotelVO.setCelular(request.getParameter("celular"));
        hotelVO.setCorreo(request.getParameter("correo"));
        hotelVO.setSitioweb(Util.nullToSpace(request.getParameter("sitioWeb")));
        hotelVO.setDescripcion(Util.nullToSpace(request.getParameter("descripcion")));

        if (hotel.update(hotelVO)) {

            this.type = "success";
            this.message = "El Hotel se ha actualizado correctamente";
        } else {
            this.type = "danger";
            this.message = "Lo sentimos el Hotel no se pudo actualizar";
        }
        request.setAttribute("message", this.message);
        request.setAttribute("type", this.type);
        request.getRequestDispatcher("views/pages/hotel/list.jsp").forward(request, response);
           
        }

      public void disable(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idhotel = Integer.parseInt(request.getParameter("id"));
        HotelModel hotel = new HotelModel();

        if (hotel.disable(idhotel,Integer.parseInt(Session.get(request).getIdusuario()))) {
            type = "info";
            message = "El Hotel se ha eliminado correctamente";
        } else {
            type = "danger";
            message = "Lo sentimos el Hotel no se puedo eliminar";
        }
        request.setAttribute("message", message);
        request.setAttribute("type", type);
        request.getRequestDispatcher("views/pages/hotel/list.jsp").forward(request, response);
    }

}
