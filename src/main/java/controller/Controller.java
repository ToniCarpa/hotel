package controller;

import model.Hotel;
import view.PanelHotel;

public class Controller {
    private static Controller controller;

    public static Controller getInstance() {
        if(controller == null){
            controller = new Controller();
        }
        return controller;
    }

    private Controller() {
    }

    public void init() {
        try {
            Hotel hotel = new Hotel("HotelTCP");
            PanelHotel panelHotel = new PanelHotel(hotel);

            Thread diasContThread = new Thread(new DiasController(panelHotel));
            diasContThread.sleep(2000);
            Thread hotelContThread = new Thread(new HotelController(panelHotel));
            hotelContThread.sleep(2000);
            Thread clientesContThread = new Thread(new ClientesController(panelHotel));
            clientesContThread.sleep(2000);
            Thread incidenciasContThread = new Thread(new IncidenciasController(panelHotel));
            incidenciasContThread.sleep(2000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
