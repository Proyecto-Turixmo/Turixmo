
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList"%>
<%@page import="vo.DocumentTypeVO"%>
<%@page import="util.Util"%>
<%@page import="vo.UserVO" %>
<%@page import="vo.RoleVO"%>


<%
   ArrayList<DocumentTypeVO> documentsTypesVO = (ArrayList<DocumentTypeVO>)request.getAttribute("documentstypes");
   ArrayList<RoleVO> rolesVO = (ArrayList<RoleVO>)request.getAttribute("roles");
     
UserVO user = (UserVO)request.getAttribute("user");
       user = (user != null) ? user : new UserVO();
       user.setGenero(Util.nullToSpace(user.getGenero()));
       
       
%>
<%@include file="../../template/header.jsp" %>
<%@include file="../../template/navbar.jsp" %>



  <div class="content-wrapper">
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <!--<h1>Registrar Usuario</h1>-->
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Casa</a></li>
              <li class="breadcrumb-item active">Actualizar usuario</li>
            </ol>
          </div>
        </div>
      </div>
    </section>

    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-md-12">
            <div class="card card-default">
              <div class="card-header">
                <h3 class="card-title">Registra tu usuario </small></h3>
              </div>
              <form action="<%=(user.getIdusuario() != "") ? "UserUpdate": "UserCreate"%>" method="post" enctype="multipart/form-data">
                   <% if(user.getIdusuario() != ""){%>
                   <input type="hidden" name="id" value="<%=user.getIdusuario()%>">
                   <%}%>
                <div class="card-body">
                    <%@include file="../../template/showMessage.jsp" %>
                  <div class="form-group">
                    <label for="tipoDocumento">Tipo documento <span class="text-danger h5">*</span></label>
                    <select name="tipoDocumento" class="form-control" id="tipo-documento">
                        <option  selected>-- Selecciona un tipo --</option>
                        <% for(DocumentTypeVO documentTypeVO : documentsTypesVO){%>
                        <option 
                            <%=(user.getIdtipodocumento().equalsIgnoreCase(documentTypeVO.getId()))?"selected": ""%> 
                            value="<%=documentTypeVO.getId()%>">
                            <%=documentTypeVO.getName()%>
                        </option>
                    <%}%>
                    </select>
                    
                  </div>
                    <div class="form-group">
                    <label for="numeroDocumento">Numero de documento <span class="text-danger h5">*</span></label>
                    <input type="text" <%=(user.getIdusuario() != "") ? "readonly": "name='numeroDocumento'"%>  value="<%=user.getNumerodocumento()%>" class="form-control" id="numeroDocumento" placeholder="Ingresa el numero de tu documento">
                  </div>
                    <div class="form-group">
                    <label for="rol">Rol <span class="text-danger h5">*</span></label>
                    <select name="rol" class="form-control" id="rol">
                        <option  >-- Selecciona un rol --</option>
                  <% for(RoleVO roleVO :rolesVO){%>
                        <option  
                        <%=(user.getIdrol().equalsIgnoreCase(roleVO.getId())) ? "selected" : ""%> 
                        value="<%=roleVO.getId()%>">
                        <%=roleVO.getName()%>    
                        </option>
                    <%}%>
                    </select>
                  </div>

                    <div class="form-group">
                    <label for="nombre">Nombres <span class="text-danger h5">*</span> </label>
                    <input type="text" name="nombre" class="form-control" value="<%=user.getNombre()%>" id="nombre" placeholder="Ingresa tu nombre">
                  </div>                    
                  <div class="form-group">
                    <label for="apellido">Apellidos <span class="text-danger h5">*</span></label>
                    <input type="text" name="apellido" class="form-control" value="<%=user.getApellido()%>" id="apellido" placeholder="Ingresa tus apellidos">
                  </div>
                    <div class="form-group">
                    <label for="correo">Correo Electronico <span class="text-danger h5">*</span></label>
                    <input type="email" name="correo" class="form-control" value="<%=user.getCorreo()%>" id="exampleInputEmail1" placeholder="Ingresa tu correo">
                  </div>
                    <% if(user.getIdusuario().equals("")){%>
                    <div class="form-group">
                    <label for="contrasena">Contraseña <span class="text-danger h5">*</span></label>
                    <input type="password" name="contrasena" class="form-control" id="contrasena" placeholder="*********">
                  </div>
                    <% } %>
                    <div class="form-group">
                    <label for="celular">Celular <span class="text-danger h5">*</span></label>
                    <input type="text" name="celular" class="form-control" value="<%=user.getCelular()%>" id="exampleInputEmail1" placeholder="Ingresa un numero de contacto">
                  </div>
                    <div class="form-group">
                    <label for="imagen">Imagen </label>
                    <input type="file" name="imagen" class="form-control" id="imagen">
                  </div>
                    <div class="form-group">
                    <label for="fecha-nacimiento">Nacimiento </label>
                    <input type="date" name="fecha-nacimiento" class="form-control" value="<%=user.getFechanacimiento()%>" id="fecha-nacimiento" placeholder="Enter email">
                  </div>
                  <div class="form-group">
                  <label for="fecha-nacimiento">Sexo (opcional)</label>
                  <div class="form-control">
                  <div class="form-check form-check-inline">
                    <input class="form-check-input" name="genero"  type="radio" id="man" value="0" <%=(user.getGenero().equals("0")) ? "checked": ""%>>
                    <label class="form-check-label" for="man">Hombre</label>
                  </div>
                  <div class="form-check form-check-inline">
                    <input class="form-check-input" name="genero"  type="radio" id="woman" value="1" <%=(user.getGenero().equals("1")) ? "checked": ""%>>
                    <label class="form-check-label" for="woman">Mujer</label>
                  </div>
                  <div class="form-check form-check-inline">
                    <input class="form-check-input" name="genero"  type="radio" id="unknouw" value="" <%=(user.getGenero().equals("")) ? "checked": ""%>>
                    <label class="form-check-label"  for="unknouw">Infedinido</label>
                  </div>    
                  </div>
                  </div>
                  </div>
                <div class="card-footer">
                  <button type="submit" class="btn btn-<%=(user.getIdusuario() != "") ? "success": "primary"%> btn-block"><%=(user.getIdusuario() != "") ? "Actualizar!": "Registrarme!"%></button>
                </div>
              </form>
            </div>
            </div>
          <div class="col-md-6">
          </div>
        </div>
      </div>
    </section>
  </div>

<%@include file="../../template/slidebar.jsp" %>
<%@include file="../../template/footer.jsp" %>