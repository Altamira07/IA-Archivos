package clases;

import java.io.RandomAccessFile;

public class  Archivo 
{
	RandomAccessFile archivo;
	String nombre;
	public Archivo (String nombre)
	{
		this.nombre= nombre;
	}
	public long escribir(Registro registro){ return 0;}
	public void leerSecuencial(){}
	public void leerAleatorio(long posicion){ }
}
