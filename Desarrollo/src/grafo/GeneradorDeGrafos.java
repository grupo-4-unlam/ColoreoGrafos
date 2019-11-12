package grafo;

import java.util.Random;

@SuppressWarnings("unused")
public class GeneradorDeGrafos {
	
	private int cantNodos; 
	private double porcAdyacencia;
	private static int gradoMax, gradoMin;

	// -------------------------------ALEATORIOS-------------------------------------------------------
	// Genera un grafo aleatorio dadas cantidad de nodos y probabilidad de cada arista
	
	public static GrafoNDNP generarAleatorioNYProbabilidad(int cantNodos, double probabilidad) {
		int cantAristas = 0;
		MatrizSimetrica matriz = new MatrizSimetrica(cantNodos);

		for (int i = 0; i < cantNodos; i++) {
			for (int j = i + 1; j < cantNodos; j++) {
				if (!matriz.getIJ(i, j)) {
					if (Math.random() < probabilidad) {
						matriz.setIJ(i, j);
						cantAristas++;
					}
				}
			}
		}

		int cantTotAristas = (cantNodos * (cantNodos - 1)) / 2;
		double porcentajeDeAdyacencia = Math.rint((cantAristas / cantTotAristas) * 100.0);
		calcularGradoMinYMax(matriz, cantNodos);
		GrafoNDNP grafo = new GrafoNDNP(matriz, cantNodos, cantAristas, porcentajeDeAdyacencia, gradoMax, gradoMin);
		return grafo;
	}

	
	// Genera grafo aleatorio dadas cantidad N de nodos y porcentaje de adyacencia
	public static GrafoNDNP generarAleatorioNYPorcAdyacencia(int cantNodos, double porcentajeAdyacencia) {
		Random arista = new Random();
		MatrizSimetrica matriz = new MatrizSimetrica(cantNodos);
		int maximoAristas = (cantNodos * (cantNodos - 1)) / 2;
		int cantAristas = (int) (Math.rint((cantNodos * cantNodos - cantNodos) * 0.5 * (porcentajeAdyacencia / 100.0)));
		int aristasAplicadas = 0;
		double porcAdy = porcentajeAdyacencia;

		while (aristasAplicadas != cantAristas) {
			for (int i = 0; i < cantNodos; i++) {
				for (int j = i + 1; j < cantNodos; j++) {
					if (!matriz.getIJ(i, j)) {
						if (arista.nextInt(2) == 1) {
							matriz.setIJ(i, j);
							aristasAplicadas++;
						}
					}
					if (aristasAplicadas == cantAristas)
						break;
				}
				if (aristasAplicadas == cantAristas)
					break;
			}
		}

		calcularGradoMinYMax(matriz, cantNodos);
		GrafoNDNP grafo = new GrafoNDNP(matriz, cantNodos, cantAristas, porcAdy, gradoMax, gradoMin);

		return grafo;
	}


	
	private static void calcularGradoMinYMax(MatrizSimetrica matriz, int cantNodos) {
		int[] sumador = new int[cantNodos];

		for (int i = 0; i < cantNodos; i++) {
			for (int j = i + 1; j < cantNodos; j++) {
				if (matriz.getIJ(i, j)) {
					sumador[i] += 1;
					sumador[j] += 1;
				}
			}
		}
		gradoMax = 0;
		for (int j = 0; j < sumador.length; j++) {
			if (sumador[j] > gradoMax)
				gradoMax = sumador[j];
		}
		gradoMin = gradoMax - 1;
		for (int j = 0; j < sumador.length; j++) {
			if (sumador[j] < gradoMin)
				gradoMin = sumador[j];
		}
	}
}
