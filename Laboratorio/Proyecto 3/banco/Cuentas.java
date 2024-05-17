package banco;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import us.lsi.tools.File2;

public class Cuentas {
	private static Cuentas gestorDeCuentas=null;
	private Set<Cuenta> cuentas;
	private Map<String,Cuenta> cuentasIban;
	
	private Cuentas(Set<Cuenta> cuentas) {
		super();
		this.cuentas=cuentas;
		this.cuentasIban=this.cuentas.stream().collect(Collectors.toMap(x->x.iban(), x->x));
	}
	public static Cuentas of() {
		if (Cuentas.gestorDeCuentas == null)
			Cuentas.gestorDeCuentas = Cuentas.parse("bancos/cuentas.txt");
		return Cuentas.gestorDeCuentas;
	}
	public static Cuentas parse(String ruta) {
		 Set<Cuenta> cuentas = File2.streamDeFichero(ruta,"UTF-8").map(x->Cuenta.parse(x)).collect(Collectors.toSet());
		 Cuentas.gestorDeCuentas=new Cuentas(cuentas);
		 return Cuentas.gestorDeCuentas;
	}
	public Set<Cuenta> todas(){
		return this.cuentas;
	}
	public Optional<Cuenta> cuentaIban(String iban){
		return this.cuentas.stream().filter(x->x.iban().equals(iban)).findFirst();
	}
	public Integer size() {
		return this.cuentas.size();
	}
	public Cuenta cuentaIndex(Integer n) {
		List<Cuenta> cuentas = new ArrayList<Cuenta>(this.cuentas);
		return cuentas.get(n);
	}
	public String toString() {
		return this.cuentas.stream().map(p -> p.toString()).collect(Collectors.joining("\n\t", "Cuentas\n\t", ""));
	}
	
	public static void main (String[] args) {
		Cuentas cuentas = Cuentas.parse("src/lab/bancos/ficheros_bancos/cuentas.txt");
		System.out.println(cuentas);
	    System.out.println(cuentas.cuentaIban("ES0882939941662478619244").get());
	    System.out.println(cuentas.cuentaIndex(2));
	}
}
