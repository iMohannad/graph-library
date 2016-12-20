package Util;

import Generate.Edge;
import Generate.Vertix;
import Graphs.DirectedGraph;
import Graphs.Graph;

public class TopologicalOrderIterator<V extends Comparable> {
	
	private LinkedList<Vertix<V>> vertices;
	private LinkedList<Edge<V>> edges;
	private DirectedGraph<V> g;
	
	public TopologicalOrderIterator(Graph<V> graph){
		if (!(graph instanceof DirectedGraph))
			throw new IllegalAccessError("The graph is not of type Simple Directed Graph");
		g = new DirectedGraph<V>((DirectedGraph)graph);
		vertices = g.getVertices();
		edges = g.getEdges();
	}
	
	public int topologicalOrderTraversal(){
		int numVisitedVertices = 0;
		int numOfVertices = vertices.getLength();
		while(numVisitedVertices <= numOfVertices){
			Vertix<V> temp = null;
			
			for(int i=0; i<vertices.getLength(); i++){
				if(vertices.get(i).getInDegree() != 0)
					continue;
				else
					temp = vertices.get(i);
				break;
				
			}
			if(temp == null) break;
			visit(temp);
			numVisitedVertices++;
			
			g.removeVertix(temp);

		}
		return numVisitedVertices;
	}
	
	public void visit(Vertix<V> ver){
		System.out.println(ver);
	}
	
}
