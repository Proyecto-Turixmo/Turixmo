<%@include file="views/template/header.jsp" %>

<div style="background: #eee">
<nav class="navbar navbar-expand-lg navbar-dark bg-gradient-dark  pl-md-5">
  <a class="navbar-brand ml-md-5" href="#">Turixmó.com</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse pr-md-5"id="navbarNav">
    <ul class="navbar-nav ml-auto mr-0">
      <li class="nav-item active">
        <a class="nav-link" href="#"> <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#"><i class="fas fa-chevron-left"></i> &nbsp;Regresar</a>
      </li>
          <li class="nav-item ">
        <a class="nav-link" href="#"><i class="fas fa-phone"></i> &nbsp;Contactanos</a>
      </li>
    </ul>
  </div>
</nav>

 <div class="container mt-3">
    <div class="row">
        <div class="col-md-7">
            <div class="d-flex align-items-center  h-100">
                <div class="d-block">
                    <span class="display-4 d-block" >Déjanos ayudarte para que tu hotel prógrese, con nosotros.</span>
                    <span class="h5 text-info">Toma tu mejor desición, no pierdas tiempo y registrate ya!<span>
                </div>
                
            </div>
            
        </div>
        <div class="col-md-5">
            <div class="card card-primary card-outline">
                <div class="card-body">
                    <h5 class="card-title text-muted text-md text-center">Regístrate con nosotros..</h5>
                    <form class="card-text mt-4   " action="">
                        <input type="hidden" name="role" value="1">
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
                                <label for="tipo-documento" class="small mb-0">Típo documento</label>
                                <select name="tipo-documento" class="form-control" id="tipo-documento">
                                    <option value="1" selected="on">Cédula de ciudadania</option>
                                    <option value="2">Cédula de extranjeria</option>
                                </select></div>
                            <div class="col-md-6 mb-3">
                                <label for="numero-documento" class="small mb-0">Numero documento</label>
                                <input type="text" class="form-control" name="numero-documento" id="numero-documento" placeholder="e.j 100674523" required="on"/>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="telefono" class="small mb-0">Telefono</label>
                                <input type="text" class="form-control" name="telefono" id="telefono" placeholder="e.j +57 3124567890" required="on"/>
                            </div>
                            <div class="col-md-12 mb-3">
                                <label for="correo" class="small mb-0">Correo</label>
                                <input type="text" class="form-control" name="correo" id="correo" placeholder="ejemplo@gmai.com" required="on"/>
                            </div>
                            <div class="col-md-12 mb-3">
                                <label for="contrasena" class="small mb-0">Contraseña</label>
                                <input type="password" class="form-control" name="contrasena" id="contrasena" placeholder="********" required="on"/>
                            </div>
                        </div>
                        <a href="#" class="btn btn-primary btn-block">Registrarme!</a><br>
                       
                    </form>

                </div>
            </div><!-- /.card -->
        </div>
    </div> 
</div>
</div>

    <div class="content px-5">
      <div class="container-fluid">
          <h1 class="text-center my-4">Aprovecha de nuestras promociones! </h1>
        <div class="row">
          <div class="col-lg-4">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">Card title</h5>

                <p class="card-text">
                  Some quick example text to build on the card title and make up the bulk of the card's
                  content.
                </p>

                <a href="#" class="card-link">Card linka</a>
                <a href="#" class="card-link">Another link</a>
              </div>
            </div>
            </div>
            <!-- /.card -->
                      <div class="col-lg-4">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">Card title</h5>

                <p class="card-text">
                  Some quick example text to build on the card title and make up the bulk of the card's
                  content.
                </p>

                <a href="#" class="card-link">Card linka</a>
                <a href="#" class="card-link">Another link</a>
              </div>
            </div>
            </div>
            <!-- /.card -->
                      <div class="col-lg-4">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">Card title</h5>

                <p class="card-text">
                  Some quick example text to build on the card title and make up the bulk of the card's
                  content.
                </p>

                <a href="#" class="card-link">Card linka</a>
                <a href="#" class="card-link">Another link</a>
              </div>
            </div>
            </div>
            <!-- /.card -->
            
        </div>
    </div> 
</div>

  <footer class="footer-regiser-onwer py-3 " >
      <hr>
    <strong class=" ml-5">Copyright &copy; 2020 <a href="#">Turixmo</a>.</strong>
    Derechos reservados.
  </footer>
</div>
