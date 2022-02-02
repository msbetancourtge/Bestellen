package Logic;

import Structures.*;

import java.util.Scanner;
import java.io.*;
import Data.*;
public class Bestellen2 {
	
private static final String pass = "Bestellen";
	
	public static String getPass() {
		return pass;
	}
	
	AVLTree<Restaurante> Restaurantes = new AVLTree<Restaurante>();
	AVLTree<Usuario> Usuarios = new AVLTree<Usuario>();
        public Restaurante restauranteSeleccionado;
        public Usuario usuarioSeleccionado;

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
			//System.exit(0);
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
			//System.exit(0);
		}
		System.out.println("\n---Información almacenada---\n");
	}
        
	public void crearRestaurante(String nombre, String direccion) {
            
		Restaurante restaurante1 = new Restaurante(Restaurantes.getSize(), nombre, direccion, pass);
		Restaurantes.insert(restaurante1);
		actualizarArchivo(Restaurantes, Usuarios);
	}
	public void eliminarRestaurante(Restaurante restaurante1) {
		System.out.println("\nRestaurante eliminado: " + restaurante1.getNombre());
		Restaurantes.remove(restaurante1);
	}
	public void editarNombreRestaurante(Restaurante restaurante1,String newName) {
            
		restaurante1.setNombre(newName);
		System.out.println("\nNombre actualizado. Nuevo nombre: " + restaurante1.getNombre());
	}
	public void editarDireccionRestaurante(Restaurante restaurante1,String newDir) {
            
		restaurante1.setDireccion(newDir);
		System.out.println("\nDireccion actualizada. Nueva direccion: " + restaurante1.getDireccion());
	}
	public void eliminarPlato(Plato plato, Restaurante restaurante1) {
		System.out.println("\nPlato eliminado: " + plato.getNombre());
		restaurante1.platos.remove(plato);
	}
	
	public void editarNombrePlato(Plato plato,String newName) {
            
		plato.setNombre(newName);
		System.out.println("\nNombre actualizado. Nuevo nombre: " + plato.getNombre());
	}
        
	public void editarDescripcionPlato(Plato plato,String newDesc) {
            
		plato.setDescripcion(newDesc);
		System.out.println("\nDescripcion actualizada. Nueva descripcion: " + plato.getDescripcion());
	}
	public void editarPrecioPlato(Plato plato,int newPrice) {
		plato.setPrecio(newPrice);
		System.out.println("\nPrecio actualizado. Nuevo precio: " + plato.getPrecio());
	}
	
	public void eliminarBebida(Bebida bebida, Restaurante restaurante1) {
		System.out.println("\nBebida eliminada: " + bebida.getNombre());
		restaurante1.bebidas.remove(bebida);
	}
	
	public void editarNombreBebida(Bebida bebida,String newName) {
            
		bebida.setNombre(newName);
		System.out.println("\nNombre actualizado. Nuevo nombre: " + bebida.getNombre());
	}
	public void editarDescripcionBebida(Bebida bebida,String newDesc) {
		bebida.setDescripcion(newDesc);
		System.out.println("\nDescripcion actualizada. Nueva descripcion: " + bebida.getDescripcion());
	}
	public void editarPrecioBebida(Bebida bebida,int newPrice) {
		bebida.setPrecio(newPrice);
		System.out.println("\nPrecio actualizado. Nuevo precio: " + bebida.getPrecio());
	}
	public void crearUsuario(String nombre,String email,int cc,int tel,String pw) {		
            
		Usuario cliente =new Usuario(nombre, email, cc, tel, pw, Usuarios.getSize());
		Usuarios.insert(cliente);
		actualizarArchivo(Restaurantes, Usuarios);
	}
	public void eliminarUsuario(Usuario user) {
		System.out.println("\nRestaurante eliminado: " + user.getNombre());
		Usuarios.remove(user);
	}
	public void editarNombreUsuario(Usuario user,String newName) {
		user.setNombre(newName);
		System.out.println("\nNombre actualizado. Nuevo nombre: " + user.getNombre());
	}
	public void editarEmailUsuario(Usuario user,String newEmail) {
		user.setEmail(newEmail);
		System.out.println("\nEmail actualizado. Nuevo Email: " + user.getEmail());
	}
	public void editarTelefonoUsuario(Usuario user,long newTel) {
		user.setTel(newTel);
		System.out.println("\nTeléfono actualizado. Nuevo teléfono: " + user.getTel());
	}
        
	
	public TreeNode <Restaurante> find(TreeNode<Restaurante> root, int pos){
		if (root==null) return root;
		int compare = pos - root.getData().getId();
		if (compare < 0) return find(root.getLeft(), pos);
		else if(compare > 0) return find(root.getRight(), pos);
		else;
		return root;

	}
	public TreeNode <Usuario> findUser(TreeNode<Usuario> root, int cc){
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
	
	
	
	public void crearPlato(Restaurante restaurante1,String nombreP,String descripcion,int precio) {
            
		restaurante1.crearPlato(nombreP, descripcion, precio);
	}
	public void crearBebida(Restaurante restaurante1,String nombreB,String descripcion,int precio,boolean alcohol) {
            
		restaurante1.crearBebida(nombreB, descripcion, precio, alcohol);
	}
	
	
	public static void main(String args[]) {
		
		Bestellen data = new Bestellen();
		data.cargarDatos();
		data.menu();
}

    void salir() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}