package grafos;

public class test {
	public static void main(String[] args) {
		ListaAdyacencia<String> la = new ListaAdyacencia();
		la.insert("1");
		la.insert("2");
		la.insert("3");
		la.insert("4");
		la.insert("5");
		la.insert("6");
		System.out.println(la.counter);
		System.out.println(la.search("5"));
		System.out.println(la.toString());
		
		
	}
}
