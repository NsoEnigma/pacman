package paquete;

import java.util.Random;

public class Funciones {

	public static char[] arrayMonedas(byte tam) {
		char[] tablero=new char[tam];
		for(byte i=0;i<tablero.length;i++) {
			tablero[i]='©';
		}
		return tablero;
	}
	
	public static String imprimeArray(char[] arr) {
		String ret="[ ";
		for(char el:arr) {
			ret+=el+" ";
		}
		return ret+"]";
	}
	
	/**
	 * Función que coloca al personaje elegido en una de las posiciones
	 * del array, devuelve la posición en la que se ha colocado el personaje.
	 * @param tablero array donde se coloca el personaje. La posición elegida queda modificada
	 * @param personaje char que representa al personaje que se coloca
	 * @return posición del array en la que se ha colocado el personaje
	 */
	public static byte colocaPersonaje(char[] tablero,char personaje) {
		Random r=new Random();
		byte pos=(byte)r.nextInt(tablero.length);
		if(tablero[pos]!='©') {
			return colocaPersonaje(tablero,personaje);
		}
		tablero[pos]=personaje;
		return pos;
	}
	
}
