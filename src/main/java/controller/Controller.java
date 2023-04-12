package controller;

import model.Hotel;
import view.PanelHotel;

public class Controller {
    Hotel hotel = new Hotel("HotelTCP");
    PanelHotel panelHotel = new PanelHotel(hotel);

    DiasController diasController = new DiasController(2);
    Thread diascontrollerThread = new Thread((Runnable) panelHotel);
    Thread





}
