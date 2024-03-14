package com.mycompany.ajedrez;

import java.util.List;
import java.util.ArrayList;

public class Tablero {
    String turno; // Atributo que permite determinar quien juega en cada turno
    private Casilla[][] posicion; // Atributo que permite ubicar la posicion de cada casilla dentro de un arreglo bidimensional
    private List<Pieza> piezasCapturadas; // Lista que almacena las piezas que hayan sido capturadas
    private List<String> historialMovimientos; // Lista que almacena los movimientos realizados en la partida

    public Tablero() {
        turno = "Blanco"; // Se inicializa en "Blanco" ya que ese es el color de piezas que siempre tiene el primer turno.
        posicion = new Casilla[8][8];
        piezasCapturadas = new ArrayList<>();
        historialMovimientos = new ArrayList<>();
                
        // Inicializa las casillas del tablero
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 1) {
                    // Fila de peones blancos
                    posicion[i][j] = new Casilla(i, j, new Peon("blanco", posicion[i][j]));
                } else if (i == 6) {
                    // Fila de peones negros
                    posicion[i][j] = new Casilla(i, j, new Peon("negro", posicion[i][j]));
                } else if (i == 0 || i == 7) {
                    // Filas de piezas no peones
                    if (j == 0 || j == 7) {
                        // Torres
                        posicion[i][j] = new Casilla(i, j, new Torre(i == 0 ? "blanca" : "negra", posicion[i][j]));
                    } else if (j == 1 || j == 6) {
                        // Caballos
                        posicion[i][j] = new Casilla(i, j, new Caballo(i == 0 ? "blanco" : "negro", posicion[i][j]));
                    } else if (j == 2 || j == 5) {
                        // Alfiles
                        posicion[i][j] = new Casilla(i, j, new Alfil(i == 0 ? "blanco" : "negro", posicion[i][j]));
                    } else if (j == 3) {
                        // Reinas
                        posicion[i][j] = new Casilla(i, j, new Reina(i == 0 ? "blanca" : "negra", posicion[i][j]));
                    } else if (j == 4) {
                        // Reyes
                        posicion[i][j] = new Casilla(i, j, new Rey(i == 0 ? "blanco" : "negro", posicion[i][j]));
                    }
                } else {
                    // Casillas vacías
                    posicion[i][j] = new Casilla(i, j, null);
                }
            }
        }
    }
    
    public void moverPieza(Pieza pieza, Casilla nuevaPosicion) {
    // Obtiene la posición actual de la pieza
    Casilla posicionActual = pieza.getPosicion();
    // Verifica si el movimiento es válido y si es el turno del jugador correcto
    if (pieza.movimientoValido(nuevaPosicion) && pieza.getColor().equals(turno)) {
        if (nuevaPosicion.getPieza() != null) {
            // Captura la pieza
            piezasCapturadas.add(nuevaPosicion.getPieza());
            nuevaPosicion.getPieza().setCapturada(true);
        }
        // Mueve la pieza a la nueva posición
        posicionActual.setPieza(null);
        nuevaPosicion.setPieza(pieza);
        pieza.setPosicion(nuevaPosicion);
        // Verifica si hay una pieza en la nueva posición        
        // Agrega el movimiento al historial
        historialMovimientos.add(pieza.getNombre() + " " + pieza.getColor() + " se movió a " + nuevaPosicion.toString());
        // Cambia el turno al otro jugador
        turno = turno.equals("blanco") ? "negro" : "blanco";
    } else {
        // Imprime un mensaje de error si el movimiento no es válido o no es el turno del jugador correcto
        System.out.println("Movimiento no válido o no es tu turno");
    }
}
    
    public boolean verificarJaque(String color) {
    Casilla posicionRey = null;
    // Recorre todas las casillas del tablero
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            // Obtiene la pieza en la casilla actual
            Pieza pieza = posicion[i][j].getPieza();
            // Si la pieza es un rey del color correcto, guarda su posición
            if (pieza != null && pieza.getNombre().equals("rey") && pieza.getColor().equals(color)) {
                posicionRey = posicion[i][j];
                // Rompe el bucle interno
                break;
            }
        }
        // Si encontramos al rey, rompe el bucle externo
        if (posicionRey != null) {
            break;
        }
    }
    // Recorre todas las casillas del tablero de nuevo
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            // Obtiene la pieza en la casilla actual
            Pieza pieza = posicion[i][j].getPieza();
            // Si la pieza es del color opuesto y puede moverse a la posición del rey, entonces el rey está en jaque
            if (pieza != null && !pieza.getColor().equals(color) && pieza.movimientoValido(posicionRey)) {
                return true;
            }
        }
    }
    // Si ninguna pieza del color opuesto puede moverse a la posición del rey, entonces el rey no está en jaque
    return false;
}
}
