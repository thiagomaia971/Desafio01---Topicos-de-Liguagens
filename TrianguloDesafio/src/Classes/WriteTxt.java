package Classes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WriteTxt {

	public static float ReturnText(String LocalFile) throws IOException {
		long timeIni = System.currentTimeMillis();
		long timefinal;
		
		String line = null;
		int lineInt = 0;
		int posResutado = 0;
		float resultadoFinal = 0;
		try {
			FileReader arquivo = new FileReader(LocalFile);
			BufferedReader writeFile = new BufferedReader(arquivo);
			line = writeFile.readLine();

			while (line != null) {
				if (lineInt == 0) {
					resultadoFinal += Float.parseFloat(line);
				} else {
					int posInicial = 0, posFinal = 0;
					float[] numeros = new float[lineInt + 1];
					int cont = 0;
					for (int i = 0; i < line.length(); i++) {
						if (line.charAt(i) == ' ') {
							posFinal = i;
							numeros[cont] = Float.parseFloat(line.substring(
									posInicial, posFinal));
							posInicial = i + 1;
							cont++;
						}
					}
					// System.out.println(line.length());
					numeros[lineInt] = Integer.parseInt(line.substring(
							posInicial, line.length()));

					if (numeros[posResutado] >= numeros[posResutado + 1]) {
						resultadoFinal += numeros[posResutado];
					} else {
						resultadoFinal += numeros[posResutado + 1];
						posResutado += 1;
					}
				}
				lineInt++;
				line = writeFile.readLine();
				//System.out.println(resultadoFinal);
			}
			arquivo.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		timefinal = System.currentTimeMillis();
		System.out.println("Time of execution: "+ (timefinal - timeIni));
		return resultadoFinal;

	}
}
