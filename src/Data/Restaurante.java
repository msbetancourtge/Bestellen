package Data;
import java.util.Scanner;

import Logic.Bestellen;

import java.io.Serializable;
import Structures.*;

public class Restaurante implements Serializable, Comparable<Restaurante>{
	
private static final long serialVersionUID = 1L;

private int id;
private String nombre;
private String direccion;
public LinkedList<Plato> platos = new LinkedList<>();
public LinkedList<Bebida> bebidas = new LinkedList<>();
public AVLTree<Factura> facturas = new AVLTree<Factura>();

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public AVLTree<Factura> getFacturas() {
	return facturas;
}
public void setFacturas(AVLTree<Factura> facturas) {
	this.facturas = facturas;
}
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

public Restaurante(int id, String nombre, String direccion, LinkedList<Plato> platos, LinkedList<Bebida> bebidas) {
	super();
	this.id=id;
	this.nombre = nombre;
	this.direccion = direccion;
	this.platos = platos;
	this.bebidas = bebidas;
}
public Restaurante(int id, String nombre, String direccion) {
	super();
	this.id=id;
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

	@SuppressWarnings("resource")
	Scanner scan = new Scanner(System.in);
	Plato seleccion = new Plato();
	if(this.platos.size() > 0) {
		for (int i = 0; i < this.platos.size(); i++) {
			System.out.println();
			System.out.println(i+1 +". "+this.platos.get(i).toString());
		}
		int selec = scan.nextInt();
		if (selec <=this.platos.size()) seleccion = this.platos.get(selec-1);
		else{
			System.out.println("\nElección Inválida");
			eleccionPlatos();
		}
	}else {
			System.out.println("\nAún no hay platos en este restaurante");
			System.out.println("\n***Presione 1 para volver al menú inicial***\n");
			int regresar = scan.nextInt ();
			if(regresar == 1 ) Bestellen.menuPrincipal();
			else invalido();
	}
	return seleccion;
}


public Bebida eleccionBebidas() {
	@SuppressWarnings("resource")
	Scanner scan = new Scanner(System.in);
	Bebida seleccion = new Bebida();
	if(this.bebidas.size() > 0) {
		for (int i = 0; i < this.bebidas.size(); i++) {
			System.out.println();
			System.out.println(i+1 +". "+this.bebidas.get(i).toString());
		}
		int selec = scan.nextInt();
		if (selec <=this.bebidas.size()) seleccion = this.bebidas.get(selec-1);
		else{
			System.out.println("\nElección Inválida");
			eleccionBebidas();
		}	
	}else {
			System.out.println("\nAún no hay platos en este restaurante");
			System.out.println("\n***Presione 1 para volver al menú inicial***\n");
			int regresar = scan.nextInt ();
			if(regresar == 1 ) Bestellen.menuPrincipal();
			else invalido();
	}
	return seleccion;
}

public void generarOrden(Usuario user) {
	
	LinkedList<Plato> ordenPlatos = new LinkedList<>();
	LinkedList<Bebida> ordenBebidas = new LinkedList<>();
	
	@SuppressWarnings("resource")
	Scanner scan = new Scanner(System.in);	
	System.out.println("Cantidad de comensales");
	int personas = scan.nextInt();
	
		for(int k=1; k<=personas; k++) {
			System.out.println("Elija un plato del menú para el comensal: " + k);
			ordenPlatos.add(eleccionPlatos());
			System.out.println("Elija una bebida del menú para el comensal: " + k);
			ordenBebidas.add(eleccionBebidas());
		}
		Orden pedido = new Orden(user, ordenPlatos, ordenBebidas);
		Factura temp = pedido.facturar(facturas.getSize(), user);
		facturas.insert(temp);
		user.agregarFactura(temp);
}
	public void verFacturas() {
		facturas.print();
	}
	public void invalido() {
		System.out.println("\n--Opción no válida--\n");
		Bestellen.menuPrincipal();
	}
	@Override
	public String toString() {
		return "\nId del restaurante: " + (getId()+1) + "\nNombre del Restaurante: " + nombre + "\nDirección: " + direccion + '\n';
	}
	@Override
	public int compareTo(Restaurante o) {
		if (this.id<o.id) return -1;
		else if (this.id>o.id) return 1;
		else return 0;
	}
}
