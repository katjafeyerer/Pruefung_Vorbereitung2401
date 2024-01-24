package src.A07_Sorting;


public class BubbleSort implements PersonenSort {

	/**
	 * Sortier-Funktion
	 */
	public void sort(Person[] personen) {
		boolean swapped;

		for (int i = 0; i < personen.length-1; i++) {
			
			swapped = false;

			for (int j = 0; j < personen.length-i-1; j++) {
				if(personen[j].compareTo(personen[j+1])>0){
					Person p1 = personen[j];
					personen[j] = personen[j+1];
					personen[j+1] = p1;
					swapped = true;
				}

			}
			if(!swapped){
				break;
			}

		}
	}
	
}
