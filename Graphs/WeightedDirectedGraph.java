package Graphs;

import Generate.Edge;
import Generate.Vertix;
import Generate.WeightedEdge;
import Util.LinkedList;

public class WeightedDirectedGraph<V extends Comparable> extends DirectedGraph<V> {
	
	public WeightedDirectedGraph(){
		super();
	}
	
	public WeightedDirectedGraph(V [] array){
		super(array);
	}
	
	public WeightedDirectedGraph(WeightedDirectedGraph<V> graph) { 
		super(graph);
		
	}

	public boolean addEdge(V from, V to){
		return addEdge(from, to, 0);
	}
	
	public boolean addEdge(V from, V to, double weight){
		if(from == null || to == null)
			throw new NullPointerException();

		if(!(vertices.isExist(new Vertix(from))) || !(vertices.isExist(new Vertix(to))))
				throw new IllegalArgumentException("Vertices are not in the graph");
		
		
		Vertix<V> source = vertices.find(new Vertix(from));
		Vertix<V> target = vertices.find(new Vertix(to));
		super.addEdge(new WeightedEdge(source,target, weight));
		
		
		return true;
	}
	
	

}
