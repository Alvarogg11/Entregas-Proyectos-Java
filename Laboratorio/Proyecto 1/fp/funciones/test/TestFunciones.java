package fp.funciones.test;
import fp.funciones.Funciones;
import fp.funciones.*;
import java.util.List;
import java.util.ArrayList;

public class TestFunciones {
	public static void main(String[] args) {
		testNumeroPrimo();
		testNumeroCombinatorio();
		testCalculoS();
		testDiferenciasNumeros();
		testCadenaMasLarga();
		testP2(); 
		testC2();
		testS2();
	}
	public static void testNumeroPrimo() {
		System.out.println("Test función 1, Número Primo");
		System.out.println("es "+Integer.toString(5)+" primo? "+Funciones.numeroPrimo(5));
		System.out.println("es "+Integer.toString(2)+" primo? "+Funciones.numeroPrimo(2));
		System.out.println("es "+Integer.toString(8)+" primo? "+Funciones.numeroPrimo(8));
		System.out.println("                        ");
	}
	public static void testNumeroCombinatorio() {
		System.out.println("Test función 2, Número combinatorio");
		System.out.println("El número combinatorio "+Integer.toString(3)+" sobre "+Integer.toString(2)+" es: "+Funciones.numeroCombinatorio(3, 2));
		System.out.println("El número combinatorio "+Integer.toString(7)+" sobre "+Integer.toString(3)+" es: "+Funciones.numeroCombinatorio(7, 3));
		System.out.println("El número combinatorio "+Integer.toString(9)+" sobre "+Integer.toString(5)+" es: "+Funciones.numeroCombinatorio(9, 5));
		System.out.println("                        ");
	
	}
	public static void testCalculoS() {
		System.out.println("Test función 3, cálculo de S");
		System.out.println("El cálculo de la función S para n = 5 y k = 2 es: "+Funciones.calculoS(5, 2));
		System.out.println("El cálculo de la función S para n = 8 y k = 5 es: "+Funciones.calculoS(8, 5));
		System.out.println("El cálculo de la función S para n = 20 y k = 11 es: "+Funciones.calculoS(20, 11));
		System.out.println("                        ");
	
	}
	public static void testDiferenciasNumeros() {
		System.out.println("Test función 4, Diferencias entre números");
		
	    List<Integer> numeros = new ArrayList<>();
	    numeros.add(1);
	    numeros.add(4);
	    numeros.add(7);
	    numeros.add(10);
	    System.out.println("La lista con las diferencias entre cada valor y el anterior es la siguiente: " + Funciones.diferenciasNumeros(numeros));
		System.out.println("                        ");
	
	}
	public static void testCadenaMasLarga() {
		System.out.println("Test función 5, Cadena más larga");
		
	    List<String> listaCadena = new ArrayList<>();
	    listaCadena.add("Ordenador");
	    listaCadena.add("vaso");
	    listaCadena.add("Ingeniería");
	    System.out.println("La cadena más larga es: " +Funciones.cadenaMasLarga(listaCadena));
		System.out.println("                        ");

	}
	//Test de las funciones de la primera defensa
	public static void testP2() { //test función A
		System.out.println("test función P2, productorio:  " +Funciones.P2(7, 5, 1));
	}
	public static void testC2() { // test función B
		System.out.println("test C2: "+Funciones.C2(5, 2)); 
	}
	public static void testS2() { //test función C
		System.out.println("test S2: "+Funciones.S2(5, 2));
	}
}
