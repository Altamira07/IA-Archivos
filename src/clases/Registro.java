package clases;

public class Registro 
{
	public int llave;
	public char origen, destino;
	public  String conexiones[];
	public int cantidad;
	int i;
	public Registro(int cantidad)
	{
		i = 0;
		conexiones = new String [cantidad];
	}
	public Registro()
	{
		
	}
	@Override
	public  String toString ()
	{
		String data = "";
		for (int i = 0 ; i < conexiones.length; i++)
			data += conexiones[i];
		return "Llave: "+llave + "Conexiones" + data;
	}
	public boolean insetConexiones(String valor)
	{
		if(i < conexiones.length)
		{
			conexiones[i] = valor;
			i++;
			return true;
		}
		return false;
	}
}
