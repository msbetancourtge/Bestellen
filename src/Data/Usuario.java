package Data;
import java.io.Serializable;
import Structures.BinarySearchTree;

public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private BinarySearchTree<Factura> facturas = new BinarySearchTree<>();
	
	private String nombre, email;
	private int cc;
	private long tel;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	public long getTel() {
		return tel;
	}
	public void setTel(long tel) {
		this.tel = tel;
	}
	
	public Usuario(){
	}
	public Usuario(String nombre, int cc) {
		setNombre(nombre);
		setEmail("noEmail");
		setCc(cc);
		setTel(0000000000);
	}
	public Usuario(String nombre, String email, int cc, long tel) {
		setNombre(nombre);
		setEmail(email);
		setCc(cc);
		setTel(tel);
	}
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", cc=" + cc + "]";
	}
}
