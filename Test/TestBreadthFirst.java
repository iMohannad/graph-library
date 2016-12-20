package Test;
import Util.BreadthFirstIterator;
import Generate.Vertix;
import Graphs.DirectedGraph;
import Graphs.UndirectedGraph;
import Graphs.UndirectedWeightedGraph;



public class TestBreadthFirst {
	public static void main(String[] args) {
		UndirectedWeightedGraph<Character> g = new UndirectedWeightedGraph<Character>();
		
		Character[] i = new Character[9];
		
		i[0] = 'A';	i[1] = 'B';	i[2] = 'C';	i[3] = 'D';	i[4] = 'E';
		i[5] = 'F';	i[6] = 'G';	i[7] = 'H';	i[8] = 'I';
		
		for(int j=0; j<9; j++) g.addVertix(i[j]);
		
		g.addEdge(i[0], i[1]);	g.addEdge(i[0], i[4]);
		g.addEdge(i[0], i[3]);	g.addEdge(i[1],i[2]);
		g.addEdge(i[1], i[4]);	g.addEdge(i[2], i[5]);
		g.addEdge(i[3], i[6]);	g.addEdge(i[4], i[6]);
		g.addEdge(i[6], i[7]);	g.addEdge(i[7], i[8]);
		
		System.out.println("Graph Created > ");
		System.out.println(g);
		System.out.println("Graph Adjacencylist representation > ");
		g.printAdjList();
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~");
		
		System.out.println("\nBreadthFirstIterator\n");

		BreadthFirstIterator bfsi = new BreadthFirstIterator(g, i[0]);
		bfsi.breadthFirst();
		
	}
	
}
