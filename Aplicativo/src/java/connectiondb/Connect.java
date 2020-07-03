
package connectiondb;
import interfaces.IConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.Config;


public class Connect  implements IConnection{
    
    private Connection connect;
    
    protected Connection connection = null;
    protected PreparedStatement stmt = null;
    protected ResultSet result = null;
    protected boolean operation = false;

    public Connect() {}

    @Override
    public void createConnection() {

        try {
            Class.forName(Config.getDBDRIVER()).newInstance();
            connect = DriverManager.getConnection(Config.getDBURL(), Config.getDBUSER(), Config.getDBPASSWORD());

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
