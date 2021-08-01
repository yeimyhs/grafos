package grafos;

public class GraphLink<E> {//
	
	protected ListaAdyacencia<Vertex<E>>listVertex;
	
	public GraphLink() {
		listVertex = new ListaAdyacencia<Vertex<E>>();
	}
	
	public void insertVertex(E data) {
		Vertex<E> nuevo = new Vertex<E>(data);
		if (this.listVertex.search(nuevo) != null) {
			System.out.print("Vertice ya fue insertado anteriormente ...");
			return;
		}
		this.listVertex.insert(nuevo);
	}
	
	public void insertEdge(E verOri, E verDes) {// para enlazar dos vertices
		Vertex<E> refOri = this.listVertex.search(new Vertex<E>(verOri));//origen
		Vertex<E> refDes = this.listVertex.search(new Vertex<E>(verDes));//destino
		
		if (refOri == null || refDes == null) {
			System.out.println("Vertice origen y/o desino no existen ...");
			return;
		}
		if(refOri.listAdj.search(new Edge<E>(refDes)) != null) {
			System.out.println("Arista ya fue insertada anteriormente...");
			return;
		}
		refOri.listAdj.insert(new Edge<E>(refDes));//inserta
		refDes.listAdj.insert(new Edge<E>(refOri));
	}
	
	public String toString() {
		return this.listVertex.toString();
		
	}
}
