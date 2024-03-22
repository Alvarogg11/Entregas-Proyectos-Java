package fp.Tipos;

public record Fecha(Integer anyo,Integer mes, Integer dia) implements Comparable<Fecha> {
    private static final String[] nombres_meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    private static final String[] nombres_dias_semana = {"Sábado", "Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};

    public Fecha {
        if (mes < 1 || mes > 12) {
            throw new IllegalArgumentException("El mes debe estar entre 1 y 12");
        }
        if (dia < 1 || dia > diasEnMes(anyo, mes)) {
            throw new IllegalArgumentException("El día debe estar entre 1 y " + diasEnMes(anyo, mes));
        }
    }

    public String toString() {
        return diaSemana() + ", " + dia + " de " + nombreMes() + " de " + anyo;
    }

    public String nombreMes() {
        return nombres_meses[mes - 1];
    }

    public String diaSemana() {
        int valor_con_zeller = congruenciaZeller(anyo, mes, dia);
        return nombres_dias_semana[valor_con_zeller];
    }

    public Fecha sumarDias(int cantidad_dias) {
        int dia_actual = dia;
        int mes_actual = mes;
        int año_actual = anyo;
        Integer dias_restantes;
        int dias_mes_actual;
        while (cantidad_dias > 0) {
            dias_mes_actual = diasEnMes(año_actual, mes_actual);
            dias_restantes = dias_mes_actual - dia_actual + 1;
            if (cantidad_dias  >= dias_restantes) {
                cantidad_dias -= dias_restantes;
                dia_actual = 1;
                mes_actual += 1;
                if (mes_actual > 12) {
                    mes_actual = 1;
                    año_actual += 1;
                }
            }
	        else {
	            dia_actual += cantidad_dias;
	            cantidad_dias = 0;
	            }
        }
        return Fecha.of(año_actual, mes_actual, dia_actual);
    }
     

    public Fecha restarDias(int cantidad_dias) {
        int dia_actual = dia;
        int mes_actual = mes;
        int año_actual = anyo;
        while (cantidad_dias > 0) {
            int dias_mes_actual = diasEnMes(año_actual, mes_actual - 1);
            if (cantidad_dias >= dia_actual) {
                cantidad_dias -= dia_actual;
                dia_actual = dias_mes_actual;
                mes_actual -= 1;
                if (mes_actual < 1) {
                    mes_actual = 12;
                    año_actual -= 1;
                }
            }
             else {
                dia_actual -= cantidad_dias;
                cantidad_dias = 0;
            }
        }
        return new Fecha(año_actual, mes_actual, dia_actual);
    }

    public Integer diferenciaEnDias(Fecha otro) {
		Integer d=0;
		Fecha fechaActual=Fecha.of(this.anyo, this.mes, this.dia);
		Fecha fechaMenor;
		Fecha fechaMayor;
		if(fechaActual.equals(otro)) {
			return 0;
		}
		else {
			if(fechaActual.compareTo(otro)>0) {
				d=1;
				fechaMenor=otro;
				fechaMayor=fechaActual;
			}
			else {
				d=-1;
				fechaMenor=fechaActual;
				fechaMayor=otro;
			}
		}
		Integer diasDiferencia=0;
		while (fechaMenor.compareTo(fechaMayor)<0){
			diasDiferencia++;
			fechaMenor=fechaMenor.sumarDias(1); 
		}
		return d*diasDiferencia;
	}
    @Override
    public int compareTo(Fecha otra_fecha) {
        Integer res;
        res = this.anyo.compareTo(otra_fecha.anyo);
        if (res == 0) {
            res = this.mes.compareTo(otra_fecha.mes);
            if (res == 0) {
                res = this.dia.compareTo(otra_fecha.dia);
            }
        }
        return res;
    }
    public static int congruenciaZeller(int año, int mes, int dia) {
        if (mes < 3) {
            año -= 1;
            mes += 12;
        }
        int K = año % 100;
        int J = año / 100;
        int h = (dia + 13 * (mes + 1) / 5 + K + K / 4 + J / 4 + 5 * J) % 7;
        return h;
    }

    public static int diasEnMes(int año, int mes) {
        int[] dias_por_mes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (año % 4 == 0 && (año % 100 != 0 || año % 400 == 0)) {
            dias_por_mes[1] = 29;
        }
        if (1 <= mes && mes <= 12) {
            return dias_por_mes[mes - 1];
        } else {
            return 0;
        }
    }

    public static boolean esAñoBisiesto(int año) {
        if ((año % 4 == 0 && año % 100 != 0) || (año % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    public static Fecha of(int anyo, int mes, int dia) {
        return new Fecha(anyo, mes, dia);
    }

    public static Fecha parse(String fecha_str) {
        String[] fecha_parts = fecha_str.split("-");
        int anyo = Integer.parseInt(fecha_parts[0]);
        int mes = Integer.parseInt(fecha_parts[1]);
        int dia = Integer.parseInt(fecha_parts[2]);
        return new Fecha(anyo, mes, dia);
    }
    //método fecha defensa
    public int[] restarDiasFechaDada(Fecha fecha, int numDias) {
        if (numDias > 999) {
            throw new IllegalArgumentException("El número de días debe tener 3 dígitos como máximo");
        }
        Fecha fechaRestada = fecha.restarDias(numDias);
        int[] resultado = {fechaRestada.dia, fechaRestada.mes, fechaRestada.anyo};
        return resultado;
    }
}
