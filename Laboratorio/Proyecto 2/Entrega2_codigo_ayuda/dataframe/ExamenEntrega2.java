package Entrega2_codigo_ayuda.dataframe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExamenEntrega2 {
	
	public static void main(String[] args) {
		
	}

	//Ejercicio 1 
	public static DataFrame emptyDataFrame(DataFrame df) {
		List<String> columNames = df.columNames();
		Map<String, Integer> columIndex = new HashMap<>();
		for (int i = 0; i < columNames.size(); i++) {
			columIndex.put(columNames.get(i), i);
		}
		List<List<String>> rows = new ArrayList<>();
		return DataFrameImpl.of(columNames, columIndex, rows);
	}
	
	//Ejercicio 2
	public static DataFrame addDataFrame(DataFrame df1, DataFrame df2) {
		List<String> columNames = new ArrayList<>(df1.columNames());
		columNames.addAll(df2.columNames());

		Map<String, Integer> columIndex = new HashMap<>(df1.columIndex());
		int columnIndex = df1.columNames().size();
		for (String columnName : df2.columNames()) {
			columIndex.put(columnName, columnIndex);
			columnIndex++;
		}
		List<List<String>> rows = new ArrayList<>(df1.rows());
		List<List<String>> df2Rows = df2.rows();
		for (int i = 0; i < rows.size(); i++) {
			rows.get(i).addAll(df2Rows.get(i));
		}
		return DataFrameImpl.of(columNames, columIndex, rows);
	}
	
	//Ejercicio 3
	public DataFrame removeColumnIndex(DataFrame df,int ci) {
		if (ci < 0 || ci >= df.columNames().size()) {
			throw new IllegalArgumentException("No puedes usar ese valor de ci");
		}
		return df.removeColum(df.columNames().get(ci));  
	}
	
	//Ejercicio 4
	public static List<DataFrame> divideDataFrame(DataFrame df, int ci) {
		if (ci < 0 || ci >= df.columNames().size()) {
			throw new IllegalArgumentException("No puedes usar ese valor de ci");
		}

		List<String> columNames1 = df.columNames().subList(0, ci + 1);
		List<String> columNames2 = df.columNames().subList(ci + 1, df.columNames().size());

		Map<String, Integer> columIndex1 = new HashMap<>();
		Map<String, Integer> columIndex2 = new HashMap<>();

		for (int i = 0; i < columNames1.size(); i++) {
			columIndex1.put(columNames1.get(i), i);
		}

		int columnIndex2 = 0;
		for (int i = ci + 1; i < df.columNames().size(); i++) {
			columIndex2.put(df.columNames().get(i), columnIndex2);
			columnIndex2++;
		}

		List<List<String>> rows = df.rows();
		List<List<String>> rows1 = new ArrayList<>();
		List<List<String>> rows2 = new ArrayList<>();

		for (List<String> row : rows) {
			List<String> row1 = row.subList(0, ci + 1);
			List<String> row2 = row.subList(ci + 1, row.size());
			rows1.add(row1);
			rows2.add(row2);
		}

		DataFrame df1 = DataFrameImpl.of(columNames1, columIndex1, rows1);
		DataFrame df2 = DataFrameImpl.of(columNames2, columIndex2, rows2);

		List<DataFrame> result = new ArrayList<>();
		result.add(df1);
		result.add(df2);

		return result;
	}

}

