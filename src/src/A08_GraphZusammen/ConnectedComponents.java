package src.A08_GraphZusammen;

import A10_DijkstraPQShortestPath.WeightedEdge;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ConnectedComponents {
	
	/**
	 * Retourniert die Anzahl der zusammenh�ngenden Komponenten eines Graphen
	 * @param g zu pr�fender Graph
	 * @return Anzahl der Komponenten
	 */
	public int getNumberOfComponents(Graph g) {
		// Liste zur Verfolgung besuchter Knoten
		List<Integer> visitedNodes = new ArrayList<>();

		// Anzahl der gefundenen Komponenten
		int components = 0;

		// Stack für iterative Tiefensuche
		Stack<Integer> stack = new Stack<>();

		// Iteriere über alle Knoten des Graphen
		for (int startVertex = 0; startVertex < g.numVertices(); startVertex++) {
			// Wenn der Knoten noch nicht besucht wurde
			if (!visitedNodes.contains(startVertex)) {
				// Erhöhe die Anzahl der Komponenten und starte Tiefensuche
				components++;

				// Lege den Startknoten auf den Stack
				stack.push(startVertex);

				// Iterative Tiefensuche
				while (!stack.isEmpty()) {
					// Pop den aktuellen Knoten vom Stack
					int currentVertex = stack.pop();

					// Wenn der Knoten noch nicht besucht wurde
					if (!visitedNodes.contains(currentVertex)) {
						// Markiere den aktuellen Knoten als besucht
						visitedNodes.add(currentVertex);

						// Iteriere über alle Nachbarn des aktuellen Knotens
						for (WeightedEdge edge : g.getEdges(currentVertex)) {
							int toVertex = edge.to_vertex;

							// Wenn der Nachbar noch nicht besucht wurde, füge ihn dem Stack hinzu
							if (!visitedNodes.contains(toVertex)) {
								stack.push(toVertex);
							}
						}
					}
				}
			}
		}

		// Gib die Anzahl der gefundenen Komponenten zurück
		return components;
	}

}
