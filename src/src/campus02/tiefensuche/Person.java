package src.campus02.tiefensuche;

public class Person {

	private final String name;
	
	private final double gewicht;

	public Person(String name, double gewicht) {
		this.name = name;
		this.gewicht = gewicht;
	}

	public String getName() {
		return name;
	}

	public double getGewicht() {
		return gewicht;
	}

	@Override
	public String toString() {
		return name + " (L�nge: " + gewicht + ")";
	}

}
