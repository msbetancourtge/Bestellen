package Data;
import java.io.Serializable;
import Structures.*;


public class Restaurante implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
private String nombre;
private String direccion;
public LinkedList<Plato> platos = new LinkedList<>();
public LinkedList<Bebida> bebidas = new LinkedList<>();
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
@Override
public String toString() {
	return "\nNombre del Restaurante: " + nombre + "\nDirección: " + direccion + '\n';
}


}
