  $(function () {
        $("#example1").DataTable({
      "responsive": true,
      "autoWidth": false,
    });
      $('#example2').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": false,
      "ordering": true,
      "info": true,
      "autoWidth": false,
      "responsive": true,
    });

  });
  
  
//  window.addEventListener("load",function(){
//     document.querySelector("#deseo").addEventListener("mouseover",function(){
//         var dropdown = document.querySelector("#deseo-dropdown");
//
//             dropdown.classList.remove("desaparecer")
//            dropdown.classList.add("aparecer")
//         
//     }); 
//     document.querySelector("#deseo").addEventListener("mouseout",function(){
//         var dropdown = document.querySelector("#deseo-dropdown");
//         setTimeout(function(){
//             dropdown.addEventListener("mouseover",function(){
//                              dropdown.classList.remove("desaparecer")
//                             dropdown.classList.add("aparecer")
//             })
//            dropdown.classList.remove("aparecer")
//            dropdown.classList.add("desaparecer") 
//         },2000);
//            
//        
//     }); 
//  });
//  
  console.log(window)