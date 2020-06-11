/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.vo;

/**
 *
 * @author andre
 */
public class User {
   private String idusuario = "", idtipodocumento = "",numerodocumento ="",idrol="",
                  nombre="",apellido="",correo="",contrasena="",celular="",token="",
                  imagen="",fechanacimiento="",fechacreacion="";

    public User() {}

    public User(String idusuario,String idtipodocumento,String numerodocumento, String idrol,
                String nombre,String apellido,String correo,String contrasena,String celular,
                String token,String imagen,String fechanacimiento,String fechacreacion) {
        
        this.idusuario = idusuario;
        this.idtipodocumento = idtipodocumento;
        this.numerodocumento = numerodocumento;
        this.idrol = idrol;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.celular = celular;
        this.token = token ;
        this.imagen = imagen;
        this.fechanacimiento = fechanacimiento;
        this.fechacreacion = fechacreacion;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getIdtipodocumento() {
        return idtipodocumento;
    }

    public void setIdtipodocumento(String idtipodocumento) {
        this.idtipodocumento = idtipodocumento;
    }

    public String getNumerodocumento() {
        return numerodocumento;
    }

    public void setNumerodocumento(String numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

    public String getIdrol() {
        return idrol;
    }

    public void setIdrol(String idrol) {
        this.idrol = idrol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }


}
