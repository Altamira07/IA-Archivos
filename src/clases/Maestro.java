package clases;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Maestro extends Archivo {

	public Maestro(String nombre) {
		super(nombre);
	}
	
	public long escribir (String [] registro,int llave)
	{
		long ultimoRegistro = 0;
		try{
			archivo = new RandomAccessFile(nombre, "rw");
			ultimoRegistro = archivo.length();
			archivo.seek(ultimoRegistro);
			archivo.writeInt(llave);
			for(int i = 0; i < registro.length; i++)
				archivo.writeChar(registro[i].charAt(0));
		}catch (IOException ex){
			ex.getMessage();
		}
		return ultimoRegistro;
	}
	
	public void leerSecuencial(int tamano) 
	{
		Registro registro = new Registro();
		char c;
		try{
			archivo = new RandomAccessFile(nombre,"r");
			while (archivo.getFilePointer() != archivo.length())
			{
				registro.llave = archivo.readInt();
				System.out.println(registro.llave);
				for(int i = 0 ; i< tamano; i++)
				{
					c =  archivo.readChar();
					System.out.println(c);
				}
			}
			archivo.close();
		}catch (IOException ex){
			ex.getMessage();
		}
	}
	public void busquedaSecuencial(int llave,int tamano)
	{
		Registro registro = new Registro(tamano);
		boolean encontrado = false;
		try{
			archivo = new RandomAccessFile(nombre,"r");
			while (archivo.getFilePointer() != archivo.length())
			{
				registro.llave = archivo.readInt();
				System.out.printf("Voy en la llave" + registro.llave+" conexiones:");
				for (int i = 0 ; i < tamano; i++)
				{
					char d = archivo.readChar();
					System.out.printf(d +"-" );
				}
				if(registro.llave == llave)
				{
					System.out.println("La encontre :)");
					encontrado = true;
					break;
				}
				System.out.println("");
			}
			archivo.close();
		}catch (IOException ex){
			ex.getMessage();
		}
	}
	public String [][]cargarMatriz (int tamano)
	{
		String [][] matriz_adyacencia = new String [tamano][tamano];
 		char c;
 		int j = 0;
		try{
			archivo = new RandomAccessFile(nombre,"r");
			while (archivo.getFilePointer() != archivo.length())
			{
				archivo.readInt();
				for(int i = 0 ; i< tamano; i++)
				{
					c =  archivo.readChar();
					matriz_adyacencia[j][i]= c+"";
				}
				j++;
			}
			archivo.close();
		}catch (IOException ex){
			ex.getMessage();
		}
		return matriz_adyacencia;
	}
	public void leerAleatorio(long posicion,int tamano) 
	{
		Registro registro = new Registro(tamano);
		try {
			archivo = new RandomAccessFile(nombre, "r");
			archivo.seek(posicion);
			registro.llave = archivo.readInt();
			for (int i = 0 ; i < tamano; i++)
			{
				char d = archivo.readChar();
				System.out.printf(d +"-" );
			}
			archivo.close();
		}catch (IOException ex){
			ex.getMessage();
		}
	}
}
