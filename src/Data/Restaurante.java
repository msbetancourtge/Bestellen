package Data;
import Structures.*;
public class Restaurante {
private String nombre;
private String direccion;
LinkedList<Plato> platos = new LinkedList<>();
LinkedList<Bebida> bebidas = new LinkedList<>();
public String getNombre() {
	return nombre;
	
}
public String getDireccion() {
	return direccion;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
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
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public Restaurante(String nombre, String direccion, LinkedList<Plato> platos, LinkedList<Bebida> bebidas) {
	super();
	this.nombre = nombre;
	this.direccion = direccion;
	this.platos = platos;
	this.bebidas = bebidas;
}
public void crearPlato(String nombre, String descripcion, int precio) {
	Plato nuevo = new Plato(nombre,descripcion,precio);
	platos.add(nuevo);
}
public void crearBebida(String nombre, String descripcion, int precio, boolean alcohol) {
	Bebida nuevo = new Bebida(nombre, descripcion, precio, alcohol);
	bebidas.add(nuevo);	
}
}
