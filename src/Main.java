
public class Main {
	public static void main(String[] args) {
		GrafoD g = new GrafoD();
		//g.agregarArco(0, 2);
		//g.agregarArco(0, 1);
		//g.agregarArco(1, 2);
		//g.agregarArco(2, 1);
		//g.agregarArco(2, 3);
		//g.agregarArco(1, 4);
		//g.agregarArco(3, 4);
		//g.agregarArco(4, 2);
		
		for(int i=0; i<10; i++) {
			g.agregarArco((int)(Math.random()*10),(int)(Math.random()*10));
		}
		//System.out.println("LOS ADYACENTES DE 0 SON:" + g.mostrarAdy(0));
		
		System.out.println("hay ciclo:" + g.dfsIterative());
			//System.out.println("Hay ciclo: "+ g.dfs());
			
	}
}
