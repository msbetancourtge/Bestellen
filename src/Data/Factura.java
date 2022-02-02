package Data;
import java.io.Serializable;

import Structures.LinkedList;

public class Factura implements Serializable, Comparable<Factura>{
	
	private static final long serialVersionUID = 1L;
	
	private int id, total;
	private Usuario cliente;
	private Restaurante restaurante;
	private LinkedList<Plato> compraPlatos = new LinkedList<>();
	private LinkedList<Bebida> compraBebidas = new LinkedList<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public LinkedList<Plato> getCompraPlatos() {
		return compraPlatos;
	}
	public void setCompraPlatos(LinkedList<Plato> compraPlatos) {
		this.compraPlatos = compraPlatos;
	}
	public LinkedList<Bebida> getCompraBebidas() {
		return compraBebidas;
	}
	public void setCompraBebidas(LinkedList<Bebida> compraBebidas) {
		this.compraBebidas = compraBebidas;
	}
	public Usuario getCliente() {
		return cliente;
	}
	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}
	public Restaurante getRestaurante() {
		return restaurante;
	}
	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}
	public Factura() {
	}
	
	public Factura(Usuario cliente, Restaurante rest, int id, int total, LinkedList<Plato> compraPlatos, LinkedList<Bebida> compraBebidas) {
		super();
		this.cliente = cliente;
		this.id = id;
		this.total = total;
		this.compraPlatos = compraPlatos;
		this.compraBebidas = compraBebidas;
		this.restaurante = rest;
	}
	public String printUser() {
		return "Restaurante: \n" + restaurante.getNombre() + "\nId de la Factura: " + (getId()+1) + "\nCompra:\n" + compraPlatos.toString() + '\n' + compraBebidas.toString() + '\n' + "Total: " + getTotal() + '\n';
		
	}
	@Override
	public String toString() {
			return "Info Cliente: \n" + cliente.toString() + "\nId de la Factura: " + (getId()+1) + "\nTotal: " + getTotal() + '\n';
	}
	@Override
	public int compareTo(Factura o) {
		
		if (this.id<o.id) return -1;
		else if(this.id>o.id) return 1;
		else return 0;

	}
	
	
	
}
