package grafos;

public class test {
	public static void main(String[] args) {
		//implementacion de lista de adyacencia
		
		GraphLink<String> la = new GraphLink<>();
		la.insertVertex("0");
		la.insertVertex("1");
		la.insertVertex("2");
		la.insertVertex("3");
		la.insertVertex("4");
		la.insertVertex("5");
		
		la.insertEdge("1", "3");
		la.insertEdge("2", "4");
		la.insertEdge("5", "1");
		la.insertEdge("3", "0");
		la.insertEdge("3", "1");
		la.insertEdge("2", "4");
		la.insertEdge("5", "4");
		la.insertEdge("0", "4");
		
		System.out.println("Grafo ciudades :\n"+ la);
		
		
		//implementacion de DFS
		la.DFS("0");
		System.out.println();
		la.DFS("5");
		
		
		
		
	}
}
