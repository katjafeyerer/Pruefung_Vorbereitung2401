package src.A07_Sorting;


public class QuickSort implements PersonenSort {

	/**
	 * Sortier-Funktion
	 */
	public void sort(Person[] personen) {
		sort(personen, 0, personen.length - 1);
	}

	private void sort(Person[] personen, int left, int right) {
		// TODO: Implementation
		if(left<right){
			int partition = partition(personen, left, right);
			sort(personen, left, partition-1);
			sort(personen, partition+1, right);
		}
	}

	private int partition(Person[] personen, int left, int right) {
		// TODO: Implementation
		int lowIndex = left;
		int highIndex = right;
		Person pivot = personen[right];

		while(lowIndex < highIndex){
			while(lowIndex < highIndex && personen[lowIndex].compareTo(pivot)<=0){
				lowIndex++;
			}
			while(highIndex > lowIndex && personen[highIndex].compareTo(pivot)>=0){
				highIndex--;
			}
			swap(personen, lowIndex, highIndex);
		}
		swap(personen, lowIndex, right);


		return lowIndex;
	}

	private void swap(Person[] personen, int index1, int index2) {
		Person p1 = personen[index1];
		personen[index1] = personen[index2];
		personen[index2] = p1;
	}
}