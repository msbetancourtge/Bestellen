package Data;
import java.io.Serializable;

import Structures.LinkedList;

public class Factura implements Serializable, Comparable<Integer>{
	
	private static final long serialVersionUID = 1L;
	
	private int id, total;
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
	
	public Factura() {
	}
	
	public Factura(int id, int total, LinkedList<Plato> compraPlatos, LinkedList<Bebida> compraBebidas) {
		super();
		this.id = id;
		this.total = total;
		this.compraPlatos = compraPlatos;
		this.compraBebidas = compraBebidas;
	}

	@Override
	public String toString() {
			return "Id de la Factura: " + getId() + '\n' + "Total: " + getTotal() + '\n';
	}

	@Override
	public int compareTo(Integer o) {
		
		if (this.id<o) return -1;
		else if(this.id>o) return 1;
		else return 0;
	}
	
	
	
}
