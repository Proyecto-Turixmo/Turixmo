<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>




<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Hoteles</title>
        <link href="../assets/css/estilos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Lista hoteles</h1>
        <table>
            
            
            <tr>
            <th>Usuario encargado</th>
            <th>Ciudad</th>
            <th>Nombre</th>
            <th>Direccion</th>
            <th>Ubicacion</th>
            <th>Telefono</th>
            <th>Celular</th>
            <th>Correo</th>
            <th>Sitio Web<th>
            <th>Descripcion</th>
            <th>Fecha creacion</th>
            </tr>
            <%
            Connection cnx=null;
            Statement sta=null;
            ResultSet rs=null;
            try{
            
            Class.forName("com.mysql.jdbc.Driver");
            cnx=DriverManager.getConnection("jdbc:mysql://localhost/proyecto_turixmo?user=root&password=");
            
            
            sta=cnx.createStatement();
            rs=sta.executeQuery("select*from hoteles");
            while(rs.next()){
            
                %>
                <tr>
                    <th><%=rs.getString(1)%></th>
                    <th><%=rs.getString(2)%></th>
                    <th><%=rs.getString(3)%></th>
                    <th><%=rs.getString(4)%></th>
                    <th><%=rs.getString(5)%></th>
                    <th><%=rs.getString(6)%></th>
                    <th><%=rs.getString(7)%></th>
                    <th><%=rs.getString(8)%></th>
                    <th><%=rs.getString(9)%></th>
                    <th><%=rs.getString(10)%></th>
                    <th><%=rs.getString(11)%></th>
                    
                </tr>
                <%
            }
            sta.close();
rs.close();
cnx.close();
            }catch(Exception e){}
            %>    
        </table>
    </body>
</html>
