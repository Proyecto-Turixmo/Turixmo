
package dao;

import Config.Conexion;
import Intefaces.CRUD;
import vo.Hotel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HotelDAO implements CRUD{
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Hotel h=new Hotel();
    
    @Override
    public List listar() {
        ArrayList<Hotel>list=new ArrayList<>();
        String sql="select * from hotel";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Hotel hot=new Hotel();
                
               
                hot.setIdhotel(rs.getInt("idhotel"));
                hot.setIdusuario(rs.getString("idusuario"));
                hot.setIdciudad(rs.getString("idciudad"));
                hot.setEstrella(rs.getString("estrella"));
                hot.setNombre(rs.getString("nombre"));
                hot.setDireccion(rs.getString("direccion"));
                hot.setTelefono(rs.getString("telefono"));
                hot.setCelular(rs.getString("celular"));
                hot.setCorreo(rs.getString("correo"));
                hot.setSitioweb(rs.getString("sitioweb"));
                hot.setDescripcion(rs.getString("descripcion"));
                hot.setFecharegistro(rs.getString("fecharegistro"));
                list.add(hot);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Hotel list(int idhotel) {
        String sql="select * from hotel where idhotel="+idhotel;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                h.setIdhotel(rs.getInt("idhotel"));
                h.setIdusuario(rs.getString("idusuario"));
                h.setIdciudad(rs.getString("idciudad"));
                h.setEstrella(rs.getString("estrella"));
                h.setNombre(rs.getString("nombre"));
                h.setDireccion(rs.getString("direccion"));
                h.setTelefono(rs.getString("telefono"));
                h.setCelular(rs.getString("celular"));
                h.setCorreo(rs.getString("correo"));
                h.setDescripcion(rs.getString("descripcion"));
                h.setFecharegistro(rs.getString("fecharegistro"));
                
                
            }
        } catch (Exception e) {
        }
        return h;
    }

    @Override
    public boolean add(Hotel hot) {
       String sql="insert into hotel (idusuario,idciudad,estrella,nombre, direccion,telefono,celular,correo,sitioweb,descripcion,fecharegistro)values('"+hot.getIdusuario()+"','"+hot.getIdciudad()+"', '"+hot.getEstrella()+"' ,'"+hot.getNombre()+"','"+hot.getDireccion()+"' , '"+hot.getTelefono()+"' , '"+hot.getCelular()+"' , '"+hot.getCorreo()+"' ,'"+hot.getSitioweb()+"' , '"+hot.getDescripcion()+"' , '"+hot.getFecharegistro()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(Hotel hot) {
        String sql="update hotel set nombre='"+hot.getNombre()+"',direccion='"+hot.getDireccion()+"'where idhotel="+hot.getIdhotel();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int idhotel) {
        String sql="delete from hotel where idhotel="+idhotel;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
}
