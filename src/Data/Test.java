package Data;
import Logic.*;
import Structures.LinkedList;
import java.util.Random;

public class Test {
	
	
	public static String palabra(Random random1, int palabra) {
		String abcMayus = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String abcMinus = "abcdefghijklmnopqrstuvwxyz";
		
		StringBuilder aux = new StringBuilder();
		int rand = random1.nextInt(abcMayus.length());
		char primeraLetra = abcMayus.charAt(rand);
		int rand2 = random1.nextInt(abcMinus.length());
		char segundaLetra = abcMinus.charAt(rand2);
		String mix = String.valueOf(primeraLetra) + segundaLetra;
		
		for(int i = 0; i < palabra-1; i++) {
			int rand3 = random1.nextInt(abcMinus.length());
			char palabra1 = abcMinus.charAt(rand3);
		    aux.append(palabra1);
		    }
		
		String palabraFinal = mix + aux.toString();
		
		return palabraFinal;
		
	}
	
	public static void main(String[] args) {
		
		LinkedList<Restaurante> Restaurantes = new LinkedList<>();
		
		for (int i=0; i<1800; i++) {
			int palabra = 10, descrip = 60, minp = 50, maxp=500;
		    Random random = new Random();
		    String nombreRestaurante = palabra(random, palabra);
		    String direccion = palabra(random, descrip);
		    
		    Restaurante restaurante1 = new Restaurante(nombreRestaurante, direccion);
			Restaurantes.add(restaurante1);
		    
		    for (int j=0; j<150; j++) {

			    Random random2 = new Random();

			    String plato = palabra(random2, palabra);
			    String descripcion = palabra(random2, descrip);
			    int precio = (int) ((Math.random() * (maxp - minp)) + minp)*100;
			    
			    Restaurantes.get(i).crearPlato(plato, descripcion, precio);
			}
		    for (int j=0; j<70; j++) {

			    Random random3 = new Random();

			    String bebida = palabra(random3, palabra);
			    String descripcion = palabra(random3, descrip);
			    int precio = (int) ((Math.random() * (maxp - minp)) + minp)*100;
			    Boolean alc = random3.nextBoolean();
			    
			    Restaurantes.get(i).crearBebida(bebida,descripcion,precio,alc);  
			}   
		}
		Bestellen.archivoInicial(Restaurantes);
		}
	}
