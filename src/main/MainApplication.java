import configuration.DatabaseConfiguration;
import habitacion.service.HabitacionService;
import java.sql.SQLException;

public class MainApplication {

  public static void main(String[] args) throws SQLException, ClassNotFoundException {

    // Obtenemos la conexion a nuestra base de datos
    DatabaseConfiguration configDatabase = new DatabaseConfiguration();
    // Cogemos la conexión para usarla para la tabla de Habitaciones
    HabitacionService habitacionDatabase = new HabitacionService(configDatabase.getConnection());
    System.out.println(habitacionDatabase.getHabitaciones());
    System.out.println("Datos de la habitación: " + habitacionDatabase.getHabitacionByCodigoHabitacion(123124124));

    // Cerramos la conexion
    configDatabase.closeConnection();
  }
}
