<%@page import="util.Util"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../template/header.jsp" %>
<%@include file="../../template/navbar.jsp" %>
<%@page import="vo.HotelVO" %>

<% HotelVO hotel = (HotelVO)request.getAttribute("hotel");
      hotel = (hotel != null) ? hotel : new HotelVO();
%>


  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <!--<h1>Registrar Usuario</h1>-->
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Casa</a></li>
              <li class="breadcrumb-item active">Crear Hotel</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <!-- left column -->
          <div class="col-md-12">
            <!-- jquery validation -->
            <div class="card card-default">
              <div class="card-header">
                <h3 class="card-title">Registra tu usuario</small></h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form action="<%=(hotel.getIdusuario() != "") ? "HotelUpdate": "HotelCreate"%>" method="post">
                  <input type="hidden" name="id" value="<%=hotel.getIdusuario()%>"> 
                  <% if(hotel.getIdusuario() != ""){%>
                   <input type="hidden" name="id" value="<%=hotel.getIdusuario()%>">
                   <%}%>
                <div class="card-body">
                    <%@include file="../../template/showMessage.jsp" %>
               
                    <div class="form-group">
                    <label for="nombre">Nombre</label>
                    <input type="text" name="nombre" class="form-control" value="<%=hotel.getNombre()%>" id="nombre" placeholder="Ingresa el nombre">
                  </div>                    
                  <div class="form-group">
                    <label for="apellido">Direccion</label>
                    <input type="text" name="direccion" class="form-control" value="<%=hotel.getDireccion()%>" id="apellido" placeholder="Ingresa la direccion">
                  </div>
                   <div class="form-group">
                    <label for="correo">No Telefono (opcional)</label>
                    <input type="text" name="telefono" class="form-control" value="<%=hotel.getTelefono()%>" id="exampleInputEmail1" placeholder="Ingresa el telefono corporativo">
                  </div>
                    <div class="form-group">
                    <label for="correo">No Celular</label>
                    <input type="text" name="celular" class="form-control" value="<%=hotel.getCelular()%>" id="exampleInputEmail1" placeholder="IIngresa el celular corporativo">
                  </div>
                    <div class="form-group">
                    <label for="correo">Correo Electronico</label>
                    <input type="email" name="correo" class="form-control" value="<%=hotel.getCorreo()%>" id="exampleInputEmail1" placeholder="Ingresa el correo corporativo">
                  </div>
                    <div class="form-group">
                    <label for="celular">Sitio web (Opcional)</label>
                    <input type="text" name="sitioWeb" class="form-control" value="<%=hotel.getSitioweb()%>" id="exampleInputEmail1" placeholder="Ingresa el sitio web del hotel">
                  </div>
                    <div class="form-group">
                        <label for="celular">Descripcion de tu hotel</label>
                        <textarea class="form-control" rows="4" name="descripcion" placeholder="Breve descripcion de por que el turita te escojeria.."><%=hotel.getDescripcion()%></textarea>
                  </div>
                  </div>
                <!-- /.card-body -->
                <div class="card-footer">
                  <button type="submit" class="btn btn-<%=(hotel.getIdusuario() != "") ? "success": "primary"%> btn-block"><%=(hotel.getIdusuario() != "") ? "Actualizar!": "Registrarme!"%></button>
                </div>
              </form>
            </div>
            <!-- /.card -->
            </div>
          <!--/.col (left) -->
          <!-- right column -->
          <div class="col-md-6">

          </div>
          <!--/.col (right) -->
        </div>
        <!-- /.row -->
      </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>

<%@include file="../../template/slidebar.jsp" %>
<%@include file="../../template/footer.jsp" %>