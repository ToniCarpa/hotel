package controller;

import model.Habitacion;
import model.Hotel;
import utils.Constants;
import utils.TxtFiles;
import utils.enums.EstadoHabitacion;
import utils.enums.TipoHabitacion;
import view.PanelHotel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class HotelController implements Runnable {
    private PanelHotel panelHotel;
    private Hotel hotel;

    public HotelController(PanelHotel panelHotel) {
        this.panelHotel = panelHotel;
    }
    //101 Disponible Sencilla 2 50.0

    @Override
    public void run() {
            try (BufferedReader br = new BufferedReader(new FileReader(Constants.HAB))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] datos = linea.split(",");
                    int numero = Integer.parseInt(datos[0]);
                    EstadoHabitacion estado = EstadoHabitacion.valueOf(datos[1]);
                    TipoHabitacion tipo = TipoHabitacion.valueOf(datos[2]);
                    int capacidad = Integer.parseInt(datos[3]);
                    double precio = Double.parseDouble(datos[4]);
                    Habitacion hab = new Habitacion(numero, estado, tipo, capacidad, precio);
                    hotel.getHabitaciones().add(hab);
                    panelHotel.actualizar();
                    Thread.sleep( 500);
                }
            } catch (IOException e) {
                System.err.format("Error de E/S: %s%n", e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
    }

}
