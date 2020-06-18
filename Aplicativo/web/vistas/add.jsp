<%-- 
    Document   : add
    Created on : 30-ago-2018, 19:58:16
    Author     : Joel
--%>

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
            <div class="col-lg-6">
                <h1>Registrar hoteles</h1>
                <form action="Controlador">
                    Usuario Encargado:<br>
                    <input class="form-control" type="text" name="txtidusuario"><br>
                    Ciudad:<br>
                    <input class="form-control" type="text" name="txtidciudad"><br>
                    Estrellas:<br>
                    <input class="form-control" type="text" name="txtestrella"><br>
                    
                    Nombre:<br>
                    <input class="form-control" type="text" name="txtnombre"><br>
                    Direccion: <br>
                    <input class="form-control" type="text" name="txtDireccion"><br>
                    Telefono:<br>
                    <input class="form-control" type="text" name="txtelefono"><br>
                    Celular:
                    <input class="form-control" type="text" name="txtcelular"><br>
                    Correo:
                    <input class="form-control" type="text" name="txtcorreo"><br>
                    Sitioweb:
                    <input class="form-control" type="text" name="txtsitioweb"><br>
                    Descripcion:
                    <input class="form-control" type="text" name="txtdescripcion"><br>
                    Fecharegistro:
                    <input class="form-control" type="date" name="txtfecharegistro"><br>
                    
                    
                    
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    <a href="Controlador?accion=listar">Regresar</a>
                </form>
            </div>

        </div>
    </body>
</html>
