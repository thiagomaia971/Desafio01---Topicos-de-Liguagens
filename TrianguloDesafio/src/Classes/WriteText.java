package Classes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WriteText {

	public static int ReturnSoma(String LocalFile) throws IOException {
		long timeIni = System.currentTimeMillis(), timeFinal, deltaTime;
		int contLine = ReturnLengh(LocalFile), posResultado = 1, posC = 0;
		int[] resultado = new int[contLine];
		int resFinal = 0;

		int[][] matriz = new int[contLine][contLine];

		PopulationMatriz(LocalFile, matriz);
		
		while (posC < matriz.length) {
			resultado[posC] = matriz[matriz.length - 1][posC];
			posResultado = posC;
			for (int i = matriz.length - 1; i > 0; i--) {
				if (posResultado == 0 || posC == 0) {
					resultado[posC] += matriz[i-1][0];
				}else if(posResultado == i){
					resultado[posC] += matriz[i-1][posResultado - 1];
					posResultado--;
				}else if(matriz[i-1][posResultado - 1] > matriz[i-1][posResultado]){
					resultado[posC] += matriz[i-1][posResultado - 1];
					posResultado--;
				}else{
					resultado[posC] += matriz[i-1][posResultado];
				}
			}
			posC++;
		}
		for (int i = 0; i < matriz.length; i++) {
			if(resultado[i] > resFinal){
				resFinal = resultado[i];
			}
		}

		timeFinal = System.currentTimeMillis();
		deltaTime = (timeFinal) - (timeIni);

		System.out.println("Soma = " + resFinal + "\nTime = " + deltaTime + "(ms)");
		return resFinal;
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

	public static int[][] PopulationMatriz(String LocalFile, int[][] Matriz)
			throws IOException {

		String line = null;
		int contLine = 0;

		try {
			FileReader arquivo = new FileReader(LocalFile);
			BufferedReader writeFile = new BufferedReader(arquivo);
			line = writeFile.readLine();
			int contStr = 0;

			while (line != null) {
				if (contLine == 0) {
					Matriz[contLine][contStr] = Integer.parseInt(line);
				} else {

					String[] splitT = line.split(" ");
					for (int i = 0; i < splitT.length; i++) {
						Matriz[contLine][i] = Integer.parseInt(splitT[i]);
					}
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
