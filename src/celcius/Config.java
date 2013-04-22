package celcius;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Config {

    public static String connectionString = "jdbc:mysql://127.0.0.1/celcius?"
            + "user=root&password=";

    public static boolean checkDBConnection() {
        try {
            Connection connect = (Connection) DriverManager.getConnection(Config.connectionString);

            if (connect != null) {
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
}
