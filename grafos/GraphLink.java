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
	public void initLabel() {//inicializar
		Node<Vertex<E>> aux = this.listVertex.head;//vertices
		for (; aux != null ; aux=aux.next) {//mientras que sea diferente de nulo se inicializa el vertice
			aux.data.label = 0;
			Node<Edge<E>> auxE = aux.data.listAdj.head;//las aristas de ese vertice ,recorrer
			for (; auxE != null ; auxE=auxE.next) {
				auxE.data.label = 0;
			}
		}
	}
	public void DFS(E data) {
		Vertex<E> nuevo = new Vertex<E>(data);
		Vertex<E> aux = this.listVertex.search(nuevo);//vertice
		if(aux == null) {
			System.out.println("Vertice no existe ...");
			return;
		}
		initLabel();
		DFSRec(aux);
	}

	private void DFSRec(Vertex<E> v) {
		v.label = 1;
		System.out.println(v.data+", ");
		Node<Edge<E>> e = v.listAdj.head;
		for (; e != null; e=e.next) {
			if(e.data.label == 0) {
				Vertex<E> w =e.data.refDest;
				if (w.label ==0) {
					e.data.label = 1;
					DFSRec(w);
				}else
					e.data.label = 2;
			}
		}
		
	}
}
