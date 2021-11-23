package Data;
import Logic.*;
import Structures.LinkedList;

import java.util.Random;

public class Test {
	
	
	public static void main(String[] args) {
		
		LinkedList<Restaurante> Restaurantes = new LinkedList<>();
		
		for (int i=0; i<100; i++) {
			int a = 97; // letter 'a'
		    int z = 122; // letter 'z'
		    int palabra = 10;
		    Random random1 = new Random();

		    String nombreRestaurante = random1.ints(a, z + 1)
		      .limit(palabra)
		      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
		      .toString();

		    //System.out.println(nombreRestaurante);
		    
		    Random random2 = new Random();
		    
		    String direccion = random2.ints(a, z + 1)
				      .limit(palabra)
				      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				      .toString();
		    
		    Restaurante restaurante1 = new Restaurante(nombreRestaurante, direccion);
			Restaurantes.add(restaurante1);

				    //System.out.println(nombreRestaurante);
		    //Restaurante restaurante1 = new Restaurante(nombreRestaurante, direccion);
			
		}
		
		Bestellen.crearArchivo(Restaurantes);
		
		}

	}
