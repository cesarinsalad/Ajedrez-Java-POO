package com.mycompany.ajedrez;

public class Casilla { 
    // Atributo que representa la pieza ubicada en una casilla
    private Pieza pieza; 
    // Coordenada x de la casilla (Columnas)
    private int x; 
    // Coordenada y de la casilla (Filas)
    private int y; 
  
    // Constructor de la clase Posicion
    public Casilla(int x, int y, Pieza pieza) 
    { 
        // Establece la pieza ubicada en la casilla
        this.setPieza(pieza); 
        // Establece la coordenada x de la casilla
        this.setX(x); 
        // Establece la coordenada y de la casilla
        this.setY(y); 
    } 
  
    // Método para obtener la pieza una casilla
    public Pieza getPieza() 
    { 
        return this.pieza; 
    } 
  
    // Método para establecer la pieza en una casilla
    public void setPieza(Pieza p) 
    { 
        this.pieza = p; 
    } 
  
    // Método para obtener la coordenada x de la casilla
    public int getX() 
    { 
        return this.x; 
    } 
  
    // Método para establecer la coordenada x de la casilla
    public void setX(int x) 
    { 
        this.x = x; 
    } 
  
    // Método para obtener la coordenada y de la casilla
    public int getY() 
    { 
        return this.y; 
    } 
  
    // Método para establecer la coordenada y de la casilla
    public void setY(int y) 
    { 
        this.y = y; 
    } 
    
     public boolean getMismaFila(Casilla otraCasilla) {
        // Devuelve true si la nueva posicion de una pieza está en la misma columna
        return this.x == otraCasilla.x;
    }

    public boolean getMismaColumna(Casilla otraCasilla) {
        // Devuelve true si la nueva posicion de una pieza está en la misma fila
        return this.y == otraCasilla.y;
    }
} 