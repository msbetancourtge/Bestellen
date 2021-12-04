package Data;

import Structures.Cola;
import Structures.Stack;

public class RestauranteCola extends Restaurante {

	public Cola<Plato> platos = new Cola<>();
	public Cola<Bebida> bebidas = new Cola<>();
	public String direccion;
	public String nombre;
	
	private static final long serialVersionUID = 1L;

	public RestauranteCola(String nombre, String direccion, Cola<Plato> platos, Cola<Bebida> bebidas) {
		super(direccion, direccion);
		this.nombre = nombre;
		this.direccion = direccion;
		this.platos = platos;
		this.bebidas = bebidas;
	}
	public void crearPlato(String nombre, String descripcion, int precio) {
		Plato nuevo = new Plato(nombre,descripcion,precio);
		platos.enqueue(nuevo);
	}
	public void crearBebida(String nombre, String descripcion, int precio, boolean alcohol) {
		Bebida nuevo = new Bebida(nombre, descripcion, precio, alcohol);
		bebidas.enqueue(nuevo);	
	}
	public void setPlatos(Cola<Plato> platos) {
		this.platos = platos;
	}
	public void setBebidas(Cola<Bebida> bebidas) {
		this.bebidas = bebidas;
	}

}
