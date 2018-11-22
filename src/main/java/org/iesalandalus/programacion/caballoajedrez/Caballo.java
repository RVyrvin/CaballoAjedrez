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


	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + MAX_COLUMNA;
		result = prime * result + MAX_FILA;
		result = prime * result + MIN_COLUMNA;
		result = prime * result + MIN_FILA;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((posicion == null) ? 0 : posicion.hashCode());
		return result;
	}
	


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Caballo other = (Caballo) obj;
		if (MAX_COLUMNA != other.MAX_COLUMNA)
			return false;
		if (MAX_FILA != other.MAX_FILA)
			return false;
		if (MIN_COLUMNA != other.MIN_COLUMNA)
			return false;
		if (MIN_FILA != other.MIN_FILA)
			return false;
		if (color != other.color)
			return false;
		if (posicion == null) {
			if (other.posicion != null)
				return false;
		} else if (!posicion.equals(other.posicion))
			return false;
		return true;
	}
	
	
}
