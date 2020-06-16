

package interfaces;

import java.sql.Connection;
import java.sql.SQLException;


public interface IConnection {
     abstract Connection getConnection() throws SQLException;
     abstract Connection closeConnection() throws SQLException;
}
