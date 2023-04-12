package controller;

import model.Hotel;
import view.PanelHotel;

public class Controller {

    public void init() {
        Hotel hotel = new Hotel("HotelTCP");
        PanelHotel panelHotel = new PanelHotel(hotel);

        Thread diasContThread = new Thread(new DiasController(panelHotel));
        Thread hotelContThread = new Thread(new HotelController(panelHotel));

        Thread clientesContThread = new Thread(new ClientesController(panelHotel));
        Thread incidenciasContThread = new Thread(new IncidenciasController(2000), String.valueOf(panelHotel));
    }





}
