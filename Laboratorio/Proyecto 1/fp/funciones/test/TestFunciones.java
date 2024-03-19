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
	}
	
}
