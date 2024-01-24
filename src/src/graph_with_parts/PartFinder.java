package src.graph_with_parts;


import java.util.Stack;

public class PartFinder {
	
	public int calcPartCount(ArrayGraph g) {
		boolean[] visited = new boolean[g.numVertices()];
		int components = 0;

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < g.numVertices(); i++) {
			if (!visited[i]) {
				components++;
				stack.push(i);


				while (!stack.isEmpty()) {
					Integer currentVertex = stack.pop();

					if (!visited[currentVertex]) {
						visited[currentVertex] = true;

						for (WeightedEdge we : g.getEdges(currentVertex)) {
							int to_vertex = we.vertex;

							if (!visited[to_vertex]) {
								stack.push(to_vertex);
							}
						}
					}
				}
			}
		}

		return components;

	}
	

}
