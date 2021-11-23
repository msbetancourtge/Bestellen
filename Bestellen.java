package Data;

import Structures.LinkList;
import java.util.LinkedList;
import java.util.Scanner;

public class Bestellen {
	static LinkedList<Restaurante> Restaurantes = new LinkedList<>();
	
	public void agregarRestaurante(String nombre, String direccion) {
		Restaurante nuevo = new Restaurante(nombre, direccion, null, null);
		Restaurantes.add(nuevo);
		System.out.println("\\\\\\\\ seleccione una opción ////////");
		System.out.println("\nOpcion 1: Agregar otro restaurante\n");
		System.out.println("Opcion 2: Ver restaurantes agregados\n");
	}
	public LinkedList<Restaurante> getRestaurantes() {
		return Restaurantes;
	}
	public void mostrarRestaurantes() {
		System.out.println(getRestaurantes());
	}
	public static int menuPrincipal() {
		Scanner entradaEscaner = new Scanner (System.in);
		System.out.println("\\\\\\\\\\\\\\\\ seleccione una opción ////////\n");
		System.out.println("Opcion 1: Agregar restaurante");
		System.out.println("Opcion 2: Ver restaurantes");
		System.out.println("Opcion 3: Salir y guardar\n");
		
		if (entradaEscaner.hasNextInt()) {
		int opcion = entradaEscaner.nextInt();
		return opcion;}
		else { 
			return 0;
		}
	}
	public static void menuRestaurante(Restaurante restaurante1) {
		Scanner entradaEscaner = new Scanner (System.in);
		int opcion;
		//clearConsole();
		System.out.println("\\\\\\\\\\\\\\\\ seleccione una opción ///////\n");
		System.out.println("Opcion 1: Agregar plato");
		System.out.println("Opcion 2: Agregar bebida");
		System.out.println("Opcion 3: Mostrar Menú de platos");
		System.out.println("Opcion 4: Mostrar Menú de bebidas");
		System.out.println("Opción 5: Regresar al menú principal");
		if (entradaEscaner.hasNextInt()) {
			opcion = entradaEscaner.nextInt();
			}
			else { 
				opcion=0;
			}
		switch (opcion) {
		case 1:{
			entradaEscaner.nextLine();
			System.out.println("\n--Ingrese el nombre del plato--\n");
			String nombreP = entradaEscaner.nextLine();
			System.out.println("\n--Ingrese la descripción del plato--\n");
			String descripcion = entradaEscaner.nextLine();
			System.out.println("\n--Ingrese el precio del producto--\n");
			int precio = entradaEscaner.nextInt ();
			restaurante1.crearPlato(nombreP, descripcion, precio);
			menuRestaurante(restaurante1);
		}
		case 2:{
			entradaEscaner.nextLine();
			System.out.println("\n--Ingrese el nombre de la bebida--\n");
			String nombreB = entradaEscaner.nextLine ();
			System.out.println("\n--Ingrese la descripción de la bebida--\n");
			String descripcion = entradaEscaner.nextLine ();
		System.out.println("\n--Ingrese el precio del producto--\n");
			int precio = entradaEscaner.nextInt ();
			System.out.println("\n¿contiene alcohol?\n");
			System.out.println("\nPresione 1 si la bebida contiene alcohol");
			System.out.println("Presione 2 si la bebida NO contiene alcohol\n");
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
		}
		case 3:{ 
			if(restaurante1.platos.size() > 0) {
			for (int i = 0; i < restaurante1.platos.size(); i++) {
				System.out.println(i+1 +". "+restaurante1.platos.get(i).toString());
			}
			}
			else {
				System.out.println("\nAún no hay platos en este restaurante");
			}
			System.out.println("\n***Presione 1 para volver al restaurante***\n");
			int regresar = entradaEscaner.nextInt ();
			if(regresar == 1 ) {
				menuRestaurante(restaurante1);
			}else {invalido();}
			
		}
		case 4:{
			if(restaurante1.bebidas.size() > 0) {
			for (int i = 0; i < restaurante1.bebidas.size(); i++) {
				System.out.println(i+1 +". "+restaurante1.bebidas.get(i).toString());
			}
			}
			else {
				System.out.println("\nAún no hay Bebidas en este restaurante\n");
			}
			System.out.println("\n***Presione 1 para volver al restaurante***\n");
			int regresar = entradaEscaner.nextInt ();
			if(regresar == 1 ) {
				menuRestaurante(restaurante1);
			}
			else {invalido();}
		}
		case 5: main(null);
		default: invalido();
		}
	}
	public static void invalido() {
			System.out.println("\n--Opción no válida--\n");
			main(null);
	}

	public static void main(String args[]) {
		@SuppressWarnings("resource")
		Scanner entradaEscaner = new Scanner (System.in);
		
		int opcion = menuPrincipal();
		switch (opcion) {
		case 1:{
			System.out.println("Ingrese el nombre restaurante:");
			String nombre = entradaEscaner.nextLine ();
			System.out.println("Ingrese la dirección:");
			String direccion = entradaEscaner.nextLine ();
			Restaurante restaurante1 = new Restaurante(nombre, direccion);
			Restaurantes.add(restaurante1);
			menuRestaurante(restaurante1);
		}
		case 2:{
			if(Restaurantes.size()>0) {
				System.out.println("Escoja un restaurante:");
				for (int i = 0; i < Restaurantes.size(); i++) {
					System.out.println(i+1 +". "+Restaurantes.get(i).getNombre());
				}
				opcion = entradaEscaner.nextInt();
				System.out.println(Restaurantes.get(opcion-1).toString());
				menuRestaurante(Restaurantes.get(opcion-1));
			}else {
				System.out.println("\n******Aún no hay restaurantes creados******\n");
				main(null);
			}
			
		}
		case 3:{
			new Archivo(Restaurantes);
		}
		default: invalido();
		}
		
		
	}
}
