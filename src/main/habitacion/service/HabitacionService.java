package habitacion.service;

import habitacion.entity.Habitacion;
import habitacion.interfaces.HabitacionUI;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HabitacionService implements HabitacionUI {

  private final Connection connection;

  public HabitacionService(Connection connection) {
    this.connection = connection;
  }

  @Override
  public List<Habitacion> getHabitaciones() throws SQLException {
    List<Habitacion> listadoHabitaciones = new ArrayList<>();

    try {
      Statement stmt = connection.createStatement();
      String queryGetHoteles = "SELECT * FROM HABITACION";
      ResultSet rs = stmt.executeQuery(queryGetHoteles);
      while (rs.next()) {
        listadoHabitaciones.add(createHabitacionFromDatabase(rs));
      }
    } catch (SQLException e) {
      throw new Error("Error leyendo la base de datos", e);
    }

    return listadoHabitaciones;
  }

  @Override
  public Habitacion getHabitacionByCodigoHabitacion(int codigo) {

    try {
      Statement stmt = connection.createStatement();

      String queryGetHotelByCodigo = "SELECT * FROM HABITACION WHERE CODIGO = " + codigo;
      ResultSet rs = stmt.executeQuery(queryGetHotelByCodigo);
      while (rs.next()) {
        return createHabitacionFromDatabase(rs);
      }


    } catch (SQLException e) {
      throw new Error("Error leyendo la base de datos", e);
    }

    return null;
  }

  private Habitacion createHabitacionFromDatabase(ResultSet resultSet) throws SQLException {
    return new Habitacion(resultSet.getInt("CODIGO"),
        resultSet.getInt("PLANTA"),
        resultSet.getInt("NUMERO"),
        resultSet.getString("TIPO"),
        resultSet.getInt("PRECIO"),
        resultSet.getInt("DESCUENTO_EMPLEADO"),
        resultSet.getInt("CODIGO_RESERVA"));
  }
}
