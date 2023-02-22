package CRUD_ARRAY;

import java.util.Scanner;
import java.io.IOException;

public class metodos {
	
	//Se inicializan las variables que se van a usar en el resto de metodos
	private static int tamanoArrays = 5;
	private static String[] titulos = new String[tamanoArrays];
	private static int[] anos = new int[tamanoArrays];;
	private static String[] generos = new String[tamanoArrays];
	
	
	//Comprueba las posiciones libres en los arrays
	public static void comprobarEspacio() {

		int contador = 0;
		boolean comprobarEspacio = true;

		do {

			if (contador == tamanoArrays) {
				comprobarEspacio = false;

			} else if (titulos[contador] == null) {

				comprobarEspacio = false;

			} else {
				contador++;
			}

		} while (comprobarEspacio);

		if (contador == tamanoArrays) {
			System.out.println("[INFO] Todos los registros estan llenos, para añadir un nuevo registro debera eliminar alguno");
		}
		
	}
	
	//Solicita al usuari pulsar Enter para continuar
	public static void pulsaEnter() throws IOException {

		System.out.print("[INFO] Pulsa 'Enter' para continuar...");
		System.in.read();
		System.out.println("");

	}
	
	//Muestra las opciones/funciones disponibles del programa y solicita al usuario que elija una
	public static int elegirOpcion() throws IOException {

		int opcion;

		while (true) {

			do {
				comprobarEspacio();
				mostrarOpciones();

				Scanner input = new Scanner(System.in);
				System.out.print("[INPUT] Selecciona alguna de las opciones disponibles: ");
				opcion = input.nextInt();

				if (opcion < 0 || opcion > 7) {
					System.out.println("[ERROR] Debes introducir un numero entre 0 y 7");
					pulsaEnter();
				}

				System.out.println("");

			} while (opcion < 0 || opcion > 7);

			return opcion;
		}
	}
	
	//Muestra las opciones disponibles
	public static boolean mostrarOpciones() {

		System.out.println("[INFO] Opciones disponibles:");
		System.out.println("[0] Generar contenido automatico");
		System.out.println("[1] Mostrar listado");
		System.out.println("[2] Añadir");
		System.out.println("[3] Modificar");
		System.out.println("[4] Buscar");
		System.out.println("[5] Borrar 1 registro");
		System.out.println("[6] Resetear registros");
		System.out.println("[7] Salir");
		System.out.println("");

		return true;
	}

	//Llena con informacion automatica 4 posiciones de los arrays
	public static boolean generarAutomatico() {
		// TODO Auto-generated method stub

		titulos[0] = "Una noche en la opera";
		titulos[1] = "Indiana Jones y la ultima cruzada";
		titulos[2] = "La lista de Schindler";
		titulos[3] = "Sucedio una noche";

		anos[0] = 1935;
		anos[1] = 1989;
		anos[2] = 1993;
		anos[3] = 1934;

		generos[0] = "Comedia";
		generos[1] = "Aventuras";
		generos[2] = "Drama";
		generos[3] = "Romance";

		System.out.println("[OK] Datos automaticos introducidos");
		System.out.println("");

		return true;
	}

	//Muestra la informacion disponible en los arrays
	public static boolean mostrarListado() {
		// TODO Auto-generated method stub

		System.out.println("[INFO] Listado de peliculas: ");

		for (int i = 0; i < tamanoArrays; ++i) {

			if (titulos[i] != null) {

				System.out.println("[" + (i + 1) + "] " + titulos[i] + " - (" + anos[i] + ") - " + generos[i]);
			}

			else {
				System.out.println("[" + (i + 1) + "] VACIO");
			}
		}

		System.out.println("");
		return true;
	}

	//Anade un elemento a los arrays
	public static void anadirElemento() {
		// TODO Auto-generated method stub

		int posicionVacia = -1;
		boolean buscarVacio = true;
		int contador = 0;
		String titulo;
		int ano;
		String genero;

		do {

			if (contador == tamanoArrays) {
				System.out.println(
						"[ERROR] No quedan posiciones vacias, debe borar algun registro antes de poder añadir otro");
				buscarVacio = false;
			}

			else if (titulos[contador] == null) {

				Scanner input = new Scanner(System.in);

				System.out.print("[INPUT] Introduce un titulo: ");
				titulo = input.next();

				System.out.print("[INPUT] Introduce el ano del titulo: ");
				ano = input.nextInt();

				System.out.print("[INPUT] Introduce el genero del titulo: ");
				genero = input.next();

				posicionVacia = contador;
				titulos[contador] = titulo;
				anos[contador] = ano;
				generos[contador] = genero;
				System.out.println("[OK] Los datos se han registrado correctamente");
				buscarVacio = false;

			} else {
				contador++;
			}

		} while (buscarVacio);
		System.out.println("");

	}

