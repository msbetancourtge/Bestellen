package Logic;

import Structures.*;

import java.util.Scanner;
import java.io.*;
import Data.*;
public class Bestellen {
	
	String pass = "Bestellen";
	
	AVLTree<Restaurante> Restaurantes = new AVLTree<Restaurante>();
	AVLTree<Usuario> Usuarios = new AVLTree<Usuario>();

	public AVLTree<Restaurante> getRestaurantes() {
		return Restaurantes;
	}
	public AVLTree<Usuario> getUsuarios(){
		return Usuarios;
	}	
	public void cargarDatos(){
		try {
			ObjectInputStream lectura = new ObjectInputStream(new FileInputStream("restaurantes.dat"));
			@SuppressWarnings("unchecked")
			AVLTree<Restaurante> temp = (AVLTree<Restaurante>) lectura.readObject() ;
			lectura.close();
			
			Restaurantes = temp;
		}
		catch(ClassNotFoundException e) {
			System.out.println("Clase no encontrada");
		}
		catch(EOFException e) {
			System.out.println("No hay más datos");
		}
		catch(IOException e){
		}
		
		try {
			ObjectInputStream lectura = new ObjectInputStream(new FileInputStream("usuarios.dat"));
			@SuppressWarnings("unchecked")
			AVLTree<Usuario> temp = (AVLTree<Usuario>) lectura.readObject();
			lectura.close();
			
			Usuarios = temp;
		}
		catch(ClassNotFoundException e) {
			System.out.println("Clase no encontrada");
		}
		catch(EOFException e) {
			System.out.println("No hay más datos");
		}
		catch(IOException e){
		}
	}
	public static void archivoInicial(AVLTree<Restaurante> Rest, AVLTree<Usuario> Usu) {	
		
		System.out.println("\nGuardando Información...");
		if(Rest.getSize()>0) {
			//System.out.println("\nGuardando Información de Restaurantes...");
			try {
				ObjectOutputStream archivo = new ObjectOutputStream(new FileOutputStream("restaurantes.dat"));
				archivo.writeObject(Rest);
				archivo.close();
				//System.out.println("\n---Información de Restaurantes almacenada---\n");
			}
			catch(EOFException e) {
				System.out.println("No hay más datos");
			}
			catch(IOException e){
				System.out.println("Error");
			}
		}else {
			System.out.println("\n******Nada para almacenar******\n");
			System.exit(0);
		}
		
		if(Usu.getSize()>0) {
			//System.out.println("\nGuardando Información de Usuarios...");
			try {
				ObjectOutputStream archivo = new ObjectOutputStream(new FileOutputStream("usuarios.dat"));
				archivo.writeObject(Usu);
				archivo.close();
				//System.out.println("\n---Información de Usuarios almacenada---\n");
			}
			catch(EOFException e) {
				System.out.println("No hay más datos");
			}
			catch(IOException e){
				System.out.println("Error");
			}
		}else {
			System.out.println("\n******Nada para almacenar******\n");
			System.exit(0);
		}
		System.out.println("\n---Información almacenada---\n");
	}
	public void actualizarArchivo(AVLTree<Restaurante> Rest, AVLTree<Usuario> Usu) {	
		
		System.out.println("\nGuardando Información...");
		if(Rest.getSize()>0) {
			//System.out.println("\nGuardando Información de Restaurantes...");
			try {
				
				ObjectOutputStream archivo = new ObjectOutputStream(new FileOutputStream("restaurantes.dat"));
				archivo.writeObject(Rest);
				archivo.close();
				//System.out.println("\n---Información de Restaurantes almacenada---\n");
			}	
			catch(EOFException e) {
				System.out.println("No hay más datos");
			}
			catch(IOException e){
				System.out.println("Error");
			}
		}else {
			System.out.println("\n******Nada para almacenar******\n");
			System.exit(0);
		}
		
		if(Usu.getSize()>0) {
			//System.out.println("\nGuardando Información de Usuarios...");
			try {
				
				ObjectOutputStream archivo = new ObjectOutputStream(new FileOutputStream("usuarios.dat"));
				archivo.writeObject(Usu);
				archivo.close();
				//System.out.println("\n---Información de Usuarios almacenada---\n");
			}	
			catch(EOFException e) {
				System.out.println("No hay más datos");
			}
			catch(IOException e){
				System.out.println("Error");
			}
		}else {
			System.out.println("\n******Nada para almacenar******\n");
			System.exit(0);
		}
		System.out.println("\n---Información almacenada---\n");
	}
	public void menu() {
		int opcion = menuPrincipal();
		switch (opcion) {
		
		case 1:{
			if (validarAdmin()) {
			menuAdmin();
			}else invalido();
			break;
		}
		case 2:{
			validarRestaurante();
			break;
		}
		case 3:{
			validarUsuario();
			break;
		}
		case 4:{
		actualizarArchivo(Restaurantes, Usuarios);
		System.exit(0);
		}
		default: invalido();
	}
	}
	@SuppressWarnings("resource")
	public static int menuPrincipal() {
		Scanner entradaEscaner = new Scanner (System.in);
		System.out.println("\\\\\\\\\\\\\\\\ seleccione una opción ////////\n");
		System.out.println("Opcion 1: Soy un Administrador");
		System.out.println("Opcion 2: Soy un Restaurante");
		System.out.println("Opcion 3: Soy un Cliente");
		System.out.println("Opcion 4: Salir y guardar\n");
		if (entradaEscaner.hasNextInt()) {
			int opcion = entradaEscaner.nextInt();
			return opcion;
		}else return 0;
	}
	public boolean validarAdmin() {
		Scanner entradaEscaner = new Scanner (System.in);
		String pw;
		System.out.println("\\\\\\\\\\\\\\\\ ¡Hola Administrador! ///////\n");
		System.out.println("Ingrese la contraseña");
			pw = entradaEscaner.nextLine();
		if (pw.equals(pass)) {
		return true;
		}else return false;
	}
	public void validarRestaurante() {
		Scanner entradaEscaner = new Scanner (System.in);
		if(Restaurantes.getSize()>0) {
			try{
				System.out.println("Ingrese su ID de restaurante:");
				int opcion = Integer.parseInt(entradaEscaner.nextLine());
					if (opcion <= Restaurantes.getSize()) {
						Restaurante restTemp = find(Restaurantes.getRoot(), (opcion-1)).getData();
						System.out.println("Ingrese su contraseña:");
						String pw = entradaEscaner.nextLine();
							if (pw.equals(restTemp.getPw())) {
								System.out.println(restTemp.toString());
								menuRestaurante(restTemp);
							}else {
								System.out.println("\n******Contraseña incorrecta******\n");
								validarRestaurante();
							}
				}else {
					System.out.println("\n******Id de Restaurante incorrecta******\n");
					validarRestaurante();
				}
			} catch (NumberFormatException e) {
				System.out.println("\n******Entrada Invalida******\n");
				validarRestaurante();
			    e.printStackTrace();
			}
		}
		//entradaEscaner.close();
	}
	public void validarUsuario() {
		Scanner entradaEscaner = new Scanner (System.in);
		if(Usuarios.getSize()>0) {
			System.out.println("Ingrese su cc:");
			try{
				int opcion = Integer.parseInt(entradaEscaner.nextLine());
				try {
					Usuario userTemp = findUser(Usuarios.getRoot(), (opcion)).getData();
					System.out.println("Ingrese su clave:");
					String pw = entradaEscaner.nextLine();
						if(pw.equals(userTemp.getPw())) {
							System.out.println(userTemp.toString());
							menuUsuario(userTemp);
						}
				}catch (Exception e) {
					System.out.println("\n******Usuario no encontrado******\n");
					validarUsuario();
					e.printStackTrace();
				}
			}catch (NumberFormatException e) {
				System.out.println("\n******Entrada Invalida******\n");
				validarUsuario();
			    e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
	
	public void menuAdmin() {
		@SuppressWarnings("resource")
		Scanner entradaEscaner = new Scanner (System.in);
			
			System.out.println("\\\\\\\\\\\\\\\\ seleccione una opción ///////\n");
			System.out.println("Opcion 1: Administrar Restaurantes");
			System.out.println("Opcion 2: Administrar Usuarios");
			System.out.println("Opción 3: Regresar al menú principal");
			int entry;
			if (entradaEscaner.hasNextInt()) {
				entry = entradaEscaner.nextInt();
			}
				else {entry=0;}
			switch (entry) {
				case 1:{
					int temp=menuRestauranteAdminInicial();
					if (temp==1) {
						crearRestaurante();
					}else if(temp==2) {
						seleccionarRestaurante(null);
					}else {
						System.out.println("\n******Entrada Invalida******\n");
						menuAdmin();}
					break;
				}
				case 2:{
					int temp=menuUsuarioAdminInicial();
					if (temp==1) {
						crearUsuario();
					}else if(temp==2) {
						seleccionarUsuario();
					}else {
						System.out.println("\n******Entrada Invalida******\n");
						menuAdmin();}
					break;
				}
				case 3:{ 
					menu();
					break;
				}
				default: {
					System.out.println("\n******Entrada Invalida******\n");
					menuAdmin();
					break;}
			}
	}
	public int menuRestauranteAdminInicial() {
			Scanner entradaEscaner = new Scanner (System.in);
			System.out.println("\\\\\\\\\\\\\\\\ seleccione una opción ///////\n");
			System.out.println("Opcion 1: Crear Restaurante");
			System.out.println("Opcion 2: Ver/Editar Restaurantes");
			int temp;
			if (entradaEscaner.hasNextInt()) temp = entradaEscaner.nextInt();
			else temp=0;
			//entradaEscaner.close();
			return temp;		
	}
	public void menuRestauranteAdmin(Restaurante restaurante1) {
		@SuppressWarnings("resource")
		Scanner entradaEscaner = new Scanner (System.in);
		int opcion;
		System.out.println("\\\\\\\\\\\\\\\\ seleccione una opción ///////\n");
		System.out.println("Opcion 1: Eliminar Restaurante");
		System.out.println("Opcion 2: Editar Nombre");
		System.out.println("Opcion 3: Editar Direccion");
		System.out.println("Opcion 4: Mostrar Menú de platos");
		System.out.println("Opcion 5: Mostrar Menú de bebidas");
		System.out.println("Opcion 6: Ver Facturas");
		System.out.println("Opción 7: Regresar al menú de Administración");
	
			try {
				opcion = Integer.parseInt(entradaEscaner.nextLine());
			} catch (NumberFormatException e) {
				opcion=0;
				e.printStackTrace();
			}
		switch (opcion) {
		case 1:{
			eliminarRestaurante(restaurante1);
			actualizarArchivo(Restaurantes, Usuarios);
			menuAdmin();
			break;
		}
		case 2:{
			editarNombreRestaurante(restaurante1);
			actualizarArchivo(Restaurantes, Usuarios);
			menuRestauranteAdmin(restaurante1);
			break;
		}
		case 3:{
			editarDireccionRestaurante(restaurante1);
			actualizarArchivo(Restaurantes, Usuarios);
			menuRestauranteAdmin(restaurante1);
			break;
		}
		case 4:{ 
			verPlatos(restaurante1, null, false);
			break;
			
		}
		case 5:{
			verBebidas(restaurante1, null, false);
			break;
		}
	
		case 6:{
			restaurante1.verFacturas();
			menuRestauranteAdmin(restaurante1);
			break;
		}
		case 7: {
			//actualizarArchivo(Restaurantes, Usuarios);
			menuAdmin();
			break;
			}
		default: {
			System.out.println("\n******Entrada Invalida******\n");
			menuRestauranteAdmin(restaurante1);
			break;
		}
		}
		//entradaEscaner.close();
	}
	public void seleccionarRestaurante(Usuario user) {
		Scanner entradaEscaner = new Scanner (System.in);
		if(Restaurantes.getSize()>0) {
			System.out.println("Elija un restaurante:");
			Restaurantes.print();
			try{
				int opcion = Integer.parseInt(entradaEscaner.nextLine());
					try {
						Restaurante restTemp = find(Restaurantes.getRoot(), (opcion-1)).getData();
						System.out.println(restTemp.toString());
						
						if(user==null)menuRestauranteAdmin(restTemp);
						else if (user!=null) menuUsuarioRestaurante(restTemp, user);
						
					} catch (Exception e) {
						System.out.println("\n******No existe ese restaurante******\n");
						seleccionarRestaurante(user);
						e.printStackTrace();
					}
			}catch (NumberFormatException e) {
				System.out.println("\n******Opción Inválida******\n");
				seleccionarRestaurante(user);
				e.printStackTrace();
			}
		}else {
			System.out.println("\n******Aún no hay restaurantes creados******\n");
			if (user==null)menuRestauranteAdminInicial();
			else if (user!=null) menuUsuario(user);
		}
		//entradaEscaner.close();
	}
	public void verPlatos(Restaurante restaurante1, Usuario user, boolean isR) {
		Scanner entradaEscaner = new Scanner (System.in);
		if(restaurante1.platos.size() > 0) {
			for (int i = 0; i < restaurante1.platos.size(); i++) {
				System.out.println(i+1 +". "+restaurante1.platos.get(i).toString() + '\n');
			}
		}else System.out.println("\nAún no hay platos en este restaurante");
		System.out.println("\n***Presione 1 para regresar***\n");
		try {
			int regresar = Integer.parseInt(entradaEscaner.nextLine());
			if(regresar == 1 && user == null && !isR) menuRestauranteAdmin(restaurante1);
			else if(regresar == 1 && user != null && !isR) menuUsuarioRestaurante(restaurante1, user);
			else if(regresar == 1 && user == null && isR) menuRestaurante(restaurante1);
			else regresar=0;
		} catch (NumberFormatException e) {
			System.out.println("\n******Entrada Invalida******\n");
			verPlatos(restaurante1, user, isR);
			//e.printStackTrace();
		}
	}
	
	public void verBebidas(Restaurante restaurante1, Usuario user, boolean isR) {
		Scanner entradaEscaner = new Scanner (System.in);
		if(restaurante1.platos.size() > 0) {
			for (int i = 0; i < restaurante1.bebidas.size(); i++) {
				System.out.println(i+1 +". "+restaurante1.bebidas.get(i).toString() + '\n');
			}
		}else System.out.println("\nAún no hay bebidas en este restaurante");
		System.out.println("\n***Presione 1 para regresar***\n");
		try {
			int regresar = Integer.parseInt(entradaEscaner.nextLine());
			if(regresar == 1 && user == null && !isR) menuRestauranteAdmin(restaurante1);
			else if(regresar == 1 && user != null &&  !isR) menuUsuarioRestaurante(restaurante1, user);
			else if (regresar ==1 && user == null && isR) menuRestaurante(restaurante1);
			else regresar=0;
		} catch (NumberFormatException e) {
			System.out.println("\n******Entrada Invalida******\n");
			verBebidas(restaurante1, user, isR);
			e.printStackTrace();
		}
	}
	
	
	public void crearRestaurante() {
		Scanner entradaEscaner = new Scanner (System.in);
		System.out.println("Ingrese el nombre restaurante:");
		String nombre = entradaEscaner.nextLine ();
		System.out.println("Ingrese la contraseña:");
		String pass = entradaEscaner.nextLine ();
		System.out.println("Ingrese la dirección:");
		String direccion = entradaEscaner.nextLine ();
		Restaurante restaurante1 = new Restaurante(Restaurantes.getSize(), nombre, direccion, pass);
		Restaurantes.insert(restaurante1);
		actualizarArchivo(Restaurantes, Usuarios);
		menuAdmin();
	}
	public void eliminarRestaurante(Restaurante restaurante1) {
		System.out.println("\nRestaurante eliminado: " + restaurante1.getNombre());
		Restaurantes.remove(restaurante1);
	}
	public void editarNombreRestaurante(Restaurante restaurante1) {
		Scanner entradaEscaner = new Scanner (System.in);
		System.out.println("\n-------Ingrese el nuevo nombre:-------\n");
		String newName = entradaEscaner.nextLine();
		restaurante1.setNombre(newName);
		System.out.println("\nNombre actualizado. Nuevo nombre: " + restaurante1.getNombre());
	}
	public void editarDireccionRestaurante(Restaurante restaurante1) {
		Scanner entradaEscaner = new Scanner (System.in);
		System.out.println("\n-------Ingrese la nueva Direccion:-------\n");
		String newDir = entradaEscaner.nextLine();
		restaurante1.setDireccion(newDir);
		System.out.println("\nDireccion actualizada. Nueva direccion: " + restaurante1.getDireccion());
	}
	
	public Plato busquedaPlato(Restaurante restaurante1) {
		Scanner entradaEscaner = new Scanner (System.in);
		Plato seleccion = new Plato();
		if(restaurante1.platos.size()>0) {
			System.out.println("\nElija un plato para editar:\n");
			for (int i = 0; i < restaurante1.platos.size(); i++) {
				System.out.println(i+1 +". "+restaurante1.platos.get(i).toString() + '\n');
			}
			int selec = entradaEscaner.nextInt();
			if (selec <=restaurante1.platos.size()) seleccion = restaurante1.platos.get(selec-1);
			else{
					System.out.println("\n*******Elección Inválida*******\n");
					busquedaPlato(restaurante1);
				}
		}else System.out.println("\nAún no hay platos en este restaurante");
		System.out.println("\n***Presione 1 para regresar***\n");
		try {
			int regresar = Integer.parseInt(entradaEscaner.nextLine());
			if(regresar == 1 ) menuRestauranteEdit(restaurante1);
			else regresar=0;
		} catch (NumberFormatException e) {
			System.out.println("\n******Entrada Invalida******\n");
			busquedaPlato(restaurante1);
			//e.printStackTrace();
		}
		return seleccion;
	}
	public void menuPlato(Plato plato, Restaurante restaurante1) {
		Scanner entradaEscaner = new Scanner (System.in);
		int opcion;
		System.out.println("\n\\\\\\\\\\\\\\\\ seleccione una opción ///////\n");
		System.out.println("Opcion 1: Eliminar Plato ");
		System.out.println("Opcion 2: Editar Nombre");
		System.out.println("Opcion 3: Editar Descripcion");
		System.out.println("Opcion 4: Editar Precio");
		System.out.println("Opción 5: Regresar al menú de Restaurante");
		if (entradaEscaner.hasNextInt()) {
			opcion = entradaEscaner.nextInt();
			}
			else {opcion=0;}
		switch (opcion) {

		case 1:{
			eliminarPlato(plato, restaurante1);
			actualizarArchivo(Restaurantes, Usuarios);
			menuRestauranteEdit(restaurante1);
			break;
		}
		case 2:{
			editarNombrePlato(plato);
			actualizarArchivo(Restaurantes, Usuarios);
			menuPlato(plato, restaurante1);
			break;
		}
		case 3:{
			editarDescripcionPlato(plato);
			actualizarArchivo(Restaurantes, Usuarios);
			menuPlato(plato, restaurante1);
			break;
		}
		case 4:{
			editarPrecioPlato(plato);
			actualizarArchivo(Restaurantes, Usuarios);
			menuPlato(plato, restaurante1);
			break;
		}
		case 5:{
			menuRestauranteEdit(restaurante1);
			break;
		}
		default:{
			System.out.println("\n******Entrada Invalida******\n");
			menuPlato(plato, restaurante1);
		}
		}
	}
	public void eliminarPlato(Plato plato, Restaurante restaurante1) {
		System.out.println("\nPlato eliminado: " + plato.getNombre());
		restaurante1.platos.remove(plato);
	}
	
	public void editarNombrePlato(Plato plato) {
		Scanner entradaEscaner = new Scanner (System.in);
		System.out.println("\n-------Ingrese el nuevo nombre:-------\n");
		String newName = entradaEscaner.nextLine();
		plato.setNombre(newName);
		System.out.println("\nNombre actualizado. Nuevo nombre: " + plato.getNombre());
		//entradaEscaner.close();
	}
	public void editarDescripcionPlato(Plato plato) {
		Scanner entradaEscaner = new Scanner (System.in);
		System.out.println("\n-------Ingrese la nueva Descripcion:-------\n");
		String newDesc = entradaEscaner.nextLine();
		plato.setDescripcion(newDesc);
		System.out.println("\nDescripcion actualizada. Nueva descripcion: " + plato.getDescripcion());
	}
	public void editarPrecioPlato(Plato plato) {
		Scanner entradaEscaner = new Scanner (System.in);
		System.out.println("\n-------Ingrese el nuevo Precio:-------\n");
		int newPrice = entradaEscaner.nextInt();
		plato.setPrecio(newPrice);
		System.out.println("\nPrecio actualizado. Nuevo precio: " + plato.getPrecio());
	}
	public Bebida busquedaBebida(Restaurante restaurante1) {
		Scanner entradaEscaner = new Scanner (System.in);
		Bebida seleccion = new Bebida();
		if(restaurante1.platos.size()>0) {
			System.out.println("\nElija un plato para editar:\n");
			for (int i = 0; i < restaurante1.platos.size(); i++) {
				System.out.println(i+1 +". "+restaurante1.platos.get(i).toString() + '\n');
			}
			int selec = entradaEscaner.nextInt();
			if (selec <=restaurante1.bebidas.size()) seleccion = restaurante1.bebidas.get(selec-1);
			else{
					System.out.println("\n*******Elección Inválida*******\n");
					busquedaBebida(restaurante1);
				}
		}else System.out.println("\nAún no hay platos en este restaurante");
		System.out.println("\n***Presione 1 para regresar***\n");
		try {
			int regresar = Integer.parseInt(entradaEscaner.nextLine());
			if(regresar == 1 ) menuRestauranteEdit(restaurante1);
			else regresar=0;
		} catch (NumberFormatException e) {
			System.out.println("\n******Entrada Invalida******\n");
			busquedaBebida(restaurante1);
			//e.printStackTrace();
		}
		return seleccion;
	}
	
	public void menuBebida(Bebida bebida, Restaurante restaurante1) {
		Scanner entradaEscaner = new Scanner (System.in);
		int opcion;
		System.out.println("\n\\\\\\\\\\\\\\\\ seleccione una opción ///////\n");
		System.out.println("Opcion 1: Eliminar Bebida ");
		System.out.println("Opcion 2: Editar Nombre");
		System.out.println("Opcion 3: Editar Descripcion");
		System.out.println("Opcion 4: Editar Precio");
		System.out.println("Opción 5: Regresar al menú de Restaurante");
		if (entradaEscaner.hasNextInt()) {
			opcion = entradaEscaner.nextInt();
			}
			else {opcion=0;}
		switch (opcion) {

		case 1:{
			eliminarBebida(bebida, restaurante1);
			actualizarArchivo(Restaurantes, Usuarios);
			menuRestauranteEdit(restaurante1);
			break;
		}
		case 2:{
			editarNombreBebida(bebida);
			actualizarArchivo(Restaurantes, Usuarios);
			menuBebida(bebida, restaurante1);
			break;
		}
		case 3:{
			editarDescripcionBebida(bebida);
			actualizarArchivo(Restaurantes, Usuarios);
			menuBebida(bebida, restaurante1);
			break;
		}
		case 4:{
			editarPrecioBebida(bebida);
			actualizarArchivo(Restaurantes, Usuarios);
			menuBebida(bebida, restaurante1);
			break;
		}
		case 5:{
			menuRestauranteEdit(restaurante1);
			break;
		}
		default:{
			System.out.println("\n******Entrada Invalida******\n");
			menuBebida(bebida, restaurante1);
		}
		}
	}
	public void eliminarBebida(Bebida bebida, Restaurante restaurante1) {
		System.out.println("\nBebida eliminada: " + bebida.getNombre());
		restaurante1.bebidas.remove(bebida);
	}
	
	public void editarNombreBebida(Bebida bebida) {
		Scanner entradaEscaner = new Scanner (System.in);
		System.out.println("\n-------Ingrese el nuevo nombre:-------\n");
		String newName = entradaEscaner.nextLine();
		bebida.setNombre(newName);
		System.out.println("\nNombre actualizado. Nuevo nombre: " + bebida.getNombre());
	}
	public void editarDescripcionBebida(Bebida bebida) {
		Scanner entradaEscaner = new Scanner (System.in);
		System.out.println("\n-------Ingrese la nueva Descripcion:-------\n");
		String newDesc = entradaEscaner.nextLine();
		bebida.setDescripcion(newDesc);
		System.out.println("\nDescripcion actualizada. Nueva descripcion: " + bebida.getDescripcion());
	}
	public void editarPrecioBebida(Bebida bebida) {
		Scanner entradaEscaner = new Scanner (System.in);
		System.out.println("\n-------Ingrese el nuevo Precio:-------\n");
		int newPrice = entradaEscaner.nextInt();
		bebida.setPrecio(newPrice);
		System.out.println("\nPrecio actualizado. Nuevo precio: " + bebida.getPrecio());
	}
	public void crearUsuario() {		
		Scanner scan = new Scanner(System.in);
		System.out.println("Nombre del Cliente");
		String nombre = scan.nextLine();
		System.out.println("Email del Cliente");
		String email = scan.nextLine();
		System.out.println("Contraseña del Cliente");
		String pw = scan.nextLine();
		System.out.println("Cédula del Cliente");
		int cc = scan.nextInt();
		System.out.println("Teléfono del Cliente");
		long tel = scan.nextLong();
		Usuario cliente =new Usuario(nombre, email, cc, tel, pw);
		Usuarios.insert(cliente);
		actualizarArchivo(Restaurantes, Usuarios);
		menuAdmin();
	}
	public void eliminarUsuario(Usuario user) {
		System.out.println("\nRestaurante eliminado: " + user.getNombre());
		Usuarios.remove(user);
	}
	public void editarNombreUsuario(Usuario user) {
		Scanner entradaEscaner = new Scanner (System.in);
		System.out.println("\n-------Ingrese el nuevo nombre:-------\n");
		String newName = entradaEscaner.nextLine();
		user.setNombre(newName);
		System.out.println("\nNombre actualizado. Nuevo nombre: " + user.getNombre());
	}
	public void editarEmailUsuario(Usuario user) {
		Scanner entradaEscaner = new Scanner (System.in);
		System.out.println("\n-------Ingrese el nuevo Email:-------\n");
		String newEmail = entradaEscaner.nextLine();
		user.setEmail(newEmail);
		System.out.println("\nEmail actualizado. Nuevo Email: " + user.getEmail());
	}
	public void editarTelefonoUsuario(Usuario user) {
		Scanner entradaEscaner = new Scanner (System.in);
		System.out.println("\n-------Ingrese el nuevo teléfono:-------\n");
		long newTel = entradaEscaner.nextLong();
		user.setTel(newTel);
		System.out.println("\nTeléfono actualizado. Nuevo teléfono: " + user.getTel());
	}
	public int menuUsuarioAdminInicial() {
		Scanner entradaEscaner = new Scanner (System.in);
		System.out.println("\\\\\\\\\\\\\\\\ seleccione una opción ///////\n");
		System.out.println("Opcion 1: Crear Usuario");
		System.out.println("Opcion 2: Ver/Editar Usuarios");
		int temp;
		if (entradaEscaner.hasNextInt()) temp = entradaEscaner.nextInt();
		else temp=0;
		//entradaEscaner.close();
		return temp;
	}
	public void menuUsuarioAdmin(Usuario user) {
		
		@SuppressWarnings("resource")
		Scanner entradaEscaner = new Scanner (System.in);
		int opcion;
		System.out.println("\n\\\\\\\\\\\\\\\\ seleccione una opción ///////\n");
		System.out.println("Opcion 1: Eliminar Usuario");
		System.out.println("Opcion 2: Editar Nombre");
		System.out.println("Opcion 3: Editar Email");
		System.out.println("Opcion 4: Editar teléfono");
		System.out.println("Opcion 5: Ver Facturas");
		System.out.println("Opción 6: Regresar al menú de Administración");
		if (entradaEscaner.hasNextInt()) {
			opcion = entradaEscaner.nextInt();
			}
			else {opcion=0;}
		switch (opcion) {
		case 1:{
			eliminarUsuario(user);
			actualizarArchivo(Restaurantes, Usuarios);
			menuAdmin();
			break;
		}
		case 2:{
			editarNombreUsuario(user);
			actualizarArchivo(Restaurantes, Usuarios);
			menuUsuarioAdmin(user);
			break;
		}
		case 3:{
			editarEmailUsuario(user);
			actualizarArchivo(Restaurantes, Usuarios);
			menuUsuarioAdmin(user);
			break;
		}
		case 4:{
			editarTelefonoUsuario(user);
			actualizarArchivo(Restaurantes, Usuarios);
			menuUsuarioAdmin(user);
			break;
		}
		case 5:{
			for (int i=0; i<user.getFacturas().getSize(); i++) {
			findFactura(user.getFacturas().getRoot(), i).getData().printUser();
			}
			menuUsuarioAdmin(user);
			break;
		}
		case 6:{
			menuAdmin();
			break;
		}
		default: {
			System.out.println("\n******Entrada Invalida******\n");
			menuUsuarioAdmin(user);
			break;
		}
		}
		
	}
	private TreeNode <Restaurante> find(TreeNode<Restaurante> root, int pos){
		if (root==null) return root;
		int compare = pos - root.getData().getId();
		if (compare < 0) return find(root.getLeft(), pos);
		else if(compare > 0) return find(root.getRight(), pos);
		else;
		return root;

	}
	private TreeNode <Usuario> findUser(TreeNode<Usuario> root, int cc){
		if (root==null) return root;
		int compare = cc - root.getData().getCc();
		if (compare < 0) return findUser(root.getLeft(), cc);
		else if(compare > 0) return findUser(root.getRight(), cc);
		else;
		return root;

	}
	private TreeNode <Factura> findFactura(TreeNode<Factura> root, int pos){
		if (root==null) return root;
		int compare = pos - root.getData().getId();
		if (compare < 0) return findFactura(root.getLeft(), pos);
		else if(compare > 0) return findFactura(root.getRight(), pos);
		else;
		return root;

	}

	public void seleccionarUsuario() {
		Scanner entradaEscaner = new Scanner (System.in);
		if(Usuarios.getSize()>0) {
			System.out.println("Elija un usuario:");
			Usuarios.print();
			if (entradaEscaner.hasNextInt()) {
				int opcion = entradaEscaner.nextInt();
				try {
					//if (opcion <= Usuarios.findMax().getCc()) {
						Usuario userTemp = findUser(Usuarios.getRoot(), (opcion)).getData();
						System.out.println(userTemp.toString());
						System.out.println(userTemp.getEmail());
						menuUsuarioAdmin(userTemp);
					//}else invalido();
				} catch (Exception e) {
					System.out.println("\n******Usuario Inexistente******\n");
					seleccionarUsuario();
					e.printStackTrace();
				}
				
			}else invalido();
		}else {
			System.out.println("\n******Aún no hay usuarios creados******\n");
			menu();
		}
		//entradaEscaner.close();
	}
	
	
	public void menuUsuarioEdit(Usuario user) {
		@SuppressWarnings("resource")
		Scanner entradaEscaner = new Scanner (System.in);
		int opcion;
		System.out.println("\n\\\\\\\\\\\\\\\\ seleccione una opción ///////\n");
		System.out.println("Opcion 1: Editar Nombre");
		System.out.println("Opcion 2: Editar Email");
		System.out.println("Opcion 3: Editar teléfono");
		System.out.println("Opción 4: Regresar al menú de Usuario y guardar");
		if (entradaEscaner.hasNextInt()) {
			opcion = entradaEscaner.nextInt();
			}
			else {opcion=0;}
		switch (opcion) {

		case 1:{
			editarNombreUsuario(user);
			menuUsuarioEdit(user);
			break;
		}
		case 2:{
			editarEmailUsuario(user);
			menuUsuarioEdit(user);
			break;
		}
		case 3:{
			editarTelefonoUsuario(user);
			menuUsuarioEdit(user);
			break;
		}
		case 4:{
			actualizarArchivo(Restaurantes, Usuarios);
			menuUsuario(user);
			break;
		}
		default: {
			invalido();
			break;}
		}
	}
	public void menuRestauranteEdit(Restaurante restaurante1) {
		@SuppressWarnings("resource")
		Scanner entradaEscaner = new Scanner (System.in);
		int opcion;
		System.out.println("\n\\\\\\\\\\\\\\\\ seleccione una opción ///////\n");
		System.out.println("Opcion 1: Editar Nombre");
		System.out.println("Opcion 2: Editar Direccion");
		System.out.println("Opcion 3: Editar Plato");
		System.out.println("Opcion 4: Editar Bebida");
		System.out.println("Opción 5: Regresar al menú del Restaurante y guardar");
		if (entradaEscaner.hasNextInt()) {
			opcion = entradaEscaner.nextInt();
			}
			else {opcion=0;}
		switch (opcion) {

		case 1:{
			editarNombreRestaurante(restaurante1);
			menuRestauranteEdit(restaurante1);
			break;
		}
		case 2:{
			editarDireccionRestaurante(restaurante1);
			menuRestauranteEdit(restaurante1);
			break;
		}
		case 3:{
			menuPlato(busquedaPlato(restaurante1), restaurante1);
			menuRestauranteEdit(restaurante1);
			break;
		}
		case 4:{
			menuBebida(busquedaBebida(restaurante1), restaurante1);
			menuRestauranteEdit(restaurante1);
			break;
		}
		case 5:{
			actualizarArchivo(Restaurantes, Usuarios);
			menuRestaurante(restaurante1);
			break;
		}
		default: {
			invalido();
			break;}
		}
	}
	
	public void crearPlato(Restaurante restaurante1) {
		Scanner entradaEscaner = new Scanner (System.in);
		entradaEscaner.nextLine();
		System.out.println("\n--Ingrese el nombre del plato--\n");
		String nombreP = entradaEscaner.nextLine();
		System.out.println("\n--Ingrese la descripción del plato--\n");
		String descripcion = entradaEscaner.nextLine();
		System.out.println("\n--Ingrese el precio del producto--\n");
		int precio = entradaEscaner.nextInt ();
		restaurante1.crearPlato(nombreP, descripcion, precio);
	}
	public void crearBebida(Restaurante restaurante1) {
		Scanner entradaEscaner = new Scanner (System.in);
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
	}
	
	public void menuRestaurante(Restaurante restaurante1) {
		@SuppressWarnings("resource")
		Scanner entradaEscaner = new Scanner (System.in);
		int opcion;
		System.out.println("\\\\\\\\\\\\\\\\ seleccione una opción ///////\n");
		System.out.println("Opcion 1: Editar Información");
		System.out.println("Opcion 2: Agregar plato");
		System.out.println("Opcion 3: Agregar bebida");
		System.out.println("Opcion 4: Mostrar Menú de platos");
		System.out.println("Opcion 5: Mostrar Menú de bebidas");
		System.out.println("Opcion 6: Ver Facturas");
		System.out.println("Opción 7: Salir y guardar");
		if (entradaEscaner.hasNextInt()) {
			opcion = entradaEscaner.nextInt();
			}
			else {opcion=0;}
		switch (opcion) {
		case 1:{
			menuRestauranteEdit(restaurante1);
			actualizarArchivo(Restaurantes, Usuarios);
			break;
		}
		case 2:{
			crearPlato(restaurante1);
			actualizarArchivo(Restaurantes, Usuarios);
			menuRestaurante(restaurante1);
			break;
		}
		case 3:{
			crearBebida(restaurante1);
			actualizarArchivo(Restaurantes, Usuarios);
			menuRestaurante(restaurante1);
			break;
		}
		case 4:{ 
			verPlatos(restaurante1, null, true);
			break;
			
		}
		case 5:{
			verPlatos(restaurante1, null, true);
			break;
		}
		case 6:{
			restaurante1.verFacturas();
			break;
		}
		case 7: actualizarArchivo(Restaurantes, Usuarios);
		default: invalido();
		}
	}
	
	
	
	
	
	
	public void menuUsuarioRestaurante(Restaurante restaurante1, Usuario user) {
		@SuppressWarnings("resource")
		Scanner entradaEscaner = new Scanner (System.in);
		int opcion;
		System.out.println("\\\\\\\\\\\\\\\\ seleccione una opción ///////\n");
		System.out.println("Opcion 1: Mostrar Menú de platos");
		System.out.println("Opcion 2: Mostrar Menú de bebidas");
		System.out.println("Opcion 3: Hacer un pedido");
		System.out.println("Opción 4: Salir y guardar");
		if (entradaEscaner.hasNextInt()) {
			opcion = entradaEscaner.nextInt();
			}
			else {opcion=0;}
		switch (opcion) {
		case 1:{ 
			verPlatos(restaurante1, user, false);
			break;
		}
		case 2:{
			verBebidas(restaurante1, user, false);
			break;
		}
		case 3:{
			if(restaurante1.bebidas.size()>0 && restaurante1.platos.size()>0) {
			restaurante1.generarOrden(user);
			menuUsuarioRestaurante(restaurante1, user);
			}else {
				System.out.println("\n******Aún no hay comida en este restaurante******\n");
				menuUsuarioRestaurante(restaurante1, user);
			}
			break;
		}
		case 4: {
			actualizarArchivo(Restaurantes, Usuarios);
			break;
		}
		default: invalido();
		}
	}
	
	public void menuUsuario(Usuario user) {
		@SuppressWarnings("resource")
		Scanner entradaEscaner = new Scanner (System.in);
		int opcion;
		System.out.println("\n\\\\\\\\\\\\\\\\ seleccione una opción ///////\n");
		System.out.println("Opcion 1: Editar mis datos");
		System.out.println("Opcion 2: Ver mis Facturas");
		System.out.println("Opcion 3: Ver Restaurantes Disponibles");
		System.out.println("Opción 4: Salir y guardar");
		if (entradaEscaner.hasNextInt()) {
			opcion = entradaEscaner.nextInt();
			}
			else {opcion=0;}
		switch (opcion) {
		case 1:{
			menuUsuarioEdit(user);
			break;
		}
		case 2:{
			for (int i=0; i<user.getFacturas().getSize(); i++) {
				findFactura(user.getFacturas().getRoot(), i).getData().printUser();
				}
			break;
		}
		case 3:{
			seleccionarRestaurante(user);
			break;
		}
		case 4:{
			actualizarArchivo(Restaurantes, Usuarios);
			break;
		}
		default:invalido();
		}
	}
	
	
	public void invalido() {
			System.out.println("\n--Opción no válida--\n");
			menu();
	}
	public static void main(String args[]) {
		
		Bestellen data = new Bestellen();
		data.cargarDatos();
		data.menu();
}
}