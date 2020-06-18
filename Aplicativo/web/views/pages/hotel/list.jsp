
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="../../template/header.jsp" %>
<%@include file="../../template/navbar.jsp" %>
<%@include file="../../template/slidebar.jsp" %>

<%@page import="java.util.ArrayList" %>
<%@page import="models.HotelModel" %>
<%@page import="vo.HotelVO" %>
<%
            HotelVO hotelVO = new HotelVO();
            HotelModel hotel = new HotelModel();
            ArrayList<HotelVO> hoteles = hotel.getAll(Integer.parseInt(Session.get(request).getIdusuario()));
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
                                        <th>Nombre</th>
                                        <th>Direccion</th>
                                        <th>Celular</th>
                                        <th>Correo</th>
                                        <th>Sitio web</th>
                                        <th>Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <%
                                    for (int i = 0; i < hoteles.size(); i++) {
                                        hotelVO = hoteles.get(i);
                                %>
                                    </tr>
                                <td><%= hotelVO.getNombre()%></td>
                                <td><%= hotelVO.getDireccion()%></td>
                                <td><%= hotelVO.getCelular()%></td>
                                <td><%= hotelVO.getCorreo()%></td>
                                <td><% out.print(!hotelVO.getSitioweb().equals("") ? "<a href="+ hotelVO.getSitioweb()+">Sitio</a>": ""); %></td>
                                <td >
                                    <div class="d-flex align-content-center">
                                        <a href="HotelEdit?id=<%=hotelVO.getIdhotel()%>" class="btn btn-default" ><i class="fas fa-edit"></i></a>
                                        <form action="HotelDisable" method="post">
                                            <input type="hidden" name="id" value="<%=hotelVO.getIdhotel()%>">
                                           <button type="submit" class="btn btn-default ml-1" onclick="return confirm('Esta seguro de eliminar este registro?');" ><i class="fas fa-trash"></i></button>
                                        </form>
                                    </div>
                                </td>
                                </tr>
                                <% }%>
                                </tbody>
                                <tfoot>
                                    <tr>
                                        <th>Nombre</th>
                                        <th>Direccion</th>
                                        <th>Celular</th>
                                        <th>Correo</th>
                                        <th>Sitio web</th>
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








