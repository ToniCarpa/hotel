package model;

import controller.ClientesController;
import utils.Constants;
import utils.enums.EstadoHabitacion;
import utils.enums.TipoHabitacion;
import view.PanelHotel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Cliente implements Runnable {
    private int id;
    private String nombre;
    private int personas;
    private TipoHabitacion tipoHabitacion;
    private int dias;
    private PanelHotel panelHotel;


    public Cliente(int id, String nombre, int personas, TipoHabitacion tipoHabitacion, int dias, PanelHotel panelHotel) {
        this.id = id;
        this.nombre = nombre;
        this.personas = personas;
        this.tipoHabitacion = tipoHabitacion;
        this.dias = dias;
        this.panelHotel = panelHotel;
    }

    public Cliente() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPersonas() {
        return personas;
    }

    public void setPersonas(int personas) {
        this.personas = personas;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    TreeSet<Habitacion> hab = (TreeSet<Habitacion>) panelHotel.getHotel().getHabitaciones();


    private synchronized Habitacion getHab() {
        Habitacion habitacion = null;
        for (Habitacion h : hab) {
            if (this.getTipoHabitacion().equals(h.getTipo()) && this.getPersonas() <= h.getCapacidad()) {
                h.setDisponible(EstadoHabitacion.OCUPADA);
                panelHotel.getHotel().setDinero(panelHotel.getHotel().getDinero() + (h.getPrecioNoche() * this.getDias()));
                habitacion = h;
            }
        }
        return habitacion;
    }


    @Override
    public void run() {
        try {
            if (getHab() != null) {
                for (int i = 0; i <= this.getDias(); i++) {
                    Thread.sleep(2000);

                    for (Habitacion h : hab) {
                        if (h.getDisponible() == (EstadoHabitacion.AVERIADA)) {
                            if (getHab() == null) {
                                panelHotel.getHotel().setPersonasPerdidas(panelHotel.getHotel().getPersonasPerdidas() + 1);
                                panelHotel.getHotel().setDinero(panelHotel.getHotel().getDinero() - 1000);
                            }
                        }
                        h.setDisponible(EstadoHabitacion.DISPONIBLE);
                    }
                }
            } else {
                panelHotel.getHotel().setPersonasPerdidas(panelHotel.getHotel().getPersonasPerdidas() + 1);
                panelHotel.getHotel().setDinero(panelHotel.getHotel().getDinero() - 1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
