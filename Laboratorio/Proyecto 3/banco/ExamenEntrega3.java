package banco;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import us.lsi.ejemplos_b1_tipos.Persona;

public class ExamenEntrega3 {
	
	public static List<Empleado> empleadosEntreDiaMes(Banco banco, String ini, String fin) {
		Set<Empleado> empleados = banco.empleados().todos();
		LocalDate fechaIni = LocalDate.parse(ini, DateTimeFormatter.ofPattern("dd/MM"));
		LocalDate fechaFin = LocalDate.parse(fin, DateTimeFormatter.ofPattern("dd/MM"));
		
		if (fechaIni.isAfter(fechaFin)) {
			throw new IllegalArgumentException("La fecha inicial debe ser menor o igual que la fecha final");
		}
		
		return empleados.stream()
			.filter(e -> {
				LocalDate fechaNacimiento = e.fechaNacimiento();
				return (fechaNacimiento.getDayOfMonth() >= fechaIni.getDayOfMonth() && fechaNacimiento.getMonthValue() >= fechaIni.getMonthValue())
					&& (fechaNacimiento.getDayOfMonth() <= fechaFin.getDayOfMonth() && fechaNacimiento.getMonthValue() <= fechaFin.getMonthValue());
			})
			.collect(Collectors.toList());
	}


	
	//ejercicio 2
	public static Map<Character, List<Empleado>> empleadosConLetraDNI(Banco banco, Set<Character> letras) {
        Set<Empleado> empleados = banco.empleados().todos();
        
        List<Empleado> empleadosFiltrados = empleados.stream()
                .filter(emp -> letras.stream().anyMatch(letra -> emp.persona().dni().indexOf(letra) >= 0))
                .collect(Collectors.toList());
        Map<Character, List<Empleado>> empleadosAgrupados = empleadosFiltrados.stream()
                .collect(Collectors.groupingBy(emp -> emp.persona().dni().charAt(0)));
        return empleadosAgrupados;
    }
	//ejercicio 3
	public static Optional<Double> clientesEdadMedia(Banco banco,Integer m){      //para optimizar el código he puesto Optional<Double> en vez de solo Double
		Set<Persona> clientes = empleadosEntreEdades(banco,m,1000);
		return clientes.stream().mapToInt(x->x.edad()).average().stream().mapToObj(Double::valueOf).findFirst();
	}
	
	//ejercicio 4
	public static Set<Persona> clientesConMenosPrestamos(Banco banco, Integer n){    //en este método he usado Set<Persona> en vez de Set<String> porque lo veo más eficiente
		Set<Persona> personas =banco.personas().todos();
		List<Persona> temp = new ArrayList<Persona> (personas);
		Set<Persona> res = new HashSet<Persona>();
		for(int i=0;i<n;i++) {
			Persona pMenosPrestamos=menosPrestamos(temp);
			temp.remove(pMenosPrestamos);
			res.add(pMenosPrestamos);
		}
		return res;
	}

	
	//estos métodos son necesarios para el funcionamiento de algunos de los métodos principales de la entrega
	private static Persona menosPrestamos(List<Persona> pe) {
		Persona res = null;
		Banco banco=Banco.of();
		Integer numeroPrestamos=0;
		Set<Persona> personas = new HashSet<Persona>(pe);
		for(Persona p:personas) {
			Integer temp=banco.prestamosDeCliente(p.dni()).size();
			if(res==null||numeroPrestamos>temp) {
				res=p;
				numeroPrestamos=temp;
			}
		}
		return res;
	}
	
	public static Set<Persona> empleadosEntreEdades(Banco banco,Integer edadIni, Integer edadFin){
		Set<Empleado> empleados =banco.empleados().todos();
		return empleados.stream().filter(x->x.persona().edad().compareTo(edadIni)>0 && x.persona().edad().compareTo(edadFin)<0).map(x->x.persona()).collect(Collectors.toSet());
	}
	
}
