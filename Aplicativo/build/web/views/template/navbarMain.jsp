  <!-- Navbar -->
  <div style="background: #f6f6f6">
  <nav class="navbar navbar-expand navbar-white navbar-light shadow-sm   bg-white rounded ">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
      <li class="nav-item">
        <!--<a class="nav-link"  href="#" role=""><i class="fas fa-bars"></i></a>-->
      </li>
    </ul>

    <a href="./" class=" h4 ml-md-5 d-flex align-content-end flex-wrap">Turixmo.com</a>

  <div class="collapse navbar-collapse  px-5 d-none" id="navbarNavDropdown">
    <ul class="navbar-nav">
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" id="nosotros" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" href="#">Nosotros</a>
       <div class="dropdown-menu" aria-labelledby="nosotros">
          <a class="dropdown-item" href="#">Historia</a>
          <a class="dropdown-item" href="#">Vision</a>
          <a class="dropdown-item" href="#">Mision</a>
        </div>
      </li>
      <li class="nav-item  ml-n3 dropdown">
        <a class="nav-link dropdown-toggle"id="unete" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" href="#">Unéte!</a>
           <div class="dropdown-menu shadow-sm" aria-labelledby="unete">
          <a class="dropdown-item" href="addOwner">Tienes un Hotel?</a>
<!--          <a class="dropdown-item" href="#">Vision</a>
          <a class="dropdown-item" href="#">Mision</a>-->
        </div>
      </li>

    </ul>
      </div>
    <!-- Right navbar links -->
    <ul class="navbar-nav ml-auto">
      <!-- Messages Dropdown Menu -->
      <li class="nav-item dropdown d-flex align-content-center flex-wrap ">
        <a class="nav-link" data-toggle="dropdown" href="#">
          <i class="far fa-heart more-size"></i>
          <span class="badge badge-danger navbar-badge mt-1 badge-turixmo">3</span>
        </a>
        <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
          <a href="#" class="dropdown-item">
            <!-- Message Start -->
            <div class="media">
              <img src="<%=ruta%>dist/img/avatar5.png" alt="User Avatar" class="img-size-50 mr-3 img-circle">
              <div class="media-body">
                <h3 class="dropdown-item-title">
                  Brad Diesel
                  <span class="float-right text-sm text-danger"><i class="fas fa-star"></i></span>
                </h3>
                <p class="text-sm">Call me whenever you can...</p>
                <p class="text-sm text-muted"><i class="far fa-clock mr-1 "></i> 4 Hours Ago</p>
              </div>
            </div>
            <!-- Message End -->
          </a>
          <div class="dropdown-divider"></div>
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item dropdown-footer">See All Messages</a>
        </div>
      </li>
      <!-- Notifications Dropdown Menu -->
      <li class="nav-item dropdown d-flex align-content-center flex-wrap">
        <a class="nav-link" data-toggle="dropdown" href="#">
          <i class="far fa-bell more-size"></i>
          <span class="badge badge-warning navbar-badge  mt-1 badge-turixmo">15</span>
        </a>
        <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right animacion">
          <span class="dropdown-item dropdown-header">15 Notifications</span>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item">
            <i class="fas fa-envelope mr-2"></i> 4 new messages
            <span class="float-right text-muted text-sm">3 mins</span>
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item">
            <i class="fas fa-users mr-2"></i> 8 friend requests
            <span class="float-right text-muted text-sm">12 hours</span>
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item">
            <i class="fas fa-file mr-2"></i> 3 new reports
            <span class="float-right text-muted text-sm">2 days</span>
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item dropdown-footer">See All Notifications</a>
        </div>
      </li>
      <li class="nav-item ">
          
    <div class="dropdown">
        <a href="login" class="btn btn-sm btn-warning ml-2 mr-5 mt-1 align-content-end flex-wrap">Iniciar Sesion</a>
<!--        <a class="nav-link" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <img style="width: 40px;height: 40px" class="img-circle p-0" src="https://www.eltiempo.com/files/image_640_428/uploads/2018/02/22/5a8f51544f290.jpeg" alt="Tu imagen" >
        </a>-->

  <div class="dropdown-menu animated fadeInRight" aria-labelledby="dropdownMenuLink">
    <a class="dropdown-item py-0" href="#"><strong class="text-primary">Opciones</strong></a>
    <div class="dropdown-divider"></div>
    <a class="dropdown-item" href="login">Iniciar Sesion</a>
    <a class="dropdown-item" href="add-tourist">Registrar Turista</a>
    <a class="dropdown-item" href="add-owner">Registrar Propietario</a>
    <a class="dropdown-item" href="user-all">Session de Admins</a>
  </div>
</div>
      </li>
    </ul>
  </nav>
  <!-- /.navbar -->