package Test;
import Generate.Edge;
import Generate.Vertix;
import Graphs.DirectedGraph;
import Util.LinkedList;
import Util.TopologicalOrderIterator;


public class TestTopologicalSort {

	public static void main(String[] args) {
		DirectedGraph<Character> g = new DirectedGraph();
		
		g.addVertix('A');
		g.addVertix('B');
		g.addVertix('C');
		g.addVertix('D');
		g.addVertix('E');
		g.addVertix('F');
		g.addVertix('G');
		g.addVertix('H');
		g.addVertix('I');
		g.addVertix('J');
		
		g.addEdge('A', 'B');
		g.addEdge('A', 'F');
		g.addEdge('B', 'H');
		g.addEdge('D','C');
		g.addEdge('D', 'E');
		g.addEdge('D', 'H');
		g.addEdge('E', 'I');
		g.addEdge('G', 'A');
		g.addEdge('G', 'B');
		g.addEdge('G', 'C');
		g.addEdge('I', 'C');
		g.addEdge('J', 'E');
		
		System.out.println("Graph Created > ");
		System.out.println(g);
		System.out.println("Graph Adjacencylist representation > ");
		g.printAdjList();
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~");
		
		System.out.println("\nTopologicalOrderIterator\n");
		
		TopologicalOrderIterator<Character> tps = new TopologicalOrderIterator<>(g);
		tps.topologicalOrderTraversal();
	
	}
	
}
