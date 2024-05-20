package banco;
import java.util.Map.Entry;

import banco.Questions.Info2;

public class TestQuestions {

	public static void main(String[] args) {
		testVencimientoDePrestamosDeCliente();
		testClienteConMasPrestamos();
		testCantidadPrestamosPmpledado();
		testEmpleadoMasLongevo();
		testRangoDeIntereseDePrestamos();
		testNumPrestamosPorMesAño();
	}
	
	public static void testVencimientoDePrestamosDeCliente() {
		Banco b =Banco.of();
		String dni="64482505G";
		System.out.println("TEST VECIMIENTO DE PRESTAMOS DE CLIENTE");
		System.out.println("\t Los prestamos del cliente con dni "+dni+" vencen: "+
							Questions.vencimientoDePrestamosDeCliente(b, dni));
	}
	public static void testClienteConMasPrestamos() {
		Banco b =Banco.of();
		System.out.println("TEST CLIENTE CON MÁS PRESTAMOS");
		System.out.println("\t El cliente con mas prestamos es: "+
							Questions.clienteConMasPrestamos(b));
	}
	public static void testCantidadPrestamosPmpledado() {
		Banco b =Banco.of();
		String dni="64482505G";
		System.out.println("TEST CANTIDAD DE PRESTAMOS DE EMPLEADO");
		System.out.println("\t La cantidad de prestamos del empleado con dni "+dni+" es: "+
							Questions.cantidadPrestamosPmpledado(b, dni));
	}
	public static void testEmpleadoMasLongevo() {
		Banco b =Banco.of();
		System.out.println("TEST EMPLEADO MÁS LONGEVO");
		System.out.println("\t El empleado mas longevo es: "+
							Questions.empleadoMasLongevo(b));
	}
	public static void testRangoDeIntereseDePrestamos() {
		Banco b =Banco.of();
		System.out.println("TEST RANGO INTERES DE PRESTAMOS");
		System.out.println("\t El rango de interes de los prestamos del banco es: "+
							Questions.rangoDeIntereseDePrestamos(b));
	}
	public static void testNumPrestamosPorMesAño() {
		Banco b =Banco.of();
		System.out.println("TEST NÚMERO DE PRESTAMOS POR MES AÑO");
		System.out.println("\t El numero de prestamos por cada par mes-año es: ");
		for(Entry<Info2,Integer> parMesAñoNum:Questions.numPrestamosPorMesAño(b).entrySet()){
			System.out.println("\t En el par mes-año: "+parMesAñoNum.getKey()+
					" el número de prestamos fue: "+parMesAñoNum.getValue());
		}
	}

}
