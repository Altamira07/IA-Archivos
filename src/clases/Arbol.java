package clases;

public class Arbol {
	Nodo raiz = null;
	int ultimo;
	public void insertar (int llave, long dirLogica)
	{
		Nodo nuevo;
		Nodo ant = null;
		Nodo rec;
		if (raiz == null) 
		{
			raiz = new Nodo(llave, dirLogica);
			//System.out.println("valor insertado \n ");
		}else{
			nuevo = new Nodo(llave, dirLogica);
			rec = raiz;
			while(rec !=  null)
			{
				ant = rec;
				if (rec.llave > nuevo.llave)
					rec = rec.izq;
				else
					rec = rec.der;
			}
			if(ant.llave > nuevo.llave)
				ant.izq = nuevo;
			else
				ant.der = nuevo;
			
		}
		ultimo = llave;
	}
	
	public long buscar(int llave)
	{
		long posicion = -1;
		Nodo rec;
		Nodo ant;
		if(raiz == null)
			System.out.println("En este momento el arbol se encuentra vacio :( ");
		else
		{
			rec = raiz;
			ant = raiz;
			while ((ant.llave!= llave) && (rec!= null))
			{
				ant = rec;
				if(rec.llave > llave)
					rec = rec.izq;
				else
					rec = rec.der;
			}
			if (ant.llave == llave){
				System.out.println("El valo se encuentra en el arbol "+ant.llave);
				posicion = ant.dirlogica;
			}else
				System.out.println("El valor no se encuentra en el arbol :(");
		}
		return posicion;
	}
	
	private class Nodo 
	{
		int llave; 
		long dirlogica;
		Nodo izq;
		Nodo der;
		public Nodo (int llave, long dirlogica, Nodo izq, Nodo der)
		{
			this.llave = llave;
			this.dirlogica = dirlogica;
			this.izq = izq;
			this.der = der;
		}
		
		public Nodo(int llave, long dirLogica)
		{
			this(llave,dirLogica,null,null);
		}
	}
}
