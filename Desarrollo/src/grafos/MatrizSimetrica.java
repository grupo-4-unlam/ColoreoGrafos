package grafos;

public class MatrizSimetrica {

	private int dimensiones;
	private int[] matriz;
	
	public MatrizSimetrica(int dimensiones){
		this.dimensiones = dimensiones;
		//vector con el tama�o para uno de los triangulos y la diagonal principal
		matriz = new int[((dimensiones+1)*dimensiones)/2];
	}
	
	public boolean agregarNumero(int fila,int columna,int num) {
		if(fila>=dimensiones || columna>=dimensiones)
			return false;
		int filaAux,columnaAux;
		if(fila>columna) {
			filaAux = columna;
			columnaAux = fila;
		}else {
			filaAux = fila;
			columnaAux = columna;
		}
		matriz[(((dimensiones+1)*dimensiones)/2)-(((dimensiones-filaAux+1)*(dimensiones-filaAux))/2)+(columnaAux-filaAux)] = num;
		return true;
	}
	
	public int getNumero(int fila,int columna) {
		int filaAux,columnaAux;
		if(fila>columna) {
			filaAux = columna;
			columnaAux = fila;
		}else {
			filaAux = fila;
			columnaAux = columna;
		}
		return matriz[(((dimensiones+1)*dimensiones)/2)-(((dimensiones-filaAux+1)*(dimensiones-filaAux))/2)+(columnaAux-filaAux)];
	}
}
