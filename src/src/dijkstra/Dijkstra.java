package src.dijkstra;

import java.util.ArrayList;
import java.util.List;

public class Dijkstra {

	public static List<Integer> dijkstra(Graph g, int von, int nach) {


		int anzahlKnoten = g.numVertices();
		int[] distanz = new int[anzahlKnoten];
		int[] vorgaenger = new int[anzahlKnoten];


		// Initialisierung
		for (int i = 0; i < anzahlKnoten; i++) {
			distanz[i] = Integer.MAX_VALUE;
			vorgaenger[i] = -1;

		}

		distanz[von] = 0;

		VertexHeap heap = new VertexHeap(anzahlKnoten);

			heap.insert(new WeightedEdge(von, distanz[0]));


		while (!heap.isEmpty()) {
			WeightedEdge aktuell = heap.remove();

			List<WeightedEdge> nachbarn = g.getEdges(aktuell.vertex);

			for (WeightedEdge nachbar : nachbarn) {
				int newCost = distanz[aktuell.vertex] + nachbar.weight;


				if (newCost < distanz[nachbar.vertex]) {
					distanz[nachbar.vertex] = newCost;
					vorgaenger[nachbar.vertex] = aktuell.vertex;
					heap.insert(new WeightedEdge(nachbar.vertex, newCost));
				}
			}
		}

		return predToWay(vorgaenger, von, nach);
	}

	private static ArrayList<Integer> predToWay(int[] pred, int from, int to) {
		ArrayList<Integer> way = new ArrayList<>();
		int current = to;

		while (current != from) {
			way.add(0, current);
			current = pred[current];
		}
		way.add(0, from);

		return way;
	}

	

}
