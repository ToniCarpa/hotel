package controller;

import model.Habitacion;
import model.Hotel;
import utils.Constants;
import utils.TxtFiles;
import view.PanelHotel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HotelController implements Runnable {
    private PanelHotel panelHotel;
    private Hotel hotel;
    private TxtFiles txtFiles;

    public HotelController(PanelHotel panelHotel) {
        this.panelHotel = panelHotel;
    }


    @Override
    public void run() {
        try {
            txtFiles.read(Constants.HAB);

            Habitacion habitacion= new Habitacion(//constructor de la habiotacion);
//añadimos la habitacion
            hotel.setHabitaciones();
                Thread.sleep(500);
            } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }


        Habitacion habitacion = new Habitacion();



        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
