import java.util.Stack;

public class GrafoD {
	Lista[] grafo;
	int cantVertices;

	public GrafoD() {
	  grafo = new Lista[10];
	  cantVertices = 10;
	  for(int i=0; i< cantVertices; i++) {
		  grafo[i] = new Lista();
	  }
	}
	
	public String mostrarAdy(int vertice) {
		return grafo[vertice].toString();
	}
	
	public void agregarArco(int origen, int destino) {
		grafo[origen].agregar(destino);
	}
	
	public void eliminarArco(int origen, int destino) {
		grafo[origen].eliminar(destino);
	}
	
	public Lista devolverAdyacentes(int vertice) {
		Lista adyacentes = new Lista();
		adyacentes = grafo[vertice];
		return adyacentes;
	}
	
	public boolean dfsIterative() {
		Stack<Integer> stack = new Stack<Integer>();
		int[] visitado = new int[cantVertices];
		
		for(int i=0; i<cantVertices; i++) 
			visitado[i] = -1;
		
		stack.push(0);
		
		while(!stack.isEmpty()) {
			Integer top = stack.peek();
			stack.pop();
			if(visitado[top] == -1) {
				visitado[top] = 0;
				Lista ady = new Lista();
				ady = devolverAdyacentes(top);
			
				Nodo cursor = ady.getPrimero();
				while(cursor != null) {
					stack.push(cursor.get_info());
					cursor = cursor.get_next();
				}
			}
			else if(visitado[top] == 1) {
					return true;
			}
			else {
				visitado[top] = 1;
				return true;
			}
		}
		return false;
	}
	
	public boolean recorridoEnProfundidad(int vertice, int visitado[], int pos) {
		boolean ciclo = false;
		visitado[vertice] = 0;
		Lista ady = new Lista();
		ady = devolverAdyacentes(vertice);
		Nodo cursor = ady.getPrimero();
		while((cursor != null)&&(!ciclo)) {
			if(visitado[ady.getDato()] == -1) {
				return recorridoEnProfundidad(ady.getDato(), visitado,pos);
			}
			else if(visitado[ady.getDato()] == 0) {
					ciclo = true;
			}
			cursor = cursor.get_next();
		}
		visitado[vertice] = 1;
		return ciclo;
	}
	
	public boolean dfs() {
		int[] visitado = new int[cantVertices];
		for(int i=0; i<cantVertices; i++) {
			visitado[i] = -1;
		}
		boolean ciclo = false;
		int pos = 0;
		for(int vertice=0; vertice<cantVertices; vertice++) {
			if(visitado[vertice] == -1) {
				if(recorridoEnProfundidad(vertice,visitado,pos))
					ciclo = true;
			}
		}
		return ciclo;
	}
}
