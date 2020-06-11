
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="../../template/header.jsp" %>
<%@include file="../../template/navbar.jsp" %>
<%@include file="../../template/slidebar.jsp" %>

<%@page import="java.util.ArrayList" %>
<%@page import="models.dao.UserModel" %>
<%@page import="models.vo.User" %>



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
                <div class="col-12">
                    <%@include file="../../template/showMessage.jsp" %>
                    <div class="card">
                        <div class="card-header">
                            <h3 class="card-title">Listado de usuarios</h3>
                        </div>
                        <!-- /.card-header -->
                        <div class="card-body">
                            <table id="example1" class="table table-bordered table-striped">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Numero Doc</th>
                                        <th>Rol</th>
                                        <th>Nombre completo</th>
                                        <th>Correo</th>
                                        <th>Celular</th>
                                        <th>Imagen</th>
                                        <th>Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        User userData = new User();
                                        UserModel user = new UserModel();
                                        ArrayList<User> users = user.getAllUsers();

                                        for (int i = 0; i < users.size(); i++) {
                                            userData = users.get(i);
                                    %>
                                    </tr>
                                <td><%= userData.getIdusuario()%></td>
                                <td><%= userData.getNumerodocumento()%></td>
                                <td><%= userData.getIdrol() == "1" ? "Admin" : userData.getIdrol() == "2" ? "Turista" : "Propietario"%></td>
                                <td><%= userData.getNombre() + " " + userData.getApellido()%></td>
                                <td><%= userData.getCorreo()%></td>
                                <td><%= userData.getCelular()%></td>
                                <td><img src="<%= userData.getImagen() == "" ? "" : "./libs/dist/img/avatar5.png"%>" class="img-circle img-size-50"></td>
                                <td >
                                    <div class="d-flex align-content-center">
                                        <a href="user?action=getById&id=<%=userData.getIdusuario()%>" class="btn btn-default" ><i class="fas fa-edit"></i></a>
                                        <form action="user" method="post">
                                            <input type="hidden" name="action" value="delete">
                                            <input type="hidden" name="idusuario" value="<%=userData.getIdusuario()%>">
                                           <button type="submit" class="btn btn-default ml-1" onclick="return confirm('Esta seguro de eliminar este registro?');" ><i class="fas fa-trash"></i></button>
                                        </form>
                                    </div>
                                </td>
                                </tr>
                                <% }%>
                                </tbody>
                                <tfoot>
                                    <tr>
                                        <th>#</th>
                                        <th>Numero Doc</th>
                                        <th>Rol</th>
                                        <th>Nombre completo</th>
                                        <th>Correo</th>
                                        <th>Celular</th>
                                        <th>Imagen</th>
                                        <th>Acciones</th>
                                    </tr>
                                </tfoot>
                            </table>
                        </div>
                        <!-- /.card-body -->
                    </div>
                    <!-- /.card -->
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container-fluid -->
    </section>
    <!-- /.content -->
</div>
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

<%@include file="../../template/footer.jsp" %>








