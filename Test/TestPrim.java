package Test;
import Util.PrimSpanningTree;
import Graphs.UndirectedWeightedGraph;


public class TestPrim {
	public static void main(String[] args) {
		UndirectedWeightedGraph<Character> g = new UndirectedWeightedGraph<>();
		g.addVertix('A');
		g.addVertix('B');
		g.addVertix('C');
		g.addVertix('D');
		g.addVertix('E');
		g.addVertix('F');
		g.addVertix('G');
		
		g.addEdge('A', 'B', 13);
		g.addEdge('A', 'D',1 );
		g.addEdge('A', 'C', 8);
		g.addEdge('B', 'C', 15);
		g.addEdge('D', 'E', 4);
		g.addEdge('D', 'F', 5);
		g.addEdge('C', 'E', 3);
		g.addEdge('D', 'F', 5);
		g.addEdge('E', 'F', 2);
	
		System.out.println("Graph Created > ");
		System.out.println(g);
		System.out.println("Graph Adjacencylist representation > ");
		g.printAdjList();
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("PrimsAlgorithm() \n\n");
	
		
		
		PrimSpanningTree<Character> prim = new PrimSpanningTree<Character>(g, 'A');
		prim.PrimsAlgorithm();
		System.out.println("getEdgeSet() of the MST : \n" 
				+prim.getEdgeSet() + "\n");
		System.out.println("prim.getSpanningTreeCost(): ");
		System.out.println("Cost of the MST >> " + prim.getSpanningTreeCost());
		
	}
}
