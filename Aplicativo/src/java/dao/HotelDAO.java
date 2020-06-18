/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connectiondb.Connect;
import interfaces.IHotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Util;
import vo.HotelVO;

/**
 *
 * @author andre
 */
public class HotelDAO extends Connect implements IHotel {

    private Connection conection = null;
    private PreparedStatement stmt = null;
    private ResultSet result = null;
    private boolean operacion = false;
    private String sql = "";

    public HotelDAO() {
    }

 
    @Override
    public boolean create(HotelVO hotel) {
        try {
            this.conection = this.getConnection();
            this.sql = "call sp_insertarhotel(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            this.stmt = conection.prepareStatement(sql);
            this.stmt.setString(1, Util.spaceToNull(hotel.getIdhotel()));
            this.stmt.setString(2, hotel.getIdusuario());
            this.stmt.setString(3, Util.spaceToNull(hotel.getIdciudad()));
            this.stmt.setString(4, Util.spaceToNull(hotel.getEstrella()));
            this.stmt.setString(5, hotel.getNombre());
            this.stmt.setString(6, hotel.getDireccion());
            this.stmt.setString(7, Util.spaceToNull(hotel.getTelefono()));
            this.stmt.setString(8, hotel.getCelular());
            this.stmt.setString(9, hotel.getCorreo());
            this.stmt.setString(10, Util.spaceToNull(hotel.getSitioweb()));
            this.stmt.setString(11, Util.spaceToNull(hotel.getDescripcion()));
            this.stmt.setString(12, hotel.getFecharegistro());
            this.stmt.setString(13, hotel.getInhabilitado());

            this.stmt.executeUpdate();
            this.operacion = true;
        } catch (SQLException e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.closeConnection();
            } catch (SQLException e) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return this.operacion;
    }

    @Override
    public ArrayList<HotelVO> getAll(int idUser) {

        ArrayList<HotelVO> hoteles = new ArrayList<>();

        try {
            conection = this.getConnection();
            this.stmt = conection.prepareStatement("SELECT * FROM v_hotel where idusuario = ?");
            this.stmt.setInt(1, idUser);
            result = stmt.executeQuery();

            while (result.next()) {
               HotelVO hotelVO = new HotelVO();
               
                hotelVO.setIdhotel(result.getString(1));
                hotelVO.setIdusuario(result.getString(2));
                hotelVO.setIdciudad(result.getString(3));
                hotelVO.setEstrella(result.getString(4));
                hotelVO.setNombre(result.getString(5));
                hotelVO.setDireccion(result.getString(6));
                hotelVO.setTelefono(result.getString(7));
                hotelVO.setCelular(result.getString(8));
                hotelVO.setCorreo(result.getString(9));
                hotelVO.setSitioweb(result.getString(10));
                hotelVO.setDescripcion(result.getString(11));
                hotelVO.setFecharegistro(result.getString(12));
                hotelVO.setInhabilitado(result.getString(13));

                hoteles.add(hotelVO);
            }
        } catch (SQLException e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.closeConnection();
            } catch (SQLException e) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return hoteles;
    }

    @Override
    public HotelVO edit(int idHotel,int idUser) {

        HotelVO hotelVO = new HotelVO();
        try {
            conection = this.getConnection();
            stmt = conection.prepareStatement("SELECT * FROM v_hotel WHERE idhotel = ? and idusuario = ? ");
            stmt.setInt(1, idHotel);
            stmt.setInt(2, idUser);
            result = stmt.executeQuery();

            if (result.next()) {

                hotelVO.setIdhotel(result.getString(1));
                hotelVO.setIdusuario(result.getString(2));
                hotelVO.setIdciudad(Util.nullToSpace(result.getString(3)));
                hotelVO.setEstrella(Util.nullToSpace(result.getString(4)));
                hotelVO.setNombre(result.getString(5));
                hotelVO.setDireccion(result.getString(6));
                hotelVO.setTelefono(Util.nullToSpace(result.getString(7)));
                hotelVO.setCelular(result.getString(8));
                hotelVO.setCorreo(result.getString(9));
                hotelVO.setSitioweb(Util.nullToSpace(result.getString(10)));
                hotelVO.setDescripcion(Util.nullToSpace(result.getString(11)));
                hotelVO.setFecharegistro(result.getString(12));
                hotelVO.setInhabilitado(result.getString(13));

            }
        } catch (SQLException e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.closeConnection();
            } catch (SQLException e) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

            return hotelVO;
    }

    @Override
    public boolean update(HotelVO hotel) {
         try {
            conection = this.getConnection();
            this.sql = "call sp_actualizarhotel(?,?,?,?,?,?,?,?,?,?,?)";
            this.stmt = conection.prepareStatement(this.sql);
            this.stmt.setString(1, Util.spaceToNull(hotel.getIdciudad()));
            this.stmt.setString(2, Util.spaceToNull(hotel.getEstrella()));
            this.stmt.setString(3, hotel.getNombre());
            this.stmt.setString(4, hotel.getDireccion());
            this.stmt.setString(5, Util.spaceToNull(hotel.getTelefono()));
            this.stmt.setString(6, hotel.getCelular());
            this.stmt.setString(7, hotel.getCorreo());
            this.stmt.setString(8, Util.spaceToNull(hotel.getSitioweb()));
            this.stmt.setString(9, Util.spaceToNull(hotel.getDescripcion()));
            this.stmt.setString(10, hotel.getIdhotel());
            this.stmt.setString(11, hotel.getIdusuario());

            this.stmt.executeUpdate();
            this.operacion = true;
        } catch (SQLException e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.closeConnection();
            } catch (SQLException e) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return this.operacion;
    
    }

    @Override
    public boolean disable(int idHotel,int idUser) {
        try {
            conection = this.getConnection();
            sql = "call sp_inhabilitarhotel(?,?)";
            stmt = conection.prepareStatement(sql);
            stmt.setInt(1, idHotel);
            stmt.setInt(2, idUser);
            
            stmt.executeUpdate();

            operacion = true;
        } catch (SQLException e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.closeConnection();
            } catch (SQLException e) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

}
