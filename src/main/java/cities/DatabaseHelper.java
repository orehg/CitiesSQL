package cities;

import utils.PropertyUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHelper {
    private static final String PROPERTIES_FILE = "src/main/resources/config.properties";

    public static Connection getConnection() {
        String url = PropertyUtils.getProperty(PROPERTIES_FILE, "db.url");
        String login = PropertyUtils.getProperty(PROPERTIES_FILE, "db.login");
        String password = PropertyUtils.getProperty(PROPERTIES_FILE, "db.password");

        try {
            return DriverManager.getConnection(url, login, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
