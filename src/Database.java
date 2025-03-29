import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:postgresql://<TU_HOST>:<PUERTO>/<TU_BASE_DE_DATOS>";
    private static final String USER = "<TU_USUARIO>";
    private static final String PASSWORD = "<TU_CONTRASEÑA>";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}