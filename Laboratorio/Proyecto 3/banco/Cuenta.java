package banco;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cuenta {
	private String iban;
	private String dni;
	private LocalDate fechaDeCreacion;
	private Double saldo;
	private Cuenta(String iban, String dni, LocalDate fechaDeCreacion, Double saldo) {
		this.iban=iban;
		this.dni=dni;
		this.fechaDeCreacion=fechaDeCreacion;
		this.saldo=saldo;
	}
	public static Cuenta of(String iban, String dni, LocalDate fechaDeCreacion, Double saldo) {
		return new Cuenta(iban,dni,fechaDeCreacion,saldo);
	}
	public static Cuenta parse(String cadena) {
		String[] trozos=cadena.split(",");
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDate fechaDeCreacion = LocalDateTime.parse(trozos[2], formato).toLocalDate();
		return Cuenta.of(trozos[0], trozos[1], fechaDeCreacion, Double.valueOf(trozos[3]));
	}
	public void ingresas(Double c) {
		this.saldo+=c;
	}
	public void retirar(Double c) {
		this.saldo-=c;
	}
	public String toString() {
		return this.iban+","+Double.toString(this.saldo);
	}
	public Boolean equals(Cuenta otra) {
		return this.iban.equals(otra.iban)&&
				this.dni.equals(otra.dni)&&
				this.fechaDeCreacion.equals(otra.fechaDeCreacion)&&
				this.saldo.equals(otra.saldo);
	}
	public String iban() {
		return this.iban;
	}
	public String dni() {
		return this.dni;
	}
	public LocalDate fechaDeCreacion() {
		return this.fechaDeCreacion;
	}
	public Double saldo() {
		return this.saldo;
	}
}
