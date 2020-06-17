package org.apache.jsp.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

public final class listahoteles_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Lista Hoteles</title>\r\n");
      out.write("        <link href=\"../assets/css/estilos.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <h1>Lista hoteles</h1>\r\n");
      out.write("        <table>\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("            <tr>\r\n");
      out.write("            <th>Usuario encargado</th>\r\n");
      out.write("            <th>Ciudad</th>\r\n");
      out.write("            <th>Nombre</th>\r\n");
      out.write("            <th>Direccion</th>\r\n");
      out.write("            <th>Ubicacion</th>\r\n");
      out.write("            <th>Telefono</th>\r\n");
      out.write("            <th>Celular</th>\r\n");
      out.write("            <th>Correo</th>\r\n");
      out.write("            <th>Sitio Web<th>\r\n");
      out.write("            <th>Descripcion</th>\r\n");
      out.write("            <th>Fecha creacion</th>\r\n");
      out.write("            </tr>\r\n");
      out.write("            ");

            Connection cnx=null;
            Statement sta=null;
            ResultSet rs=null;
            try{
            
            Class.forName("com.mysql.jdbc.Driver");
            cnx=DriverManager.getConnection("jdbc:mysql://localhost/proyecto_turixmo?user=root&password=");
            
            
            sta=cnx.createStatement();
            rs=sta.executeQuery("select*from hotel");
            while(rs.next()){
            
                
      out.write("\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <th>");
      out.print(rs.getString(1));
      out.write("</th>\r\n");
      out.write("                    <th>");
      out.print(rs.getString(2));
      out.write("</th>\r\n");
      out.write("                    <th>");
      out.print(rs.getString(3));
      out.write("</th>\r\n");
      out.write("                    <th>");
      out.print(rs.getString(4));
      out.write("</th>\r\n");
      out.write("                    <th>");
      out.print(rs.getString(5));
      out.write("</th>\r\n");
      out.write("                    <th>");
      out.print(rs.getString(6));
      out.write("</th>\r\n");
      out.write("                    <th>");
      out.print(rs.getString(7));
      out.write("</th>\r\n");
      out.write("                    <th>");
      out.print(rs.getString(8));
      out.write("</th>\r\n");
      out.write("                    <th>");
      out.print(rs.getString(9));
      out.write("</th>\r\n");
      out.write("                    <th>");
      out.print(rs.getString(10));
      out.write("</th>\r\n");
      out.write("                    <th>");
      out.print(rs.getString(11));
      out.write("</th>\r\n");
      out.write("                    \r\n");
      out.write("                </tr>\r\n");
      out.write("                ");

            }
            sta.close();
rs.close();
cnx.close();
            }catch(Exception e){}
            
      out.write("    \r\n");
      out.write("        </table>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
