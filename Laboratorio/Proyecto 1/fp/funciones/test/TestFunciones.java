package fp.funciones.test;
import fp.funciones.Funciones;

public class TestFunciones {
	public static void main(String[] args) {
		testNumeroPrimo();
	}
public static void testNumeroPrimo() {
	System.out.println("es "+Integer.toString(5)+" primo? "+Funciones.numero_primo(5));
	System.out.println("es "+Integer.toString(2)+" primo? "+Funciones.numero_primo(2));
	System.out.println("es "+Integer.toString(8)+" primo? "+Funciones.numero_primo(8));
//en las siguientes funciones es lo mismo que lo anterior pero cambiando el final el 'Funciones.(método) cambiando ese método por el método correspondiente
	}

public static void testNumeroCombinatorio() {
	System.out.println("el número combinatorio "+Integer.toString(3)+" sobre "+Integer.toString(2)+" es: "+Funciones.numero_combinatorio(3, 2));
	}
public static void testCalculoS() {
	System.out.println("calculamos S(n,k) siendo n "+Integer.toString(0));
	}
}
