package Graphs;

import Graphs.Graph;

public class DirectedGraph<V extends Comparable> extends Graph<V>{
	
	public DirectedGraph(){
		super();
	}
	
	public DirectedGraph(V[] array){
		super(array);
	}
	
	public DirectedGraph(DirectedGraph g){
		super(g);
	}


}
