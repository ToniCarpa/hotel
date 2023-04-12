package utils.enums;

public enum TipoHabitacion {
    sencilla(1),
    doble(2),
    suite(3);

    private final int tipo;

    private TipoHabitacion(int tipo){
        this.tipo = tipo;
    }
    public int getTipo() {
        return tipo;
    }
}
