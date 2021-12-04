package Data;

import Structures.LinkedList;
import Structures.Stack;

public class RestaurantePila extends Restaurante {

	public Stack<Plato> platos = new Stack<>();
	public Stack<Bebida> bebidas = new Stack<>();
	public String direccion;
	public String nombre;
	
	private static final long serialVersionUID = 1L;

	public RestaurantePila(String nombre, String direccion, Stack<Plato> platos, Stack<Bebida> bebidas) {
		super(direccion, direccion);
		this.nombre = nombre;
		this.direccion = direccion;
		this.platos = platos;
		this.bebidas = bebidas;
	}
	public void crearPlato(String nombre, String descripcion, int precio) {
		Plato nuevo = new Plato(nombre,descripcion,precio);
		platos.push(nuevo);
	}
	public void crearBebida(String nombre, String descripcion, int precio, boolean alcohol) {
		Bebida nuevo = new Bebida(nombre, descripcion, precio, alcohol);
		bebidas.push(nuevo);	
	}
	public void setPlatos(Stack<Plato> platos) {
		this.platos = platos;
	}
	public void setBebidas(Stack<Bebida> bebidas) {
		this.bebidas = bebidas;
	}

	

}
