package controller;

import model.Cliente;
import utils.Constants;
import utils.enums.TipoHabitacion;
import view.PanelHotel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ClientesController implements Runnable {
    private PanelHotel panelHotel;

    //101 Ana 2,2 Sencilla 5
    public ClientesController(PanelHotel panelHotel) {
        this.panelHotel = panelHotel;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader(Constants.CLI))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                int id = Integer.parseInt(datos[0]);
                String nom = datos[1];
                TipoHabitacion tipo = TipoHabitacion.valueOf(datos[3]);
                int dias = Integer.parseInt(datos[4]);

                int numHab = datos[2].length();
                String[] habXpers = datos[2].split(",");

                for (int i = 0; i < numHab; i++) {
                    for (int j = 0; j < habXpers.length; j++) {
                        int numPers = Integer.parseInt(habXpers[j]);
                        Thread t = new Thread(new Cliente(id, nom, numPers, tipo, dias));
                        t.sleep(500);
                    }
                }
            }
        } catch (
                IOException e) {
            System.err.format("Error de E/S: %s%n", e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
