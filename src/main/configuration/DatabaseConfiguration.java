package configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfiguration {

  // Atributos de configuración de la base de datos
  private static final String DB_URL = "jdbc:mysql://localhost:3306/hotel";
  private static final String DB_USERNAME = "root";
  private static final String DB_PASSWORD = "root";

  private static Connection connection;

  public DatabaseConfiguration() throws SQLException {
    this.connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
  }

  // Método para obtener una conexión a la base de datos (ya que la variable connection no voy a reutilizarla y devuelvo directamente la conexion
  public Connection getConnection() throws SQLException {
    return connection;
  }

  // Método para cerrar la conexión a la base de datos
  public void closeConnection() throws SQLException {
    connection.close();
  }
}
