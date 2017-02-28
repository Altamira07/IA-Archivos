package clases;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Maestro extends Archivo {

	public Maestro(String nombre) {
		super(nombre);
	}
	@Override
	public long escribir(Registro registro)
	{
		long ultimoRegistro = 0;
		try{
			archivo = new RandomAccessFile(nombre, "rw");
			ultimoRegistro = archivo.length();
			archivo.seek(ultimoRegistro);
			archivo.writeInt(registro.llave);
			archivo.writeChar(registro.origen);
			archivo.writeChar(registro.destino);
			archivo.close();
		}catch (IOException ex){
			ex.getMessage();
		}
		return ultimoRegistro;
	}
	@Override
	public void leerSecuencial() 
	{
		Registro registro = new Registro();
		try{
			archivo = new RandomAccessFile(nombre,"r");
			while (archivo.getFilePointer() != archivo.length())
			{
				registro.llave = archivo.readInt();
				registro.origen = archivo.readChar();
				registro.destino = archivo.readChar();
				System.out.println(registro.toString());
				
			}
			archivo.close();
		}catch (IOException ex){
			ex.getMessage();
		}
	}
	@Override
	public void leerAleatorio(long posicion) 
	{
		Registro registro = new Registro();
		try {
			archivo = new RandomAccessFile(nombre, "r");
			archivo.seek(posicion);
			registro.llave = archivo.readInt();
			registro.origen = archivo.readChar();
			registro.destino = archivo.readChar();
			System.out.println(registro.toString());
			archivo.close();
		}catch (IOException ex){
			ex.getMessage();
		}
	}
}
