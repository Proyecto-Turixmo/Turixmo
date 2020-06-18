
package vo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HotelVO {
    String idhotel = "";
    String idusuario = "";
    String idciudad = "";
    String estrella= "";
    String nombre= "";
    String direccion= "";
    String telefono= "";
    String celular= "";
    String correo= "";
    String sitioweb= "";
    String descripcion= "";
    String fecharegistro= "";
    String inhabilitado= "";

    public HotelVO() {}


    public HotelVO(String idhotel, String idusuario, String idciudad, String estrella, String nombre, String direccion, String telefono, String celular, String correo, String sitioweb, String descripcion, String fecharegistro) {
        this.idhotel = idhotel;
        this.idusuario = idusuario;
        this.idciudad = idciudad;
        this.estrella = estrella;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.celular = celular;
        this.correo = correo;
        this.sitioweb = sitioweb;
        this.descripcion = descripcion;
        this.fecharegistro = fecharegistro;
    }
    
        public String getInhabilitado() {
        return inhabilitado;
    }

    public void setInhabilitado(String inhabilitado) {
        this.inhabilitado = inhabilitado;
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

    public String getEstrella() {
        return estrella;
    }

    public void setEstrella(String estrella) {
        this.estrella = estrella;
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

    public String getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(String fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

   
}

   