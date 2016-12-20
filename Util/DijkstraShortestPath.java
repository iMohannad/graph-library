package Util;

import Generate.Edge;
import Generate.Vertix;
import Generate.WeightedEdge;
import Graphs.WeightedDirectedGraph;

public class DijkstraShortestPath<V extends Comparable> {
	
	private LinkedList<Vertix<V>> vertices;
	private LinkedList<WeightedEdge<V>> edges;
	private WeightedDirectedGraph g;
	private Vertix start;
	private double minPathLength;
	private LinkedList<WeightedEdge<V>> list;
	
	public DijkstraShortestPath(WeightedDirectedGraph<V> graph){

		g = new WeightedDirectedGraph(graph);
		vertices = g.getVertices();
		edges = g.getEdges();
		start = null;
	}
	
	public DijkstraShortestPath(WeightedDirectedGraph<V> graph, V from, V to){
		if(! graph.getVertices().isExist(new Vertix(from)) || !graph.getVertices().isExist(new Vertix(to))){
			throw new IllegalArgumentException("The vertix you want to start from is not exist");
		}
		g = new WeightedDirectedGraph<>(graph);
		vertices = g.getVertices();
		edges = g.getEdges();
		start = vertices.find(new Vertix(from));
		findPathBetween(from, to);
	}
	
	public void setStart(V start){
		if(start != null || !vertices.isExist(new Vertix(start)))
			throw new IllegalArgumentException("Start vertex is null or doesn't exist in the graph");
		
		this.start = vertices.find(new Vertix(start));
	}
	
	public DijkstraShortestPath(WeightedDirectedGraph<V> graph, V ver){
		if(! graph.getVertices().isExist(new Vertix(ver))){
			throw new IllegalArgumentException("The vertix you want to start from is not exist");
		}
		g = new WeightedDirectedGraph(graph);
		vertices = g.getVertices();
		edges = g.getEdges();
		start = vertices.find(new Vertix(ver));
	}
	
	public void DijkstraAlgorithm(){
		if(start == null)	throw new NullPointerException("You didn't specify the start index");
		
		
		//Set all the vertices current distance to MAX
		for(int i=0; i<g.getVertices().getLength();i++){
			Vertix<V> temp = vertices.get(i);
			temp.setCurrDistance(Integer.MAX_VALUE);
		}
		start.setCurrDistance(0);
		//BinaryHeap toBeChecked = new BinaryHeap(vertex);
		PriorityQueue<Vertix<V>> toBeChecked = new PriorityQueue<>();
		//Enqueue all the vertices depending on the currentDistance
		for(int i=0; i<vertices.getLength(); i++){
			Vertix<V> ver = vertices.get(i);
			toBeChecked.enqueue(ver, ver.getCurrDistance());
		}
		while(! toBeChecked.isEmpty()){
			Vertix<V> ver = toBeChecked.dequeue();
			LinkedList<Edge<V>> adjNodes = ver.getAdjNodes();
			if(adjNodes == null) continue;
			for(int i=0; i<adjNodes.getLength(); i++){
				WeightedEdge<V> edge = (WeightedEdge) adjNodes.get(i);
				Vertix<V> adjacent = edge.getTarget();
				if(toBeChecked.isExist(adjacent)){
					if(adjacent.getCurrDistance() > ver.getCurrDistance() + edge.getWeight()){
						adjacent.setCurrDistance(ver.getCurrDistance() + edge.getWeight());
						adjacent.setPredecessor(ver);
					}
				
				}else{
					if(adjacent.getCurrDistance() > ver.getCurrDistance() + edge.getWeight()){
						adjacent.setCurrDistance(ver.getCurrDistance() + edge.getWeight());
						adjacent.setPredecessor(ver);
					}
				}
			}
		}
		
	}
	/*
	 * This method takes two vertices and find the path between them
	 * Then it returns the path as a LinkedList
	 */
	public LinkedList<WeightedEdge<V>> findPathBetween(V from, V to){
		if(from == null || to == null)
			throw new NullPointerException();

		if(!(vertices.isExist(new Vertix(from))) || !(vertices.isExist(new Vertix(to))))
				throw new IllegalArgumentException("Vertices are not in the graph");
		
		Vertix<V> source = vertices.find(new Vertix(from));
		Vertix<V> target = vertices.find(new Vertix<>(to));
		minPathLength = 0;
		//Assign the source to start instance variable
		start = source;
		//run the algorithm on the new start
		DijkstraAlgorithm();
		
		
		Vertix<V> temp = target;
		list = new LinkedList();
		//This loop goes over all the predecessor of the target until it reaches the source
		// and it keeps adding the edge between the target and it's predecessor to the LinkedList
		while(temp != source){
			temp = target.getPredecessor();
			if(temp == null)
				if(target != source){
					System.out.println("There's no path between " + source + " and " + target);
					minPathLength = Integer.MAX_VALUE; //minPathLength is assigned to MAX INTEGER if there's no path
					return null;
				}
				else break;
			//Creating the edge
			WeightedEdge<V> edge = (WeightedEdge) edges.find(new WeightedEdge(temp,target));
			list.add2head(edge);
			minPathLength += edge.getWeight();	//update the pathLength
			//updating the targets
			target = temp;
		}
		
		
		return list;
		
	}
	
	public double getMinPathLength(){
		return minPathLength;
	}
	
	public LinkedList<WeightedEdge<V>> getList() {
		return list;
	}


	public void printTable(){
		for(int i=0; i<vertices.getLength();i++){
			Vertix<V> temp = vertices.get(i);
			System.out.println("Vertix ("+temp+"): CurrentDistance =  " + temp.getCurrDistance() +
					". Predecessor : " + temp.getPredecessor());
			System.out.println();
		}
		
	}
	
	
	
	
}
