package com.mycompany.ajedrez;


public class Peon extends Pieza {
    public Peon(String color, Casilla posicion) {
        super("Peón", color, color.equals("blanco") ? 10 : -10, posicion);
    }
    
    private boolean primerMovimiento = true; // Booleano que determina si un peon se encuentra en su primer movimiento

    @Override
    public boolean movimientoValido(Casilla nuevaPosicion) {
        // Obtiene la posición actual del peon
        Casilla posicionActual = this.getPosicion();
        // Calcula la diferencia en filas y columnas entre la posición actual y la nueva posición
        int diferenciaFila = posicionActual.getY() - nuevaPosicion.getY();
        int diferenciaColumna = Math.abs(posicionActual.getX() - nuevaPosicion.getX());
        // Verifica si el movimiento es válido (cambio en vertical positivo para piezas blancas y negativo para piezas negras) 
        // 1. Si primerMovimiento es true, el cambio puede ser de 2 casillas en vertical.        
        if (this.getColor().equals("blanca")) {
            if (primerMovimiento && diferenciaFila == 2 && diferenciaColumna == 0) {
                primerMovimiento = false;
                return true;
            } // 2. El cambio puede ser en diagonal (en una casilla) si hay una pieza del oponente en esa posición.
            if (diferenciaFila == 1 && diferenciaColumna == 1 && nuevaPosicion.getPieza() != null && !nuevaPosicion.getPieza().getColor().equals(this.getColor())) {
                return true;
            } // 3. Un cambio en Y de una casilla con respecto a la posicion anterior.
            return diferenciaFila == 1 && diferenciaColumna == 0 && nuevaPosicion.getPieza() == null;
        } else { 
            if (primerMovimiento && diferenciaFila == -2 && diferenciaColumna == 0) {
                primerMovimiento = false;
                return true;
            }
            if (diferenciaFila == -1 && diferenciaColumna == 1 && nuevaPosicion.getPieza() != null && !nuevaPosicion.getPieza().getColor().equals(this.getColor())) {
                return true;
            }
            return diferenciaFila == -1 && diferenciaColumna == 0 && nuevaPosicion.getPieza() == null;
        }
    }
}
