
public class Nodo {
	private int dato;
	private Nodo siguiente;

	
	public Nodo() {
		this.siguiente = null;
	}
	
	public Nodo(int dato, Nodo siguiente) {
		this.dato = dato;
		this.siguiente = siguiente;
	}
	
	public void set_info(int dato) {
		this.dato = dato;
	}
	
	public void set_siguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}
	
	public int get_info() {
		return this.dato;
	}
	
	public Nodo get_next() {
		return siguiente;
	}
	
	public void eliminar() {
		this.siguiente = null;
	}
}
