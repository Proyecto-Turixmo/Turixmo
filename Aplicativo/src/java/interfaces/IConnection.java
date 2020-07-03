

package interfaces;

import java.sql.Connection;
import java.sql.SQLException;


public interface IConnection {
     abstract void createConnection() throws SQLException;
     abstract Connection getConnection() throws SQLException;
     abstract Connection closeConnection() throws SQLException;
}
