package grafos;

public class test {
	public static void main(String[] args) {
		//implementacion de lista de adyacencia
		
		GraphLink<String> la = new GraphLink<>();
		la.insertVertex("lima");
		la.insertVertex("aqp");
		la.insertVertex("cusco");
		la.insertVertex("piura");
		la.insertVertex("tarapoto");
		
		la.insertEdge("lima", "aqp");
		la.insertEdge("cusco", "aqp");
		la.insertEdge("piura", "lima");
		la.insertEdge("cusco", "lima");
		la.insertEdge("piura", "tarapoto");
		//la.insertEdge("lima", "aqp");
		
		System.out.println("Grafo ciudades :\n"+ la);
		
		
		//implementacion de DFS
		la.DFS("cusco");
		System.out.println();
		la.DFS("lima");
		
		
		
		
	}
}
