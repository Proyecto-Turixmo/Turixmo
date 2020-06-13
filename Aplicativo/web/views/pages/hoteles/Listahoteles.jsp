<%-- 
    Document   : Listahoteles
    Created on : 13/06/2020, 05:22:03 PM
    Author     : Neira Castillo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="../../template/header.jsp" %>
<%@include file="../../template/navbar.jsp" %>
<%@include file="../../template/slidebar.jsp" %>

<%@page import="java.util.ArrayList" %>
<%@page import="models.dao.HotelesModel" %>
<%@page import="models.vo.Hoteles" %>





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
                        <li class="breadcrumb-item"><a href="#">Home </a></li>
                        <li class="breadcrumb-item active">Regitro Hoteles</li>
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
                            <h3 class="card-title">Lista de Hoteles</h3>
                        </div>
                        <!-- /.card-header -->
                        <div class="card-body">
                            <table id="example1" class="table table-bordered table-striped">
                                <thead>
                                    <tr>
                                        <th>Usuario encargado</th>
                                        <th>Ciudad</th>
                                        <th>Nombre</th>
                                        <th>Direccion</th>
                                        <th>Ubicacion</th>
                                        <th>Telefono</th>
                                        <th>Celular</th>
                                        <th>Correo</th>
                                        <th>Sitio Web</th>
                                        <th>Descripcion</th>
                                        <th>Fecha de creacion</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        Hoteles hotelesData = new Hoteles();
                                        HotelesModel hoteles = new HotelesModel();
                                        ArrayList<Hoteles> hoteles = hoteles.getAllHoteles();

                                        for (int i = 0; i < hoteles.size(); i++) {
                                            hotelesData = hoteles.get(i);
                                    %>
                                    </tr>
                                <td><%= hotelesData.getIdusuario()%></td>
                                
                               
                                <td><%= hotelesData.getIdciudad()%></td>
                                <td><%= hotelesData.getNombre()%></td>
                                <td><%= hotelesData.getDireccion()%></td>
                                <td><%= hotelesData.getUbicacion()%></td>
                                <td><%= hotelesData.getTelefono()%></td>
                                <td><%= hotelesData.getCelular()%></td>
                                <td><%= hotelesData.getCorreo()%></td>
                                <td><%= hotelesData.getSitioweb()%></td>
                                <td><%= hotelesData.getDescripcion()%></td>
                                <td><%= hotelesData.getFechacreacion()%></td>
                                
                               
                                <td >
                                    <div class="d-flex align-content-center">
                                        <a href="user?action=getbyid&id=<%=hotelesData.getIdusuario()%>" class="btn btn-default" ><i class="fas fa-edit"></i></a>
                                        <form action="user" method="post">
                                            <input type="hidden" name="action" value="delete">
                                            <input type="hidden" name="idusuario" value="<%=hotelesData.getIdusuario()%>">
                                           <button type="submit" class="btn btn-default ml-1" onclick="return confirm('Esta seguro de eliminar este registro?');" ><i class="fas fa-trash"></i></button>
                                        </form>
                                    </div>
                                </td>
                                </tr>
                                <% }%>
                                </tbody>
                                <tfoot>
                                    <tr>
                                       <th>Usuario encargado</th>
                                        <th>Ciudad</th>
                                        <th>Nombre</th>
                                        <th>Direccion</th>
                                        <th>Ubicacion</th>
                                        <th>Telefono</th>
                                        <th>Celular</th>
                                        <th>Correo</th>
                                        <th>Sitio Web</th>
                                        <th>Descripcion</th>
                                        <th>Fecha de creacion</th>
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








