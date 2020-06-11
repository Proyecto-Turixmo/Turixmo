
<% if(request.getAttribute("message") != null && request.getAttribute("type") != null){ %>
<div class="alert alert-${type} alert-dismissible fade show"  role="alert">
  <% if(request.getAttribute("type") == "success"){ %>
        <strong>Bien!</strong> ${message}.
  <%}else if(request.getAttribute("type") == "danger"){%>
    <strong>Error!</strong>  ${message}.
  <%}else if(request.getAttribute("type") == "info"){ %>
    <strong>Listo!</strong>  ${message}.
  <%}else{ %>
   <strong>No se ha ingresado un tipo</strong>
  <% } %>
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
<% } %>