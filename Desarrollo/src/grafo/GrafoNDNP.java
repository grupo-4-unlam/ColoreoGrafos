package grafo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GrafoNDNP {
	private MatrizSimetrica matriz;
	private int cantidadDeNodos;
	private int cantidadDeAristas;
	private double porcentajeAdyacencia;
	private int gradoMaximo;
	private int gradoMinimo;
	private Nodo[] nodos;
	private int cantidadDeColores; 
	
	public GrafoNDNP(String path) {
		BufferedReader bf = null;
		FileReader entrada = null;
		String linea;
		String[] data;
		boolean bandera = false;
		int fila, columna;

		try {
			entrada = new FileReader(new File(path));
			bf = new BufferedReader(entrada);

			while ((linea = bf.readLine()) != null) {
				data = linea.split(" ");
				if (!bandera) {
					this.cantidadDeNodos = Integer.parseInt(data[0]);
					this.cantidadDeAristas = Integer.parseInt(data[1]);
					this.porcentajeAdyacencia = Double.parseDouble(data[2]);
					this.gradoMinimo = Integer.parseInt(data[3]);
					this.gradoMaximo = Integer.parseInt(data[4]);

					this.nodos = new Nodo[this.cantidadDeNodos];

					for (int i = 0; i < this.cantidadDeNodos; i++) {
						this.nodos[i] = new Nodo(i, 0, 0);
					}

					this.matriz = new MatrizSimetrica(this.cantidadDeNodos);
					bandera = true;
				} else {
					fila = Integer.parseInt(data[0]);
					columna = Integer.parseInt(data[1]);

					matriz.setIJ(fila, columna);
					this.nodos[fila].setGrado(this.nodos[fila].getGrado() + 1);
					this.nodos[columna].setGrado(this.nodos[columna].getGrado() + 1);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public GrafoNDNP(MatrizSimetrica matriz, int cantNodos, int cantAristas, double PorcAdyacencia, int gMin, int gMax) {
		this.matriz = matriz;
		this.cantidadDeNodos = cantNodos;
		this.cantidadDeAristas = cantAristas;
		this.porcentajeAdyacencia = PorcAdyacencia;
		this.gradoMinimo = gMin;
		this.gradoMaximo = gMax;
	}
	
	public MatrizSimetrica getMatrizSimetrica() {
		return this.matriz;
	}

	public void colorearPowell() {
		ordenarGradoMayorAMenor(nodos, 0, nodos.length - 1);
		colorear();
	}

	private void ordenarGradoMayorAMenor(Nodo[] nodos2, int i, int j) {
		// TODO Auto-generated method stub
		
	}

	public void colorearMatula() {

		ordenarGradoMenorAMayor(nodos, 0, nodos.length - 1);
		colorear();
	}

	private void ordenarGradoMenorAMayor(Nodo[] nodos2, int i, int j) {
		// TODO Auto-generated method stub
		
	}

	public void colorearSecuencialAleatorio() {
		colorear();
	}

	private void colorear() {
	}
}


