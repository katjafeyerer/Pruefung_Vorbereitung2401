package src.campus02.tiefensuche;

public class DemoTiefensuche {

	public static void main(String[] args) {
		Tiefensuche ts = new Tiefensuche();
		ts.add(new Person("Max Muster", 78.5));
		ts.add(new Person("Susi Maier", 57.3));
		ts.add(new Person("John Doe", 63.5));
		ts.add(new Person("Gregor Spencer", 105.8));
		ts.add(new Person("Luka McMayer", 83.1));
		ts.add(new Person("Henrik Schüller", 69.3));
		ts.add(new Person("Bernhard Tamminger", 55.4));
		ts.add(new Person("Manuela Ulm", 63.9));
		ts.add(new Person("Max Smith", 79.1));
		ts.add(new Person("Thomas Ellimar", 101.8));
		
		System.out.println(ts.getRoot().getValue());
		
		System.out.println(ts.getNodesPreOrder(ts.getRoot()));;
		
		System.out.println(ts.getMinMax(50, 60));
		
		

	}

}
