package com.mycompany.ajedrez;

public class Alfil extends Pieza {
    public Alfil(String color, Casilla posicion) {
        super("Alfil", color, color.equals("blanco") ? 30 : -30, posicion);
    }

    @Override
    public boolean movimientoValido(Casilla nuevaPosicion) {
        // Obtiene la posición actual del alfil
        Casilla posicionActual = this.getPosicion();
        // Verifica si el movimiento es válido (la nueva posición está en la misma diagonal de la anterior posición)
        return Math.abs(posicionActual.getY() - nuevaPosicion.getY()) == Math.abs(posicionActual.getX() - nuevaPosicion.getX());
    }
}
