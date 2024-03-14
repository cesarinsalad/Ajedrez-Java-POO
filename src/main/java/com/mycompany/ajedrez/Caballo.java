package com.mycompany.ajedrez;

public class Caballo extends Pieza {
    public Caballo(String color, Casilla posicion) {
        super("Caballo", color, color.equals("blanco") ? 30 : -30, posicion);
    }

    @Override
    public boolean movimientoValido(Casilla nuevaPosicion) {
        // Obtiene la posición actual del caballo
        Casilla posicionActual = this.getPosicion();
        // Calcula la diferencia en filas y columnas entre la posición actual y la nueva posición
        int diferenciaFila = Math.abs(posicionActual.getY() - nuevaPosicion.getY());
        int diferenciaColumna = Math.abs(posicionActual.getX() - nuevaPosicion.getX());
        // Verifica si el movimiento es válido (Dos casillas en horizontal y una vertical o dos casillas en vertical y una horizontal)
        return (diferenciaFila == 2 && diferenciaColumna == 1) || (diferenciaFila == 1 && diferenciaColumna == 2);
    }
}
