package org.iesalandalus.programacion.caballoajedrez;

public class Posicion {
	
	private int fila;
	private char columna;	
	
	
	public Posicion(int fila, char columna) {
		
		super();
		
		if (fila < 1 || fila > 8)
			this.fila = fila;
		else 
			throw new IllegalArgumentException("La fila teiene ser ente 1 y 8, inclusive");
		
		if ( columna < 'a' || columna > 'h')
			this.columna = columna;
		else
			throw new IllegalArgumentException("La columna tiene que ser entre 'a' y 'h', inclusive");
	}

	public int getFila() {
		return fila;
	}
	
	public void setFila(int fila) {
		if (fila < 1 || fila > 8)
			this.fila = fila;
		else 
			throw new IllegalArgumentException("La fila teiene ser ente 1 y 8, inclusive");
	}
	
	public char getColumna() {
		return columna;
	}
	
	public void setColumna(char columna) {
		if ( columna < 'a' || columna > 'h')
			this.columna = columna;
		else
			throw new IllegalArgumentException("La columna tiene que ser entre 'a' y 'h', inclusive");
	}	

}
