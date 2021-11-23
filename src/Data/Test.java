package Data;
import Logic.*;
import Structures.LinkedList;
import java.util.Random;

public class Test {
	
	public static void main(String[] args) {
		
		LinkedList<Restaurante> Restaurantes = new LinkedList<>();
		LinkedList<Plato> platos = new LinkedList<>();
		LinkedList<Bebida> bebidas = new LinkedList<>();
		
		for (int i=0; i<100; i++) {
			int a = 97, z = 122, palabra = 10, descrip = 100, minp = 5000, maxp=50000;
		    Random random1 = new Random();

		    String nombreRestaurante = random1.ints(a, z + 1)
		      .limit(palabra)
		      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
		      .toString();
		    
		    Random random2 = new Random();
		    
		    String direccion = random2.ints(a, z + 1)
				      .limit(palabra)
				      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				      .toString();
		    
		    Restaurante restaurante1 = new Restaurante(nombreRestaurante, direccion);
			Restaurantes.add(restaurante1);
		    
		    for (int j=0; j<5; j++) {

			    Random random3 = new Random();

			    String plato = random3.ints(a, z + 1)
			      .limit(palabra)
			      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
			      .toString();
			    
			    Random random4 = new Random();
			    
			    String descripcion = random4.ints(a, z + 1)
					      .limit(descrip)
					      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
					      .toString();
			    
			    int precio = (int) ((Math.random() * (maxp - minp)) + minp);
			    
//			    Plato plato1 = new Plato (plato, descripcion, precio);
//			    platos.add(plato1);   
			    Restaurantes.get(i).crearPlato(plato, descripcion, precio);
			}
		    
		    for (int j=0; j<5; j++) {

			    Random random5 = new Random();

			    String bebida = random5.ints(a, z + 1)
			      .limit(palabra)
			      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
			      .toString();
			    
			    Random random6 = new Random();
			    
			    String descripcion = random6.ints(a, z + 1)
					      .limit(descrip)
					      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
					      .toString();
			    
			    int precio = (int) ((Math.random() * (maxp - minp)) + minp);
			    
			    Boolean alc = random6.nextBoolean();
			    
			    Restaurantes.get(i).crearBebida(bebida,descripcion,precio,alc);  
			}   
		}
		
		Bestellen.crearArchivo(Restaurantes);
		
		}

	}
