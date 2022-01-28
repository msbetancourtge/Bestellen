package Data;

import Structures.LinkedList;

public class Orden {
	Usuario cliente;
	public LinkedList<Plato> platos = new LinkedList<>();
	public LinkedList<Bebida> bebidas = new LinkedList<>();
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
	public Orden(Usuario cliente, LinkedList<Plato> platos, LinkedList<Bebida> bebidas) {
		super();
		this.cliente = cliente;
		this.platos = platos;
		this.bebidas = bebidas;
	}
	
	public Factura facturar(int id) {
		
		int total=0;
		
		System.out.println("Cosas a facturar: \n");
		
		for (int i=0; i<platos.size(); i++) {
			
			System.out.println("Plato " + i + ":");
			System.out.println(platos.get(i));
			//total += platos.get(i).getPrecio();
		}
		for (int i=0; i<bebidas.size(); i++) {
			System.out.println("Bebida " + i + ":");
			System.out.println(platos.get(i));
			//total += bebidas.get(i).getPrecio();
		}
		
		Factura factura = new Factura(id, total, platos, bebidas);
		
		return factura;
		
	}
	
	
	
	
}
