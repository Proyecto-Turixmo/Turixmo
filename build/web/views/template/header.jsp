<!DOCTYPE html>
<!-- la variable ruta solo completa el la ruta de las urls de la plantilla -->
<% String ruta = "./libs/";%>

<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Turixmo | Tu mejor opcion</title>

  <!-- Google Font: Source Sans Pro -->
  <!--<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">-->
  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="<%=ruta%>plugins/fontawesome-free/css/all.min.css">
  <link rel="stylesheet" href="<%=ruta%>plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
  <link rel="stylesheet" href="<%=ruta%>plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
  <!-- overlayScrollbars -->
  <link rel="stylesheet" href="<%=ruta%>plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="<%=ruta%>dist/css/adminlte.min.css">
</head>
<body class="hold-transition sidebar-mini layout-fixed layout-navbar-fixed layout-footer-fixed">
