package src.campus02.bubblesort;


public class BubbleSort implements AutoSort {

	/**
	 * Sortier-Funktion
	 */
	public void sort(Auto[] personen) {
		boolean swapped;

		for (int i = 0; i < personen.length-1; i++) {
			swapped = false;
			for (int j = 0; j < personen.length-1-i; j++) {
				if(personen[j].compareTo(personen[j+1])>0){
					Auto person = personen[j];
					personen[j] = personen[j+1];
					personen[j+1] = person;
					swapped = true;
				}

			}
			if(!swapped){
				break;
			}
		}
	}
	
}
