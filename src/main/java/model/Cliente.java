package model;

import utils.enums.TipoHabitacion;
import view.PanelHotel;

public class Cliente implements Runnable{
    private int id;
    private String nombre;
    private int personas;
    private TipoHabitacion tipoHabitacion;
    private int dias;
    private PanelHotel panelHotel;


    @Override
    public void run() {

    }
}
