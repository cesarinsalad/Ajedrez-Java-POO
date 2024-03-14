package com.mycompany.ajedrez;

public class Rey extends Pieza {
    public Rey(String color, Casilla posicion) {
        super(color, "rey", color.equals("blanco") ? 900 : -900, posicion);
    }

    @Override
    public boolean movimientoValido(Casilla nuevaPosicion) {
        // Obtiene la posición actual del rey
        Casilla posicionActual = this.getPosicion();
        // Calcula la diferencia en filas y columnas entre la posición actual y la nueva posición
        int diferenciaFila = Math.abs(posicionActual.getY() - nuevaPosicion.getY());
        int diferenciaColumna = Math.abs(posicionActual.getX() - nuevaPosicion.getX());
        // Verifica si el movimiento es válido (a una casilla de distancia desde la posición anterior, en cualquier dirección)
        return diferenciaFila <= 1 && diferenciaColumna <= 1;
    }
}
