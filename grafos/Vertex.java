package grafos;

public class Vertex<E> {//vertice
	protected E data; //data generica
	protected ListaAdyacencia<Edge<E>> listAdj;//creacion lista de aristas
	protected int label ; // estados:0 no explorado , 1 = visitado
	
	public Vertex(E data) {//constructor del vertice 
		this.data = data;
		listAdj = new ListaAdyacencia<Edge<E>>();//inicializando su lista de aristas
	}
	
	public boolean equals (Object o) {//sobreescribiendo el metodo equals
		if(o instanceof Vertex<?>) {
			Vertex<E> v = (Vertex<E>)o;
			return this.data.equals(v.data);
		}
		return false;
	}
	
	@Override
	public String toString() {//sobreescribiendo el metodo toString
		return this.data+ " ---> " + this.listAdj.toString()+"\n";
	}
	
	

}
