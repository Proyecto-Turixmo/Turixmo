/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connectiondb.Connect;
import interfaces.IUser;
import vo.UserVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Util;

/**
 *
 * @author andre
 */
public class UserDAO extends Connect implements IUser {

    private Connection conection = null;
    private PreparedStatement stmt = null;
    private ResultSet result = null;
    private boolean operacion = false;
    private String sql = "";

    public UserDAO() {
    }

    @Override
    public boolean create(UserVO user) {

        try {
            this.createConnection();
            this.conection = this.getConnection();
            this.sql = "call sp_insertarusuario(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            this.stmt = conection.prepareStatement(sql);
            this.stmt.setString(1, Util.spaceToNull(user.getIdusuario()));
            this.stmt.setString(2, user.getIdtipodocumento());
            this.stmt.setString(3, user.getNumerodocumento());
            this.stmt.setString(4, user.getIdpais());
            this.stmt.setString(5, user.getIdrol());
            this.stmt.setString(6, user.getNombre());
            this.stmt.setString(7, user.getApellido());
            this.stmt.setString(8, user.getCorreo());
            this.stmt.setString(9, user.getContrasena());
            this.stmt.setString(10, user.getCelular());
            this.stmt.setString(11, Util.spaceToNull(user.getGenero()));
            this.stmt.setString(12, Util.spaceToNull(user.getToken()));
            this.stmt.setString(13, Util.spaceToNull(user.getImagen()));
            this.stmt.setString(14, Util.spaceToNull(user.getFechanacimiento()));
            this.stmt.setString(15, user.getFecharegistro());
            this.stmt.setString(16, user.getInhabilitado());

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
    public ArrayList<UserVO> getAll() {

        ArrayList<UserVO> users = new ArrayList<>();

        try {
            this.createConnection();
            conection = this.getConnection();
            stmt = conection.prepareStatement("SELECT * FROM v_usuario");
            result = stmt.executeQuery();

            while (result.next()) {

                UserVO userVO = new UserVO();
                userVO.setIdusuario(result.getString(1));
                userVO.setIdtipodocumento(result.getString(2));
                userVO.setNumerodocumento(result.getString(3));
                userVO.setIdpais(result.getString(4));
                userVO.setIdrol(result.getString(5));
                userVO.setNombre(result.getString(6));
                userVO.setApellido(result.getString(7));
                userVO.setCorreo(result.getString(8));
                userVO.setContrasena(result.getString(9));
                userVO.setCelular(result.getString(10));
                userVO.setGenero(result.getString(11));
                userVO.setToken(result.getString(12));
                userVO.setImagen(result.getString(13));
                userVO.setFechanacimiento(result.getString(14));
                userVO.setFecharegistro(result.getString(15));

                users.add(userVO);
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

        return users;
    }

    @Override
    public UserVO getById(int idUser) {

        UserVO userVO = new UserVO();

        try {
            this.createConnection();
            conection = this.getConnection();
            stmt = conection.prepareStatement("SELECT * FROM v_usuario WHERE idusuario = ?");
            stmt.setInt(1, idUser);
            result = stmt.executeQuery();

            if (result.next()) {

                userVO.setIdusuario(result.getString(1));
                userVO.setIdtipodocumento(result.getString(2));
                userVO.setNumerodocumento(result.getString(3));
                userVO.setIdpais(result.getString(4));
                userVO.setIdrol(result.getString(5));
                userVO.setNombre(result.getString(6));
                userVO.setApellido(result.getString(7));
                userVO.setCorreo(result.getString(8));
                userVO.setContrasena(result.getString(9));
                userVO.setCelular(result.getString(10));
                userVO.setGenero(result.getString(11));
                userVO.setToken(result.getString(12));
                userVO.setImagen(result.getString(13));
                userVO.setFechanacimiento(result.getString(14));
                userVO.setFecharegistro(result.getString(15));

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

        return userVO;

    }

    @Override
    public boolean updateById(UserVO user) {

        try {
            this.createConnection();
            conection = this.getConnection();
            this.sql = "call sp_actualizarusuario(?,?,?,?,?,?,?,?,?,?)";
            this.stmt = conection.prepareStatement(this.sql);
            this.stmt.setString(1, user.getIdtipodocumento());
            this.stmt.setString(2, user.getIdpais());
            this.stmt.setString(3, user.getNombre());
            this.stmt.setString(4, user.getApellido());
            this.stmt.setString(5, user.getCorreo());
            this.stmt.setString(6, user.getCelular());
            this.stmt.setString(7, Util.spaceToNull(user.getGenero()));
            this.stmt.setString(8, Util.spaceToNull(user.getImagen()));
            this.stmt.setString(9, Util.spaceToNull(user.getFechanacimiento()));
            this.stmt.setString(10, user.getIdusuario());

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
    public boolean deleteById(int idUser) {

        try {
            this.createConnection();
            this.conection = this.getConnection();
            this.sql = "call sp_inhabilitarusuario(?) ";
            stmt = conection.prepareStatement(sql);
            stmt.setInt(1, idUser);
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
    
    public UserVO validate(String email) {

        UserVO userVO = new UserVO();
        try {
            this.createConnection();
            conection = this.getConnection();
            sql = "SELECT * FROM v_usuario WHERE correo = ? ";
            stmt = conection.prepareStatement(sql);
            stmt.setString(1, email);
            result =  stmt.executeQuery();
            if (result.next()) {

                userVO.setIdusuario(result.getString(1));
                userVO.setIdtipodocumento(result.getString(2));
                userVO.setNumerodocumento(result.getString(3));
                userVO.setIdpais(result.getString(4));
                userVO.setIdrol(result.getString(5));
                userVO.setNombre(result.getString(6));
                userVO.setApellido(result.getString(7));
                userVO.setCorreo(result.getString(8));
                userVO.setContrasena(result.getString(9));
                userVO.setCelular(result.getString(10));
                userVO.setGenero(result.getString(11));
                userVO.setToken(result.getString(12));
                userVO.setImagen(result.getString(13));
                userVO.setFechanacimiento(result.getString(14));
                userVO.setFecharegistro(result.getString(15));
            }else{
            userVO = null;
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
        return userVO;
    }

}
