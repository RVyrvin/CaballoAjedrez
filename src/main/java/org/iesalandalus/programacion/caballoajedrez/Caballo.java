package org.iesalandalus.programacion.caballoajedrez;

import javax.naming.OperationNotSupportedException;

public class Caballo {
	
	private Color color;
	private Posicion posicion;
	
	private int MIN_FILA = 1;
	private int MAX_FILA = 8;
	private char MIN_COLUMNA = 'a';
	private char MAX_COLUMNA = 'h';
	
	
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
	
	
	public Caballo (Color color, char columna) {
		if (color == null)
			throw new IllegalArgumentException("ERROR: No se puede asignar un color nulo.");	
		
		Posicion posicion = new Posicion();
		
		if (columna == 'b' || columna == 'g') {	
			
			if (color == Color.BLANCO)
				posicion.setFila(1);
			if (color == Color.NEGRO)
				posicion.setFila(8);
			
			posicion.setColumna(columna);
			
		} else {
			throw new IllegalArgumentException("ERROR: Columna inicial no válida.");
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
	
	
	public void mover(Direccion direccion) throws OperationNotSupportedException {		
		
		int curFila;
		char curColumna;
		
		curFila = this.posicion.getFila();
		curColumna = this.posicion.getColumna();
		
		switch (direccion) {
		
		case ABAJO_IZQUIERDA:
			
			curFila--;
			curFila--;
			curColumna--;
			
			if (curFila < MIN_FILA || curColumna < MIN_COLUMNA) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");				
			} else {
				this.posicion.setFila(curFila);
				this.posicion.setColumna(curColumna);
			}			
		break;
		
		case ABAJO_DERECHA:
			
			curFila--;
			curFila--;
			curColumna++;
			
			if (curFila < MIN_FILA || curColumna > MAX_COLUMNA) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");				
			} else {
				this.posicion.setFila(curFila);
				this.posicion.setColumna(curColumna);
			}			
		break;
		
		case ARRIBA_IZQUIERDA:
			
			curFila++;
			curFila++;
			curColumna--;
			
			if (curFila > MAX_FILA || curColumna < MIN_COLUMNA) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");				
			} else {
				this.posicion.setFila(curFila);
				this.posicion.setColumna(curColumna);
			}			
		break;
		
		case ARRIBA_DERECHA:
			
			curFila++;
			curFila++;
			curColumna++;
			
			if (curFila > MAX_FILA || curColumna > MAX_COLUMNA) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");				
			} else {
				this.posicion.setFila(curFila);
				this.posicion.setColumna(curColumna);
			}			
		break;
		
		case DERECHA_ABAJO:
			
			curFila--;
			curColumna++;
			curColumna++;
			
			if (curFila < MIN_FILA || curColumna > MAX_COLUMNA) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");				
			} else {
				this.posicion.setFila(curFila);
				this.posicion.setColumna(curColumna);
			}			
		break;
		
		case DERECHA_ARRIBA:
			
			curFila++;
			curColumna++;
			curColumna++;
			
			if (curFila > MAX_FILA || curColumna > MAX_COLUMNA) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");				
			} else {
				this.posicion.setFila(curFila);
				this.posicion.setColumna(curColumna);
			}			
		break;
		
		case IZQUIERDA_ABAJO:
			
			curFila--;
			curColumna--;
			curColumna--;
			
			if (curFila < MIN_FILA || curColumna < MIN_COLUMNA) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");				
			} else {
				this.posicion.setFila(curFila);
				this.posicion.setColumna(curColumna);
			}			
		break;
		
		case IZQUIERDA_ARRIBA:
			
			curFila++;
			curColumna--;
			curColumna--;
			
			if (curFila > MAX_FILA || curColumna < MIN_COLUMNA) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");				
			} else {
				this.posicion.setFila(curFila);
				this.posicion.setColumna(curColumna);
			}			
		break;		
		
		default:
			System.out.println("mal dirección");
			break;			
		
		}
		
	}
	

}
