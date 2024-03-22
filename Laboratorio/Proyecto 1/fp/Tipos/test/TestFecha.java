package fp.Tipos.test;
import fp.Tipos.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TestFecha {
    public static void main(String[] args) {
        testCrearFecha();
        testEsAnioBisiesto();
        testDiasEnMes();
        testSumarDias();
        testRestarDias();
        testDiferenciaEnDias();
        testrestarDiasFechaDada();
    }

    public static void testCrearFecha() {
        Integer anio = 2024;
        Integer mes = 3;
        Integer dia = 8;

        Fecha fecha = Fecha.of(anio, mes, dia);
        LocalDate localDate = LocalDate.of(anio, mes, dia);

        System.out.println("Fecha: " + fecha);
        System.out.println("LocalDate: " + localDate);
		System.out.println("                        ");

    }

    public static void testEsAnioBisiesto() {
        Integer anio = 2024;
        Integer mes = 3;
        Integer dia = 8;

        Fecha fecha = Fecha.of(anio, mes, dia);
        LocalDate localDate = LocalDate.of(anio, mes, dia);

        System.out.println("Fecha.esAnioBisiesto(): " + Fecha.esAñoBisiesto(fecha.anyo()));
        System.out.println("LocalDate.isLeapYear(): " + localDate.isLeapYear());
		System.out.println("                        ");

    }

    public static void testDiasEnMes() {
        Integer anio = 2024;
        Integer mes = 3;
        Integer dia = 8;

        Fecha fecha = Fecha.of(anio, mes, dia);
        LocalDate localDate = LocalDate.of(anio, mes, dia);

        System.out.println("Fecha.diasEnMes(): " + Fecha.diasEnMes(fecha.anyo(), fecha.mes()));
        System.out.println("LocalDate.lengthOfMonth(): " + localDate.lengthOfMonth());
		System.out.println("                        ");

    }

    public static void testSumarDias() {
        Integer anio = 2024;
        Integer mes = 3;
        Integer dia = 8;

        Fecha fecha = Fecha.of(anio, mes, dia);
        LocalDate localDate = LocalDate.of(anio, mes, dia);

        Fecha fechaSumada = fecha.sumarDias(10);
        LocalDate localDateSumada = localDate.plusDays(10);

        System.out.println("Fecha.sumardias(10): " + fechaSumada);
        System.out.println("LocalDate.plusDays(10): " + localDateSumada);
		System.out.println("                        ");

    }

    public static void testRestarDias() {
        Integer anio = 2024;
        Integer mes = 3;
        Integer dia = 8;

        Fecha fecha = Fecha.of(anio, mes, dia);
        LocalDate localDate = LocalDate.of(anio, mes, dia);

        Fecha fechaRestada = fecha.restarDias(10);
        LocalDate localDateRestada = localDate.minusDays(10);

        System.out.println("Fecha.restarDias(10): " + fechaRestada);
        System.out.println("LocalDate.minusDays(10): " + localDateRestada);
		System.out.println("                        ");

    }

    public static void testDiferenciaEnDias() {
        Integer anio = 2024;
        Integer mes = 3;
        Integer dia = 8;

        Fecha fecha = Fecha.of(anio, mes, dia);
        LocalDate localDate = LocalDate.of(anio, mes, dia);

        Fecha fechaSumada = fecha.sumarDias(10);
        LocalDate localDateSumada = localDate.plusDays(10);

        Integer diferenciaEnDias = fecha.diferenciaEnDias(fechaSumada);
        long diferenciaEnDiasLocalDate = ChronoUnit.DAYS.between(localDate, localDateSumada);

        System.out.println("Fecha.diferenciaEnDias(fechaSumada): " + diferenciaEnDias); //aparece negativo pero si se cambia el orden de las fechas ya sale positivo
        System.out.println("ChronoUnit.DAYS.between(localDate, localDateSumada): " + diferenciaEnDiasLocalDate);
		System.out.println("                        ");

    }
    //test método defensa 1
    public static void testrestarDiasFechaDada() {
        Fecha fecha = Fecha.parse("2024-03-22");
        int numDias = 11;
        int[] resultado = fecha.restarDiasFechaDada(fecha, numDias);
        System.out.println("Fecha restada: " + resultado[0] + "-" + resultado[1] + "-" + resultado[2]);
    }
}