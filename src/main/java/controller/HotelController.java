package controller;

import view.PanelHotel;

import java.io.IOException;

public class HotelController implements Runnable {
    private PanelHotel panelHotel;

    public HotelController(PanelHotel panelHotel) {
        this.panelHotel = panelHotel;
    }


    @Override
    public void run() {
        try {
            ProcessBuilder fichero = new ProcessBuilder("\"java\", \"-cp\", \"/home/users/inf/wiam2/a201691ac/IdeaProjects/hotelTCP/src/main/java/org/example/Main\", \"com.controller.HotelController.Main\"");
            Process inicio = fichero.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
