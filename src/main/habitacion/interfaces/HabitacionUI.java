package habitacion.interfaces;

import habitacion.entity.Habitacion;
import java.sql.SQLException;
import java.util.List;

public interface HabitacionUI {

  List<Habitacion> getHabitaciones() throws SQLException;

  Habitacion getHabitacionByCodigoHabitacion(int codigo);
}
