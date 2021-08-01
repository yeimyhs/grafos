package grafos;

public class Node <T> {
	
		protected T data;
		protected Node<T> next;

		public Node(T data) {
			this (data, null);
		}
		public Node(T data, Node<T>next) {
			this.data = data;
			this.next = next;
		}
		public String toString() {
			return data.toString();
		}

}
