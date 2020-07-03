
<%@page import="util.Message"%>

<% if(Message.get(request,"message") != null && Message.get(request,"type") != null){ %>
<div class="alert alert-${type} alert-dismissible fade show"  role="alert">
    <% if(Message.get(request,"type").equals("success")){ %>
        <strong>Bien!</strong> ${message}.
  <%}else if(Message.get(request,"type").equals("danger")){%>
    <strong>Error!</strong>  ${message}.
  <%}else if(Message.get(request,"type").equals("info")){ %>
    <strong>Listo!</strong>  ${message}.
  <%}else{ %>
   <% out.print(Message.get(request,"message")); %>
  <% } %>
  
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
   <% String[] names = {"message","type"};%>
   <% Message.destroy(request, names); %>
<% } %>