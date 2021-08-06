package grafos;

public class test {
	public static void main(String[] args) {
		//implementacion de lista de adyacencia
		
		GraphLink<String> la = new GraphLink<>();
		la.insertVertex("words");
		la.insertVertex("cords");
		la.insertVertex("corps");
		la.insertVertex("coops");
		la.insertVertex("crops");
		la.insertVertex("drops");
		la.insertVertex("drips");
		la.insertVertex("grips");
		la.insertVertex("gripe");
		la.insertVertex("graph");
		
		
		
		la.insertEdge("words", "cords");;
		la.insertEdge("cords", "corps");
		la.insertEdge("corps", "coops");
		la.insertEdge("coops", "crops");
		la.insertEdge("crops", "drops");
		la.insertEdge("drops", "drips");
		la.insertEdge("drips", "grips");
		la.insertEdge("grips", "gripe");
		la.insertEdge("gripe", "graph");
		
		System.out.println("Grafo palabras :\n"+ la);
		
		
		//implementacion de DFS
		la.DFS("words");
		System.out.println();
		la.DFS("5");
		
		
		System.out.println("\n Busqueda en anchura");
		//la.BFS("0");
		
		
		
	}
}
