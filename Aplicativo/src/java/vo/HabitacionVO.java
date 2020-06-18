/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vo;

/**
 *
 * @author ACER
 */
public class HabitacionVO {
    private String idhabitacion, idtipohabitacion, idserviciohabitacion, idhotel,
            numerohabitacion, cantidadpersonas, precio, numeropiso, descripcion,
            disponibilidad,fechacreacion;

    public HabitacionVO(String idhabitacion, String idtipohabitacion, String idserviciohabitacion, String idhotel, String numerohabitacion, String cantidadpersonas, String precio, String numeropiso, String descripcion, String disponibilidad, String fechacreacion) {
        this.idhabitacion = idhabitacion;
        this.idtipohabitacion = idtipohabitacion;
        this.idserviciohabitacion = idserviciohabitacion;
        this.idhotel = idhotel;
        this.numerohabitacion = numerohabitacion;
        this.cantidadpersonas = cantidadpersonas;
        this.precio = precio;
        this.numeropiso = numeropiso;
        this.descripcion = descripcion;
        this.disponibilidad = disponibilidad;
        this.fechacreacion = fechacreacion;
    }

    public String getIdhabitacion() {
        return idhabitacion;
    }

    public void setIdhabitacion(String idhabitacion) {
        this.idhabitacion = idhabitacion;
    }

    public String getIdtipohabitacion() {
        return idtipohabitacion;
    }

    public void setIdtipohabitacion(String idtipohabitacion) {
        this.idtipohabitacion = idtipohabitacion;
    }

    public String getIdserviciohabitacion() {
        return idserviciohabitacion;
    }

    public void setIdserviciohabitacion(String idserviciohabitacion) {
        this.idserviciohabitacion = idserviciohabitacion;
    }

    public String getIdhotel() {
        return idhotel;
    }

    public void setIdhotel(String idhotel) {
        this.idhotel = idhotel;
    }

    public String getNumerohabitacion() {
        return numerohabitacion;
    }

    public void setNumerohabitacion(String numerohabitacion) {
        this.numerohabitacion = numerohabitacion;
    }

    public String getCantidadpersonas() {
        return cantidadpersonas;
    }

    public void setCantidadpersonas(String cantidadpersonas) {
        this.cantidadpersonas = cantidadpersonas;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getNumeropiso() {
        return numeropiso;
    }

    public void setNumeropiso(String numeropiso) {
        this.numeropiso = numeropiso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }
}
