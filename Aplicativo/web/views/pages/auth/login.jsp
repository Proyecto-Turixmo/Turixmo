<%@include file="../../template/header.jsp" %>

<%@include file="../../template/navbarMain.jsp" %>



<div class="container mt-0">
    <div class="row mt-4">
        <div class="col-md-3"></div>
        <div class="col-md-6 px-md-5">
            <div class="card card-primary card-outline shadow">
                <div class="card-body">
<!--                    <a class="small" href="user"><i class="fas fa-chevron-left"></i> &nbsp;Regresar</a>-->
                        <div class="w-100 d-flex">
                            <div class="align-content-center mx-auto">
                                <img src="assets/img/logo.jpg" class="img-size-50 mx-auto " style="width: 150px;height: 100px;"/>
                            </div>
                        </div>
                    <h5 class="text-center">Iniciar Sesion</h5>
                    <form class="card-text mt-4   " action="validate" method="post">
                        <%@include file="../../template/showMessage.jsp" %>
                        <div class="col-md-12 mb-3">
                            <label for="correo" class="small mb-0">Correo</label>
                            <input type="text" class="form-control" name="correo" id="correo" placeholder="ejemplo@gmail.com" required="on"/>
                        </div>
                        <div class="col-md-12 mb-3">
                            <label for="contrasena" class="small mb-0">Contraseña</label>
                            <input type="password" class="form-control" name="contrasena" id="contrasena" placeholder="********" required="on"/>
                        </div>
                        <div class="col-md-12 mb-3 d-flex">
                            <div class="custom-control custom-checkbox">
                                <input type="checkbox" name="checkbox"  class="form-check-input" id="check" >
                                <label class="form-check-label" for="check">Recordarme la contraseña</label>
                            </div>
                        </div>
                        <div class="text-center">
                            <div class="form-group">
                                <button type="submit" class="btn btn-primary btn-block">Iniciar Sesion</button>
                            </div>
                            <div class="form-group">
                                <a href="forgotPassword" class=" my-n1 ">¿Olvidaste tu contraseña?</a>
                            </div>
                            <div class="form-group  text-sm">
                                <span class="col-md-6 align-content-start">¿aún no tienes una cuenta? <a href="addTourist" class="">Registrarme!</a></span>
                            </div>                            <div class="form-group  text-sm">
                       
                            </div>
                            
                        </div>

                </div>
                </form>

            </div>
        </div>
    </div>
    <div class="col-md-3"></div>
</div> 

<%@include file="../../template/footerDefault.jsp" %></div>
</div>


