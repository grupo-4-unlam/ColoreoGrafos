package grafos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import grafo.GeneradorDeGrafos;
import grafo.GrafoNDNP;
import grafo.ImpresorGrafo;
public class Main {

	public static void main(String[] args) throws IOException {
		//PROBANDO CUENTAS
		int n=5;
		int f=0;
		int c=0;
//		int auxConst = ((n+1)*n)/2; 
		int auxVar = ((n-f+1)*(n-f))/2;
		System.out.println(auxVar+(c-f)-1);
		//GeneradorDeGrafos generador = new GeneradorDeGrafos();
		GrafoNDNP grafo = GeneradorDeGrafos.generarRegularNYGrado(5, 4);
	
		ImpresorGrafo.imprimirGrafo(grafo);
		


	}

}
