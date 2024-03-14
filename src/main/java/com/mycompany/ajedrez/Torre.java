package com.mycompany.ajedrez;

public class Torre extends Pieza {
    public Torre(String color, Casilla posicion) {
        super("Torre", color, color.equals("blanca") ? 50 : -50, posicion);
    }

    @Override
    public boolean movimientoValido(Casilla nuevaPosicion) {
        // Obtiene la posición actual de la torre
        Casilla posicionActual = this.getPosicion();
        // Verifica si el movimiento es válido (la nueva posición está en la misma fila o columna que la posición anterior)
        return posicionActual.getMismaFila(nuevaPosicion) || posicionActual.getMismaColumna(nuevaPosicion);
    }
}
