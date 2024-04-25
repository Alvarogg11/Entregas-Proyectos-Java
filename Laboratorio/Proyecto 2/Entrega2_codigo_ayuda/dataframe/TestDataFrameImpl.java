package Entrega2_codigo_ayuda.dataframe;

import java.util.List;
import java.util.function.Function;

import us.lsi.tools.File2;

public class TestDataFrameImpl {

    private static String ruta = "C:\\Users\\gilgr\\git\\repository\\Laboratorio\\Proyecto 2\\Entrega2_codigo_ayuda\\ficheros\\personas.csv";
    private static String ruta2 = "C:\\Users\\gilgr\\git\\repository\\Laboratorio\\Proyecto 2\\Entrega2_codigo_ayuda\\ficheros\\mascotas.csv";
    private static String ruta3 = "C:\\Users\\gilgr\\git\\repository\\Laboratorio\\Proyecto 2\\Entrega2_codigo_ayuda\\ficheros\\pp.csv";

    
    public static void main(String[] args) {
            testParse();
            testOf();
            testColumNames();
        	testColumNumber();
        	testColum();
        	testRow();
        	testColumAllDifferent();
        	testCell();
        	testRowNumber();
        	testRows();
        	testSlice();
        	testAddCalculatedColum();
        	testRemoveColum();
            testHead();
            testTail();
            testFilter();
            testSortBy();

    }

    private static void testParse() {
            DataFrame df = DataFrameImpl.parse(ruta);
            DataFrame df2 = DataFrameImpl.parse(ruta2);
            DataFrame df3 = DataFrameImpl.parse(ruta3);
            System.out.println("PERSONAS-->");
            System.out.println("DataFrame construido con el método de factoria:\n" + df);
            System.out.println("MASCOTAS-->");
            System.out.println("DataFrame construido con el método de factoria:\n" + df2);
            System.out.println("PELICULAS-->");
            System.out.println("DataFrame construido con el método de factoria:\n" + df3);

    }
    
    private static void testOf() {
        DataFrame df = DataFrameImpl.of(File2.mapDeCsv(ruta));
        DataFrame df2 = DataFrameImpl.parse(ruta2);
        DataFrame df3 = DataFrameImpl.parse(ruta3);
        System.out.println("PERSONAS-->");
        System.out.println("DataFrame construido con el método de factoria:\n"+df);
        System.out.println("MASCOTAS-->");
        System.out.println("DataFrame construido con el método de factoria:\n"+df2);
        System.out.println("PELICULAS-->");
        System.out.println("DataFrame construido con el método de factoria:\n"+df3);
    }

    private static void testColumNames() {
        DataFrame df = DataFrameImpl.parse(ruta);
        DataFrame df2 = DataFrameImpl.parse(ruta2);
        DataFrame df3 = DataFrameImpl.parse(ruta3);
        System.out.println("PERSONAS-->");
        System.out.println("Los nombres de las columnas del DataFrame son:\n" + df.columNames());
        System.out.println("MASCOTAS-->");
        System.out.println("Los nombres de las columnas del DataFrame son:\n" + df2.columNames());
        System.out.println("PELICULAS-->");
        System.out.println("Los nombres de las columnas del DataFrame son:\n" + df3.columNames());
    }
    
    private static void testColumNumber() {
        DataFrame df = DataFrameImpl.parse(ruta);
        DataFrame df2 = DataFrameImpl.parse(ruta2);
        DataFrame df3 = DataFrameImpl.parse(ruta3);
        System.out.println("PERSONAS-->");
        System.out.println("El número de  columnas del DataFrame es:\n" + df.columNumber());
        System.out.println("MASCOTAS-->");
        System.out.println("El número de  columnas del DataFrame es:\n" + df2.columNumber());
        System.out.println("PELICULAS-->");
        System.out.println("El número de  columnas del DataFrame es:\n" + df3.columNumber());
    }
    

    
    private static void testColum() {
        DataFrame df = DataFrameImpl.parse(ruta);
        DataFrame df2 = DataFrameImpl.parse(ruta2);
        DataFrame df3 = DataFrameImpl.parse(ruta3);
        System.out.println("PERSONAS-->");
        System.out.println("La columna en la posicion 2 contiene:\n" + df.colum(2));
        System.out.println("La columna de los nombres contiene:\n" + df.colum("Nombre"));
        System.out.println("MASCOTAS-->");
        System.out.println("La columna en la posicion 2 contiene:\n" + df2.colum(2));
        System.out.println("La columna de los nombres contiene:\n" + df2.colum("Nombre"));
        System.out.println("PELICULAS-->");
        System.out.println("La columna en la posicion 2 contiene:\n" + df3.colum(2));
        System.out.println("La columna de los nombres contiene:\n" + df3.colum("Titulo"));
        }
    
