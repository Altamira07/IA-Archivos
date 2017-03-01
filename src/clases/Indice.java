package clases;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Indice extends Archivo
{
	private Arbol arbol;
	public Indice(String nombre,Arbol arbol) {
		super(nombre);
		this.arbol = arbol;
	}
	public void escribir(int llave, long posicion)
	{
		try{
			archivo = new RandomAccessFile(nombre, "rw");
			long posFinal = archivo.length();
			archivo.seek(posFinal);
			archivo.writeInt(llave);
			archivo.writeLong(posicion);
			archivo.close();
		}catch(IOException ex){
			
		}
	}
	@Override
	public void leerSecuencial() {
		int llave; 
		long dirLogica;
		try {
			archivo = new RandomAccessFile(nombre, "r");
			System.out.println("Leyendo indice y cargando al arbol");
			while (archivo.getFilePointer() != archivo.length())
			{
				llave = archivo.readInt();
				dirLogica = archivo.readLong();
				System.out.println("llave = "+llave +" dirLogica "+dirLogica);
				arbol.insertar(llave, dirLogica);
			}
			archivo.close();
		}catch (IOException ex){
			
		}
	
	}

	


	
}
