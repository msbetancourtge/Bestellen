package Logic;

import Structures.LinkedList;

import java.util.Scanner;

import Data.*;
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
		System.out.println("Opcion 3: Mostrar Menu de platos");
		System.out.println("Opcion 4: Mostrar Menu de bebidas");
		System.out.println("devolverse (ingrese cualquier otro numero)");
		opcion = entradaEscaner.nextInt();
		if(opcion == 1) {
			entradaEscaner.nextLine();
			System.out.println("Ingrese el nombre del plato: ");
			String nombreP = entradaEscaner.nextLine();
			System.out.println("Ingrese la descripción del plato: ");
			String descripcion = entradaEscaner.nextLine();
			System.out.println("Ingrese el precio del producto: ");
			int precio = entradaEscaner.nextInt ();
			restaurante1.crearPlato(nombreP, descripcion, precio);
			menuRestaurante(restaurante1);
		}else if(opcion == 2) {
			entradaEscaner.nextLine();
			System.out.println("Ingrese el nombre de la bebida: ");
			String nombreB = entradaEscaner.nextLine ();
			System.out.println("Ingrese la descripción de la bebida: ");
			String descripcion = entradaEscaner.nextLine ();
		System.out.println("Ingrese el precio del producto: ");
			int precio = entradaEscaner.nextInt ();
			System.out.println("¿contiene alcohol?: ");
			System.out.println("presione 1 si la bebida contiene alcohol");
			System.out.println("presione 2 si la bebida no contiene alcohol");
			boolean alcohol;
			int contieneAlcohol = entradaEscaner.nextInt();
			if(contieneAlcohol ==1) {
				alcohol = true;
			}
			else {
				alcohol = false;
			}
			restaurante1.crearBebida(nombreB, descripcion, precio, alcohol);
			menuRestaurante(restaurante1);
		}else if (opcion == 3){ 
			if(restaurante1.platos.size() > 0) {
			for (int i = 0; i < restaurante1.platos.size(); i++) {
				System.out.println(i+1 +". "+restaurante1.platos.get(i).toString());
			}
			}
			else {
				System.out.println("Aun no hay platos en este restaurante");
			}
			System.out.println("Presione 1 para volver al restaurante");
			int regresar = entradaEscaner.nextInt ();
			if(regresar == 1 ) {
				menuRestaurante(restaurante1);
			}
			
		}
		else if (opcion == 4) {
			if(restaurante1.bebidas.size() > 0) {
			for (int i = 0; i < restaurante1.bebidas.size(); i++) {
				System.out.println(i+1 +". "+restaurante1.bebidas.get(i).toString());
			}
			}
			else {
				System.out.println("Aun no hay Bebidas en este restaurante");
			}
			System.out.println("Presione 1 para volver al restaurante");
			int regresar = entradaEscaner.nextInt ();
			if(regresar == 1 ) {
				menuRestaurante(restaurante1);
			}
			
		}
		else {
			main(null);
		}
	}
	public static void main(String args[]) {
		Scanner entradaEscaner = new Scanner (System.in);
		
		int opcion;
		
		opcion = menuPrincipal();
		
		if(opcion == 1) {
			System.out.println("Ingrese el nombre restaurante:");
			String nombre = entradaEscaner.nextLine ();
			System.out.println("Ingrese la dirección:");
			String direccion = entradaEscaner.nextLine ();
			Restaurante restaurante1 = new Restaurante(nombre, direccion);
			Restaurantes.add(restaurante1);
			menuRestaurante(restaurante1);
		}
		if(opcion == 2) {
			if(Restaurantes.size()>0) {
				System.out.println("Escoja un restaurante:");
				for (int i = 0; i < Restaurantes.size(); i++) {
					System.out.println(i+1 +". "+Restaurantes.get(i).getNombre());
				}
				opcion = entradaEscaner.nextInt();
				System.out.println(Restaurantes.get(opcion-1).toString());
				menuRestaurante(Restaurantes.get(opcion-1));
			}else {
				System.out.println("Aun no hay restaurantes creados");
				System.out.println("ingrese cualquier cosa para regresar");
				entradaEscaner.nextLine ();
				main(null);
			}
		}
		
	}
}
