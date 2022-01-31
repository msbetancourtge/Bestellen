package Data;
import Logic.*;
import Structures.AVLTree;
import Structures.TreeNode;
import java.util.Random;

public class Test {
	
	public static String palabra(Random random1, int palabra) {
		String abcMinus = "abcdefghijklmnopqrstuvwxyz ";
		StringBuilder aux = new StringBuilder();

		for(int i = 0; i < palabra; i++) {
			int rand2 = random1.nextInt(abcMinus.length());
			char palabra1 = abcMinus.charAt(rand2);
		    aux.append(palabra1);
		    }
		String palabraFinal = aux.toString();
		return palabraFinal;	
	}
	public static String email(Random random1, int email, int dominio) {

		String abcMinus = "abcdefghijklmnopqrstuvwxyz";
		StringBuilder aux = new StringBuilder();
		for(int i = 0; i < email; i++) {
			int rand3 = random1.nextInt(abcMinus.length());
			char palabra1 = abcMinus.charAt(rand3);
		    aux.append(palabra1);
		    }
		aux = aux.append('@');
		for(int i = 0; i < dominio; i++) {
			int rand4 = random1.nextInt(abcMinus.length());
			char palabra2 = abcMinus.charAt(rand4);
		    aux.append(palabra2);
		    }
		String finalEmail = aux.toString();
		finalEmail+=".com";
		return finalEmail;
	}

	private static TreeNode <Restaurante> find(TreeNode<Restaurante> root, int pos){
		
		if (root==null) return root;
		int compare = pos - root.getData().getId();
		if (compare < 0) return find(root.getLeft(), pos);
		else if(compare > 0) return find(root.getRight(), pos); 
		else; 
		return root;
	}
	
	public static void main(String[] args) {
		
		AVLTree<Restaurante> Restaurantes = new AVLTree<Restaurante>();
		AVLTree<Usuario> Usuarios = new AVLTree<Usuario>();

		//Restaurantes
		for (int i=0; i<5000; i++) {
			int palabra = 10, descrip = 60, minp = 50, maxp=500;
		    Random random = new Random();
		    String nombreRestaurante = palabra(random, palabra);
		    String direccion = palabra(random, descrip);
		    
		    Restaurante restaurante1 = new Restaurante(Restaurantes.getSize(), nombreRestaurante, direccion);
			Restaurantes.insert(restaurante1);
		    
		    for (int j=0; j<150; j++) {

			    Random random2 = new Random();
			    String plato = palabra(random2, palabra);
			    String descripcion = palabra(random2, descrip);
			    int precio = (int) ((Math.random() * (maxp - minp)) + minp)*100;
			    find(Restaurantes.getRoot(), i).getData().crearPlato(plato, descripcion, precio);
			}
		    for (int j=0; j<70; j++) {

			    Random random3 = new Random();
			    String bebida = palabra(random3, palabra);
			    String descripcion = palabra(random3, descrip);
			    int precio = (int) ((Math.random() * (maxp - minp)) + minp)*100;
			    Boolean alc = random3.nextBoolean();
			    find(Restaurantes.getRoot(), i).getData().crearBebida(bebida,descripcion,precio,alc);
			}   
		}
		
		//Usuarios
		for (int i=0; i<5000; i++) {
			int palabra = 12, e = 10, dominio = 10;
		    Random random = new Random();
		    String nombre = palabra(random, palabra);
		    String email = email(random, e, dominio);
		    
		    int i1 = 10000000;
		    int i2 = 1111111111;
		    int cedula = i1 + (int) (Math.random() * (i2 - i1));		    
		    long l1 = 3000000000L;
		    long l2 = 3209999999L;
		    long telefono = l1 + (long) (Math.random() * (l2 - l1));
		    Usuario cliente = new Usuario(nombre,email,cedula,telefono);
			Usuarios.insert(cliente);

		}
		System.out.println("Árboles Creados");		
		Bestellen.archivoInicial(Restaurantes, Usuarios);
		}
	}
