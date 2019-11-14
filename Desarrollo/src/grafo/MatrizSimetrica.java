package grafo;

//  implementacion de la Class MatrizSimetrica implementada en un vector

public class MatrizSimetrica {
	public boolean[] matrizEnVector;
	private int cantNodos;
	
	public MatrizSimetrica(int cantNodos){
		this.cantNodos = cantNodos;
		int cantidadDePosiciones = (cantNodos * (cantNodos - 1)) / 2;
		this.matrizEnVector = new boolean[cantidadDePosiciones];
	}
	
	public void setIJ(int fila, int columna) {

		int indice = calcularIndiceEnVector(fila, columna);
		this.matrizEnVector[indice] = true;
	}

	public boolean getIJ(int fila, int columna) {

		int indice = calcularIndiceEnVector(fila, columna);
		return this.matrizEnVector[indice];
	}

	public int calcularIndiceEnVector(int fila, int columna) {
		if (columna < fila) {
			int aux = fila;
			fila = columna;
			columna = aux;
		}
		return (fila * cantNodos + columna - (fila * fila + 3 * fila + 2) / 2);
	}

	//	public int getCantAristas() {
	//		return matrizEnVector.length;
	//	}
	//
	
	public int getCantNodos() {
		return this.cantNodos;
	}

	public boolean hayArista(int pos) {
		return this.matrizEnVector[pos];
	}
	
	public void ponerArista(int pos) {
		this.matrizEnVector[pos] = true;
	}
}
