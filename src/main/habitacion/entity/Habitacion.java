package habitacion.entity;

import entity.Reserva;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Habitacion implements Serializable {

  private static final long serialVersionUID = 1L;

	private int codigoHabitacion;
  private int planta;
  private int numeroHabitacion;
  private String tipoHabitacion;
  private int precio;
  private int descuentoEmpleado;
  private int codigoReserva;

  public Habitacion(int codigoHabitacion, int planta, int numeroHabitacion, String tipoHabitacion,
      int precio, int descuentoEmpleado, int codigoReserva) {
    this.codigoHabitacion = codigoHabitacion;
    this.planta = planta;
    this.numeroHabitacion = numeroHabitacion;
    this.tipoHabitacion = tipoHabitacion;
    this.precio = precio;
    this.descuentoEmpleado = descuentoEmpleado;
    this.codigoReserva = codigoReserva;
  }

  public int getCodigoHabitacion() {
    return codigoHabitacion;
  }

  public void setCodigoHabitacion(int codigoHabitacion) {
    this.codigoHabitacion = codigoHabitacion;
  }

  public int getPlanta() {
    return planta;
  }

  public void setPlanta(int planta) {
    this.planta = planta;
  }

  public int getNumeroHabitacion() {
    return numeroHabitacion;
  }

  public void setNumeroHabitacion(int numeroHabitacion) {
    this.numeroHabitacion = numeroHabitacion;
  }

  public String getTipoHabitacion() {
    return tipoHabitacion;
  }

  public void setTipoHabitacion(String tipoHabitacion) {
    this.tipoHabitacion = tipoHabitacion;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(int precio) {
    this.precio = precio;
  }

  public int getDescuentoEmpleado() {
    return descuentoEmpleado;
  }

  public void setDescuentoEmpleado(int descuentoEmpleado) {
    this.descuentoEmpleado = descuentoEmpleado;
  }

  public int getCodigoReserva() {
    return codigoReserva;
  }

  public void setCodigoReserva(int codigoReserva) {
    this.codigoReserva = codigoReserva;
  }

  public int compareTo(Habitacion other) {
    if (this.tipoHabitacion.compareTo(other.tipoHabitacion) != 0) {
      return this.tipoHabitacion.compareTo(other.tipoHabitacion);
    } else {
      return Integer.compare(this.codigoHabitacion, other.codigoHabitacion);
    }
  }


  public boolean estaDisponible(ArrayList<Reserva> reservas) {
    for (Reserva reserva : reservas) {
      if (reserva.getCodigoHabitacion() == codigoHabitacion) {
        return false;
      }
    }
    return true;
  }

  public List<Reserva> getReservas(ArrayList<Reserva> reservas) {
    List<Reserva> reservasHabitacion = new ArrayList<>();
    for (Reserva reserva : reservas) {
      if (reserva.getCodigoHabitacion() == this.codigoHabitacion) {
        reservasHabitacion.add(reserva);

      }
    }
    return reservasHabitacion;
  }

  @Override
  public String toString() {
    return
        "Código Habitación: " + codigoHabitacion +
        ", Planta=" + planta +
        ", Número de Habitación: " + numeroHabitacion +
        ", Tipo de Habitación: " + tipoHabitacion +
        ", Precio: " + precio +
        ", Descuento para Empleado: " + descuentoEmpleado +
        ", Código de Reserva: " + codigoReserva ;
  }
}