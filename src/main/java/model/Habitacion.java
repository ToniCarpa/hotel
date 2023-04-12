package model;

import utils.enums.EstadoHabitacion;
import utils.enums.TipoHabitacion;

public class Habitacion implements Comparable<Habitacion>{
    private int numero;
    private EstadoHabitacion disponible;
    private TipoHabitacion tipo;
    private int capacidad;
    private double precioNoche;


    @Override
    public int compareTo(Habitacion o) {
        if (numero < o.numero) {
            return 1;
        }
        if (numero > o.numero) {
            return -1;
        }
        return 0;
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
}
