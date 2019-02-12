package es.studium.FicheroContarPalabras;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FicheroContarPalabras
{
	public static void main(String[] args)
	{
		// Creamos objeto entrada, enlazado al teclado
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		String fichero = "";
		String lineaFichero = "";
		String contenidoFichero = "";
		String cadenaBuscada = "";
		int contador = 0;
		try
		{
			// Preguntamos al usuario por el nombre del fichero
			System.out.println("Indicar el nombre del fichero:");
			fichero = entrada.readLine();
			// Origen de los datos
			FileReader fr = new FileReader(fichero);
			// Buffer de lectura
			BufferedReader origen = new BufferedReader(fr);
			// Sacamos el contenido del fichero y lo guardamos en la variable contenido
			while((lineaFichero=origen.readLine())!=null)
			{
				contenidoFichero += lineaFichero;
			}
			// Preguntar por la palabra a buscar
			System.out.println("Indicar la palabra a buscar en el fichero:");
			cadenaBuscada = entrada.readLine();
			// Buscar la palabra en el contenido del fichero
		    while (contenidoFichero.indexOf(cadenaBuscada) > -1) 
		    {
		    	contenidoFichero = contenidoFichero.substring(contenidoFichero.indexOf(cadenaBuscada)+cadenaBuscada.length(),contenidoFichero.length());
		        contador++; 
		    }
			if(contador!=0)
			{
				System.out.println("La palabra '" + cadenaBuscada + "' est� en el fichero " + fichero + " y aparece " + contador + " veces.");
			}
			else
			{
				System.out.println("La palabra '" + cadenaBuscada + "' NO est� en el fichero " + fichero);
			}
			//Cerrar los objetos
			entrada.close();
			origen.close();
			fr.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Archivo NO encontrado");
		}
		catch(IOException i)
		{
			System.out.println("Se produjo un error de Archivo:"+i.getMessage());
		}
	}
}