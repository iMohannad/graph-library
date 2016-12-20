package Test;
import Util.DijkstraShortestPath;
import Graphs.WeightedDirectedGraph;


public class TestDijkstra {
	public static void main(String[] args) {
		WeightedDirectedGraph<Character> g = new WeightedDirectedGraph<>();
		g.addVertix('A');
		g.addVertix('B');
		g.addVertix('C');
		g.addVertix('D');
		g.addVertix('E');
		g.addVertix('F');
		
		g.addEdge('B', 'A', 3);
		g.addEdge('B', 'C', 5);
		g.addEdge('A', 'C', 1);
		g.addEdge('C', 'D', 2);
		g.addEdge('C', 'E', 4);
		g.addEdge('D', 'A', 5);
		g.addEdge('E', 'F', 1);
		g.addEdge('D', 'F', 5);
		
		System.out.println("Graph Created > ");
		System.out.println(g);
		System.out.println("Graph Adjacencylist representation > ");
		g.printAdjList();
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~");
		
		System.out.println("DijkstraAlgorithm() \n\nPrintTable()\n");
		DijkstraShortestPath dj = new DijkstraShortestPath(g, 'B');
		dj.DijkstraAlgorithm();
		dj.printTable();
		
		System.out.println("Shortest Path between 'A' and 'F' = " + dj.findPathBetween('A', 'F'));
		System.out.println("Length = " + dj.getMinPathLength());
		
		
	}
}
