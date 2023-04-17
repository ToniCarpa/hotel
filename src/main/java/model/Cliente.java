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

public class Cliente implements Runnable {
    private int id;
    private String nombre;
    private int personas;
    private TipoHabitacion tipoHabitacion;
    private int dias;
    private PanelHotel panelHotel;
    private Hotel hotel;
    private Habitacion habitacion;


    public Cliente(int id, String nombre, int personas, TipoHabitacion tipoHabitacion, int dias) {
        this.id = id;
        this.nombre = nombre;
        this.personas = personas;
        this.tipoHabitacion = tipoHabitacion;
        this.dias = dias;
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

    private Habitacion buscHab(Cliente cliente) {
        Set<Habitacion> hab = hotel.getHabitaciones();
        Iterator<Habitacion> it = hab.iterator();
        Habitacion h = null;
        while (it.hasNext()) {
            if (cliente.getTipoHabitacion().equals(it.next().getTipo()) &&
                    cliente.getPersonas() == it.next().getCapacidad()) {
                h = new Habitacion(it.next().getNumero(),
                        it.next().getDisponible(), it.next().getTipo(),
                        it.next().getCapacidad(), it.next().getPrecioNoche());
            }
        }
        return h;
    }

    private boolean cliHab(Cliente c) {
        Habitacion h = buscHab(c);
        if (h != null) {
            h.setDisponible(EstadoHabitacion.OCUPADA);
            hotel.setDinero(hotel.getDinero() + h.getPrecioNoche() * c.getDias());
            return true;
        } else {
            hotel.setPersonasPerdidas(hotel.getPersonasPerdidas() + 1);
            hotel.setDinero(hotel.getDinero() - 1000);
        }
        return false;
    }

    private void averHab(Cliente cli) {
        Habitacion h = buscHab(cli);
        for (int i = 0; i < cli.getDias(); i++) {
                if (h.getDisponible().equals(EstadoHabitacion.AVERIADA)) {
                    if (buscHab(cli) == null) {
                        hotel.setPersonasPerdidas(hotel.getPersonasPerdidas() + 1);
                        hotel.setDinero(hotel.getDinero() + h.getPrecioNoche() * cli.getDias());
                    }
                }
            }
        h.setDisponible(EstadoHabitacion.DISPONIBLE);
    }


    @Override
    public void run() {
        try {
            Cliente c = new Cliente();
            if(cliHab(c)) {
                for (int i = 0; i < c.getDias(); i++) {
                    Thread.sleep(2000);
                }
                Thread.sleep(2000);
                averHab(c);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }



    }
