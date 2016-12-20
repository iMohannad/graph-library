package Test;
import Util.DepthFirstIterator;
import Graphs.UndirectedGraph;


public class TestDepthFirst {
	public static void main(String[] args) {
		UndirectedGraph<Character> g = new UndirectedGraph<>();
		g.addVertix('A');
		g.addVertix('B');
		g.addVertix('C');
		g.addVertix('D');
		g.addVertix('E');
		g.addVertix('F');
		g.addVertix('G');
		g.addVertix('H');
		g.addVertix('I');
		
		g.addEdge('A', 'B');
		g.addEdge('A', 'E');
		g.addEdge('A', 'D');
		g.addEdge('B','C');
		g.addEdge('B', 'E');
		g.addEdge('C', 'F');
		g.addEdge('D', 'G');
		g.addEdge('E', 'G');
		g.addEdge('G', 'H');
		g.addEdge('H', 'I');
		
		System.out.println("Graph Created > ");
		System.out.println(g);
		System.out.println("Graph Adjacencylist representation > ");
		g.printAdjList();
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~");
		DepthFirstIterator dpf = new DepthFirstIterator<>(g, 'A');
		System.out.println("PreOrder Traversal");
		dpf.preorder();
		System.out.println("PostOrder Traversal");
		
		dpf.postorder();
	}
}
