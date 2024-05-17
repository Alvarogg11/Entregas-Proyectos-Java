package banco;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import us.lsi.ejemplos_b1_tipos.Persona;

public class Questions {

	//	Vencimiento de los prestamos de un cliente
	public static Set<LocalDate> vencimientoDePrestamosDeCliente(Banco banco,String dni) {
		Set<LocalDate> res = new HashSet<LocalDate>();
		Set<Prestamo> prestamos=banco.prestamosDeCliente(dni);
		for(Prestamo p:prestamos) {
			res.add(p.fechaVencimiento());
		}
		return res;
	}
	//	Persona con más prestamos
	public static Persona clienteConMasPrestamos(Banco banco) {
		Persona res = null;
		Integer numeroPrestamos=0;
		Set<Persona> personas = banco.personas().todos();
		for(Persona p:personas) {
			Integer temp=banco.prestamosDeCliente(p.dni()).size();
			if(res==null||numeroPrestamos<temp) {
				res=p;
				numeroPrestamos=temp;
			}
		}
		return res;
	}
	//	Cantidad total de los crétditos gestionados por un empleado
	public static Double cantidadPrestamosPmpledado(Banco banco,String dni) {
		Double res=0.0;
		for(Prestamo prestamo:banco.prestamosDeCliente(dni)) {
			res+=prestamo.cantidad();
		}
		return res;
	}
	//	Empleado más longevo
	public static Persona empleadoMasLongevo(Banco banco) {
		Persona res = null;
		Integer edad=0;
		Set<Empleado> empleados = banco.empleados().todos();
		for(Empleado e:empleados) {
			Integer temp=e.persona().edad();
			if(res==null||edad<temp) {
				res=e.persona();
				edad=temp;
			}
		}
		return res;
	}
	//	Interés mínimo, máximo y medio de los préstamos
	public static record Info(Double min, Double max, Double mean) {
		public String toString() {
			return String.format("(%.2f,%.2f,%.2f)",this.min(),this.max(),this.mean());
		}
	}
	public static  Info rangoDeIntereseDePrestamos(Banco banco) {
		Set<Prestamo>prestamos=banco.prestamos().todos();
		Double interesMaximo=null;
		Double interesMinimo=null;
		Double sumaIntereses=0.0;
		Integer numeroInteres=0;

		for(Prestamo p:prestamos) {
			if(interesMaximo==null||p.interes()>interesMaximo) {
				interesMaximo=p.interes();
			}
			else {
				if(interesMinimo==null|| p.interes()<interesMinimo) {
					interesMinimo=p.interes();
				}
			}
			sumaIntereses+=p.interes();
			numeroInteres++;
		}
		return new Info(interesMinimo,interesMaximo,sumaIntereses/numeroInteres);
	}

	//	Número de préstamos por mes y año
	public static record Info2(Integer mes, Integer año) {
		public String toString() {
			return String.format("(%d,%d)",this.mes(),this.año());
		}
	}
	public static Map<Info2,Integer> numPrestamosPorMesAño(Banco banco) {
		Map<Info2,Integer> res= new HashMap<Info2,Integer>();
		Set<Prestamo> prestamos=banco.prestamos().todos();
		for(Prestamo p: prestamos) {
			Info2 clave= new Info2(p.fechaComienzo().getMonthValue(),p.fechaComienzo().getYear());
			if(!res.containsKey(clave)) {
				res.put(clave, 0);
			}
			res.replace(clave, res.get(clave)+1);
		}
		return res;
	}
}