    private static void testRow() {
        DataFrame df = DataFrameImpl.parse(ruta);
        DataFrame df2 = DataFrameImpl.parse(ruta2);
        DataFrame df3 = DataFrameImpl.parse(ruta3);
        System.out.println("PERSONAS-->");
        System.out.println("La segunda fila contiene:\n" + df.row(2));
        System.out.println("MASCOTAS-->");
        System.out.println("La segunda fila contiene:\n" + df2.row(2));
        System.out.println("PELICULAS-->");
        System.out.println("La primera fila contiene:\n" + df3.row(1));
    }
    
    private static void testColumAllDifferent() { 
        DataFrame df = DataFrameImpl.parse(ruta);
        DataFrame df2 = DataFrameImpl.parse(ruta2);
        DataFrame df3 = DataFrameImpl.parse(ruta3);
        System.out.println("PERSONAS-->");
        System.out.println("¿Son todos los elementos de la columna Altura diferentes?\n" + df.columAllDifferent("Altura"));
        System.out.println("MASCOTAS-->");
        System.out.println("¿Son todos los elementos de la columna especie diferentes?\n" + df2.columAllDifferent("Especie"));
        System.out.println("PELICULAS-->");
        System.out.println("¿Son todos los elementos de la columna valoraciones diferentes?\n" + df3.columAllDifferent("Valoracion"));
    }
    
    private static void testCell() {
        DataFrame df = DataFrameImpl.parse(ruta);
        DataFrame df2 = DataFrameImpl.parse(ruta2);
        DataFrame df3 = DataFrameImpl.parse(ruta3);
        System.out.println("PERSONAS-->");
        System.out.println("El elemento en la columna 2, fila 3 es:\n" + df.cell(3, 2));
        System.out.println("El elemento en la columna de los nombres, fila 3 es:\n" + df.cell(3, "Nombre"));
        System.out.println("MASCOTAS-->");
        System.out.println("El elemento en la columna 2, fila 3 es:\n" + df2.cell(3, 2));
        System.out.println("El elemento en la columna de los nombres, fila 3 es:\n" + df2.cell(3, "Nombre"));    
        System.out.println("PELICULAS-->");
        System.out.println("El elemento en la columna 2, fila 1 es:\n" + df3.cell(1, 2));
        System.out.println("El elemento en la columna de los nombres, fila 1 es:\n" + df3.cell(1, "Titulo"));  
        }
    
    private static void testRowNumber() {
        DataFrame df = DataFrameImpl.parse(ruta);
        DataFrame df2 = DataFrameImpl.parse(ruta2);
        DataFrame df3 = DataFrameImpl.parse(ruta3);
        System.out.println("PERSONAS-->");
        System.out.println("El número de  filas del DataFrame es:\n" + df.rowNumber());
        System.out.println("MASCOTAS-->");
        System.out.println("El número de  filas del DataFrame es:\n" + df2.rowNumber());
        System.out.println("PELICULAS-->");
        System.out.println("El número de  filas del DataFrame es:\n" + df3.rowNumber());
    }
    
    private static void testRows() {
        DataFrame df = DataFrameImpl.parse(ruta);
        DataFrame df2 = DataFrameImpl.parse(ruta2);
        DataFrame df3 = DataFrameImpl.parse(ruta3);
        System.out.println("PERSONAS-->");
        System.out.println("Las filas del DataFrame son:\n");
        for(List<String> row:df.rows()) {
        	System.out.println("\t"+row);
        }
        System.out.println("MASCOTAS-->");
        System.out.println("Las filas del DataFrame son:\n");
        for(List<String> row2:df2.rows()) {
        	System.out.println("\t"+row2);
        }
        System.out.println("PELICULAS-->");
        System.out.println("Las filas del DataFrame son:\n");
        for(List<String> row3:df3.rows()) {
        	System.out.println("\t"+row3);
        }
    }
    
    private static void testSlice() {
        DataFrame df = DataFrameImpl.parse(ruta);
        DataFrame df2 = DataFrameImpl.parse(ruta2);
        DataFrame df3 = DataFrameImpl.parse(ruta3);
        System.out.println("PERSONAS-->");
        System.out.println("El DataFrame entre las filas 2 y 3 es:\n" + df.slice(2, 3));
        System.out.println("MASCOTAS-->");
        System.out.println("El DataFrame entre las filas 2 y 3 es:\n" + df2.slice(2, 3));
        System.out.println("PELICULAS-->");
        System.out.println("El DataFrame entre las filas 2 y 3 es:\n" + df3.slice(1, 2));
    }
    
