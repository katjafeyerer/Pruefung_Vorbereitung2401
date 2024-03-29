package src.A10_DijkstraPQShortestPath;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DijkstraPQShortestPath extends FindWay {
	private int[] dist;

	public DijkstraPQShortestPath(Graph graph) {
		super(graph);
	}

	/**
	 * Startentfernung initialisieren
	 * 
	 * @param //from
	 *            Startknoten
	 */
	protected void initPathSearch() {
		int numv = graph.numVertices();
		dist = new int[numv];
		for (int i = 0; i < numv; i++) {
			dist[i] = 9999; // Summen im Graph d�rfen nie mehr ergeben
			pred[i] = -1;
		}
	}

	/**
	 * Berechnet *alle* k�rzesten Wege ausgehend vom Startknoten Setzt dist[]-
	 * und pred[]-Arrays, kein R�ckgabewert
	 * 
	 * @param from
	 *            Startknoten
	 */
	protected boolean calculatePath(int from, int to) {

		// TODO: IHRE IMPLEMENTIERUNG

		dist[from] = 0;

		VertexHeap heap = new VertexHeap(graph.numVertices());
		for (int i = 0; i < graph.numVertices(); i++) {
			heap.insert(new Vertex(i, dist[i]));
		}
		while(!heap.isEmpty()){
			int vertex = heap.remove().vertex;
			List<WeightedEdge> edges = graph.getEdges(vertex);
			for (WeightedEdge we:edges) {
				int newCost = we.weight+dist[vertex];
				int to_vertex = we.to_vertex;

				if(newCost < dist[to_vertex]){
					dist[to_vertex] = newCost;
					heap.setCost(to_vertex, newCost);
					pred[to_vertex] = vertex;
				}
			}
		}
		return (dist[to] != Integer.MAX_VALUE);
	}
}
