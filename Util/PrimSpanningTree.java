package Util;

import Generate.Edge;
import Generate.Vertix;
import Generate.WeightedEdge;
import Graphs.UndirectedWeightedGraph;

public class PrimSpanningTree<V extends Comparable> {
	
	private UndirectedWeightedGraph<V> g;
	private LinkedList<WeightedEdge<V>> edgeSet;
	private LinkedList<Vertix<V>> vertices;
	private LinkedList<Edge<V>> edges;
	private Vertix<V> start;
	private UndirectedWeightedGraph tree;

	public PrimSpanningTree(UndirectedWeightedGraph<V> graph, V ver){
		if(! graph.getVertices().isExist(new Vertix(ver))){
			throw new IllegalArgumentException("The vertix you want to start from is not exist");
		}
		g = new UndirectedWeightedGraph(graph);
		vertices = g.getVertices();
		edges = g.getEdges();
		start = vertices.find(new Vertix(ver));
		tree = new UndirectedWeightedGraph<>();
		edgeSet = new LinkedList<>();
	}
	
	public PrimSpanningTree(UndirectedWeightedGraph<V> graph){
		if( graph == null){
			throw new NullPointerException("The graph is null");
		}
		g = new UndirectedWeightedGraph(graph);
		vertices = g.getVertices();
		edges = g.getEdges();
		start = vertices.get(0);
		//tree = new UndirectedWeightedGraph<>();
		edgeSet = new LinkedList<>();
	}
	
	public void PrimsAlgorithm(){
		tree = new UndirectedWeightedGraph<>();
		for(int i=0;i<vertices.getLength(); i++){
			vertices.get(i).setVisited(false);
			vertices.get(i).setPredecessor(null);
		}
		LinkedList<Edge<V>> adjNodes = start.getAdjNodes();
		PriorityQueue<WeightedEdge<V>> queue = new PriorityQueue<>();
		for(int i=0; i<adjNodes.getLength();i++){
			WeightedEdge edge = (WeightedEdge) adjNodes.get(i);
			queue.enqueue(edge, edge.getWeight());
		}
		tree.addVertix(start);
		start.setVisited(true);
		
		while(tree.getVertices().getLength() < vertices.getLength()){
		
			WeightedEdge edge;
			do{
				edge = queue.dequeue();
				if(edge == null)
					break;
				
			}while(edge.getTarget().isVisited());
			
			if(edge == null)
				break;
			
			Vertix<V> target = edge.getTarget();
			
			
			tree.addVertix(target);
			tree.addEdge(edge);
			target.setVisited(true);
			target.setPredecessor(edge.getSource());
				
			start = target;
			edgeSet.add(edge);
			
			adjNodes = start.getAdjNodes();
			for(int i=0; i<adjNodes.getLength();i++){
				WeightedEdge edgeAdj = (WeightedEdge) adjNodes.get(i);
				queue.enqueue(edgeAdj, edgeAdj.getWeight());
			}
			
		
		}
	}
		
	public LinkedList<WeightedEdge<V>> getEdgeSet(){
		return edgeSet;
	}
	
	public double getSpanningTreeCost(){
		if(edgeSet.isEmpty())
			return 0;
		double cost = 0;
		for(int i=0; i<edgeSet.getLength();i++){
			System.out.println("edge : " + edgeSet.get(i) + ", Weight = " + edgeSet.get(i).getWeight());
			cost += edgeSet.get(i).getWeight();
		}
		return cost;
	}
	

	
	public void CycleDetection(){
		for(int i=0;i<g.getVertices().getLength();i++){
			Vertix<V> temp = (Vertix<V>) g.getVertices().get(i);
			temp.setVisited(false);
			temp.setPredecessor(null);
			temp.setColor(0);
		}
		boolean flag = false;
		for(int i=0;i<vertices.getLength();i++){
			System.out.println("Vertix (" + i + "): " + vertices.get(i));
			if(vertices.get(i).getColor() == 0) //white
				if(CycleDetection(vertices.get(i))){ //if it detect cycle it breaks the loop
					System.out.println("Cycle Detected");
					flag = true;
					break;
				}
		}
		System.out.println("No Cycle");
	}
	
	private boolean CycleDetection(Vertix<V> ver){
		ver.setColor(1);
		boolean flag = false;
		LinkedList<Edge<V>> adjNodes = ver.getAdjNodes();
		//System.out.println("adjNodes of vertix " + ver + " : " + adjNodes);
		if(adjNodes == null) return false;
		for(int i =0; i<adjNodes.getLength();i++){
			WeightedEdge<V> edge = (WeightedEdge) adjNodes.get(i); 
			//System.out.println("Edge = " + edge + ", Color: " + edge.getTarget().getColor());
			if(edge.getTarget().getColor() == 0){
				edge.getTarget().setPredecessor(edge.getSource());
				if(CycleDetection(edge.getTarget())){
					flag = true;
					break;
				}
			}
			else if((edge.getTarget().getColor() == -1) && edge.getTarget().getPredecessor() != null){
				System.out.println("Detection Cycle ... Vertix : " + edge.getTarget() + " Predecessor = " + edge.getTarget().getPredecessor());
				if(!edge.getTarget().equals(edge.getSource())){
					flag = true;
					System.out.println("Flag " + flag);
					break;
					//return true; //Cycle Detected	
				}
			}

		}
		if(flag)	return flag;
		ver.setColor(-1);
		return flag;
		
	}
	
	
}
