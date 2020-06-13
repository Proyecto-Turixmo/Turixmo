/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.vo;

/**
 *
 * @author Neira Castillo
 */
public class Hoteles {
    private String idhotel = "", idusuario = "",idciudad ="",nombre="",
                  direccion="",ubicacion="",telefono="",celular="",correo="",sitioweb="",
                  descripcion="",fechacreacion="";

    public Hoteles() {}

    public Hoteles(String idhotel,String idusuario,String idciudad, String nombre,
                String direccion,String ubicacion,String telefono,String celular,String correo,
                String sitioweb,String descripcion,String fechacreacion) {
        
        this.idhotel = idhotel;
        this.idusuario = idusuario;
        this.idciudad = idciudad;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ubicacion = ubicacion;
        this.telefono = telefono;
        this.celular = celular;
        this.correo = correo;
        this.sitioweb = sitioweb ;
        this.descripcion = descripcion;
        this.fechacreacion = fechacreacion;
        
    }

    public Hoteles(String string, String string0, String string1, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getIdhotel() {
        return idhotel;
    }

    public void setIdhotel(String idhotel) {
        this.idhotel = idhotel;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(String idciudad) {
        this.idciudad = idciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getSitioweb() {
        return sitioweb;
    }

    public void setSitioweb(String sitioweb) {
        this.sitioweb = sitioweb;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

   

}
