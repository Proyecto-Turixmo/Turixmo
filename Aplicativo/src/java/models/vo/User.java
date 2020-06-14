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
   private String idusuario = "", idtipodocumento = "",numerodocumento ="",idpais="",idrol="",
                  nombre="",apellido="",correo="",contrasena="",celular="",genero="",token="",
                  imagen="",fechanacimiento="",fechacreacion="";

    public User() {}

    public User(String idusuario,String idtipodocumento,String numerodocumento, String idpais,String idrol,
                String nombre,String apellido,String correo,String contrasena,String celular,String genero,
                String token,String imagen,String fechanacimiento,String fechacreacion) {
        
        this.idusuario = idusuario;
        this.idtipodocumento = idtipodocumento;
        this.numerodocumento = numerodocumento;
        this.idpais = idpais;
        this.idrol = idrol;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.celular = celular;
        this.genero = genero;
        this.token = token ;
        this.imagen = imagen;
        this.fechanacimiento = fechanacimiento;
        this.fechacreacion = fechacreacion;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public String getIdtipodocumento() {
        return idtipodocumento;
    }

    public String getNumerodocumento() {
        return numerodocumento;
    }

    public String getIdpais() {
        return idpais;
    }

    public String getIdrol() {
        return idrol;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getCelular() {
        return celular;
    }

    public String getGenero() {
        return genero;
    }

    public String getToken() {
        return token;
    }

    public String getImagen() {
        return imagen;
    }

    public String getFechanacimiento() {
        return fechanacimiento;
    }

    public String getFechacreacion() {
        return fechacreacion;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public void setIdtipodocumento(String idtipodocumento) {
        this.idtipodocumento = idtipodocumento;
    }

    public void setNumerodocumento(String numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

    public void setIdpais(String idpais) {
        this.idpais = idpais;
    }

    public void setIdrol(String idrol) {
        this.idrol = idrol;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setFechanacimiento(String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

  
}
