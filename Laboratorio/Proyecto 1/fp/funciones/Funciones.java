package fp.funciones;
import java.util.List;
import java.util.ArrayList;

public class Funciones {
	    
	// FUNCIÓN 1
	public static boolean numero_primo(int n) {
	    if (n <= 1) {
	        return false; // los números menores o iguales a 1 no son primos
	    } else if (n == 2 || n == 3) {
	        return true; // 2 y 3 son primos
	    } else if (n % 2 == 0 || n % 3 == 0) {
	        return false; // los múltiplos de 2 y 3 no son primos
	    }
	    
	    int i = 5;
	    while (i * i <= n) {
	        if (n % i == 0 || n % (i + 2) == 0) {
	            return false; // Si es divisible por i o i + 2, no es primo
	        }
	        i += 6; // Optimización: solo comprobar números de la forma 6k +/- 1
	    }
	    
	    return true;
	}
	
	// FUNCIÓN 2 (primero definimos la función factorial para implementarla en la función que nos piden)
	public static Long factorial(int n) {
	    Long result = 1L;
	    for (int i = 1; i <= n; i++) {
	        result *= i;
	    }
	    return result;
	}
	
	public static Long numero_combinatorio(int n, int k) {
	    if (n < k) {
	    	Integer temp;
	    	temp = k;
	    	k = n;
	    	n=temp;
	    }
        Long num = factorial(n); // n!
        Long den = factorial(k) * factorial(n - k); // k!*(n-k)!
        Long res = num / den;
        return  res;
	}
	
	// FUNCIÓN 3
	public static int calculo_s(int n, int k) {
	    int i = 0;
	    double sumatorio = 0;
	    assert n >= k : "n debe ser mayor o igual que k";
	    assert n >= i : "k debe ser mayor o igual que i";
	    for (i = 0; i < k; i++) {
	        sumatorio += Math.pow(-1, i) * numero_combinatorio(k, i)* Math.pow((k - i), n);
	    }
	    return (int) ((1.0 / factorial(k)) * sumatorio);
	}
	
	// FUNCIÓN 4
	public static List<Integer> diferencias_numeros(List<Integer> numeros_enteros) {
	    List<Integer> lista_diferencias_numeros = new ArrayList<>();
	    for (int i = 1; i < numeros_enteros.size(); i++) {
	        lista_diferencias_numeros.add(numeros_enteros.get(i) - numeros_enteros.get(i - 1));
	    }
	    return lista_diferencias_numeros;
	}
	
	// FUNCIÓN 5
	public static String cadena_mas_larga(List<String> lista_cadena) {
	    String maxZ = null;
	    for (String z : lista_cadena) {
	        if (maxZ == null || z.length() > maxZ.length()) {
	            maxZ = z;
	        }
	    }
	    return maxZ;
	}
	    
}
