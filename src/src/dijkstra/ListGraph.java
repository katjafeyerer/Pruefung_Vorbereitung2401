package src.dijkstra;
import java.util.ArrayList;
import java.util.List;


public class ListGraph implements Graph {

	private ArrayList<WeightedEdge>[] graph;
	private int numVertices;
	private boolean directed;
	private int[] costs;
	
	
	@SuppressWarnings("unchecked")
	public ListGraph(int numVertices, boolean directed) {
		graph = new ArrayList[numVertices];
		costs = new int[numVertices];
		
		for (int i=0; i < numVertices; i++) {
			graph[i] = new ArrayList<WeightedEdge>();
			costs[i] = 0;
		}
		
		this.numVertices = numVertices;
		this.directed = directed;
		
	}
	
	public int numVertices() {
		return numVertices;
	}

	public boolean hasEdge(int u, int v) {
		WeightedEdge pv = findEdge(u, v);
		return pv != null;
	}

	public int getEdgeWeight(int u, int v) {
		WeightedEdge pv = findEdge(u, v);
		return pv.weight;
	}

	public void addEdge(int u, int v) {
		addEdge(u, v, 1);
	}
	
	public void addEdge(int u, int v, int weight) {
		WeightedEdge pv = new WeightedEdge(v, weight);
		graph[u].add(pv);
		if (!directed) {
			pv = new WeightedEdge(u, weight);
			graph[v].add(pv);
		}
	}
	
	private WeightedEdge findEdge(int u, int v) {
		for (int i=0; i < graph[u].size(); i++) {
			if (graph[u].get(i).vertex == v)
				return graph[u].get(i);
		}
		return null;
	}

	public void removeEdge(int u, int v) {
		WeightedEdge pv = findEdge(u, v);
		graph[u].remove(pv);
		if (!directed) {
			pv = findEdge(v, u);
			graph[u].remove(pv);
		}
	}

	public List<WeightedEdge> getEdges(int v) {
		return graph[v];
	}

	
	public void setCosts(int cost, int v) {
		costs[v] = cost;
	}

	@Override
	public int getCosts(int v) {
		return costs[v];
	}
}
