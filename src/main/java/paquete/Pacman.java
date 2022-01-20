package paquete;

import java.util.Scanner;

public class Pacman {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		byte tamanio;
		do {
			System.out.println("Dime el tamaño del array (entre 3 y 64)");
			tamanio=Byte.parseByte(sc.nextLine());
		}while(tamanio<3||tamanio>64);

		char[] tablero=Funciones.arrayMonedas(tamanio);
		
		byte posPacman=Funciones.colocaPersonaje(tablero,'ᗧ');
		byte posFantasma=Funciones.colocaPersonaje(tablero,'ᗣ');
		byte monedas=(byte)(tablero.length-2);
		
		System.out.println("Monedas: "+monedas);
		System.out.println(Funciones.imprimeArray(tablero));
		
		do {
			System.out.println("¿Dónde te mueves a | d ?");
			char dondeVoy=sc.nextLine().toLowerCase().charAt(0);
			
			tablero[posPacman]=' ';
			switch(dondeVoy) {
			case 'a':
				posPacman--;
			break;
			case 'd':
				posPacman++;
			break;
			default:
				System.out.println("Entrada no válida");
			}
			if(tablero[posPacman]=='©') {
				monedas--;
			}
			tablero[posPacman]='ᗧ';
			
			System.out.println("\nMonedas: "+monedas);
			System.out.println(Funciones.imprimeArray(tablero));
		}while(posPacman!=posFantasma&&monedas>0);
		
		
		if(posPacman!=posFantasma) {
			System.out.println("¡Enhorabuena, has ganado!");
		}else {
			System.out.println("El fantasma te ha comido");
		}
	}

}

