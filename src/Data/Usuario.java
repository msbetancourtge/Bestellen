package Data;
import java.io.Serializable;

import Structures.AVLTree;
import Structures.QPHashTable;

public class Usuario implements Serializable, Comparable<Usuario>{
	
	private static final long serialVersionUID = 1L;

	private AVLTree<Factura> facturas = new AVLTree<Factura>();
	private QPHashTable<Orden> ordenes = new QPHashTable<Orden>();
	private String nombre, email, pw;
	private int cc, id;
	private long tel;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public QPHashTable<Orden> getOrdenes() {
		return ordenes;
	}
	public void setOrdenes(QPHashTable<Orden> ordenes) {
		this.ordenes = ordenes;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public AVLTree<Factura> getFacturas() {
		return facturas;
	}
	public void setFacturas(AVLTree<Factura> facturas) {
		this.facturas = facturas;
	}
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
	public Usuario(String nombre, String email, int cc, long tel, String pw, int id) {
		setNombre(nombre);
		setEmail(email);
		setCc(cc);
		setTel(tel);
		setPw(pw);
	}
	
	public Usuario(String nombre, String email, int cc, long tel, String pw, QPHashTable<Orden> ordenes,int id) {
		setNombre(nombre);
		setEmail(email);
		setCc(cc);
		setTel(tel);
		setPw(pw);
		setOrdenes(ordenes);
	}
	
	public void agregarFactura(Factura factura) {
		facturas.insert(factura);
	}
	public void agregarOrden(Orden orden, String key) {
		ordenes.insert(orden, key);
	}
	@Override
	public String toString() {
		return "\nCC: " + cc + "\nNombre: " + nombre + "\nTeléfono: " + tel + "\nEmail: "+ email;
	}
	@Override
	public int compareTo(Usuario o) {
		
		if(this.cc<o.cc) return -1;
		else if(this.cc>o.cc) return 1;
		else return 0;
	}
}
