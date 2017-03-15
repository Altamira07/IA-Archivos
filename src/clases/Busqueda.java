package clases;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Busqueda 
{
	String matriz_adyacencia [][]; 
	/*= {
			{"a","1","0","0","1","0",},
			{"1","b","1","0","1","0",},
			{"0","1","c","1","0","0",},
			{"0","0","1","d","1","1",},
			{"1","1","0","1","e","0",},
			{"0","0","0","1","0","f",}
			};*/
	public Busqueda (String matriz[][])
	{
		matriz_adyacencia = matriz;
	}
	public Busqueda (){
		
	}
	public void busquedaAnchura()
	{
		Queue<String> secuencia = new LinkedList<>();
		ArrayList<String> pasados = new ArrayList<>();
		int j = 5 ; //Renglon a partir de donde hare la busqueda
		secuencia.add(matriz_adyacencia[j][j]);
		pasados.add(matriz_adyacencia[j][j]);
		while(!secuencia.isEmpty())
		{
			String x = secuencia.poll();
			j = equivalencia(x);
			for(int i = 0; i < matriz_adyacencia.length; i++)
			{
				if (matriz_adyacencia[j][i].equals("1"))
				{
					String y = matriz_adyacencia[i][i];
					secuencia.add(y);
					if (!pasados.contains(matriz_adyacencia[i][i]))
					{
						imprime("("+x+","+y+")");
						pasados.add(y);
					}
				}
				matriz_adyacencia[j][i] = matriz_adyacencia[i][j] = "-1";
			}	
		}
	
	}
	public int equivalencia(String valor)
	{
		for (int i = 0 ; i < matriz_adyacencia.length; i++)
			if (matriz_adyacencia[i][i].equals(valor))
			return i;
		return 0;
	}
	public void imprime(String t)
	{
		System.out.println(t);
	}
}
