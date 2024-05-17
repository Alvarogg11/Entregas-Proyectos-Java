package banco;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import us.lsi.ejemplos_b1_tipos.Persona;

public class Banco {
	

	private static Banco gestorDeBanco = null;
	private String nombre;
	private Integer codigoPostal;
	private String email;
	private Personas personas;
	private Empleados empleados;
	private Cuentas cuentas;
	private Prestamos prestamos;

	private Banco(String nombre, Integer codigoPostal, String email, Personas personas, Empleados empleados,
			Cuentas cuentas, Prestamos prestamos) {
		super();
		this.nombre = nombre;
		this.codigoPostal = codigoPostal;
		this.email = email;
		this.personas = personas;
		this.empleados = empleados;
		this.cuentas = cuentas;
		this.prestamos = prestamos;
	}

	public static Banco of() {
		String nombre = "Reina Mercedes";
	    Integer codigoPostal = 41012;
	    String email = "bib@us.es";
		String fp = "src/lab/bancos/ficheros_bancos/personas.txt";
		String fe = "src/lab/bancos/ficheros_bancos/empleados.txt";
		String fc = "src/lab/bancos/ficheros_bancos/cuentas.txt";
		String fpt = "src/lab/bancos/ficheros_bancos/prestamos.txt";
		return Banco.of(nombre, codigoPostal, email, fp, fe, fc, fpt);
	}

	public static Banco of(String nombre, Integer codigoPostal, String email, String fp, String fe, String fc,
			String fpt) {
		if (Banco.gestorDeBanco == null) {
			Personas personas = Personas.parse(fp);
			Empleados empleados = Empleados.parse(fe);
			Cuentas cuentas = Cuentas.parse(fc);
			Prestamos prestamos = Prestamos.parse(fpt);
			Banco.gestorDeBanco = new Banco(nombre, codigoPostal, email, personas, empleados, cuentas, prestamos);
		}
		return Banco.gestorDeBanco;
	}

	public Personas personas() {
		return this.personas;
	}

	public Empleados empleados() {
		return this.empleados;
	}

	public Cuentas cuentas() {
		return this.cuentas;
	}

	public Prestamos prestamos() {
		return this.prestamos;
	}

//	Préstamos gestionados por un empleado

	public String nombre() {
		return nombre;
	}

	public Integer codigoPostal() {
		return codigoPostal;
	}

	public String email() {
		return email;
	}

	public Set<Prestamo> prestamosDeEmpleado(String dni) {
		
		return this.prestamos().todos().stream().filter(x->x.dniEmpleado().equals(dni)).collect(Collectors.toSet());
	}

//Préstamos de un cliente

	public Set<Prestamo> prestamosDeCliente(String dni) {
		return this.prestamos().todos().stream().filter(x->x.dniCliente().equals(dni)).collect(Collectors.toSet());
	}
// Empleado más joven
	public Optional<Persona> empleadoMasJoven() {
		return this.empleados().todos().stream().map(x->x.persona()).min(Comparator.comparing(x->x.edad()));
	}
// Número de cuentas de cada cliente
	public Map<String, Integer> numeroDeCuentasDeCliente() {
		return this.cuentas.todas().stream().collect(Collectors.groupingBy(x->Personas.of().personaDni(x.dni()).get().nombreCompleto(),
				Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
	}
	
	public void test() {
		Set<String> dnis = this.personas().dnis();
		Set<String> dniCuentas = 
				this.cuentas().todas().stream()
				.map(c->c.dni())
				.filter(d->dnis.contains(d))
				.collect(Collectors.toSet());
		System.out.println(dniCuentas);
		Set<String> dniEmpleados = 
				this.empleados().todos().stream()
				.map(c->c.dni())
				.filter(d->dnis.contains(d))
				.collect(Collectors.toSet());
		System.out.println(dniEmpleados);
		Set<String> dniPrestamosClientes = 
				this.prestamos().todos().stream()
				.map(c->c.dniCliente())
				.filter(d->dnis.contains(d))
				.collect(Collectors.toSet());
		System.out.println(dniPrestamosClientes);
		Set<String> dniPrestamosEmpleados = 
				this.prestamos().todos().stream()
				.map(c->c.dniEmpleado())
				.filter(d->dnis.contains(d))
				.collect(Collectors.toSet());
		System.out.println(dniPrestamosEmpleados);
	}
	
	public static void main(String[] args) {
		Banco banco = Banco.of();
		banco.test();
		System.out.println("\nNUMERO DE CUENTAS DE CADA CLIENTE:\n");
		for(Entry<String, Integer> k:banco.numeroDeCuentasDeCliente().entrySet()) {
			System.out.println("\t"+k.getKey()+":"+k.getValue());
		}
		System.out.println("\nEMPLEADO MÁS JOVEN:\n");
		System.out.println("\t"+banco.empleadoMasJoven());
		System.out.println("\nPRESTAMOS DE CLIENTE CON DNI: 63068643K\n");
		for(Prestamo p:banco.prestamosDeCliente("63068643K")) {
			System.out.println("\t"+p);
		}
		System.out.println("\nPRESTAMOS DE EMPLEADO CON DNI: 67555772B\n");
		for(Prestamo p:banco.prestamosDeEmpleado("67555772B")) {
			System.out.println("\t"+p);
		}
	}
	
}
