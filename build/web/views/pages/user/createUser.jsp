

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../template/header.jsp" %>
<%@include file="../../template/navbar.jsp" %>


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
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Regitro usuario</li>
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
              <form id="quickForm" method="post">
                  <input type="hidden" name="action" value="save">
                <div class="card-body">
                    <%@include file="../../template/showMessage.jsp" %>
                  <div class="form-group">
                    <label for="tipo-documneto">Tipo documento</label>
                    <select name="tipo-documento" class="form-control" id="tipo-documento">
                        <option  selected>-- Selecciona un tipo --</option>
                        <option value="1">CC</option>
                        <option value="2">CE</option>
                    </select>
                  </div>
                    <div class="form-group">
                    <label for="numero-documento">Numero de documento</label>
                    <input type="text" name="numero-documento" class="form-control" id="numero-documento" placeholder="Ingresa el numero de tu documento">
                  </div>
                    <div class="form-group">
                    <label for="rol">Rol</label>
                    <select name="rol" class="form-control" id="rol">
                        <option  selected>-- Selecciona un rol --</option>
                        <option value="1">Propietario</option>
                        <option value="2">Turista</option>
                        <option value="3">Administrador</option>
                    </select>
                  </div>
                    <div class="form-group">
                    <label for="nombre">Nombre</label>
                    <input type="text" name="nombre" class="form-control" id="nombre" placeholder="Ingresa tu nombre">
                  </div>                    
                  <div class="form-group">
                    <label for="apellido">Apellidos</label>
                    <input type="text" name="apellido" class="form-control" id="apellido" placeholder="Ingresa tus apellidos">
                  </div>
                    <div class="form-group">
                    <label for="correo">Correo Electronico</label>
                    <input type="email" name="correo" class="form-control" id="exampleInputEmail1" placeholder="Ingresa tu correo">
                  </div>
                    <div class="form-group">
                    <label for="contrasena">Contraseña</label>
                    <input type="password" name="contrasena" class="form-control" id="contrasena" placeholder="Ingresa una contraseña">
                  </div>
                    <div class="form-group">
                    <label for="celular">Celular</label>
                    <input type="text" name="celular" class="form-control" id="exampleInputEmail1" placeholder="Ingresa un numero de contacto">
                  </div>
<!--                    <div class="form-group">
                    <label for="imagen">Imagen (opcional)</label>
                    <input type="file" name="imagen" class="form-control" id="imagen">
                  </div>-->
                    <div class="form-group">
                    <label for="fecha-nacimiento">Nacimiento (opcional)</label>
                    <input type="date" name="fecha-nacimiento" class="form-control" id="fecha-nacimiento" placeholder="Enter email">
                  </div>
<!--                  <div class="form-group mb-0">
                    <div class="custom-control custom-checkbox">
                      <input type="checkbox" name="terms" class="custom-control-input" id="exampleCheck1">
                      <label class="custom-control-label" for="exampleCheck1">I agree to the <a href="#">terms of service</a>.</label>
                    </div>
                  </div>-->
                </div>
                <!-- /.card-body -->
                <div class="card-footer">
                  <button type="submit" class="btn btn-primary btn-block">Registarme!</button>
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
