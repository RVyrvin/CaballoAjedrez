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
