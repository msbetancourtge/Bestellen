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
	public void mostrarRestaurantes() {
		System.out.println(getRestaurantes());
	}
	public void mostrarClientes() {
		System.out.println(getUsuarios());
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
	public void crearRestaurante() {
		@SuppressWarnings("resource")
		Scanner entradaEscaner = new Scanner (System.in);
		
		System.out.println("Ingrese el nombre restaurante:");
		String nombre = entradaEscaner.nextLine ();
		System.out.println("Ingrese la dirección:");
		String direccion = entradaEscaner.nextLine ();
		Restaurante restaurante1 = new Restaurante(Restaurantes.getSize(), nombre, direccion);
		//entradaEscaner.close();
		Restaurantes.insert(restaurante1);
		actualizarArchivo(Restaurantes, Usuarios);
		menuRestauranteAdmin(restaurante1);
	}
	public void crearUsuario() {		
		Scanner scan = new Scanner(System.in);
		System.out.println("Nombre del Cliente");
		String nombre = scan.nextLine();
		System.out.println("Email del Cliente");
		String email = scan.nextLine();
		System.out.println("Cédula del Cliente");
		int cc = scan.nextInt();
		System.out.println("Teléfono del Cliente");
		long tel = scan.nextLong();
		Usuario cliente =new Usuario(nombre, email, cc, tel);
		Usuarios.insert(cliente);
		actualizarArchivo(Restaurantes, Usuarios);
		System.out.println("Actualizado");
		menuUsuarioAdmin(cliente);
		scan.nextInt();
		scan.close();
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

	public void elegirRestauranteAdmin() {
		Scanner entradaEscaner = new Scanner (System.in);
		if(Restaurantes.getSize()>0) {
			System.out.println("Elija un restaurante:");
			Restaurantes.print();
			if (entradaEscaner.hasNextInt()) {
				int opcion = entradaEscaner.nextInt();
				if (opcion <= Restaurantes.getSize()) {
					Restaurante restTemp = find(Restaurantes.getRoot(), (opcion-1)).getData();
					System.out.println(restTemp.toString());
					menuRestauranteAdmin(restTemp);
				}else invalido();
			}else invalido();
		}else {
			System.out.println("\n******Aún no hay restaurantes creados******\n");
			menu();
		}
		entradaEscaner.close();
	}
	public void elegirRestaurante() {
		Scanner entradaEscaner = new Scanner (System.in);
		if(Restaurantes.getSize()>0) {
			System.out.println("Ingrese su ID de restaurante:");
			if (entradaEscaner.hasNextInt()) {
				int opcion = entradaEscaner.nextInt();
				if (opcion <= Restaurantes.getSize()) {
					Restaurante restTemp = find(Restaurantes.getRoot(), (opcion-1)).getData();
					System.out.println(restTemp.toString());
					menuRestaurante(restTemp);
				}else invalido();
			}else invalido();
		}else {
			System.out.println("\n******Aún no hay restaurantes creados******\n");
			menu();
		}
		entradaEscaner.close();
	}
	public void elegirUsuarioAdmin() {
		Scanner entradaEscaner = new Scanner (System.in);
		if(Usuarios.getSize()>0) {
			System.out.println("Elija un usuario:");
			Usuarios.print();
			if (entradaEscaner.hasNextInt()) {
				int opcion = entradaEscaner.nextInt();
				try {
					if (opcion <= Usuarios.findMax().getCc()) {
						Usuario userTemp = findUser(Usuarios.getRoot(), (opcion)).getData();
						System.out.println(userTemp.toString());
						System.out.println(userTemp.getEmail());
						menuUsuarioAdmin(userTemp);
					}else invalido();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else invalido();
		}else {
			System.out.println("\n******Aún no hay usuarios creados******\n");
			menu();
		}
		entradaEscaner.close();
	}
	public void elegirUsuario() {
		Scanner entradaEscaner = new Scanner (System.in);
		if(Usuarios.getSize()>0) {
			System.out.println("Ingrese su cc:");
			if (entradaEscaner.hasNextInt()) {
				int opcion = entradaEscaner.nextInt();
				try {
					if (opcion <= Usuarios.findMax().getCc()) {
						Usuario userTemp = findUser(Usuarios.getRoot(), (opcion)).getData();
						System.out.println(userTemp.toString());
						menuUsuario(userTemp);
					}else invalido();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else invalido();
		}else {
			System.out.println("\n******Aún no hay usuarios creados******\n");
			menu();
		}
		entradaEscaner.close();
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
					System.out.println("\\\\\\\\\\\\\\\\ seleccione una opción ///////\n");
					System.out.println("Opcion 1: Crear Restaurante");
					System.out.println("Opcion 2: Ver/Editar Restaurantes");
					int temp;
					if (entradaEscaner.hasNextInt()) {
						temp = entradaEscaner.nextInt();
					}
						else {temp=0;}
					if (temp==1) {
						crearRestaurante();
					}else if(temp==2) {
						elegirRestauranteAdmin();
					}else {invalido();}
				}
				case 2:{
					System.out.println("\\\\\\\\\\\\\\\\ seleccione una opción ///////\n");
					System.out.println("Opcion 1: Crear Usuario");
					System.out.println("Opcion 2: Ver/Editar Usuarios");
					int temp;
					if (entradaEscaner.hasNextInt()) {
						temp = entradaEscaner.nextInt();
					}
						else {temp=0;}
					if (temp==1) {
						crearUsuario();
					}else if(temp==2) {
						elegirUsuarioAdmin();
					}else {invalido();}
				}
				case 3:{ 
					menu();
				}
				default: invalido();
			}
		//entradaEscaner.close();
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
		System.out.println("Opción 7: Regresar al menú de Administración y guardar");
		if (entradaEscaner.hasNextInt()) {
			opcion = entradaEscaner.nextInt();
			}
			else {opcion=0;}
		switch (opcion) {
		case 1:{
			Restaurante temp = restaurante1;
			Restaurantes.remove(restaurante1);
			System.out.println("\nRestaurante eliminado: " + temp.getNombre());
			menuAdmin();
		}
		case 2:{
			entradaEscaner.nextLine();
			System.out.println("\n-------Ingrese el nuevo nombre:-------\n");
			String newName = entradaEscaner.nextLine();
			restaurante1.setNombre(newName);
			System.out.println("\nNombre actualizado. Nuevo nombre: " + restaurante1.getNombre());
			System.out.println(restaurante1);
			menuRestauranteAdmin(restaurante1);
		}
		case 3:{
			entradaEscaner.nextLine();
			System.out.println("\n-------Ingrese la nueva Direccion:-------\n");
			String newDir = entradaEscaner.nextLine();
			restaurante1.setDireccion(newDir);
			System.out.println("\nDireccion actualizada. Nueva direccion: " + restaurante1.getDireccion());
			System.out.println(restaurante1);
			menuRestauranteAdmin(restaurante1);
		}
		case 4:{ 
			if(restaurante1.platos.size() > 0) {
			for (int i = 0; i < restaurante1.platos.size(); i++) {
				System.out.println();
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
		case 5:{
			if(restaurante1.bebidas.size() > 0) {
			for (int i = 0; i < restaurante1.bebidas.size(); i++) {
				System.out.println();
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

		case 6:{
			restaurante1.verFacturas();
			menuRestauranteAdmin(restaurante1);
		}
		case 7: {
			actualizarArchivo(Restaurantes, Usuarios);
			menuAdmin();
			}
		default: invalido();
		}
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
		System.out.println("Opción 6: Regresar al menú de Administración y guardar");
		if (entradaEscaner.hasNextInt()) {
			opcion = entradaEscaner.nextInt();
			}
			else {opcion=0;}
		switch (opcion) {
		case 1:{
			Usuario temp = user;
			Usuarios.remove(user);
			System.out.println("\nUsuario eliminado: " + temp.getNombre());
			menuUsuarioAdmin(user);
		}
		case 2:{
			entradaEscaner.nextLine();
			System.out.println("\n-------Ingrese el nuevo nombre:-------\n");
			String newName = entradaEscaner.nextLine();
			user.setNombre(newName);
			System.out.println("\nNombre actualizado. Nuevo nombre: " + user.getNombre());
			System.out.println(user);
			menuUsuarioAdmin(user);
		}
		case 3:{
			entradaEscaner.nextLine();
			System.out.println("\n-------Ingrese el nuevo Email:-------\n");
			String newEmail = entradaEscaner.nextLine();
			user.setEmail(newEmail);
			System.out.println("\nEmail actualizado. Nuevo Email: " + user.getEmail());
			System.out.println(user);
			menuUsuarioAdmin(user);
		}
		case 4:{
			entradaEscaner.nextLine();
			System.out.println("\n-------Ingrese el nuevo teléfono:-------\n");
			long newTel = entradaEscaner.nextLong();
			user.setTel(newTel);
			System.out.println("\nTeléfono actualizado. Nuevo teléfono: " + user.getTel());
			System.out.println(user);
			menuUsuarioAdmin(user);
		}
		case 5:{
			user.getFacturas().print();
			menuUsuarioAdmin(user);
		}
		case 6:{
			actualizarArchivo(Restaurantes, Usuarios);
			menuAdmin();
		}
		default: {
			invalido();}
		}
		
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
			entradaEscaner.nextLine();
			System.out.println("\n-------Ingrese el nuevo nombre:-------\n");
			String newName = entradaEscaner.nextLine();
			user.setNombre(newName);
			System.out.println("\nNombre actualizado. Nuevo nombre: " + user.getNombre());
			System.out.println(user);
			menuUsuarioEdit(user);
		}
		case 2:{
			entradaEscaner.nextLine();
			System.out.println("\n-------Ingrese el nuevo Email:-------\n");
			String newEmail = entradaEscaner.nextLine();
			user.setEmail(newEmail);
			System.out.println("\nEmail actualizado. Nuevo Email: " + user.getEmail());
			System.out.println(user);
			menuUsuarioEdit(user);
		}
		case 3:{
			entradaEscaner.nextLine();
			System.out.println("\n-------Ingrese el nuevo teléfono:-------\n");
			long newTel = entradaEscaner.nextLong();
			user.setTel(newTel);
			System.out.println("\nTeléfono actualizado. Nuevo teléfono: " + user.getTel());
			System.out.println(user);
			menuUsuarioEdit(user);
		}
		case 4:{
			actualizarArchivo(Restaurantes, Usuarios);
			menuUsuario(user);
		}
		default: {
			invalido();}
		}
	}
	
	
	public void menuRestaurante(Restaurante restaurante1) {
		@SuppressWarnings("resource")
		Scanner entradaEscaner = new Scanner (System.in);
		int opcion;
		System.out.println("\\\\\\\\\\\\\\\\ seleccione una opción ///////\n");
		System.out.println("Opcion 1: Agregar plato");
		System.out.println("Opcion 2: Agregar bebida");
		System.out.println("Opcion 3: Mostrar Menú de platos");
		System.out.println("Opcion 4: Mostrar Menú de bebidas");
		System.out.println("Opcion 5: Ver Facturas");
		System.out.println("Opción 6: Salir y guardar");
		if (entradaEscaner.hasNextInt()) {
			opcion = entradaEscaner.nextInt();
			}
			else {opcion=0;}
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
				System.out.println();
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
				System.out.println();
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
		case 5:{
			restaurante1.verFacturas();
		}
		case 6: actualizarArchivo(Restaurantes, Usuarios);
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
		System.out.println("Opcion 3: Ordenar");
		System.out.println("Opción 4: Salir y guardar");
		if (entradaEscaner.hasNextInt()) {
			opcion = entradaEscaner.nextInt();
			}
			else {opcion=0;}
		switch (opcion) {
		case 1:{ 
			if(restaurante1.platos.size() > 0) {
			for (int i = 0; i < restaurante1.platos.size(); i++) {
				System.out.println();
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
		case 2:{
			if(restaurante1.bebidas.size() > 0) {
			for (int i = 0; i < restaurante1.bebidas.size(); i++) {
				System.out.println();
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
		case 3:{
			restaurante1.generarOrden(user);
		}
		case 6: actualizarArchivo(Restaurantes, Usuarios);
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
		}
		case 2:{
			user.getFacturas().print();
		}
		case 3:{
			
			Scanner scan = new Scanner (System.in);
			if(Restaurantes.getSize()>0) {
				System.out.println("Elija un restaurante:");
				Restaurantes.print();
				if (scan.hasNextInt()) {
					int sel = scan.nextInt();
					if (sel <= Restaurantes.getSize()) {
						Restaurante restTemp = find(Restaurantes.getRoot(), (sel-1)).getData();
						System.out.println(restTemp.toString());
						menuUsuarioRestaurante(restTemp, user);
					}else invalido();
				}else invalido();
			}else {
				System.out.println("\n******Aún no hay restaurantes disponibles******\n");
				menuUsuario(user);
			}
			scan.close();
		}
		case 4:{
			actualizarArchivo(Restaurantes, Usuarios);
		}
		default:invalido();
		}
	}
	
	
	public void invalido() {
			System.out.println("\n--Opción no válida--\n");
			menu();
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
		
		if(Rest.getSize()>0) {
			System.out.println("\nGuardando Información de Restaurantes...");
			try {
				ObjectOutputStream archivo = new ObjectOutputStream(new FileOutputStream("restaurantes.dat"));
				archivo.writeObject(Rest);
				archivo.close();
				System.out.println("\n---Información de Restaurantes almacenada---\n");
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
			System.out.println("\nGuardando Información de Usuarios...");
			try {
				ObjectOutputStream archivo = new ObjectOutputStream(new FileOutputStream("usuarios.dat"));
				archivo.writeObject(Usu);
				archivo.close();
				System.out.println("\n---Información de Usuarios almacenada---\n");
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
		
		
		
	}
	public void actualizarArchivo(AVLTree<Restaurante> Rest, AVLTree<Usuario> Usu) {	
		
		if(Rest.getSize()>0) {
			System.out.println("\nGuardando Información de Restaurantes...");
			try {
				
				ObjectOutputStream archivo = new ObjectOutputStream(new FileOutputStream("restaurantes.dat"));
				archivo.writeObject(Rest);
				archivo.close();
				System.out.println("\n---Información de Restaurantes almacenada---\n");
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
			System.out.println("\nGuardando Información de Usuarios...");
			try {
				
				ObjectOutputStream archivo = new ObjectOutputStream(new FileOutputStream("usuarios.dat"));
				archivo.writeObject(Usu);
				archivo.close();
				System.out.println("\n---Información de Usuarios almacenada---\n");
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
		
		
		
		
	}
	
	
	
	
	
	public void menu() {
		int opcion = menuPrincipal();
		switch (opcion) {
		
		case 1:{
			@SuppressWarnings("resource")
			Scanner entradaEscaner = new Scanner (System.in);
			String pw;
			System.out.println("\\\\\\\\\\\\\\\\ ¡Hola Administrador! ///////\n");
			System.out.println("Ingrese la contraseña");
			if (entradaEscaner.hasNext()) {
				pw = entradaEscaner.nextLine();
				}
				else {pw=" ";}
			if (pw.equals(pass)) {
			menuAdmin();
			}else invalido();
			//entradaEscaner.close();
		}
		case 2:{
			elegirRestaurante();
		}
		case 3:{
			elegirUsuario();
		}
		case 4:{
		actualizarArchivo(Restaurantes, Usuarios);
		System.exit(0);
		}

		default: invalido();
	}
	}
	public static void main(String args[]) {
		
		Bestellen data = new Bestellen();
		data.cargarDatos();
		data.menu();
}
}