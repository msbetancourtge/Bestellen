package Data;
import java.io.Serializable;

public class Plato implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nombre;
	private String descripcion;
	private int precio;

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public Plato(String nombre, String descripcion, int precio) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Nombre del plato: " + nombre + '\n' + "Descripcion: " + descripcion + '\n' + "Precio: $ " + precio;
	}

}
