package model;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Hotel {
    private String nombre;
    private Set<Habitacion> habitaciones;
    private List<Tecnico> tecnicos;
    private double dinero;
    private int dia;
    private int personasPerdidas;
    private boolean open;


    public Hotel(String nombre) {
        this.nombre = "HotelTCP";
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(Set<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public List<Tecnico> getTecnicos() {
        return tecnicos;
    }

    public void setTecnicos(List<Tecnico> tecnicos) {
        this.tecnicos = tecnicos;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getPersonasPerdidas() {
        return personasPerdidas;
    }

    public void setPersonasPerdidas(int personasPerdidas) {
        this.personasPerdidas = personasPerdidas;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return habitaciones.equals(hotel.habitaciones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(habitaciones);
    }
}
