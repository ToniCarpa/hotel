package controller;

import model.Habitacion;
import model.Hotel;
import utils.Constants;
import utils.enums.EstadoHabitacion;
import view.PanelHotel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class IncidenciasController implements Runnable {
    private PanelHotel panelHotel;
    private Hotel hotel;


    public IncidenciasController(PanelHotel panelHotel) {
        this.panelHotel = panelHotel;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader(Constants.IN))) {
            String linea;
            Set<Habitacion> hab = hotel.getHabitaciones();
            Iterator<Habitacion> it = hab.iterator();

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String letra = datos[0];
                String tiempo = datos[1];
                String num = datos[2];
                String n = String.valueOf(num.charAt(0));

                Thread.sleep(Long.parseLong(tiempo));

                if (letra.equals("P")) {
                    while (it.hasNext()) {
                        String x = String.valueOf(it.next().getNumero());
                        String l = String.valueOf(x.charAt(0));
                        if (l.equals(n)) {
                            it.next().setDisponible(EstadoHabitacion.AVERIADA);
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        String x = String.valueOf(it.next().getNumero());
                        if(x.equals(num)){
                            it.next().setDisponible(EstadoHabitacion.AVERIADA);
                        }
                    }
                }
            }
                Thread.sleep(500);
            } catch(IOException e){
                throw new RuntimeException(e);
            } catch(InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }