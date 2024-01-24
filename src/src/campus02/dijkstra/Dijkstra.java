package src.campus02.dijkstra;

import java.util.ArrayList;
import java.util.List;

public class Dijkstra {

	public static List<Integer> dijkstra(Graph g, int von, int nach) {

		int[] pred = new int[g.numVertices()];
		int[] dist = new int[g.numVertices()];

		for (int i = 0; i < g.numVertices(); i++) {
			pred[i] = -1;
			dist[i] = Integer.MAX_VALUE;
		}
		VertexHeap heap = new VertexHeap(g.numVertices());
		dist[von] = 0;
		for (int i = 0; i < g.numVertices(); i++) {
			heap.insert(new Vertex(i, dist[i]));
		}

		while(!heap.isEmpty()){
			int vertex = heap.remove().vertex;
			List<WeightedEdge> edges = g.getEdges(vertex);
			for (WeightedEdge we: edges){
				int newCost = we.weight + dist[vertex];
				int to_vertex = we.to_vertex;

				if(newCost < dist[to_vertex]){
					dist[to_vertex] = newCost;
					heap.setCost(to_vertex, newCost);
					pred[to_vertex] = vertex;
				}
			}


		}

		return predToWay(pred, von, nach); // <-- Liefern Sie hier ihr Ergebnis retour
		
	}
	
	private static ArrayList<Integer> predToWay(int[] pred, int from, int to) {
		
		ArrayList<Integer> way = new ArrayList<Integer>();

		int i = to;
		while(i != from){
			way.add(0,i);
			i = pred[i];
		}
		way.add(0,from);
		
		// TODO: Implementierung dar ausgabe
		
		return way;
	}
	
	

}
