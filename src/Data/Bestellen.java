package Data;

import Structures.LinkList;

import java.util.LinkedList;
import java.util.Scanner;

public class Bestellen {
	static LinkedList<Restaurante> Restaurantes = new LinkedList<>();
	
	
	
	
	
	public void agregarRestaurante(String nombre, String direccion) {
		Restaurante nuevo = new Restaurante(nombre, direccion, null, null);
		Restaurantes.add(nuevo);
		System.out.println("seleccione una opción: ");
		System.out.println("Opcion 1: Agregar restaurante ");
		System.out.println("Opcion 2: Ver restaurantes ");
	}
	
	public LinkedList<Restaurante> getRestaurantes() {
		return Restaurantes;
	}
	public void mostrarRestaurantes() {
		System.out.println(getRestaurantes());
	}
	public static int menuPrincipal() {
		Scanner entradaEscaner = new Scanner (System.in);
		System.out.println("seleccione una opción: ");
		System.out.println("Opcion 1: Agregar restaurante ");
		System.out.println("Opcion 2: Ver restaurantes ");
		int opcion = entradaEscaner.nextInt();
		return opcion;
	}
	public static void menuRestaurante(Restaurante restaurante1) {
		Scanner entradaEscaner = new Scanner (System.in);
		int opcion;
		System.out.println("seleccione una opción: ");
		System.out.println("Opcion 1: Agregar plato");
		System.out.println("Opcion 2: Agregar bebida");
		System.out.println("devolverse (ingrese cualquier otro numero)");
		opcion = entradaEscaner.nextInt();
		if(opcion == 1) {
			System.out.println("nombre plato: ...");
			String nombreP = entradaEscaner.nextLine();
			System.out.println("descripción: ...");
			String descripcion = entradaEscaner.nextLine();
			System.out.println("precio: ...");
			int precio = entradaEscaner.nextInt ();
			restaurante1.crearPlato(nombreP, descripcion, precio);
			menuRestaurante(restaurante1);
		}else if(opcion == 2) {
			System.out.println("nombre bebida: ...");
			String nombreB = entradaEscaner.nextLine();
			System.out.println("descripción: ...");
			String descripcion = entradaEscaner.nextLine ();
			System.out.println("precio: ...");
			int precio = entradaEscaner.nextInt ();
			System.out.println("¿contiene alcohol?: ...");
			boolean contieneAlcohol = entradaEscaner.nextBoolean();
			restaurante1.crearBebida(nombreB, descripcion, precio, contieneAlcohol);
			menuRestaurante(restaurante1);
		}else {
			main(null);
		}
	}
	public static void main(String args[]) {
		Scanner entradaEscaner = new Scanner (System.in);
		
		int opcion;
		
		opcion = menuPrincipal();
		
		if(opcion == 1) {
			System.out.println("nombre restaurante: ...");
			String nombre = entradaEscaner.nextLine ();
			System.out.println("dirección: ...");
			String direccion = entradaEscaner.nextLine ();
			Restaurante restaurante1 = new Restaurante(nombre, direccion);
			Restaurantes.add(restaurante1);
			menuRestaurante(restaurante1);
		}
		if(opcion == 2) {
			System.out.println("Escoja un restaurante:");
			if(Restaurantes.size()>0) {
				for (int i = 0; i < Restaurantes.size(); i++) {
					System.out.println(i +". "+Restaurantes.get(i).getNombre());
				}
				opcion = entradaEscaner.nextInt();
				menuRestaurante(Restaurantes.get(opcion));
			}else {
				System.out.println("Aun no hay restaurantes");
				System.out.println("ingrese cualquier cosa para regresar");
				entradaEscaner.nextLine ();
				main(null);
			}
			//menuRestaurante(restaurante1);
		}
		
	}
}
