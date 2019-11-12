package grafo;

public class GrafoNDNP {
	private MatrizSimetrica matriz;
	private int cantidadDeNodos;
	private int cantidadDeAristas;
	private double porcentajeAdyacencia;
	private int gradoMaximo;
	private int gradoMinimo;
	private Nodo[] nodos;
	private int cantidadDeColores; 
	
	public GrafoNDNP(MatrizSimetrica matriz, int cantNodos, int cantAristas, double PorcAdyacencia, int gMin, int gMax) {
		this.matriz = matriz;
		this.cantidadDeNodos = cantNodos;
		this.cantidadDeAristas = cantAristas;
		this.porcentajeAdyacencia = PorcAdyacencia;
		this.gradoMinimo = gMin;
		this.gradoMaximo = gMax;
	}

}
