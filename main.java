package CRUD_ARRAY;

import java.io.IOException;
import java.util.Scanner;


public class main {

	public static void main (String[] args) throws IOException {
		// TODO Auto-generated method stub

		int opcion;
		
		//Se ejecuta el bucle con las opciones disponibles hasta que el usuario cierre el prgograma
		while (true) {
			
			//Se ejecuta el bucle con las opciones disponibles hasta que el usuario escoja un opcion valida
			do {
				metodos.comprobarEspacio();
				metodos.mostrarOpciones();

				Scanner input = new Scanner(System.in);
				System.out.print("[INPUT] Selecciona alguna de las opciones disponibles: ");
				opcion = input.nextInt();

				if (opcion < 0 || opcion > 7) {
					System.out.println("[ERROR] Debes introducir un numero entre 0 y 7");
					metodos.pulsaEnter();
				}

				System.out.println("");

			} while (opcion < 0 || opcion > 7);
			
			//Se ejecuta el metodo correspondiente segun la opcion indicada por el usuario
			switch (opcion) {

			case 0:
				metodos.generarAutomatico();
				metodos.pulsaEnter();
				break;
			case 1:
				metodos.mostrarListado();
				metodos.pulsaEnter();
				break;
			case 2:
				metodos.anadirElemento();
				metodos.pulsaEnter();
				break;
			case 3:
				metodos.modificarElemento();
				metodos.pulsaEnter();
				break;
			case 4:
				metodos.buscarElemento();
				metodos.pulsaEnter();
				break;
			case 5:
				metodos.borrarElemento();
				metodos.pulsaEnter();
				break;
			case 6:
				metodos.resetearRegistros();
				metodos.pulsaEnter();
				break;
			case 7:
				System.out.print("[EXIT] Saliendo del programa...");
				System.exit(0);
				break;
			}
		}
	}
}
