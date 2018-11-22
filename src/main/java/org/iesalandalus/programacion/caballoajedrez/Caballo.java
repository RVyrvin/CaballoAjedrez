package org.iesalandalus.programacion.caballoajedrez;

public class Caballo {
	
	private Color color;
	private Posicion posicion;
	
	
	public Caballo() {
		color = color.NEGRO;
		posicion = new Posicion();
		posicion.setFila(8);
		posicion.setColumna('b');
	}
	
	
	public Caballo(Color color) {
		if (color == null)
			throw new IllegalArgumentException("ERROR: No se puede asignar un color nulo.");
		
		this.color = color;
		Posicion posicion = new Posicion();
		if (this.color == Color.BLANCO) {
			posicion.setFila(1);
			posicion.setColumna('b');
		}else {
			posicion.setFila(8);
			posicion.setColumna('b');
		}
		this.posicion = posicion;
	}
	
	
	public Color getColor() {
		return color;
	}
	
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	
	public Posicion getPosicion() {
		return posicion;
	}
	
	
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	

}
