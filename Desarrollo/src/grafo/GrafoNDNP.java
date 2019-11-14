package grafo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

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

	

//	public void colorearSecuencialAleatorio() {
//		colorear();
//	}	
	
//	public void colorearPowell() {
//		ordenarGradoMayorAMenor(nodos, 0, nodos.length - 1);
//		colorear();
//	}

//	public void colorearMatula() {
//
//		ordenarGradoMenorAMayor()
//		colorear();
//	}

	private void ordenarGradoMayorAMenor() {
		Arrays.sort(this.nodos, new Comparator<Nodo>() {
			@Override
			public int compare(Nodo nodo1, Nodo nodo2) {
				return nodo2.getGrado() - nodo1.getGrado();
			}
		});
	}

	private void ordenarGradoMenorAMayor() {
		Arrays.sort(this.nodos, new Comparator<Nodo>() {
			@Override
			public int compare(Nodo nodo1, Nodo nodo2) {
				return nodo1.getGrado() - nodo2.getGrado();
			}
			
		});
	}


	private void colorear() {
		int nodo, indice=0, j, color=1;
		for(int i = 1; i < this.cantidadDeNodos; i++) {
			nodo = this.nodos[i].getNumero();
			this.nodos[nodo].setColor(color);
			j=0;
			while ( j < this.cantidadDeNodos) {
				if(nodo != j)
					if(nodo < j)
						indice = this.matriz.calcularIndiceEnVector(nodo, j);
					else
						indice = this.matriz.calcularIndiceEnVector(j, nodo);
				if(this.matriz.hayArista(indice) && this.nodos[nodo] == this.nodos[j]) {
					color++;
					if(color > cantidadDeColores)
						cantidadDeColores = color;
					this.nodos[nodo].setColor(color);
					j=-1;
				}
				j++;
			}
			color = 1;
		}
	}
}


