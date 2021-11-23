package Data;
import java.io.Serializable;

public class Bebida implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String descripcion;
	private int precio;
	private boolean esAlcoholica;
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
	public boolean isEsAlcoholica() {
		return esAlcoholica;
	}
	public void setEsAlcoholica(boolean esAlcoholica) {
		this.esAlcoholica = esAlcoholica;
	}
	public Bebida(String nombre, String descripcion, int precio, boolean esAlcoholica) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.esAlcoholica = esAlcoholica;
	}
	@Override
	public String toString() {
		if(esAlcoholica == true) {
			return "Nombre de la bebida: " + nombre + '\n' + "Descripcion: " + descripcion + '\n' + "Precio: $ " + precio + "\n***CONTIENE ALCOHOL***" ;
		}
		else {
			return "Nombre de la bebida: " + nombre + '\n' + "Descripcion: " + descripcion + '\n' + "Precio: $ " + precio + " \n***NO contiene alcohol***";
		}
	}
}
