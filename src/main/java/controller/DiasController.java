package controller;

import model.Hotel;
import view.PanelHotel;

public class DiasController implements Runnable {
    private PanelHotel panelHotel;


    public DiasController(PanelHotel panelHotel) {
        this.panelHotel = panelHotel;
    }

    @Override
    public void run() {
        do{
            try {
                Thread.sleep( 2000); // OR WAIT
                panelHotel.getHotel().setDia(panelHotel.getHotel().getDia()+1);
                panelHotel.actualizar();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        while(panelHotel.getHotel().isOpen());
    }
}
