package Data;
import Logic.*;
import Structures.AVLTree;
import Structures.LinkedList;
import Structures.QPHashTable;
import Structures.TreeNode;
import java.util.Random;
import java.util.Scanner;

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
	
private static TreeNode <Usuario> findUser(TreeNode<Usuario> root, int cc){
		
		if (root==null) return root;
		int compare = cc - root.getData().getCc();
		if (compare < 0) return findUser(root.getLeft(), cc);
		else if(compare > 0) return findUser(root.getRight(), cc); 
		else; 
		return root;
	}
	
	public static Plato eleccionPlatos(Restaurante rest) {
		Random random = new Random();
		int rand = random.nextInt(rest.platos.size());
		return rest.platos.get(rand);
		
	}
	public static Bebida eleccionBebidas(Restaurante rest) {
		Random random = new Random();
		int rand = random.nextInt(rest.bebidas.size());
		return rest.bebidas.get(rand);
	}
	
	
	public static void generarOrden(Usuario user, Restaurante rest, AVLTree<Factura> facturas, int personas) {
		
		LinkedList<Plato> ordenPlatos = new LinkedList<>();
		LinkedList<Bebida> ordenBebidas = new LinkedList<>();
		
			for(int k=1; k<=personas; k++) {
				ordenPlatos.add(eleccionPlatos(rest));
				ordenBebidas.add(eleccionBebidas(rest));
			}
			Orden pedido = new Orden(rest, user, ordenPlatos, ordenBebidas);
			Factura temp = pedido.facturar(facturas.getSize(), user, rest);
			facturas.insert(temp);
			user.agregarFactura(temp);
			StringBuilder aux = new StringBuilder();
			aux.append(user.getNombre().charAt(0));
			String key=Integer.toString(temp.getId());
			String finalkey=aux.toString();
			finalkey+=key;
			user.agregarOrden(pedido, finalkey);
	}
	
	
	public static void main(String[] args) {
		
		LinkedList<Integer> ccs = new LinkedList<>();
		
		AVLTree<Restaurante> Restaurantes = new AVLTree<Restaurante>();
		AVLTree<Usuario> Usuarios = new AVLTree<Usuario>();
		long totalR=0;
		long initR = System.currentTimeMillis();

		//Restaurantes
		for (int i=0; i<100; i++) {
			int palabra = 10, descrip = 60, minp = 50, maxp=500;
		    Random random = new Random();
		    String nombreRestaurante = palabra(random, palabra);
		    String direccion = palabra(random, descrip);
		    String pass = palabra(random, palabra);
		    AVLTree<Factura> facturas = new AVLTree<Factura>();
		    Restaurante restaurante1 = new Restaurante(Restaurantes.getSize(), nombreRestaurante, direccion, pass, facturas);
			Restaurantes.insert(restaurante1);
		    
		    for (int j=0; j<20; j++) {

			    Random random2 = new Random();
			    String plato = palabra(random2, palabra);
			    String descripcion = palabra(random2, descrip);
			    int precio = (int) ((Math.random() * (maxp - minp)) + minp)*100;
			    find(Restaurantes.getRoot(), i).getData().crearPlato(plato, descripcion, precio);
			}
		    for (int j=0; j<10; j++) {

			    Random random3 = new Random();
			    String bebida = palabra(random3, palabra);
			    String descripcion = palabra(random3, descrip);
			    int precio = (int) ((Math.random() * (maxp - minp)) + minp)*100;
			    Boolean alc = random3.nextBoolean();
			    find(Restaurantes.getRoot(), i).getData().crearBebida(bebida,descripcion,precio,alc);
			}   
		}
		
		long finR = System.currentTimeMillis();
		totalR=finR-initR;
		System.out.println("Restaurantes Creados en: " + totalR + "ms");		
		
		long totalU=0;
		long initU = System.currentTimeMillis();
		//Usuarios
		for (int i=0; i<100; i++) {
			int palabra = 12, e = 10, dominio = 6;
		    Random random = new Random();
		    String nombre = palabra(random, palabra);
		    String email = email(random, e, dominio);
		    String pass = palabra(random, e);
		    
		    int i1 = 10000000;
		    int i2 = 1111111111;
		    int cedula = i1 + (int) (Math.random() * (i2 - i1));	
		    ccs.add(cedula);
		    long l1 = 3000000000L;
		    long l2 = 3209999999L;
		    long telefono = l1 + (long) (Math.random() * (l2 - l1));
		    QPHashTable<Orden> ordenes = new QPHashTable<Orden>();
		    Usuario cliente = new Usuario(nombre,email,cedula,telefono, pass, ordenes);
			Usuarios.insert(cliente);

		}
		
		long finU = System.currentTimeMillis();
		
		totalU=finU-initU;
		System.out.println("Usuarios Creados en: " + totalU + "ms");
		
		long totalF=0;
		long initF = System.currentTimeMillis();
		//Facturas y Órdenes
		for (int i=0; i<40000; i++) {

		    Random random = new Random();
		    int rand = random.nextInt(Restaurantes.getSize());
		    Restaurante restTemp = find(Restaurantes.getRoot(), rand).getData();
		    int rand2 = random.nextInt(ccs.size());
		    int ccTemp = ccs.get(rand2);
		    Usuario userTemp = findUser(Usuarios.getRoot(), ccTemp).getData();
		    int personas = random.nextInt(4);
		    
		    generarOrden(userTemp, restTemp, restTemp.facturas, personas);

		}
		
		long finF = System.currentTimeMillis();
		
		totalF=finF-initF;
		System.out.println("Ordenes creadas en: " + totalF + "ms");
		
		Bestellen.archivoInicial(Restaurantes, Usuarios);
		}
	
	
	
	
	
	}
