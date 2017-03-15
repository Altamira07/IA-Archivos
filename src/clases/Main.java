package clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
	Scanner teclado;
	Maestro maestro;
	Arbol arbol;
	Indice indice ;
	int tamanoRegisto = 6;
	public static void main (String args[])
	{
		new Main();
	}
	public Main ()
	{
		teclado = new Scanner(System.in);
		maestro = new Maestro("biblioteca.dat");
		arbol = new Arbol();
		indice = new Indice("indice.dat",arbol);
		init();
	}
	public void init()
	{
		int opcion = 0;
		indice.leerSecuencial();
		do{
			imprime("Que deseas hacer?");
			imprime("1: Buscar registro ");
			imprime("2: Realizar busqueda sobre le grafo");
			imprime("3: Agrgar un nuevo grafo desde archivo externo");
			imprime("4: Salir");
			opcion = teclado.nextInt();
			switch(opcion)
			{
			case 1:
				buscar();
				break;
			case 2: 
				busquedaGrafo();
				break;
			case 3:
				cargarMatriz();
				break;
			default:
				opcion =4;
			}
		}while (opcion != 4);
			
	}
	public void agregar(String[] registro, int llave)
	{
		long posicion;
		posicion = maestro.escribir(registro,llave);
		indice.escribir(llave, posicion);
	}
	public void busquedaGrafo()
	{
		Busqueda busqueda = new Busqueda();
		String matriz [][] = maestro.cargarMatriz(tamanoRegisto);
		busqueda.matriz_adyacencia = matriz;
		busqueda.busquedaAnchura();
	}
	public void buscar ()
	{
		int opcion = 0;
		int llave = 0;
		long dirLogica;
		do{
			imprime ("Que llave deseas buscar ? ");
			llave = teclado.nextInt();
			imprime("Como deseas hacerlo ? 1: aleatorio, 2: secuencial");
			opcion = teclado.nextInt();
			if(opcion == 2)
				maestro.busquedaSecuencial(llave,tamanoRegisto);
			else
			{
				dirLogica = arbol.buscar(llave);
				if(dirLogica != -1)
					maestro.leerAleatorio(dirLogica,tamanoRegisto);
				else
					imprime("Esa llave no se encuentra :( ");
			}
			imprime("Deseas hacer otra busqueda? 1: si, 2: no");
			opcion = teclado.nextInt();
		}while(opcion == 1);
	}
	
	public void imprime(String mensaje)
	{
		System.out.println(mensaje);
	}
	
	public void cargarMatriz()
	{
		try{
			File archivo = new File("matriz.txt");
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			String linea="";
			String registro[];
			int llave = 1;
			while ((linea = br.readLine()) != null)
			{
				registro = linea.split("-");
				tamanoRegisto = registro.length;
				agregar(registro,llave);
				llave ++;
			}
			
		}catch(Exception ex){
			
		}
		
	}
}
