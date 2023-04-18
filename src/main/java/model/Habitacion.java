package model;

import utils.enums.EstadoHabitacion;
import utils.enums.TipoHabitacion;

import java.util.Objects;

public class Habitacion implements Comparable<Habitacion>{
    private int numero;
    private EstadoHabitacion disponible;
    private TipoHabitacion tipo;
    private int capacidad;
    private double precioNoche;

    public Habitacion(int numero, EstadoHabitacion disponible, int tipo, int capacidad, double precioNoche) {
    }

    public Habitacion(int numero, EstadoHabitacion disponible, TipoHabitacion tipo, int capacidad, double precioNoche) {
        this.numero = numero;
        this.disponible = disponible;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.precioNoche = precioNoche;
    }

    @Override
    public int compareTo(Habitacion o) {
       return numero - o.numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Habitacion that = (Habitacion) o;
        return numero == that.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    public int getNumero() {
        return numero;
    }
    public EstadoHabitacion getDisponible() {
        return disponible;
    }
    public int getTipo() {
        return tipo.getTipo();
    }
    public int getCapacidad() {
        return capacidad;
    }
    public double getPrecioNoche() {
        return precioNoche;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    public void setDisponible(EstadoHabitacion disponible) {
        this.disponible = disponible;
    }
    public void setTipo(TipoHabitacion tipo) {
        this.tipo = tipo;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    public void setPrecioNoche(double precioNoche) {
        this.precioNoche = precioNoche;
    }
}
