package clases;

public class Main {
	public static void main (String args[])
	{
		Maestro m = new Maestro("biblioteca.dat");
		/*Registro r = new Registro();
		r.llave = 1;
		r.destino = 'b';
		r.origen = 'a';
		System.out.println(m.escribir(r));
		
		r.llave = 2;
		r.destino = 'c';
		r.origen = 'b';
		m.escribir(r);
		r.llave = 3;
		r.destino = 'd';
		r.origen = 'c';
		m.escribir(r);
		r.llave = 4;
		r.destino = 'e';
		r.origen = 'd';
		m.escribir(r);
	
		m.leerSecuencial();*/
		m.leerAleatorio(32);
	}
}
