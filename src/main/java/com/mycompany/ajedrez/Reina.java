package com.mycompany.ajedrez;

public class Reina extends Pieza {
    public Reina(String color, Casilla posicion) {
        super("Reina", color, color.equals("blanca") ? 90 : -90, posicion);
    }

    @Override
    public boolean movimientoValido(Casilla nuevaPosicion) {
        // Obtiene la posición actual de la reina
        Casilla posicionActual = this.getPosicion();
        // Verifica si el movimiento es válido (en línea recta en horizontal, vertical o diagonal)
        return posicionActual.getMismaFila(nuevaPosicion) || posicionActual.getMismaColumna(nuevaPosicion) || 
               Math.abs(posicionActual.getY() - nuevaPosicion.getY()) == Math.abs(posicionActual.getX() - nuevaPosicion.getX());
    }
}