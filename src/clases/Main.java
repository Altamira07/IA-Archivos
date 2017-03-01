package clases;

import java.util.Scanner;

public class Main {
	public static void main (String args[])
	{
		Maestro m = new Maestro("biblioteca.dat");
		Arbol a = new Arbol();
		Indice i = new Indice ("indice.dat",a);
		Registro r = new Registro();
		Scanner s = new Scanner(System.in);
		int opcion = 1;
		/*
		long pos;
		
		r.llave = 1;
		r.destino = 'b';
		r.origen = 'a';
		pos =  m.escribir(r);
		System.out.println("Posicion "+pos);
		i.escribir(r.llave, pos);
		System.out.println("Escribiendo llave");
		
		r.llave = 2;
		r.destino = 'c';
		r.origen = 'b';
		pos = m.escribir(r);
		System.out.println("Posicion "+pos);
		i.escribir(r.llave, pos);
		System.out.println("Escribiendo llave");
		
		r.llave = 3;
		r.destino = 'd';
		r.origen = 'c';
		pos = m.escribir(r);
		System.out.println("Posicion "+pos);
		i.escribir(r.llave, pos);
		System.out.println("Escribiendo llave");
		
		r.llave = 4;
		r.destino = 'e';
		r.origen = 'd';
		pos = m.escribir(r);
		System.out.println("Posicion "+pos);
		i.escribir(r.llave, pos);
		System.out.println("Escribiendo llave");
		
		r.llave = 5;
		r.destino = 'f';
		r.origen = 'e';
		pos = m.escribir(r);
		System.out.println("Posicion "+pos);
		i.escribir(r.llave, pos);
		System.out.println("Escribiendo llave");
		
		*/
		i.leerSecuencial();
		do{
			System.out.println("Que llave deseas buscar ? ");
			int llave = s.nextInt();
			long pos =  a.buscar(llave);
			if (pos != 0) {
				m.leerAleatorio(pos);
			}else{
				System.out.println("No se encontro esa llave");
			}
			System.out.println("Deseas hacer otra busqueda ? 1= si, 2 = no ");
		}while (opcion == 1);
		
	}
}
