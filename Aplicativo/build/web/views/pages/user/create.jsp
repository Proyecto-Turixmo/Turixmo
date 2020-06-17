
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../template/header.jsp" %>
<%@include file="../../template/navbar.jsp" %>
<%@page import="vo.UserVO" %>

<% UserVO user = (UserVO)request.getAttribute("user");
       user = (user != null) ? user : new UserVO(); %>


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
              <li class="breadcrumb-item"><a href="#">Casa ${sesion}</a></li>
              <li class="breadcrumb-item active">Actualizar usuario</li>
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
              <form action="<%=(user.getIdusuario() != "") ? "UserUpdate": "UserCreate"%>" method="post">
                   <% if(user.getIdusuario() != ""){%>
                   <input type="hidden" name="id" value="<%=user.getIdusuario()%>">
                   <%}%>
                <div class="card-body">
                    <%@include file="../../template/showMessage.jsp" %>
                  <div class="form-group">
                    <label for="tipoDocumento">Tipo documento</label>
                    <select name="tipoDocumento" class="form-control" id="tipo-documento">
                        <option  selected>-- Selecciona un tipo --</option>
                        <option <%=(user.getIdtipodocumento().equalsIgnoreCase("1"))?"selected": ""%> value="1">Cédula de ciudadania</option>
                        <option <%=(user.getIdtipodocumento().equalsIgnoreCase("2"))?"selected": ""%> value="2">Cédula de extranjeria</option>
                    </select>
                  </div>
                    <div class="form-group">
                    <label for="numeroDocumento">Numero de documento</label>
                    <input type="text" <%=(user.getIdusuario() != "") ? "readonly": "name='numeroDocumento'"%>  value="<%=user.getNumerodocumento()%>" class="form-control" id="numeroDocumento" placeholder="Ingresa el numero de tu documento">
                  </div>
                    <div class="form-group">
                    <label for="rol">Rol</label>
                    <select name="rol" class="form-control" id="rol">
                        <option  >-- Selecciona un rol --</option>
                        <option <%=(user.getIdrol().equalsIgnoreCase("1"))?"selected": ""%> value="1">Propietario</option>
                        <option <%=(user.getIdrol().equalsIgnoreCase("2"))?"selected": ""%> value="2">Administrador</option>
                        <option <%=(user.getIdrol().equalsIgnoreCase("3"))?"selected": ""%> value="3">Turista</option>
                    </select>
                  </div>
                    <div class="form-group">
                    <label for="nombre">Nombre</label>
                    <input type="text" name="nombre" class="form-control" value="<%=user.getNombre()%>" id="nombre" placeholder="Ingresa tu nombre">
                  </div>                    
                  <div class="form-group">
                    <label for="apellido">Apellidos</label>
                    <input type="text" name="apellido" class="form-control" value="<%=user.getApellido()%>" id="apellido" placeholder="Ingresa tus apellidos">
                  </div>
                    <div class="form-group">
                    <label for="correo">Correo Electronico</label>
                    <input type="email" name="correo" class="form-control" value="<%=user.getCorreo()%>" id="exampleInputEmail1" placeholder="Ingresa tu correo">
                  </div>
                  <% if(user.getIdusuario() == ""){%>
                    <div class="form-group">
                    <label for="contrasena">Contraseña</label>
                    <input type="password" name="contrasena" class="form-control" id="contrasena" placeholder="*********">
                  </div>
                    <%}%>
                    <div class="form-group">
                    <label for="celular">Celular</label>
                    <input type="text" name="celular" class="form-control" value="<%=user.getCelular()%>" id="exampleInputEmail1" placeholder="Ingresa un numero de contacto">
                  </div>
<!--                    <div class="form-group">
                    <label for="imagen">Imagen (opcional)</label>
                    <input type="file" name="imagen" class="form-control" id="imagen">
                  </div>-->
                    <div class="form-group">
                    <label for="fecha-nacimiento">Nacimiento (opcional)</label>
                    <input type="date" name="fecha-nacimiento" class="form-control" value="<%=user.getFechanacimiento()%>" id="fecha-nacimiento" placeholder="Enter email">
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
                  <button type="submit" class="btn btn-<%=(user.getIdusuario() != "") ? "success": "primary"%> btn-block"><%=(user.getIdusuario() != "") ? "Actualizar!": "Registrarme!"%></button>
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
