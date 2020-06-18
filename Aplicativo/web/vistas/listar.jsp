
<%@page import="java.util.Iterator"%>
<%@page import="vo.Hotel"%>
<%@page import="java.util.List"%>
<%@page import="dao.HotelDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Turixmo tu mejor opcion</title>
    </head>
    <body>
        <div class="container">
            <h1>Hoteles</h1>
            
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID hotel</th>
                        <th class="text-center">Usuario encargado</th>
                        <th class="text-center">Ciudad</th>
                        <th class="text-center">Estrellas</th>
                       
                        
                         <th class="text-center">Nombre</th>
                        
                        <th class="text-center">Direccion</th>
                        <th class="text-center">Telefono</th>
                        <th class="text-center">Celular</th>
                        <th class="text-center">Correo</th>
                        <th class="text-center">Sitioweb</th>
                        <th class="text-center">Descripcion</th>
                        <th class="text-center">Fecharegistro</th>
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    HotelDAO dao=new HotelDAO();
                    List<Hotel>list=dao.listar();
                    Iterator<Hotel>iter=list.iterator();
                    Hotel hot=null;
                    while(iter.hasNext()){
                        hot=iter.next();
                    
                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= hot.getIdhotel()%></td>
                         <td class="text-center"><%= hot.getIdusuario()%></td>
                          <td class="text-center"><%= hot.getIdciudad()%></td>
                          <td class="text-center"><%= hot.getEstrella()%></td>
                          
                         
                        <td class="text-center"><%= hot.getNombre()%></td>
                        <td><%= hot.getDireccion()%></td>
                        <td class="text-center"><%= hot.getTelefono()%></td>
                        <td class="text-center"><%= hot.getCelular()%></td>
                        <td class="text-center"><%= hot.getCorreo()%></td>
                        <td class="text-center"><%= hot.getSitioweb()%></td>
                        <td class="text-center"><%= hot.getDescripcion()%></td>
                        <td class="text-center"><%= hot.getFecharegistro()%></td>
                        <td class="text-center">
                            <a class="btn btn-warning"  href="Controlador?accion=editar&id=<%= hot.getIdhotel()%>">Editar</a>
                            <a class="btn btn-danger" href="Controlador?accion=eliminar&idhotel=<%= hot.getIdhotel()%>">Remove</a>
                            
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
<a class="btn btn-success" href="Controlador?accion=add">Agregar Nuevo</a>
        </div>
    </body>
</html>
