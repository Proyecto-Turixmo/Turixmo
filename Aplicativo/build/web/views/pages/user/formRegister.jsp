  <div class="card card-primary card-outline">
                <div class="card-body">
                    <h3 class="card-title text text-center w-100">Regístrate con Turixmo</h3>
                    <div class="text-sm"> <%@include file="../../template/showMessage.jsp" %> </div>
                    <form class="card-text mt-4" action="createUser" method="post">
                        <input type="hidden" name="rol" value="${role}">
                        <input type="hidden" name="nacionalidad" value="1">
                        <div class="form-row"> 
                            <div class="col-md-6 mb-3"> 
                                <label for="nombre" class="small mb-0">Nombre</label>
                                <input type="text" class="form-control" name="nombre" id="nombre" placeholder="Juan" required="on"/>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="apellido" class="small mb-0">Apellidos</label>
                                <input type="text" class="form-control" name="apellido" id="apellido" placeholder="Perez Ortiz" required="on"/>
                            </div>
                            <div class="col-md-12 mb-3">
                                <label for="tipoDocumento" class="small mb-0">Típo documento</label>
                                <select name="tipoDocumento" class="form-control" id="tipoDocumento">
                                    <option value="1" selected="on">Cédula de ciudadania</option>
                                    <option value="2">Cédula de extranjeria</option>
                                </select></div>
                            <div class="col-md-6 mb-3">
                                <label for="numeroDocumento" class="small mb-0">Numero documento</label>
                                <input type="text" class="form-control" name="numeroDocumento" id="numeroDocumento" placeholder="e.j 100674523" required="on"/>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="celular" class="small mb-0">Celular</label>
                                <input type="text" class="form-control" name="celular" id="celular" placeholder="e.j +57 3124567890" required="on"/>
                            </div>
                            <div class="col-md-12 mb-3">
                                <label for="correo" class="small mb-0">Correo</label>
                                <input type="email" class="form-control" name="correo" id="correo" placeholder="ejemplo@gmai.com" required="on"/>
                            </div>
                            <div class="col-md-12 mb-3">
                                <label for="contrasena" class="small mb-0">Contraseña</label>
                                <input minlength="5" type="password" class="form-control" name="contrasena" id="contrasena" placeholder="********" required="on"/>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary btn-block">Registrarme!</button><br>
                        <div class="text-center w-100 mb-2 border-bottom">
                             <a href="login">Iniciar Sesion</a>
                        </div>
                        
                        <div class="text-center small ">
                            Al registrarte aceptas nuestros <a href="#" class="">Terminos y condiciones.</a>
                        </div>
                    </form>

                </div>
            </div><!-- /.card -->