package Data;
import Structures.*;
public class Restaurante {
private String nombre;
private String direccion;
LinkList<Plato> platos = new LinkList<>();
LinkList<Bebida> bebidas = new LinkList<>();
public String getNombre() {
	return nombre;
	
}
public String getDireccion() {
	return direccion;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
}
public LinkList<Plato> getPlatos() {
	return platos;
}
public void setPlatos(LinkList<Plato> platos) {
	this.platos = platos;
}
public LinkList<Bebida> getBebidas() {
	return bebidas;
}
public void setBebidas(LinkList<Bebida> bebidas) {
	this.bebidas = bebidas;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public Restaurante(String nombre, String direccion, LinkList<Plato> platos, LinkList<Bebida> bebidas) {
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
}
