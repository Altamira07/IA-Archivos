package clases;

import java.util.Scanner;

public class Main {
	Scanner teclado;
	Maestro maestro;
	Arbol arbol;
	Indice indice ;
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
			imprime("2: Agregar registro ");
			imprime("3: Salir");
			opcion = teclado.nextInt();
			switch(opcion)
			{
			case 1:
				buscar();
				break;
			case 2: 
				agregar();
				arbol.raiz = null;
				indice.leerSecuencial();
				break;
			default:
				opcion =3;
			}
		}while (opcion != 3);
			
	}
	public void agregar ()
	{
		int opcion = 0;
		do{
			Registro nuevo = new Registro();
			long posicion;
			nuevo.llave = arbol.ultimo+1;
			imprime("Llave del ultimo registro"+nuevo.llave);
			imprime("Origen");
			nuevo.origen = teclado.next().charAt(0);
			imprime("Destino");
			nuevo.destino = teclado.next().charAt(0);
			posicion = maestro.escribir(nuevo);
			indice.escribir(nuevo.llave, posicion);
			imprime("Se agrego con exito");
			imprime("Otro registro ? 1: si, 2:No");
			opcion = teclado.nextInt();
		}while(opcion == 1);
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
				maestro.busquedaSecuencial(llave);
			else
			{
				dirLogica = arbol.buscar(opcion);
				if(dirLogica != -1)
					maestro.leerAleatorio(dirLogica);
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
}
