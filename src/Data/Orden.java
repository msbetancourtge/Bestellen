package Data;

import java.io.Serializable;

import Structures.LinkedList;

public class Orden implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Usuario cliente;
	Restaurante rest;
	public LinkedList<Plato> platos = new LinkedList<>();
	public LinkedList<Bebida> bebidas = new LinkedList<>();
	
	
	public Restaurante getRest() {
		return rest;
	}
	public void setRest(Restaurante rest) {
		this.rest = rest;
	}
	public Usuario getCliente() {
		return cliente;
	}
	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
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
	public Orden(Restaurante rest, Usuario cliente, LinkedList<Plato> platos, LinkedList<Bebida> bebidas) {
		super();
		this.cliente = cliente;
		this.platos = platos;
		this.bebidas = bebidas;
		this.rest=rest;
	}
	public Factura facturar(int id, Usuario cliente, Restaurante restaurante) {
		
		int total=0;	
		for (int i=0; i<platos.size(); i++) {
			total += platos.get(i).getPrecio();
		}
		for (int i=0; i<bebidas.size(); i++) {
			total += bebidas.get(i).getPrecio();
		}
		System.out.println( "\nUsuario: " + cliente.getCc() + "\nRestaurante: "+ restaurante.getId() + "Total: \n" + total);
		Factura factura = new Factura(cliente, restaurante, id, total, platos, bebidas);
		return factura;
	}
	@Override
	public String toString() {
		return  "\nRESTAURANTE: " + rest + "\n------- PLATOS -------\n" + platos.toString() + "\n------- BEBIDAS -------\n" + bebidas.toString() +'\n';
	}
	
	
	
	
	
	
	
	
}
