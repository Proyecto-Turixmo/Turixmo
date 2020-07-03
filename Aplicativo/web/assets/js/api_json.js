//"use strict"
//
//window.$ = (elemento) => {
//    var e = document.querySelectorAll(elemento);
//    return (e.length == 1) ? e[0] : e;
//}
//
//const cargarApi = () => {
//    fetch("http://localhost:8080/turixmo/logina")// por medio de la url, una peticion por el metodo GET
//        .then(data => data.json())
//        .then(data => {
////             $("body").style.padding = "50px"
////             $("body").innerHTML = data.nombre + " " + data.apellido;
////             data.amigos.map((amigo, indice) => {
////                 $("body").innerHTML += "<br>" + indice + " " + amigo;
////             });
//            console.log(data)
//        })
//        .catch(err => console.log(err))
//
//}
//window.addEventListener("load", cargarApi);