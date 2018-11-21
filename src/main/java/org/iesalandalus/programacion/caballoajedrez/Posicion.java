package org.iesalandalus.programacion.caballoajedrez;

public class Posicion {
	
	private int fila;
	private char columna;	
	
	
	public Posicion () {
		this.fila = 1;
		this.columna= 'a';
	}
	
	
	public Posicion(int fila, char columna) {
		
		this.setFila(fila);
		this.setColumna(columna);
	}
	

	public int getFila() {
		return fila;
	}
	
	
	public void setFila(int fila) {
		if (fila >= 1 && fila <= 8)
			this.fila = fila;
		else 
			throw new IllegalArgumentException("ERROR: Fila no válida.");
	}
	
	
	public char getColumna() {
		return columna;
	}
	
	
	public void setColumna(char columna) {
		if ( columna >= 'a' && columna <= 'h')
			this.columna = columna;
		else
			throw new IllegalArgumentException("ERROR: Columna no válida.");
	}	

}
