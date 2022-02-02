package paquete;

import java.util.Random;
import java.util.Scanner;

public class Pacman {


public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		byte tamanio;

		do {

			System.out.println("Dime el tamaño del array (entre 3 y 64)");

			tamanio =  Byte.parseByte(sc.nextLine());
			if(tamanio < 4 || tamanio > 64) {System.out.println("Entrada no válida");};

		} while (tamanio < 4 || tamanio > 64);
		char[] tablero = Funciones.arrayMonedas(tamanio);

		byte posPacman = Funciones.colocaPersonaje(tablero, 'ᗧ');

		byte posFantasma = Funciones.colocaPersonaje(tablero, 'ᗣ');

		byte posFantasma2 = Funciones.colocaPersonaje(tablero, 'ᗣ');

		byte monedas = (byte) (tablero.length - 1);

		System.out.println("Monedas: " + monedas);

		System.out.println(Funciones.imprimeArray(tablero));

		char trasElFantasma = '©';
		char trasElFantasma2 = '©';
		do {

			System.out.println("¿Dónde te mueves a | d ?");

			char dondeVoy = sc.nextLine().toLowerCase().charAt(0);

			// Movimiento del pacman

			String paraSplit = Funciones.moverPersonaje(tablero, 'ᗧ',

					posPacman, dondeVoy, ' ');

			String[] posYAntes = paraSplit.split("#");

			posPacman = Byte.parseByte(posYAntes[0]);

			if (posYAntes[1].charAt(0) == '©') {

				monedas--;

			}
			
			//powerUp
			

			// compruebo si pacman ha caido donde el fantasma

			if (posPacman == posFantasma) {

				break;

			}

			// Movimiento 2º fantasma

			String paraSplit2 = Funciones.moverPersonaje(tablero, 'ᗣ',

					posFantasma2, dondeVoy, trasElFantasma2);

			String[] posYAntes2 = paraSplit2.split("#");
			posFantasma2 = Byte.parseByte(posYAntes2[0]);
			if (posYAntes2[1].charAt(0) != '&') {
				trasElFantasma2 = posYAntes2[1].charAt(0);
			} else {
				trasElFantasma2 = trasElFantasma;
				trasElFantasma = 'ᗣ';
			}
	

			// Aleatoriamente

			Random r = new Random();

			char[] movimientos = { 'a', 'd' };

			char dondeVoyFantasma =

					movimientos[r.nextInt(movimientos.length)];

			// Movimiento del fantasma

			paraSplit = Funciones.moverFantasma(tablero, 'ᗣ', posFantasma,

					dondeVoyFantasma, trasElFantasma);

			posYAntes = paraSplit.split("#");

			posFantasma = Byte.parseByte(posYAntes[0]);

			if (posYAntes[1].charAt(0) != '&') {
				trasElFantasma = posYAntes[1].charAt(0);
			} else {
				trasElFantasma = trasElFantasma2;
				trasElFantasma2 = 'ᗣ';
			}

			System.out.println("\nMonedas: " + monedas);

			System.out.println(Funciones.imprimeArray(tablero));

		} while (posPacman != posFantasma && monedas > 0);

		if (posPacman != posFantasma) {

			System.out.println("¡Enhorabuena, has ganado!");

		} else {

			System.out.println("El fantasma te ha comido");

		}

	}
}