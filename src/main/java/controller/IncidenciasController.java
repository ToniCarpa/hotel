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
import java.util.TreeSet;

public class IncidenciasController implements Runnable {
    private PanelHotel panelHotel;

    public IncidenciasController(PanelHotel panelHotel) {
        this.panelHotel = panelHotel;
    }

    //P 200 101
    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader(Constants.IN))) {
            String linea;
            TreeSet<Habitacion> hab = (TreeSet<Habitacion>) panelHotel.getHotel().getHabitaciones();

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(" ");
                String letra = datos[0];

                Thread.sleep(Long.parseLong(datos[1]));

                switch (letra) {
                    case "P":
                        for (Habitacion h : hab) {
                            if (Integer.parseInt(datos[2]) / 100 == (h.getNumero()) / 100) {
                                h.setDisponible(EstadoHabitacion.AVERIADA);
                            }
                        }
                        break;
                    case "A":
                        for (Habitacion h : hab) {
                            if (Integer.parseInt(datos[2]) == (h.getNumero())) {
                                h.setDisponible(EstadoHabitacion.AVERIADA);
                            }
                        }
                        break;
                }
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }



                /*
                while (it.hasNext()) {
                        String x = String.valueOf(it.next().getNumero());
                        String l = String.valueOf(x.charAt(0));
                        if (l.equals(n)) {
                           it.forEachRemaining(habitacion -> habitacion.setDisponible(EstadoHabitacion.AVERIADA));
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        String y = String.valueOf(it.next().getNumero());
                        if(y.equals(num)){
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

                 */
    }
}