package clases;

public class Registro 
{
	public int llave;
	public char origen, destino;
	@Override
	public  String toString ()
	{
		return "Llave: "+llave + " origen: " + origen + " destino: "+ destino;
	}
}
