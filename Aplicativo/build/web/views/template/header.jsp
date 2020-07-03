<%@page import="util.Config"%>
<!DOCTYPE html>
<%! String ruta = "libs/";%>
<html lang="es">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Turixmo | Tu mejor opcion</title>

  <link rel="stylesheet" href="<%=Config.getURL_PROJECT()+ruta%>plugins/fontawesome-free/css/all.min.css">
  <link rel="stylesheet" href="<%=Config.getURL_PROJECT()+ruta%>plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
  <link rel="stylesheet" href="<%=Config.getURL_PROJECT()+ruta%>plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
  <!-- overlayScrollbars -->
  <link rel="stylesheet" href="<%=Config.getURL_PROJECT()+ruta%>plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="<%=Config.getURL_PROJECT()+ruta%>dist/css/adminlte.min.css">
  <link rel="stylesheet" href="<%=Config.getURL_PROJECT()%>assets/css/estilos.css">
  <!-- Animate css -->
    <link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.0.0/animate.compat.css"
  />
</head>
<body class="hold-transition sidebar-mini layout-fixed layout-navbar-fixed layout-footer-fixed">
