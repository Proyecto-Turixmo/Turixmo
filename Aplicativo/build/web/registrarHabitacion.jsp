<%-- 
    Document   : registrarHabitacion
    Created on : 18/06/2020, 11:37:51 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="assets/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Registrar Habitación</title>
    </head>
    <body>
        <h1>Registrar Habitacion</h1>
        <form method="post" action="Habitacion">
            Numero de Habitación:<br>
            <input type="text" name="idhabitacion" required="required" ><br>
            Tipo Habitación:<br>
            <select name="tipohabitacion" required="required">
                <option>Seleccione</option>
                <option>individual</option>
                <option>Doble</option>
                <option>Doble de uso individual</option>
                <option>Doble con camas individuales</option>
                <option>Triple</option>
                <option>Cuatruple</option>
                <option>Dormitorios</option>
            </select><br>
            Servicios De Habitación:<br>
            <ul name="serviciohabitacion">
                <li>Parqueadero</li>
                <li>Restaurante</li>
                <li>Piscina</li>
                <li>Piscina con tobogan</li>
                <li>Area de juegos</li>
                <li>Recibir commida</li>
                <li>Zona verde</li>
                <li>Limpieza a la habitación</li>
                <li>Otro</li>
            </ul><br>
            ID Hotel:<br>
            <input type="number" name="idhotel" ><br>
            Numero de la Habitación:<br>
            <input type="text" name="numerohabitacion" pattern="[A-Za-z]" ><br>
            Cantidad de Personas:<br>
            <input type="number" name="cantidadpersonas"><br>
            Precio:<br>
            <input type="number" name="precio"><br>
            Piso Numero:<br>
            <input type="text" name="numeropiso" pattern="[A-Za-z]"><br>
            Descripción:<br>
            <input type="text" name="descripcion" pattern="[A-Za-z]"><br>
            Disponibilidad:<br>
            <input type="number" name="disponibilidad"><br>
            Fecha:<br>
            <input type="date" name="fechacreacion"><br>
            <br>
            
            <button>Registrar</button>
            <input type="hidden" value="1" name="opcion">
            <button>Cancelar</button>
            <input type="hidden" value="2" name="opcion">
            
            
        </form>
        <div>
            <% if (request.getAttribute("mensajeError") != null) { %>
            ${mensajeError}
            <%} else {%>
            ${mensajeExito}
            <% }%>
        </div>
    </body>
</html>
