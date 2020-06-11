/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectiondb;
import interfaces.IConection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author andre
 */
public class Connect implements IConection{
    
    private String DBDRIVER, DBUSER, DBPASSWORD, DBNAME, DBURL;
    private Connection conexion;

    public Connect() {

        DBDRIVER = "com.mysql.jdbc.Driver";
        DBUSER = "root";
        DBPASSWORD = "";
        DBNAME = "proyecto_turixmo";
        DBURL = "jdbc:mysql://localhost:3306/" + DBNAME + "?useSSL=false";

        try {
            Class.forName(DBDRIVER).newInstance();
            conexion = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);

        } catch (Exception e) {
            System.out.print("Error " + e);
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
            return this.conexion;
    }

    @Override
    public Connection closeConnection() throws SQLException {
            this.conexion.close();
            this.conexion = null;
            return this.conexion;
                
    }
    
    
 

}
