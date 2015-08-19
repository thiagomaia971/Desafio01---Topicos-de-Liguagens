package Classes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WriteText {

	public static float ReturnText(String LocalFile) throws IOException {
		long timeIni = System.currentTimeMillis(), timeFinal;
		float resultado = 0;
		int contLine = ReturnLengh(LocalFile);

		float[][] matriz = new float[contLine][contLine];

		PopulationMatriz(LocalFile, matriz);

		return resultado;
	}

	public static int ReturnLengh(String LocalFile) throws IOException {

		int contLine = 0;
		String line = null;
		try {
			FileReader arquivo = new FileReader(LocalFile);
			BufferedReader writeFile = new BufferedReader(arquivo);
			line = writeFile.readLine();

			while (line != null) {
				line = writeFile.readLine();
				contLine++;
			}

			arquivo.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return contLine;

	}

	public static float[][] PopulationMatriz(String LocalFile, float[][] Matriz)
			throws IOException {

		String line = null;
		int contLine = 0;

		try {
			FileReader arquivo = new FileReader(LocalFile);
			BufferedReader writeFile = new BufferedReader(arquivo);
			line = writeFile.readLine();
			int contStr = 0, posInicial = 0, posFinal = 0;

			while (line != null) {
				if (contLine == 0) {
					Matriz[contLine][contStr] = Float.parseFloat(line);
				} else {
					posInicial = 0;
					posFinal = 0;
					contStr = 0;
					
					String[] splitT = line.split(" "); 
					for (int i = 0; i < splitT.length; i++) {
						Matriz[contLine][i] = Float.parseFloat(splitT[i]);
					}
					/*
					for (int i = 0; i < line.length(); i++) {
						if (line.charAt(i) == ' ') {
							posFinal = i;
							Matriz[contLine][contStr] = Float.parseFloat(line
									.substring(posInicial, posFinal));
							posInicial = i + 1;
							contStr++;
						}
					}
					Matriz[contLine][contStr] = Float.parseFloat(line
							.substring(posInicial, line.length()));*/
				}
				line = writeFile.readLine();
				contLine++;
			}

			arquivo.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Matriz;
	}

}
