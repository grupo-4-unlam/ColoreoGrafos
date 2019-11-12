package grafos;

public class Main {

	public static void main(String[] args) {
		//PROBANDO CUENTAS
		int n=5;
		int f=3;
		int c=4;
		int auxConst = ((n+1)*n)/2; 
		int auxVar = ((n-f+1)*(n-f))/2;
		System.out.println(auxConst - auxVar+(c-f));
		

	}

}
