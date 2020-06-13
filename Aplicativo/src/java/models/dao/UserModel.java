/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dao;

import conectiondb.Connect;
import interfaces.IUser;
import models.vo.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andre
 */
public class UserModel extends Connect implements IUser {

    private Connection conection = null;
    private PreparedStatement stmt = null;
    private ResultSet result = null;
    private boolean operacion = false;

    private String sql = "";
    private String idusuario = "", idtipodocumento = "", numerodocumento = "", idrol = "",
            nombre = "", apellido = "", correo = "", contrasena = "", celular = "", token = "",
            imagen = "", fechanacimiento = "", fechacreacion = "";

    public UserModel() {
    }

    public UserModel(User usuario) {

        try {
            conection = this.getConnection();
            this.idusuario = usuario.getIdusuario();
            this.idtipodocumento = usuario.getIdtipodocumento();
            this.numerodocumento = usuario.getNumerodocumento();
            this.idrol = usuario.getIdrol();
            this.nombre = usuario.getNombre();
            this.apellido = usuario.getApellido();
            this.correo = usuario.getCorreo();
            this.contrasena = usuario.getContrasena();
            this.celular = usuario.getCelular();
            this.token = usuario.getToken();
            this.imagen = usuario.getImagen();
            this.fechanacimiento = usuario.getFechanacimiento();
            this.fechacreacion = usuario.getFechacreacion();

        } catch (Exception e) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public boolean registerUser() {
        try {
            this.sql = "INSERT INTO usuarios VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            this.stmt = conection.prepareStatement(sql);
            this.stmt.setString(1, this.idusuario);
            this.stmt.setString(2, this.idtipodocumento);
            this.stmt.setString(3, this.numerodocumento);
            this.stmt.setString(4, this.idrol);
            this.stmt.setString(5, this.nombre);
            this.stmt.setString(6, this.apellido);
            this.stmt.setString(7, this.correo);
            this.stmt.setString(8, this.contrasena);
            this.stmt.setString(9, this.celular);
            this.stmt.setString(10, this.token);
            this.stmt.setString(11, this.imagen);
            this.stmt.setString(12, this.fechanacimiento.equals("") ? null : this.fechanacimiento);
            this.stmt.setString(13, this.fechacreacion);

            this.stmt.executeUpdate();
            this.operacion = true;
        } catch (SQLException e) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.closeConnection();
            } catch (SQLException e) {
                Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return this.operacion;
    }

    @Override
    public ArrayList<User> getAllUsers() {

        User usuarioData = null;

        ArrayList<User> usuarios = new ArrayList<>();

        try {
            conection = this.getConnection();
            stmt = conection.prepareStatement("SELECT * FROM usuarios");
            result = stmt.executeQuery();

            while (result.next()) {
                usuarioData = new User(result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6),
                        result.getString(7),
                        result.getString(8),
                        result.getString(9),
                        result.getString(10),
                        result.getString(11),
                        result.getString(12),
                        result.getString(13)
                );
                usuarios.add(usuarioData);
            }
        } catch (SQLException e) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.closeConnection();
            } catch (SQLException e) {
                Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return usuarios;

    }
    
        @Override
    public User getUserById(int iduser) {
       User usuarioData = null;
        try {
            conection = this.getConnection();
            stmt = conection.prepareStatement("SELECT * FROM usuarios WHERE idusuario = ?");
            stmt.setInt(1,iduser);
            result = stmt.executeQuery();

            if(result.next()) {
                usuarioData = new User(result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6),
                        result.getString(7),
                        result.getString(8),
                        result.getString(9),
                        result.getString(10),
                        result.getString(11),
                        result.getString(12),
                        result.getString(13)
                );
              
            }
        } catch (SQLException e) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.closeConnection();
            } catch (SQLException e) {
                Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return usuarioData;
    }


    @Override
    public boolean updateUserById(int iduser) {
         
        try {
            this.sql = "UPDATE usuarios SET idtipodocumento = ?, idrol = ?, nombre = ?,"
                    + "apellido = ?, correo = ?, celular = ?, fechanacimiento = ? "
                    + "WHERE idusuario = ?";
            this.stmt = conection.prepareStatement(sql);
            this.stmt.setString(1, this.idtipodocumento);
            this.stmt.setString(2, this.idrol);
            this.stmt.setString(3, this.nombre);
            this.stmt.setString(4, this.apellido);
            this.stmt.setString(5, this.correo);
            this.stmt.setString(6, this.celular);
            this.stmt.setString(7, this.fechanacimiento.equals("") ? null : this.fechanacimiento);
            this.stmt.setString(8, this.idusuario);

            this.stmt.executeUpdate();
            this.operacion = true;
        } catch (SQLException e) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.closeConnection();
            } catch (SQLException e) {
                Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return this.operacion;
      }
    

    @Override
    public boolean deleteUserById(int iduser) {
        try {
            conection = this.getConnection();
            sql = "DELETE  FROM usuarios WHERE idusuario = ? ";
            stmt = conection.prepareStatement(sql);
            stmt.setInt(1, iduser);
            stmt.executeUpdate();

            operacion = true;
        } catch (SQLException e) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.closeConnection();
            } catch (SQLException e) {
                Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }


}
