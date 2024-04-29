import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionManager {

    private static final String URL = "jdbc:postgresql://localhost:5432/mydatabase";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    private static DatabaseConnectionManager instance;
    private Connection connection;

    // Private constructor to prevent instantiation from outside
    private DatabaseConnectionManager() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception appropriately
        }
    }

    // Static method to get the singleton instance
    public static synchronized DatabaseConnectionManager getInstance() {
        if (instance == null) {
            instance = new DatabaseConnectionManager();
        }
        return instance;
    }

    // Method to get the database connection
    public Connection getConnection() {
        return connection;
    }
}
