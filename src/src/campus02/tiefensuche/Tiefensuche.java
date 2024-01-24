package src.campus02.tiefensuche;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Tiefensuche extends BaseTree<Person> {

	@Override
	/**
	 * Sortierkriterium im Baum: Länge des Films
	 */
	protected int compare(Person a, Person b) {

		if (a.getGewicht() < b.getGewicht())
			return -1;
		if (a.getGewicht() > b.getGewicht())
			return 1;
	
		return a.getName().compareTo(b.getName());
	}

	/**
	 * Retourniert die Personen des Knoten des Teilbaums in preorder Folge
			(engl. pre-order, d.h. Knoten-links-rechts)
	 * @param node Wurzelknoten des Teilbaums
	 * @return Liste der Titel in Präordnung
	 */
	public List<String> getNodesPreOrder(Node<Person> node) {

		List<String> result = new ArrayList<>();

		Stack<Node<Person>> stack = new Stack<>();
		Node<Person> current = node;

		while(!stack.isEmpty() || current != null){
			while(current != null){
				Node<Person> push = stack.push(current);
				current = current.getLeft();
			}
			if(!stack.isEmpty()){
				current = stack.pop();
				result.add(current.toString());
				current = current.getRight();
			}
		}

		return result;
	}
	
	/**
	 * Retourniert Personen, deren Gewicht sich zwischen min und max befinden zurück
	 * @param min - minimales Gewicht der Personen
	 * @param max - maximales Gewicht der Personen
	 * @return Liste der Personen mit dem entsprechenden Gewicht
	 */
	public List<String> getMinMax(double min, double max) {

		List<String> result = new ArrayList<>();
		Stack<Node<Person>> stack = new Stack<>();
		Node<Person> current = root;

		while(current != null || !stack.isEmpty()){
			while(current != null){

				if(current.getValue().getGewicht() >= min && current.getValue().getGewicht() <= max){

					result.add(current.getValue().toString());

				}
				if(current.getRight() != null){
					stack.push(current.getRight());
				}
				current = current.getLeft();
			}
			if(!stack.isEmpty()){
				current = stack.pop();

			}
		}




		return result;
	}

}
