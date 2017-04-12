
public class Lista {
	Nodo lista;
	private int cantDatos;
	
	public Lista() {
		lista = null;
		cantDatos = 0;
	}
	
	public Nodo getPrimero() {
		return lista;
	}
	
	//agrega al principio
	public void agregar(int dato) {
		Nodo nuevo = new Nodo(dato, null);
		if (lista == null) 
			lista = nuevo;
		else if(lista != null) {
				nuevo.set_siguiente(lista);
				lista = nuevo;
			//Nodo pos = lista;
			//	while(pos.get_next() != null)
					//pos = pos.get_next();
				//pos.set_siguiente(nuevo);
		  }
		cantDatos++;
	}
	
	public boolean es_vacia() {
		return lista == null;
	}
	
	public int cantElementos() {
		return cantDatos;
	}
	
	//Retorna TRUE si existe un determinado elemento
	public boolean existeElem(int dato) {
		while(lista != null) {
			if(dato == lista.get_info())
				return true;
			lista = lista.get_next();
		}
		return false;
	}
	
	public int getDato() {
		return lista.get_info();
	}
	
	public String toString() {
		String datos = "";
		while (lista != null) {
			datos = datos + lista.get_info() + " ";
			lista = lista.get_next();
		}
		return datos;
	}
	
	//ELIMINA UN ELEMENTO DADO.
	public void eliminar(int dato) {
		Nodo pos = lista;
		if(lista != null){
			if(dato == lista.get_info()) {
				lista = lista.get_next();
				cantDatos--;
			}
			else { while((pos.get_next() != null)&&(dato != pos.get_next().get_info()))
						pos = lista.get_next();
				   if(dato == pos.get_next().get_info()){
					   pos.set_siguiente(pos.get_next().get_next());
					   cantDatos--;
				   }
			}
		}
	}
}
