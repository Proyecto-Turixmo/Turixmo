<%@include file="../../template/header.jsp" %>

<%@include file="../../template/navbarDefault.jsp" %>



<div class="container mt-5">
    <div class="row mt-4">
        <div class="col-md-3"></div>
        <div class="col-md-6 px-md-5">
            <div class="card card-primary card-outline">
                <div class="card-body">
                    <a class="small" href="user"><i class="fas fa-chevron-left"></i> &nbsp;Regresar</a>
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
                                <span class="col-md-6 align-content-start">Aun no tienes una cuenta? <a href="registerTourist" class="">Registrarme!</a></span>
                            </div>
                        </div>
<!--                 <hr class="py-0 pb-n2">
                 <span class="mt-0">Turixmo.com</span>-->
                </div>
                </form>

            </div>
        </div><!-- /.card -->
    </div>
    <div class="col-md-3"></div>
</div> 

<%@include file="../../template/footerDefault.jsp" %></div>
</div>


