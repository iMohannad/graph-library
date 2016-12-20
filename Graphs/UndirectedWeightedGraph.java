package Graphs;

import Generate.Edge;
import Generate.Vertix;
import Generate.WeightedEdge;

public class UndirectedWeightedGraph<V extends Comparable> extends UndirectedGraph<V> {
	
	public UndirectedWeightedGraph(){
		super();
		setDirected(false);
	}
	
	public UndirectedWeightedGraph(V[] array){
		super(array);
		setDirected(false);
	}
	
	public UndirectedWeightedGraph(UndirectedWeightedGraph g){
		super(g);
		setDirected(false);
	}
	
	public boolean addEdge(V from, V to){
		return this.addEdge(from,to, 0);
	}
	
	public boolean addEdge(V from, V to, double weight){
		
		if(from == null || to == null)
			throw new NullPointerException();

		if(!(vertices.isExist(new Vertix(from))) || !(vertices.isExist(new Vertix(to))))
				throw new IllegalArgumentException("Vertices are not in the graph");
		
		Vertix<V> source = vertices.find(new Vertix(from));
		Vertix<V> target = vertices.find(new Vertix(to));
		
		return this.addEdge(new WeightedEdge(source, target, weight));	
	}
	
	public boolean addEdge(Vertix<V> source, Vertix<V> target, double weight){
		super.addEdge(new WeightedEdge(source, target,weight));
		super.addEdge(new WeightedEdge(target, source, weight));
		
		return true;
	}
	
	public boolean addEdge(WeightedEdge<V> edge){
		return this.addEdge(edge.getSource(), edge.getTarget(), edge.getWeight());
		
	}
	
	public boolean removeEdge(V from, V to){
		super.removeEdge(from, to);
		super.removeEdge(to, from);
		return true;
	}
}
