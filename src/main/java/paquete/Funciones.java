package paquete;

import java.util.Random;
import java.util.Scanner;

public class Funciones {

	public static char[] arrayMonedas(byte tam) {
		
		char[] tablero = new char[tam];
		
		for (byte i = 0; i < tablero.length; i++) {
		 
		 			tablero[i] = '©';
		 
		 		}
		 
		 		return tablero;
		 
		 	}
		 
		 	public static String imprimeArray(char[] arr) {
		 
		 		String ret = "[ ";
		 
		 		for (char el : arr) {
		 
		 			ret += el + " ";
		 
		 		}
		 
		 		return ret + "]";
		 
		 	}
		 
		 	/**
		 	 * 
		 	 * Función que coloca al personaje elegido en una de las posiciones
		 	 * 
		 	 * del array, devuelve la posición en la que se ha colocado el personaje.
		 	 * 
		 	 * @param tablero   array donde se coloca el personaje. La posición elegida
		 	 *                  queda modificada
		 	 * 
		 	 * @param personaje char que representa al personaje que se coloca
		 	 * 
		 	 * @return posición del array en la que se ha colocado el personaje
		 	 * 
		 	 */
		 
		 	public static byte colocaPersonaje(char[] tablero, char personaje) {
		 
		 		Random r = new Random();
		 
		 		byte pos = (byte) r.nextInt(tablero.length);
		 
		 		if (tablero[pos] != '©') {
		 
		 			return colocaPersonaje(tablero, personaje);
		 
		 		}
		 
		 		tablero[pos] = personaje;
		 
		 		return pos;
		 
		 	}
		 
		 	/**
		 	 * 
		 	 * Función que mueve un personaje en un tablero, haciendo
		 	 * 
		 	 * movimiento circular en los casos extremo. Devuelve concatenadas
		 	 * 
		 	 * y separadas por # la nueva posición del personaje y lo que había
		 	 * 
		 	 * anteriormente en la casilla a la que el personaje se ha movido
		 	 * 
		 	 * @param tablero       array en el que los personajes se mueven
		 	 * 
		 	 * @param personaje     representación en char del personaje que se mueve
		 	 * 
		 	 * @param posPersonaje  posición inicial donde se encuentra el personaje
		 	 * 
		 	 * @param direccion     'a' para mover a la izda, o 'd' para la derecha.
		 	 *                      Cualquier otro es no válido.
		 	 * 
		 	 * @param queHabiaAntes elemento que había en posPersonaje antes de que
		 	 *                      personaje llegase ahí, para restaurarlo tras su
		 	 *                      movimiento
		 	 * 
		 	 * @return un String con la nueva posición del personaje y lo que había en la
		 	 *         posición a la que el personaje se ha movido, concatenados y separados
		 	 *         por #
		 	 * 
		 	 */
		 
		 	public static String moverPersonaje(
		 
		 			char[] tablero, char personaje, byte posPersonaje,
		 
		 			char direccion, char queHabiaAntes) {
		 
		 		tablero[posPersonaje] = queHabiaAntes;
		 
		 		switch (direccion) {
		 
		 		case 'a':
		 
		 			if (posPersonaje > 0) {
		 
		 				posPersonaje--;
		 
		 			} else {
		 
		 				posPersonaje = (byte) (tablero.length - 1);
		 
		 			}
		 
		 			break;
		 
		 		case 'd':
		 
		 			if (posPersonaje < tablero.length - 1) {
		 
		 				posPersonaje++;
		 
		 			} else {
		 
		 				posPersonaje = 0;
		 
		 			}
		 
		 			break;
		 
		 		default:
		 
		 			System.out.println("Entrada no válida");
		 
		 		}
		 		
		 		char loQueHay = (tablero[posPersonaje] == 'ᗣ' ? '&' : tablero[posPersonaje]);
		 
		 		tablero[posPersonaje] = personaje;
		 
		 		return posPersonaje + "#" + loQueHay;
		 
		 	}
		 
		 	/**
			 * 
			 * Función que mueve un personaje en un tablero, haciendo
			 * 
			 * movimiento circular en los casos extremo. Devuelve concatenadas
			 * 
			 * y separadas por # la nueva posición del personaje y lo que había
			 * 
			 * anteriormente en la casilla a la que el personaje se ha movido
			 * 
			 * @param tablero       array en el que los personajes se mueven
			 * 
			 * @param personaje     representación en char del personaje que se mueve
			 * 
			 * @param posPersonaje  posición inicial donde se encuentra el personaje
			 * 
			 * @param direccion     'a' para mover a la izda, o 'd' para la derecha.
			 *                      Cualquier otro es no válido.
			 * 
			 * @param queHabiaAntes elemento que había en posPersonaje antes de que
			 *                      personaje llegase ahí, para restaurarlo tras su
			 *                      movimiento
			 * 
			 * @return un String con la nueva posición del personaje y lo que había en la
			 *         posición a la que el personaje se ha movido, concatenados y separados
			 *         por #
			 * 
			 */

			public static String moverFantasma(

					char[] tablero, char personaje, byte posPersonaje,

					char direccion, char queHabiaAntes) {

				tablero[posPersonaje] = queHabiaAntes;

				switch (direccion) {

				case 'a':

					if (posPersonaje > 0) {

						posPersonaje--;

					} else {

						posPersonaje = (byte) (tablero.length - 1);

					}

					break;

				case 'd':

					if (posPersonaje < tablero.length - 1) {

						posPersonaje++;

					} else {

						posPersonaje = 0;

					}

					break;

				default:

					System.out.println("Entrada no válida");

				}

				char loQueHay = tablero[posPersonaje];

				tablero[posPersonaje] = personaje;

				return posPersonaje + "#" + loQueHay;

			}

			public static String imprimeArray1(char[] arr) {
				String ret = "";
				for (char el : arr) {
					ret += el + " ";

				}
				return ret + " ";
			}

			public static String imprimeArray(String[] arr) {
				String ret = "";
				for (String el : arr) {
					ret += el + " ";

				}
				return ret + " ";

			}

			public static String imprimeArray(float[] arr) {
				String ret = "";
				for (float el : arr) {
					ret += el + " ";

				}
				return ret + " ";
			}

			public static String[] creaArrayStrings() {

				Scanner lector = new Scanner(System.in);
				System.out.println("Dime un nemero");
				int h = Integer.parseInt(lector.nextLine());
				String[] arr = new String[h];
				for (int i = 0; i < h; i++) {
					System.out.println("Dime un nombre para esta posicion");
					arr[i] = lector.nextLine();

				}
				return arr;

			}
}

