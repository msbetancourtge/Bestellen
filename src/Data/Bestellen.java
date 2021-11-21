package Data;

import Structures.LinkedList;

public class Bestellen {
	LinkedList<Restaurante> Restaurantes = new LinkedList<>();
	
	public void agregarRestaurante(String nombre, String direccion) {
		Restaurante nuevo = new Restaurante(nombre, direccion, null, null);
	}
	
}
