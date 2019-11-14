package grafo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ImpresorGrafo {

	public static void imprimirGrafo(GrafoNDNP grafo) throws IOException {

		PrintWriter salida = new PrintWriter(new FileWriter("grafo.in"));

		
		MatrizSimetrica mat = grafo.getMatriz();
		salida.println(grafo.getCantidadDeNodos() + " " + grafo.getCantidadDeAristas() + " " + grafo.getPorcentajeAdyacencia()
		 + "% " + grafo.getGradoMaximo() + " " + grafo.getGradoMaximo());
		for (int i = 0; i < grafo.getCantidadDeNodos(); i++) {
			for (int j = i + 1; j < grafo.getCantidadDeNodos(); j++) {
				if (mat.getIJ(i,j)) {
					salida.println(i + " " + j);
				}
			}
		}
		
		salida.close();

	}
}
