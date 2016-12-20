package Util;

import Generate.Edge;
import Generate.Vertix;

import Graphs.Graph;

public class BreadthFirstIterator<V extends Comparable> {
	
	private LinkedList<Vertix<V>> vertices;
	private LinkedList<Edge<V>> edges;
	private Vertix<V> start;
	
	public BreadthFirstIterator(Graph<V> g){
		Graph<V> graph = new Graph<V>(g);
		vertices = graph.getVertices();
		edges = graph.getEdges();
		start = vertices.get(0);
	}
	
	public BreadthFirstIterator(Graph<V> g, V ver ){
		if(! g.getVertices().isExist(new Vertix(ver))){
			throw new IllegalArgumentException("The vertix you want to start from is not exist");
		}
		Graph<V> graph = new Graph<V>(g);
		vertices = graph.getVertices();
		edges = graph.getEdges();
		start = vertices.find(new Vertix(ver));
	}
	
	public void breadthFirst(){
		Queue<Vertix<V>> queue = new Queue();
		queue.enqueue(start);
		start.setVisited(true);
		
		while(!queue.isEmpty()){
			Vertix<V> ver = queue.dequeue();
			visit(ver);
			LinkedList<Edge<V>> temp = ver.getAdjNodes();
			//Check if the adjList is null so we skip that iteration
			if(temp == null)
				continue;
			for(int i=0; i<temp.getLength(); i++){
				Vertix<V> next = temp.get(i).getTarget();
				if(! next.isVisited()){
					queue.enqueue(next);
					next.setVisited(true);
				}	
			}	
		}
		//To set all the element to false in case the method will be invoked again
		for(int i=0; i<vertices.getLength(); i++){
			vertices.get(i).setVisited(false);
		}
		
	}
	
	public void visit(Vertix<V> ver){
		System.out.println(ver);
	}
	
}
