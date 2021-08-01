package grafos;

public class ListaAdyacencia<T> {

	protected Node<T> head;
	protected Node<T> last;
	protected int counter;
	
	public ListaAdyacencia() {}
	public ListaAdyacencia(Node<T> head) {
		this.head = head;
	}

	public void insert(T data) {
		Node<T> aux = new Node<T> (data); 
		if (counter == 0) {
			this.head = aux;
			this.last = head;
			counter++;
		}else {
			last.next = aux;
			this.last = last.next;
			counter ++;
		}
	}

	public T search(T data) {
		Node<T> aux = this.head;
		while(aux != null && !aux.data.equals(data)) {
			aux = aux.next;
		}
		if(aux != null) {
			return aux.data;
		} else {
			return null;
		}
	}
	
	@Override
	public String toString() {
		String str = "";
		Node <T> aux = this.head;
		while(aux != null) {
			str += aux.toString()+ " "; 
			aux = aux.next;
		}
		return str;
	}
}
