package src.dijkstra;
import java.util.List;


public interface Graph {

	public int getCosts(int v);
	public int numVertices();
	public boolean hasEdge(int u, int v);
	public int getEdgeWeight(int u, int v);
	public void addEdge(int u, int v);
	public void addEdge(int u, int v, int weight);
	public void removeEdge(int u, int v);
	public List<WeightedEdge> getEdges(int v);
}
