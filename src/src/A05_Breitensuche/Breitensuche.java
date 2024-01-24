package src.A05_Breitensuche;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Breitensuche extends BaseTree<Integer> {

	@Override
	protected int compare(Integer a, Integer b) {
		return a.compareTo(b);
	}

	/**
	 * Liefert Knoten des Baums ausgehend von Start in Reihenfolge der Breitensuche zurück
	 * @param start Startknoten für Teilbaum
	 * @return Liste der Knoten in Breitenfolge
	 */
	public List<Integer> getBreadthFirstOrder(Node<Integer> start) {

		List<Integer> result = new ArrayList<>();
		Queue<Node<Integer>> queue = new LinkedList<>();

		queue.offer(start);

		while(!queue.isEmpty()){
			Node<Integer> poll = queue.poll();
			result.add(poll.getValue());

			if(poll.getLeft() != null){
				queue.offer(poll.getLeft());
			}
			if(poll.getRight() != null){
				queue.offer(poll.getRight());
			}
		}

		return result;
	}

	/**
	 * Liefert Knoten des Baums ausgehend von Start in Reihenfolge der Breitensuche zurück,
	 * allerdings nur jene Knoten, die in der angegebenen Ebene liegen (Start hat Ebene=1)
	 * @param start Startknoten für Teilbaum
	 * @param level Nur Knoten dieser Ebene ausgeben
	 * @return Liste aller Knoten
	 */
	public List<Integer> getBreadthFirstOrderForLevel(Node<Integer> start, int level) {

		List<Integer> result = new ArrayList<>();

		Queue<NodeWithLevel> queue = new LinkedList<>();


		queue.offer(new NodeWithLevel(start, 1));

		while(!queue.isEmpty()){
			NodeWithLevel poll = queue.poll();

			if(poll.getLevel() == level){
				result.add(poll.start.getValue());
			}
			if(poll.getStart().getLeft() != null){
				queue.offer(new NodeWithLevel(poll.start.getLeft(), poll.getLevel()+1));
			}
			if(poll.getStart().getRight() != null){
				queue.offer(new NodeWithLevel(poll.start.getRight(), poll.getLevel()+1));
			}
		}


		return result;
	}
	private class NodeWithLevel{
		private Node<Integer> start;
		private int level;

		public NodeWithLevel(Node<Integer> start, int level) {
			this.start = start;
			this.level = level;
		}

		public Node<Integer> getStart() {
			return start;
		}

		public void setStart(Node<Integer> start) {
			this.start = start;
		}

		public int getLevel() {
			return level;
		}

		public void setLevel(int level) {
			this.level = level;
		}
	}

}
