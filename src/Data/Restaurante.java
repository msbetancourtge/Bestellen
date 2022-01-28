package Data;
import java.util.Scanner;

import Logic.Bestellen;

import java.io.Serializable;
import Structures.*;

public class Restaurante implements Serializable{
	
private static final long serialVersionUID = 1L;

private String nombre;
private String direccion;
public LinkedList<Plato> platos = new LinkedList<>();
public LinkedList<Bebida> bebidas = new LinkedList<>();
public AVLTree<Factura> facturas = new AVLTree<Factura>();

public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getNombre() {
	return nombre;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
}
public String getDireccion() {
	return direccion;
}
public LinkedList<Plato> getPlatos() {
	return platos;
}
public void setPlatos(LinkedList<Plato> platos) {
	this.platos = platos;
}
public LinkedList<Bebida> getBebidas() {
	return bebidas;
}
public void setBebidas(LinkedList<Bebida> bebidas) {
	this.bebidas = bebidas;
}

public Restaurante(String nombre, String direccion, LinkedList<Plato> platos, LinkedList<Bebida> bebidas) {
	super();
	this.nombre = nombre;
	this.direccion = direccion;
	this.platos = platos;
	this.bebidas = bebidas;
}
public Restaurante(String nombre, String direccion) {
	super();
	this.nombre = nombre;
	this.direccion = direccion;
}
public void crearPlato(String nombre, String descripcion, int precio) {
	Plato nuevo = new Plato(nombre,descripcion,precio);
	platos.add(nuevo);
}
public void crearBebida(String nombre, String descripcion, int precio, boolean alcohol) {
	Bebida nuevo = new Bebida(nombre, descripcion, precio, alcohol);
	bebidas.add(nuevo);	
}

public Plato eleccionPlatos() {
	Scanner scan = new Scanner(System.in);
	Plato seleccion = new Plato();
	if(this.platos.size() > 0) {
		for (int i = 0; i < this.platos.size(); i++) {
			System.out.println();
			System.out.println(i+1 +". "+this.platos.get(i).toString());
		}
		int selec = scan.nextInt();
		if (selec <=this.platos.size())
		seleccion = this.platos.get(selec-1);
		else{
			System.out.println("\nElección Inválida");
			eleccionPlatos();
		}
		
		}
		else {
			System.out.println("\nAún no hay platos en este restaurante");
			System.out.println("\n***Presione 1 para volver al menú inicial***\n");
			int regresar = scan.nextInt ();
			if(regresar == 1 ) {
				Bestellen.menuPrincipal();
			}else {invalido();}
		}
return seleccion;

}


public Bebida eleccionBebidas() {
	Scanner scan = new Scanner(System.in);
	Bebida seleccion = new Bebida();
	if(this.bebidas.size() > 0) {
		for (int i = 0; i < this.bebidas.size(); i++) {
			System.out.println();
			System.out.println(i+1 +". "+this.bebidas.get(i).toString());
		}
		int selec = scan.nextInt();
		if (selec <=this.bebidas.size())
		seleccion = this.bebidas.get(selec-1);
		else{
			System.out.println("\nElección Inválida");
			eleccionBebidas();
		}
		
		}
		else {
			System.out.println("\nAún no hay platos en este restaurante");
			System.out.println("\n***Presione 1 para volver al menú inicial***\n");
			int regresar = scan.nextInt ();
			if(regresar == 1 ) {
				Bestellen.menuPrincipal();
			}else {invalido();}
		}
return seleccion;
}




public void generarOrden() {
	
	LinkedList<Plato> ordenPlatos = new LinkedList<>();
	LinkedList<Bebida> ordenBebidas = new LinkedList<>();
	
	Scanner scan = new Scanner(System.in);
	System.out.println("Nombre del Cliente");
	String nombre = scan.nextLine();
	System.out.println("Email del Cliente");
	String email = scan.nextLine();
	System.out.println("Cédula del Cliente");
	int cc = scan.nextInt();
	System.out.println("Teléfono del Cliente");
	long tel = scan.nextLong();
	
	System.out.println("Cantidad de comensales");
	int personas = scan.nextInt();
	
	for(int k=1; k<=personas; k++) {
	
	System.out.println("Elija un plato del menú para el comensal: " + k);
	
	ordenPlatos.add(eleccionPlatos());
//	if(this.platos.size() > 0) {
//		for (int i = 0; i < this.platos.size(); i++) {
//			System.out.println();
//			System.out.println(i+1 +". "+this.platos.get(i).toString());
//		}
//		int selec = scan.nextInt();
//		if (selec <=this.platos.size())
//		ordenPlatos.add(this.platos.get(selec-1));
//		else{}
//		
//		}
//		else {
//			System.out.println("\nAún no hay platos en este restaurante");
//			System.out.println("\n***Presione 1 para volver al menú inicial***\n");
//			int regresar = scan.nextInt ();
//			if(regresar == 1 ) {
//				Bestellen.menuPrincipal();
//				break;
//			}else {invalido();}
//		}
		
		System.out.println("Elija una bebida del menú para el comensal: " + k);
		
		ordenBebidas.add(eleccionBebidas());
//		if(this.bebidas.size() > 0) {
//			for (int i = 0; i < this.bebidas.size(); i++) {
//				System.out.println();
//				System.out.println(i+1 +". "+this.bebidas.get(i).toString());
//			}
//			
//			int sel = scan.nextInt();
//			ordenBebidas.add(this.bebidas.get(sel-1));
//			
//			}
//			else {
//				System.out.println("\nAún no hay bebidas en este restaurante");
//				System.out.println("\n***Presione 1 para volver al menú inicial***\n");
//				int back = scan.nextInt ();
//				if(back == 1 ) {
//					
//					Bestellen.menuPrincipal();
//					break;
//				}else {invalido();}
//			}
		
	}
		Usuario cliente =new Usuario(nombre, email, cc, tel);
		Orden pedido = new Orden(cliente, ordenPlatos, ordenBebidas);
		
		facturas.insert(pedido.facturar(facturas.getSize(), cliente));

}

	public void verFacturas() {
		//System.out.println(facturas);
		facturas.print();
	}

	public void invalido() {
		System.out.println("\n--Opción no válida--\n");
		Bestellen.menuPrincipal();
	}


@Override
public String toString() {
	return "\nNombre del Restaurante: " + nombre + "\nDirección: " + direccion + '\n';
}


}
