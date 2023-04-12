package controller;

import model.Hotel;

public class DiasController implements Runnable {
    private int sleep;

    public DiasController(int sleep) {
        this.sleep = sleep;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2000; i++) {
            try {
                Thread.sleep(sleep * 2000);
                //panelHotel.actualizar();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
