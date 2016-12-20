package Test;

import Graphs.UndirectedGraph;

public class UndirectedGraphTest {
	public static void main(String[] args) {
		UndirectedGraph<Integer> g = new UndirectedGraph<>();
		
		g.addVertix(1);
		g.addVertix(2);
		g.addVertix(3);
		g.addVertix(4);
		
		
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		g.addEdge(1, 3);
		g.addEdge(3, 4);
		
		System.out.println("Graph Created >> ");
		System.out.println(g);
		System.out.println("Graph Adjacencylist representation > ");
		g.printAdjList();
		System.out.println("~~~~~~~~~~~~~~");
			
		g.removeEdge(4,2);
		System.out.println("Graph After removeEdge(4,2) >> ");
		System.out.println(g);
		System.out.println("Graph Adjacencylist representation > ");
		g.printAdjList();
		System.out.println("~~~~~~~~~~~~~~");
		
		
		g.removeVertix(3);
		System.out.println("Graph After removeVertix(3) >> ");
		System.out.println(g);
		System.out.println("Graph Adjacencylist representation > ");
		g.printAdjList();
		System.out.println("~~~~~~~~~~~~~~");
		
	}
}
