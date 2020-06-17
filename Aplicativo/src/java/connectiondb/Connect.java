/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectiondb;
import interfaces.IConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author andre
 */
public class Connect implements IConnection{
    
    private final String DBDRIVER, DBUSER, DBPASSWORD, DBNAME, DBURL;
    private Connection connect;

    public Connect() {

        DBDRIVER = "com.mysql.jdbc.Driver";
        DBUSER = "root";
        DBPASSWORD = "monserrate1010";
        DBNAME = "proyecto_turixmo";
        DBURL = "jdbc:mysql://localhost:3306/" + DBNAME + "?useSSL=false";

        try {
            Class.forName(DBDRIVER).newInstance();
            connect = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);

        } catch (Exception e) {
            System.out.print("Error " + e);
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
            return this.connect;
    }

    @Override
    public Connection closeConnection() throws SQLException {
            this.connect.close();
            this.connect = null;
            return this.connect;
                
    }
    
    
 

}
