package org.iesalandalus.programacion.caballoajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
	
	boolean repeat = true;
	
	public static void main(String[] args) {
		System.out.println("Programa para aprender a colocar y mover un caballo en el tablero de ajedrez");
						
		MainApp ma = new MainApp();
		
		do {
			ma.mostrarMenu();			
		} while (ma.repeat);
	}
	
	/**
	 * Se crean los diferentes métodos que se indican en el diagrama de clases para 
	 * permitir que el método main nos muestre un menú que nos permitirá 
	 * crear un caballo por defecto, 
	 * crear un caballo de un color, 
	 * crear un caballo de un color en una columna inicial válida, 
	 * mover el caballo y 
	 * salir. D
	 * espués de cada operación se nos 
	 * mostrará el estado actual de nuestro caballo. 
	 * El menú se repetirá mientras no elijamos la opción salir. 
	 * En todo caso se debe validar que todas las entradas al programa son correctas. 
	 * Se ha realizado el commit correspondiente y se han subido todos los cambios al repositorio GetiHub,
	 */
	
	public Color elegirColor() {
		
		Color color = Color.BLANCO;		
		boolean isElegido = false;
		
		do {
			System.out.println("");
			System.out.println("Elige el color del caballo, \n1. - BLANCO \n2. - NEGRO");
			System.out.println("");
			
			int option = elejirOpcion();
			
			if (option == 1) {
				color = Color.BLANCO;
				isElegido = true;
			} else if (option == 2) {
				color = Color.NEGRO;
				isElegido = true;
			}
			
		} while (!isElegido);
		
		return color;
	}
	
	
	public void crearCaballoDefectoColor() {
		Caballo caballo = new Caballo(elegirColor());
		System.out.println(caballo.toString());
	}
	
	
	
	public void crearCaballoDefecto() {
		Caballo caballo = new Caballo();
		System.out.println(caballo.toString());		
	}
	
	
	public void ejecutarOpcion(int opcion) {

		switch (opcion) {
		case 1:			
			System.out.println("");
			crearCaballoDefecto();
			System.out.println("Caballo por defecto se ha creado ...");
			break;
		case 2:			
			System.out.println("");
			crearCaballoDefectoColor();
			System.out.println("Caballo por defecto con el color elegido se ha creado ...");
			break;
		case 3:
			System.out.println("Elejir color ");
			break;
		case 4:
			System.out.println("Crear Cabalo Color Posicion");
			break;
		case 5:
			System.out.println("Elegir columna inicial");
			break;
		case 6:
			System.out.println("mover ");
			break;
		case 7:
			repeat = false;
			System.out.println("");
			System.out.println("applicación se ha terminado");
			System.out.println("");
			break;
		default:
			System.out.println("La opción entroducida no es correcta ...");
			break;
		}
	}
	
	
	public int elejirOpcion() {
		return Entrada.entero();		
	}	
	
	
	public void mostrarMenu() {
		
		System.out.println("");
		System.out.println("----------------MENU--------------");
		System.out.println("                                  ");
		System.out.println("1. Crear Caballo defecto          ");
		System.out.println("2. Crear Caballo defecto Color    ");
		System.out.println("3. Elejir color                   ");
		System.out.println("4. Crear Cabalo Color Posicion    ");
		System.out.println("5. Elegir columna inicial         ");
		System.out.println("6. mover                          ");
		System.out.println("7. salir                          ");
		System.out.println("----------------------------------");	
		
		ejecutarOpcion(elejirOpcion());
	}
		
}