	//Modifica un elemento de los arrays
	public static void modificarElemento() {

		int posicionModificar;
		String nuevoTitulo;
		int nuevoAno;
		String nuevoGenero;

		mostrarListado();

		Scanner input = new Scanner(System.in);
		System.out.print("[INPUT] Que elemento deseas modificar?: ");
		posicionModificar = input.nextInt() - 1;

		if (titulos[posicionModificar] != null) {

			System.out.print("[INPUT] Introduce un titulo: ");
			nuevoTitulo = input.next();

			System.out.print("[INPUT] Introduce el ano del titulo: ");
			nuevoAno = input.nextInt();

			System.out.print("[INPUT] Introduce el genero del titulo: ");
			nuevoGenero = input.next();

			titulos[posicionModificar] = nuevoTitulo;
			anos[posicionModificar] = nuevoAno;
			generos[posicionModificar] = nuevoGenero;

			System.out.println("[OK] Los datos se han registrado correctamente");
			System.out.println("");

		} else {
			System.out.println("[ERROR] No puedes modificar un registro vacio");
			System.out.println("");
		}

	}

	//busca un elemento por tipo de dato
	public static void buscarElemento() {

		int tipoDato;
		String terminos;
		int contadorResultados = 0;

		Scanner input = new Scanner(System.in);
		System.out.println("[INFO] Tipos de datos: ");
		System.out.println("[1] Titulo");
		System.out.println("[2] Ano");
		System.out.println("[3] Genero");

		System.out.print("[INPUT] Por que tipo de dato deseas buscar?: ");
		tipoDato = input.nextInt();

		System.out.print("[INPUT] Introduce los terminos de busqueda: ");
		terminos = input.next().toLowerCase();

		System.out.println("[INFO] Resltados: ");

		switch (tipoDato) {

		case 1:

			for (int i = 0; i < tamanoArrays; i++) {

				if (titulos[i] != null) {

					if (titulos[i].toLowerCase().contains(terminos)) {
						System.out.println("[" + (i + 1) + "] " + titulos[i] + " - (" + anos[i] + ") - " + generos[i]);
						contadorResultados++;
					}
				}
			}

			break;

		case 2:

			for (int i = 0; i < tamanoArrays; i++) {

				if (anos[i] != 0) {

					if (Integer.toString(anos[i]).contains(terminos)) {
						System.out.println("[" + (i + 1) + "] " + titulos[i] + " - (" + anos[i] + ") - " + generos[i]);
						contadorResultados++;
					}
				}
			}

			break;

		case 3:

			for (int i = 0; i < tamanoArrays; i++) {

				if (generos[i] != null) {

					if (generos[i].toLowerCase().contains(terminos)) {
						System.out.println("[" + (i + 1) + "] " + titulos[i] + " - (" + anos[i] + ") - " + generos[i]);
						contadorResultados++;
					}
				}
			}

			break;
		}

		if (contadorResultados == 0) {
			System.out.println("[INFO] No se han encontrado resultados con esos terminos");
		}

		System.out.println("");

	}

	//Borra un elemento de los arrays
	public static void borrarElemento() {

		int posicionBorar;

		mostrarListado();

		Scanner input = new Scanner(System.in);
		System.out.print("[INPUT] Que elemento deseas borrar?: ");
		posicionBorar = input.nextInt() - 1;

		if (titulos[posicionBorar] != null) {

			titulos[posicionBorar] = null;
			anos[posicionBorar] = 0;
			generos[posicionBorar] = null;

			System.out.println("[OK] Los datos se han borrado correctamente");
			System.out.println("");

		} else {

			System.out.println("[ERROR] No puedes borrar un registro vacio");
			System.out.println("");

		}

	}

	//Borra todos los registros de todos los arrays
	public static void resetearRegistros() {

		for (int i = 0; i < tamanoArrays; i++) {

			titulos[i] = null;
			anos[i] = 0;
			generos[i] = null;
		}

		System.out.println("[OK] Los datos se han borrado correctamente");
		System.out.println("");

	}
}
