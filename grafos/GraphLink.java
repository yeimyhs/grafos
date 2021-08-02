package grafos;

import java.util.ArrayList;

public class GraphLink<T> {//

	protected ListaAdyacencia<Vertex<T>>listVertex;

	public GraphLink() {
		listVertex = new ListaAdyacencia<Vertex<T>>();
	}

	public void insertVertex(T data) {
		Vertex<T> nuevo = new Vertex<T>(data);
		if (this.listVertex.search(nuevo) != null) {
			System.out.print("Vertice ya fue insertado anteriormente ...");
			return;
		}
		this.listVertex.insert(nuevo);
	}

	public void insertEdge(T verOri, T verDes) {// para enlazar dos vertices
		Vertex<T> refOri = this.listVertex.search(new Vertex<T>(verOri));//origen
		Vertex<T> refDes = this.listVertex.search(new Vertex<T>(verDes));//destino

		if (refOri == null || refDes == null) {
			System.out.println("Vertice origen y/o desino no existen ...");
			return;
		}
		if(refOri.listAdj.search(new Edge<T>(refDes)) != null) {
			System.out.println("Arista ya fue insertada anteriormente...");
			return;
		}
		refOri.listAdj.insert(new Edge<T>(refDes));//inserta
		refDes.listAdj.insert(new Edge<T>(refOri));
	}

	public String toString() {
		return this.listVertex.toString();

	}
	public void initLabel() {//inicializar
		Node<Vertex<T>> aux = this.listVertex.head;//vertices
		for (; aux != null ; aux=aux.next) {//mientras que sea diferente de nulo se inicializa el vertice
			aux.data.label = 0;
			Node<Edge<T>> auxE = aux.data.listAdj.head;//las aristas de ese vertice ,recorrer
			for (; auxE != null ; auxE=auxE.next) {
				auxE.data.label = 0;
			}
		}
	}
	//------------------------------------------DFS
	public void DFS(T data) {
		Vertex<T> nuevo = new Vertex<T>(data);
		Vertex<T> aux = this.listVertex.search(nuevo);//vertice
		if(aux == null) {
			System.out.println("Vertice no existe ...");
			return;
		}
		initLabel();
		DFSRec(aux);
	}

	private void DFSRec(Vertex<T> v) {
		v.label = 1;
		System.out.println(v.data+"-"+v.label+", ");
		Node<Edge<T>> e = v.listAdj.head;
		for (; e != null; e=e.next) {
			if(e.data.label == 0) {
				Vertex<T> w =e.data.refDest;
				if (w.label ==0) {
					e.data.label = 1;
					DFSRec(w);
				}else
					e.data.label = 2;
			}
		}

	}
	//-------------------------------------------BFS
	public void BFS(T data) {
		Vertex<T> nuevo = new Vertex<T>(data);
		Vertex<T> aux = this.listVertex.search(nuevo);//vertice
		if(aux == null) {
			System.out.println("Vertice no existe ...");
			return;
		}
		initLabel();
		BFSRec(aux);
	}

	private void BFSRec(Vertex<T> v) {
		//		System.out.println(v);
		//		Node<Edge<T>> e = v.listAdj.head;
		//		boolean explored [] =new boolean [length()];
		//		explored[pos(v.data)] = true;
		//		ArrayList<T> vertexes = new ArrayList<T>();
		//		vertexes.add(v.data);
		//		//Vertex<T> aux = new Vertex<T>(null);
		//		
		//		
		//		Vertex<T> nuevo = new Vertex<T>(null);
		//		Vertex<T> aux = new Vertex<T>(null);//vertice
		//		for (; e != null; e=e.next) {
		//			System.out.println(e.data);
		//			vertexes.add((T) e.data);
		//			nuevo.data= (T) e.data;
		//			aux = this.listVertex.search(nuevo);
		//			explored[pos(aux.data)] = true;
		//			System.out.println("x---"+e.data);
		//		}

		v.label = 1;
		
		Node<Edge<T>> e = v.listAdj.head;
		//while(e.next != null) {
	//	if(v.label ==1)
//System.out.println(v.data+", "+v.label);
			for (; e != null; e=e.next) {
			System.out.println(e+"_"+ e.data.label +" data");
			//while(e.data.refDest != null)
			BFS( v.data);
			if(e.data.label == 0) {
				Vertex<T> w =e.data.refDest;
				if (w.label ==0) {
					
					e.data.label = 1;
					
					w.label = 1;
					System.out.println(e.next.data);
					
					//System.out.println(e.data.refDest + "ref");
					//BFSRec(e.next.data.refDest);
					
					
				}else {
					e.data.label = 2;
					
				}
				
			}
			//}
			e = e.next;
			
			
			
		}
	}
	public int length() {
		int vertex = 0;
		Node<Vertex<T>> aux = this.listVertex.head;//vertices
		for (; aux != null ; aux=aux.next) {
			vertex++;
		}
		return vertex;
	}
	//prerequisito , que exista
	public int pos(T data) {
		System.out.println("pos---");
		System.out.println(data);
		System.out.println("pos---x");
		Vertex<T> nuevo = new Vertex<T>(data);
		int pos = this.listVertex.get(nuevo);//vertice
		return pos;
	}
}
