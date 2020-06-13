/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dao;
import conectiondb.Connect;
import interfaces.IHoteles;
import models.vo.Hoteles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Neira Castillo
 */
public class HotelesModel extends Connect implements IHoteles {
    private Connection conection = null;
    private PreparedStatement stmt = null;
    private ResultSet result = null;
    private boolean operacion = false;

    private String sql = "";
    private String idhotel = "", idusuario = "", idciudad = "", nombre = "",
            direccion = "", ubicacion = "", telefono = "", celular = "", correo = "", sitioweb = "",
            descripcion = "", fechacreacion = "";

    public HotelesModel() {
    }

    public HotelesModel(Hoteles hoteles) {

        try {
            conection = this.getConnection();
            this.idhotel = hoteles.getIdhotel();
            this.idusuario = hoteles.getIdusuario();
            this.idciudad = hoteles.getIdciudad();
            this.nombre = hoteles.getNombre();
            this.direccion = hoteles.getDireccion();
            this.ubicacion = hoteles.getUbicacion();
            this.telefono = hoteles.getTelefono();
            this.celular = hoteles.getCelular();
            this.correo = hoteles.getCorreo();
            this.sitioweb = hoteles.getSitioweb();
            this.descripcion = hoteles.getDescripcion();
            this.fechacreacion = hoteles.getFechacreacion();
            

        } catch (Exception e) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public boolean registerHoteles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Hoteles> getAllHoteles() {
        Hoteles hotelesData = null;

        ArrayList<Hoteles> hoteles = new ArrayList<>();

        try {
            conection = this.getConnection();
            stmt = conection.prepareStatement("SELECT * FROM hoteles");
            result = stmt.executeQuery();

            while (result.next()) {
                hotelesData = new Hoteles(result.getString(1),
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
                hoteles.add(hotelesData);
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

        return hoteles;

    }
    

    @Override
    public Hoteles getHotelesById(int idhotel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateHotelesById(int idhotel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteHotelesById(int idhotel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
