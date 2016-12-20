package Test;

import Graphs.DirectedGraph;

public class DirectedGraphTest {
	public static void main(String[] args) {
		DirectedGraph<Character> g = new DirectedGraph<Character>();
		g.addVertix('A');
		g.addVertix('B');
		g.addVertix('C');
		g.addVertix('D');

		g.addEdge('A', 'B');
		g.addEdge('A', 'D');
		g.addEdge('B', 'D');
		g.addEdge('A', 'C');
		g.addEdge('C', 'D');		
		
		System.out.println("Graph Created >> ");
		System.out.println(g);
		System.out.println("Graph Adjacencylist representation > ");
		g.printAdjList();
		System.out.println("~~~~~~~~~~~~~~");
		
		
		g.removeEdge('A', 'D');
		System.out.println("Graph After removeEdge('A','D') >> ");
		System.out.println(g);
		System.out.println("Graph Adjacencylist representation > ");
		g.printAdjList();
		System.out.println("~~~~~~~~~~~~~~");
		
		g.removeVertix('D');
		System.out.println("Graph After removeVertix('D') >> ");
		System.out.println(g);
		System.out.println("Graph Adjacencylist representation > ");
		g.printAdjList();
		System.out.println("~~~~~~~~~~~~~~");
		
		
	}
}
