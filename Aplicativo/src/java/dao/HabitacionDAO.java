/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import connectiondb.Connect;
import interfaces.IHabitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import vo.HabitacionVO;
import java.sql.SQLException;

/**
 *
 * @author ACER
 */
public class HabitacionDAO extends Connect implements IHabitacion{
        private Connection conection = null;
        private PreparedStatement puente = null;
        private ResultSet mensajero = null;
        private boolean operacion = false;
        private String sql = "";
        public String idhabitacion="", idtipohabitacion="", idserviciohabitacion="",
                idhotel="",numerohabitacion="", cantidadpersonas="", precio="", 
                numeropiso="", descripcion="",disponibilidad="",fechacreacion="";
        public HabitacionDAO(HabitacionVO HabVO){
            super();
            try {
                conection = this.getConnection();
                idhabitacion = HabVO.getIdhabitacion();
                idtipohabitacion = HabVO.getIdtipohabitacion();
                idserviciohabitacion = HabVO.getIdserviciohabitacion();
                idhotel = HabVO.getIdhotel();
                numerohabitacion = HabVO.getNumerohabitacion();
                cantidadpersonas = HabVO.getCantidadpersonas();
                precio = HabVO.getPrecio();
                numeropiso = HabVO.getNumeropiso();
                descripcion = HabVO.getDescripcion();
                disponibilidad = HabVO.getDisponibilidad();
                fechacreacion = HabVO.getFechacreacion();   
            } catch (Exception e) {
                Logger.getLogger(HabitacionDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }   

    @Override
    public boolean agregarHabitacion() {
        try {
            sql = "insert into habitaciones values(null,?,?,?,?,?,?,?,?,?,?)";
            puente = conection.prepareStatement(sql);
            puente.setString(1, idhabitacion);
            puente.setString(2, idtipohabitacion);
            puente.setString(3, idserviciohabitacion);
            puente.setString(4, idhotel);
            puente.setString(5, numerohabitacion);
            puente.setString(6, cantidadpersonas);
            puente.setString(7, precio);
            puente.setString(8, numeropiso);
            puente.setString(9, descripcion);
            puente.setString(10, disponibilidad);
            puente.setString(11, fechacreacion);
            puente.executeUpdate();
            operacion = true;
        } catch (SQLException e) {
            Logger.getLogger(HabitacionDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            try {
                this.closeConnection();
            } catch (SQLException e) {
                Logger.getLogger(HabitacionDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }
}