    private static void testAddCalculatedColum() {
        DataFrame df = DataFrameImpl.parse(ruta);
        DataFrame df2 = DataFrameImpl.parse(ruta2);
        DataFrame df3 = DataFrameImpl.parse(ruta3);
        Function<List<String>,String> longuitudNombre=x->Integer.toString(x.get(0).length());
        System.out.println("PERSONAS-->");
        System.out.println("El DataFrame con una columna mas donde este el numero de letras del nombre es:\n" + df.addCalculatedColum("Numero de letras del nombre",longuitudNombre ));
        System.out.println("MASCOTAS-->");
        System.out.println("El DataFrame con una columna mas donde este el numero de letras del nombre es:\n" + df2.addCalculatedColum("Numero de letras del nombre",longuitudNombre ));
        System.out.println("PELICULAS-->");
        System.out.println("El DataFrame con una columna mas donde este el numero de letras del nombre es:\n" + df3.addCalculatedColum("Numero de letras del nombre",longuitudNombre ));
    }
    private static void testRemoveColum() {
        DataFrame df = DataFrameImpl.parse(ruta);
        DataFrame df2 = DataFrameImpl.parse(ruta2);
        DataFrame df3 = DataFrameImpl.parse(ruta3);
        System.out.println("PERSONAS-->");
        System.out.println("El DataFrame sin la columna del nombre es:\n" + df.removeColum("Nombre"));
        System.out.println("MASCOTAS-->");
        System.out.println("El DataFrame sin la columna del nombre es:\n" + df2.removeColum("Nombre"));
        System.out.println("PELICULAS-->");
        System.out.println("El DataFrame sin la columna del nombre es:\n" + df3.removeColum("Titulo"));
    }
    
    
    private static void testHead() {
        DataFrame df = DataFrameImpl.parse(ruta);
        DataFrame df2 = DataFrameImpl.parse(ruta2);
        DataFrame df3 = DataFrameImpl.parse(ruta3);
        System.out.println("PERSONAS-->");
        System.out.println("Las dos primeras filas del DataFrame son:\n" + df.head(2));
        System.out.println("MASCOTAS-->");
        System.out.println("Las dos primeras filas del DataFrame son:\n" + df2.head(2));
        System.out.println("PELICULAS-->");
        System.out.println("La primera fila del DataFrame es:\n" + df3.head(1));
    }

    private static void testTail() {
        DataFrame df = DataFrameImpl.parse(ruta);
        DataFrame df2 = DataFrameImpl.parse(ruta2);
        DataFrame df3 = DataFrameImpl.parse(ruta3);
        System.out.println("PERSONAS-->");
        System.out.println("Las dos ultimas filas del DataFrame son:\n" + df.tail(2));
        System.out.println("MASCOTAS-->");
        System.out.println("Las dos ultimas filas del DataFrame son:\n" + df2.tail(2));
        System.out.println("PELICULAS-->");
        System.out.println("La ultima fila del DataFrame es:\n" + df3.tail(1));
    }

    private static void testFilter() { 
        DataFrame df = DataFrameImpl.parse(ruta);
        DataFrame df2 = DataFrameImpl.parse(ruta2);
        DataFrame df3 = DataFrameImpl.parse(ruta3);
        System.out.println("PERSONAS-->");
        System.out.println("El DataFrame de las personas cuya altura es mayor que 1.65 es:\n" + df.filter(row -> Double.parseDouble(row.get(df.columNames().indexOf("Altura"))) > 1.75));
        System.out.println("MASCOTAS-->");
        System.out.println("El DataFrame de las mascotas cuyo sexo es M es:\n" + df2.filter(row -> row.get(df2.columNames().indexOf("Sexo")).equals("M")));
        System.out.println("PELICULAS-->");
        System.out.println("El DataFrame de las peliculas cuya valoracion es mayor que 8 es:\n" + df3.filter(row -> Double.parseDouble(row.get(df3.columNames().indexOf("Valoracion")))>8));
    }

    private static void testSortBy() { 
        DataFrame df = DataFrameImpl.parse(ruta);
        DataFrame df2 = DataFrameImpl.parse(ruta2);
        DataFrame df3 = DataFrameImpl.parse(ruta3);
        System.out.println("PERSONAS-->");
        System.out.println("El DataFrame ordenado por la altura es:\n" + df.sortBy(row -> Double.parseDouble(row.get(df.columNames().indexOf("Altura"))), true));
        System.out.println("MASCOTAS-->");
        System.out.println("El DataFrame ordenado por el sexo es:\n" + df2.sortBy(row -> row.get(df2.columNames().indexOf("Sexo")), true));
        System.out.println("PELICULAS-->");
        System.out.println("El DataFrame ordenado por la valoracion es:\n" + df3.sortBy(row -> Double.parseDouble(row.get(df3.columNames().indexOf("Valoracion"))), true));
    }
}
