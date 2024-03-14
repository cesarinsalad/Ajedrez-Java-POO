package com.mycompany.ajedrez;

public abstract class Pieza {
    private String nombre; // Atributo que permite identificar las piezas por su nombre
    private String color; // Atributo que diferencia las piezas por su color
    private Casilla posicion; // Valor de la posición en el tablero de la pieza.
    private boolean capturada; // Atributo que define si una pieza se "come" a otra
    private int valor; // Valor númerico asignado a cada tipo de pieza para determinar su relevancia en el juego;
                       // este valor ayuda al algoritmo del CPU a realizar el movimiento acertado al atacar.
    
    // Constructor de la clase Pieza
    public Pieza(String nombre, String color, int valor, Casilla posicion) {
        this.nombre = nombre;
        this.color = color;
        this.valor = valor;
        this.capturada = false;
        this.posicion = posicion;
    }

    // Método para obtener el nombre de la pieza
    public String getNombre() {
        return this.nombre;
    }

    // Método para obtener el color de la pieza
    public String getColor() {
        return this.color;
    }

    // Método para verificar si la pieza ha sido capturada
    public boolean isCapturada() {
        return this.capturada;
    }

    // Método para establecer si la pieza ha sido capturada
    public void setCapturada(boolean capturada) {
        this.capturada = capturada;
    }

    // Método para obtener el valor de la pieza
    public int getValor() {
        return this.valor;
    }
    
    // Método para obtener la posición de la pieza
    public Casilla getPosicion() {
        return this.posicion;
    }

    // Método para establecer la posición de la pieza
    public void setPosicion(Casilla nuevaPosicion) {
        this.posicion = nuevaPosicion;
    }

    // Método abstracto para verificar si un movimiento es válido, es único y debe ser implementado para cada tipo de pieza
    public abstract boolean movimientoValido(Casilla nuevaPosicion);
    
        @Override
    public String toString() {
        return nombre + " " + color + " en " + posicion.toString();
    }
}
