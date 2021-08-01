package grafos;

public class Edge<E> {//arista
	protected Vertex<E> refDest; //vertice del grafo
	protected int weight;//el peso en caso de ser grafo ponderado
	protected int label; //0 = no explorado , 1 = visitado, 2 = back
	
	public Edge(Vertex<E> refDest) {//contructor
		this(refDest, -1);//-1 en caso de no ser ponderado
	}

	public Edge (Vertex<E> refDest, int weight) {// constructor con peso de la arista
		this.refDest = refDest;//destino
		this.weight = weight;//peso
	}

	public boolean equals(Object o) {//sobreescribiendo etodo equals
		if(o instanceof Edge<?>) {
			Edge<E> e =(Edge<E>)o;//casteando el objeto
			return this.refDest.equals(e.refDest);//devuelve si esigual
		}
		return false;//devuele false si no es igual
	}

	public String toString(){//sobre escribiendo metodo toString
		if(this.weight > -1) return refDest.data +" ["+ this.weight +"], ";
		else return refDest.data+ ", ";
	}
}
