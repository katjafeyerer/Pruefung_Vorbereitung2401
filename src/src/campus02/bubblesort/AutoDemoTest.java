package src.campus02.bubblesort;

public class AutoDemoTest {

	public static void main(String[] args) {
		
		Auto[] autos = new Auto[5];
		autos[0] = new Auto("VW", 2009, 8);
		autos[1] = new Auto("Audi", 2009, 8);
		autos[2] = new Auto("BMW", 2008, 1);
		autos[3] = new Auto("Ford", 2009, 1);
		autos[4] = new Auto("Opel", 2001,5);
		
		System.out.println("Vor Sortierung");
		for (Auto auto : autos) {
			System.out.println(auto);
		}
		System.out.println("----");
		
		AutoSort as = new BubbleSort();
		as.sort(autos);
		System.out.println("Nach Sortierung");
		for (Auto auto : autos) {
			System.out.println(auto);
		}
		System.out.println("----");		
	}

}
