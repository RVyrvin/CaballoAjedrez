package org.iesalandalus.programacion.caballoajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
	
	boolean repeat = true;
	Caballo caballo = new Caballo();
	
	public static void main(String[] args) {
		System.out.println("Programa para aprender a colocar y mover un caballo en el tablero de ajedrez");
						
		MainApp ma = new MainApp();
		
		do {
			ma.mostrarMenu();			
		} while (ma.repeat);
	}
	
	/**
	 * eleccion de direccion a donde va caballo
	 * @return direccion de caballo
	 */
	
	public Direccion elegirDireccion() {
		Direccion direccion = null;
		boolean isElejido = false;
		
		do {
			int opcion = elejirOpcion();

			switch (opcion) {
			case 1:
				direccion = Direccion.ARRIBA_IZQUIERDA;
				isElejido = true;
				break;
			case 2:
				direccion = Direccion.ARRIBA_DERECHA;
				isElejido = true;
				break;
			case 3:
				direccion = Direccion.DERECHA_ARRIBA;
				isElejido = true;
				break;
			case 4:
				direccion = Direccion.DERECHA_ABAJO;
				isElejido = true;
				break;
			case 5:
				direccion = Direccion.ABAJO_DERECHA;
				isElejido = true;
				break;
			case 6:
				direccion = Direccion.ABAJO_IZQUIERDA;
				isElejido = true;
				break;
			case 7:
				direccion = Direccion.IZQUIERDA_ARRIBA;
				isElejido = true;
				break;
			case 8:
				direccion = Direccion.IZQUIERDA_ABAJO;
				isElejido = true;
				break;
			default:
				System.out.println("Elige la opción correcta ...");
				break;
			}
			
		} while (!isElejido);

		return direccion;
	}
	
	
	
	/**
	 * muestra menu de direcciónes
	 */
	
	public void mostrarMenuDirecciones() {
		
		System.out.println("");
		System.out.println("--------MENU--DIRECCIONES------");
		System.out.println("                               ");
		System.out.println("1. ARRIBA_IZQUIERDA            ");
		System.out.println("2. ARRIBA_DERECHA              ");
		System.out.println("3. DERECHA_ARRIBA              ");
		System.out.println("4. DERECHA_ABAJO               ");
		System.out.println("5. ABAJO_DERECHA               ");
		System.out.println("6. ABAJO_IZQUIERDA             ");
		System.out.println("7. IZQUIERDA_ARRIBA            ");
		System.out.println("8. IZQUIERDA_ABAJO             ");
		System.out.println("-------------------------------");
	}
	
	
	/**
	 * el metodo que mueve el caballo
	 */
	
	public void mover() {
		
		Direccion direccion;
		mostrarMenuDirecciones();
		direccion = elegirDireccion();
		
		try {
			System.out.println("caballo se ha movido desde posicion...");
			System.out.println(caballo.getPosicion().toString());
			caballo.mover(direccion);
			System.out.println("a ...");
			System.out.println(caballo.getPosicion().toString());
		} catch (OperationNotSupportedException onse) {
			System.out.println("No se ha podido mober el caballo ...\n");
			onse.printStackTrace();
		}		
		
	}
	
	
	/**
	 * devuelve la columna elegida
	 * @return char columna
	 */
	
	public char elegirColumnaInicial() {
		
		char columna = 'b';		
		boolean isElegido = false;
		
		do {
			System.out.println("");
			System.out.println("Elige la columna del caballo, \n1. - b \n2. - g");
			System.out.println("");
			
			int option = elejirOpcion();
			
			if (option == 1) {
				columna = 'b';
				isElegido = true;
			} else if (option == 2) {
				columna = 'g';
				isElegido = true;
			}
			
			if (!isElegido)
				System.out.println("\nElige opción correcta !!!");
			
		} while (!isElegido);		
		
		return columna;
	}
	
	
	/**
	 * Metodo que permite crear el caballo 
	 * con el color y posicion elegidos
	 */
	
	
	public void crearCaballoColorPosicion() {
		Color color = elegirColor();
		char columna = elegirColumnaInicial();
		caballo = new Caballo(color, columna);
		System.out.println(caballo.toString());
	}
	
	
	/**
	 * Medoto que permite elegir el color del caballo
	 * @return color elegido
	 */
	
	public Color elegirColor() {
		
		Color color = null;		
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
			
			if (!isElegido)
				System.out.println("\nElige opción correcta !!!");
			
		} while (!isElegido);
		
		return color;
	}
	
	
	
	/**
	 * Se crea el caballo con el color elegido
	 */
	
	public void crearCaballoDefectoColor() {
		caballo = new Caballo(elegirColor());
		System.out.println(caballo.toString());
	}
	
	
	
	/**
	 * Se crea el caballo con el constructor por defecto
	 */
	public void crearCaballoDefecto() {
		caballo = new Caballo();
		System.out.println(caballo.toString());		
	}
	
	
	/**
	 * metodo que ejecuta la opsion
	 * @param opcion ejelida
	 */
	
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
			System.out.println("");
			crearCaballoColorPosicion();
			System.out.println("Se ha creado el caballo con el color y columna elegidos ...");
			break;
		case 4:
			System.out.println("");
			mover();			
			break;
		case 5:
			repeat = false;
			System.out.println("");
			System.out.println("applicación se ha terminado ...");
			System.out.println("");
			break;
		default:
			System.out.println("La opción entroducida no es correcta ...");
			break;
		}
	}
	
	
	/**	 
	 * metodo que devuelve opción elegida
	 * @return int de opcion
	 */
	public int elejirOpcion() {
		return Entrada.entero();		
	}	
	
	
	/**
	 * El metodo que imprime menu 
	 */
	public void mostrarMenu() {
		
		System.out.println("");
		System.out.println("--------------------------MENU------------------------");
		System.out.println("                                                      ");
		System.out.println("1. Crear Caballo por defecto                          ");
		System.out.println("2. Crear Caballo con color elegido                    ");
		System.out.println("3. Crear Caballo con color y posicion inicial elegidos");
		System.out.println("4. mover                                              ");
		System.out.println("5. salir                                              ");
		System.out.println("------------------------------------------------------");	
		
		ejecutarOpcion(elejirOpcion());
	}
		
}
