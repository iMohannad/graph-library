package Graphs;

import Generate.Edge;
import Generate.Vertix;
import Graphs.Graph;

public class UndirectedGraph <V extends Comparable> extends Graph<V>{
	
	public UndirectedGraph(){
		super();
		setDirected(false);
	}
	
	public UndirectedGraph(UndirectedGraph g){
		super(g);
		setDirected(false);
	}
	
	public UndirectedGraph(V[] array){
		super(array);
		setDirected(false);
	}
	
	public boolean addEdge(V from, V to){
		super.addEdge(from, to);
		super.addEdge(to, from);
		return true;
	}
	
	public boolean removeEdge(V from, V to){
		super.removeEdge(from, to);
		super.removeEdge(to, from);
		return true;
	}

}
