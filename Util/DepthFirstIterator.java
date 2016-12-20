package Util;

import Generate.Edge;
import Generate.Vertix;
import Graphs.Graph;

public class DepthFirstIterator<V extends Comparable> {
	private LinkedList<Vertix<V>> vertices;
	private LinkedList<Edge<V>> edges;
	private Vertix<V> start;
	private boolean done;
	
	public DepthFirstIterator(Graph<V> graph){
		Graph<V> g = new Graph<V>(graph);
		vertices = g.getVertices();
		edges = g.getEdges();
		start = vertices.get(0);
	}
	
	public DepthFirstIterator(Graph<V> graph, V ver ){
		if(! graph.getVertices().isExist(new Vertix(ver))){
			throw new IllegalArgumentException("The vertix you want to start from is not exist");
		}
		Graph<V> g = new Graph<V>(graph);
		vertices = g.getVertices();
		edges = g.getEdges();
		//System.out.println("vertices >> " + vertices);
		//System.out.println("edges >> " + edges);
		start = vertices.find(new Vertix(ver));
	}
	
	public void preorder(){
		preorder(start);
		
		//To set all the element to false in case the method will be invoked again
		for(int i=0; i<vertices.getLength(); i++){
			vertices.get(i).setVisited(false);
		}
	}
	
	public void preorder(Vertix<V> start){
		visit(start);
		int length;
		start.setVisited(true);
		LinkedList<Edge<V>> adjList = start.getAdjNodes();
		if(adjList == null)
			length = 0;
		else length = adjList.getLength();
		for(int i=0; i<length; i++){
			Vertix<V> ver = adjList.get(i).getTarget();
			if(!ver.isVisited()){
				preorder(ver);
			}
		}
		
	}
	
	public void postorder(){
		postorder(start);
		//To set all the element to false in case the method will be invoked again
		for(int i=0; i<vertices.getLength(); i++){
			vertices.get(i).setVisited(false);
		}
	}
	
	public void postorder(Vertix<V> start){
		start.setVisited(true);
		int length;
		LinkedList<Edge<V>> adjList = start.getAdjNodes();
		if(adjList == null)
			length = 0;
		else length = adjList.getLength();
		for(int i =0; i<length;i++){
			Vertix<V> ver = adjList.get(i).getTarget();
			if(!ver.isVisited()){
				postorder(ver);
			}
		}
		visit(start);
	}
	
	public void visit(Vertix<V> ver){
		System.out.println(ver);
	}
	
}
