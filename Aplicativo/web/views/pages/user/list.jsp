
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="../../template/header.jsp" %>
<%@include file="../../template/navbar.jsp" %>
<%@include file="../../template/slidebar.jsp" %>

<%@page import="java.util.ArrayList" %>
<%@page import="dto.UserDTO"%>

<%
    ArrayList<UserDTO> usersDTO = (ArrayList<UserDTO>) request.getAttribute("users");
    UserDTO userDTO = new UserDTO();
%>




<div class="content-wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6"></div>
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a href="#">Home</a></li>
                        <li class="breadcrumb-item active">Regitro usuario</li>
                    </ol>
                </div>
            </div>
        </div>
    </section>

  
    <section class="content">
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <%@include file="../../template/showMessage.jsp" %>
                    <div class="card">
                        <div class="card-header">
                            <h3 class="card-title">Listado de usuarios</h3>
                        </div>
      
                        <div class="card-body">
                            <table id="example1" class="table table-bordered table-striped">
                                <thead>
                                    <tr>
                                        <th>Tipo</th>
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
                                for (int i = 0; i < usersDTO.size(); i++) {
                                    userDTO = usersDTO.get(i);
                            %>
                                  </tr>
                                <td><%= userDTO.getDocument().getName()%></td>
                                <td><%= userDTO.getUser().getNumerodocumento()%></td>
                                <td><%= userDTO.getRole().getName()%></td>
                                <td><%= userDTO.getUser().getNombre() + " " + userDTO.getUser().getApellido()%></td>
                                <td><%= userDTO.getUser().getCorreo()%></td>
                                <td><%= userDTO.getUser().getCelular()%></td>
                                <td><img src="<%= userDTO.getUser().getImagen() == "" ? "" : "./libs/dist/img/avatar5.png"%>" class="img-circle img-size-50"></td>
                                <td>
                                    <div class="d-flex align-content-center">
                                        <a href="UserEdit?id=<%=userDTO.getUser().getIdusuario()%>" class="btn btn-default" ><i class="fas fa-edit"></i></a>
                                        <form action="UserDisable" method="post">
                                            <input type="hidden" name="id" value="<%=userDTO.getUser().getIdusuario()%>">
                                            <button type="submit" class="btn btn-default ml-1" onclick="return confirm('Esta seguro de eliminar este registro?');" ><i class="fas fa-trash"></i></button>
                                        </form>
                                    </div>
                                </td>
                                </tr>
                                <% }%>
                                </tbody>
                                <tfoot>
                                    <tr>
                                        <th>Tipo</th>
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
                    </div>                    
                </div>                
            </div>            
        </div>        
    </section>
</div>  

<%@include file="../../template/footer.jsp" %>








