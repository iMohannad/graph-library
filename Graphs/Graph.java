package Graphs;

import Util.*;

import Generate.Edge;
import Generate.WeightedEdge;

import Generate.Vertix;


public class Graph<V extends Comparable<?>>{
	
	LinkedList<Vertix<V>> vertices;
	LinkedList<Edge<V>> edges;
	private boolean directed;
	
	public Graph(){
		vertices = new LinkedList<>();
		edges = new LinkedList<>();
		directed = true;
	}
	
	public Graph(V [] array){
		vertices = new LinkedList();
		for(int i = 0; i<array.length; i++)
			vertices.add(new Vertix(array[i]));
		
		directed = true;
	}
	
	public Graph(LinkedList<Vertix<V>> vertices, LinkedList<Edge<V>> edges){
		this.vertices = vertices;
		this.edges = edges;
		
		directed = true;
	}
	
	public LinkedList<Vertix<V>> getVertices(){
		return vertices;
	}
	
	public LinkedList<Edge<V>> getEdges(){
		return edges;
	}
	
	public Graph(Graph other){
		LinkedList<Vertix<V>> verticesCopy = other.getVertices();
		LinkedList<Edge<V>> edgesCopy = other.getEdges();
		vertices = new LinkedList<Vertix<V>>(other.getVertices());
		edges = new LinkedList<Edge<V>>(other.getEdges());
		directed = other.getDirected();

	}
	
	
	public void setDirected(boolean directed){
		this.directed = directed;
	}
	
	public boolean getDirected(){
		return directed;
	}
	
	/*PreCondition: Vertix to be added should not be exist in the graph
	 *Exception: IllegalArgumentException if any of the vertices is not currently in the graph
	 */
	public void addVertix(V data){
		Vertix<V> ver = new Vertix(data);
		addVertix(ver);
	}
	
	public void addVertix(Vertix<V> ver){
		if(vertices.isEmpty()){
			vertices.add(ver);
			return ;
		}
			
		//Check if the vertix is already exist
		if(vertices.isExist(ver))
			throw new IllegalArgumentException("The vertix is already exist in the graph");
			
		vertices.add(ver);
	}
	
	
	/* we first find the vertix to be deleted from the vertices linkedlist
	 * 1- delete the connected edges
	 * 2- delete the vertix
	 * 3- delete the edges the contains that vertex from the eges linkedlist
	 */
	
	public Vertix<V> removeVertix(V data){
		if(data == null)
			throw new NullPointerException();
		
		if(!vertices.isExist(new Vertix(data)))
			throw new IllegalAccessError("Vertices are not in the graph");
		
		Vertix<V> ver = vertices.find(new Vertix<V>(data)); //get the reference of the vertix
		return removeVertix(ver);
	}
	
	public Vertix<V> removeVertix(Vertix<V> ver){
		if(ver == null)
			throw new NullPointerException();
		
		if(!vertices.isExist(ver))
			throw new IllegalAccessError("Vertices are not in the graph");
		
		ver.setInDegree(0);
		ver.setOutDegree(0);
		deleteConnectedEdges(ver);	//deletes all the edges where the deleted vertix is a target
		vertices.delete(ver);
		
		//Update the inDegree for the target nodes of the removed vertix
		if(getDirected()){
			if(ver.getAdjNodes() != null)
				for(int i =0; i<ver.getAdjNodes().getLength();i++){
					Edge<V> edge = ver.getAdjNodes().get(i);
					edge.getTarget().setInDegree(edge.getTarget().getInDegree() - 1);
				}
		}
		
		//Delete edges from linkedlist (edges)
		for(int i=0; i<edges.getLength(); i++){
			Edge<V> edge = edges.get(i);
			Vertix<V> source = edge.getSource();
			Vertix<V> target = edge.getTarget();
			if(source.equals(ver) || target.equals(ver)){
				edges.delete(edge);
				//target.setInDegree(target.getInDegree()-1);
				i--; //go back one index because the size now is less by 1
			}
		}
		
		return ver;
		
	}
	
	/*PreCondition: Vertices (from and to) should be existed in graph
	 *Exception: NullPointerException if any of the vertices doesn't exist
	 *			 IllegalArgumentException if any of the vertices is not currently in the graph
	 */
	public boolean addEdge(V from, V to){
		if(from == null || to == null)
			throw new NullPointerException();

		if(!(vertices.isExist(new Vertix(from))) || !(vertices.isExist(new Vertix(to))))
				throw new IllegalArgumentException("Vertices are not in the graph");
		
		Vertix<V> source = vertices.find(new Vertix(from)); //to get the reference of the vertix
		Vertix<V> target = vertices.find(new Vertix<>(to));	
		
		
		Edge<V> edge = new Edge(source, target);
		if(edges.isExist(edge))	throw new IllegalArgumentException("The edge is already added");
		
		edges.add(edge);
		if (getDirected()) {
			target.setInDegree(target.getInDegree() + 1); //to update Indegree of the target vertex
			source.setOutDegree(source.getOutDegree() + 1); //Update outDegree of the source vertix
		}
		//Updating the Adjacencylist in the source vertix
		LinkedList<Edge<V>> temp = source.getAdjNodes();
		
		//if the AdjList is already null, we create a new LinkedList and we add the edge to it.
		//then we set the new AdjList to the vertix
		if(temp == null)
			temp = new LinkedList<>();
		
		temp.add(edge);
		source.setAdjNodes(temp);
		
		return true;
	}
	
	protected boolean addEdge(WeightedEdge<V> edge){
		if(edge == null)	throw new NullPointerException("The edge is null");
		if(edges.isExist(edge))	throw new IllegalArgumentException("The edge is already added");
		edges.add(edge);
		
		if (getDirected()) {
			edge.getTarget().setInDegree(edge.getTarget().getInDegree() + 1);
			edge.getSource().setOutDegree(edge.getSource().getOutDegree() + 1);
		}
		LinkedList<Edge<V>> temp = edge.getSource().getAdjNodes();
		
		if(temp == null)
			temp = new LinkedList();
		
		temp.add(edge);
		edge.getSource().setAdjNodes(temp);
		return true;
		
	}
	
	
	/*PreCondition: Vertices (from and to) should be existed in graph
	 *Exception: NullPointerException if any of the vertices doesn't exist
	 *			 IllegalArgumentException if any of the vertices is not currently in the graph
	 */
	public boolean removeEdge(V from, V to){
		if(from == null || to == null)
			throw new NullPointerException();
		
		if(!(vertices.isExist(new Vertix(from))) || !(vertices.isExist(new Vertix(to))))
				throw new IllegalArgumentException("Vertices are not in the graph");
		
		Vertix<V> source = vertices.find(new Vertix(from));
		Vertix<V> target = vertices.find(new Vertix(to));
		Edge<V> edge = new Edge(source, target);
		
	
		edges.delete(edge);
		if (getDirected()) {
			target.setInDegree(target.getInDegree() - 1); //update the indegree of the target vertix
			source.setOutDegree(source.getOutDegree() - 1); //update the outdegree of the target vertix
		}
		//Updating the Adjacencylist in the source vertix
		LinkedList<Edge<V>> temp = source.getAdjNodes();
		
		temp.delete(edge);
		if(temp.isEmpty()){
			source.setAdjNodes(null);
			return true;
		}
		source.setAdjNodes(temp);
		
		return true;
	}
	
	protected boolean removeEdge(Edge<V> edge) {
		Vertix<V> source = edge.getSource();
		Vertix<V> target = edge.getTarget();
		return removeEdge(source.getData(), target.getData());
	}
	
	
	public LinkedList<Edge<V>> outEdges(Vertix<V> vertix){
		LinkedList<Edge<V>> out = new LinkedList();
		Vertix<V> source = vertices.find(vertix);
		LinkedList<Edge<V>> temp = source.getAdjNodes();
		if(temp == null)
			return out;
		
		for(int i=0; i<temp.getLength();i++)
			out.add(temp.get(i));
		
		return out;
	}
	
	public void printAdjList(){
		
		for(int i=0; i<vertices.getLength(); i++){
			Vertix<V> ver = vertices.get(i);
			System.out.print(ver + " >> " );
			System.out.println(ver.getAdjNodes());
		}
	}
	
	/* Go over all the edges, if the target of the edge equal to the vertix to be deleted
	 * we get the source of that edge. Then, we get the associated adjList and we delete that edge
	 */
	protected boolean deleteConnectedEdges(Vertix<V> element){
		
		if(element == null){
			System.out.println("The Object is null");
			return false;
		}
		
		for(int i=0; i<edges.getLength(); i++){
			Edge<V> edge = edges.get(i);

			Vertix<V> source = edge.getSource();
			Vertix<V> target = edge.getTarget();
			
			if(target.equals(element)){
				
				if(source.getAdjNodes() != null){
					LinkedList<Edge<V>> adjNode = source.getAdjNodes();
					adjNode.delete(edge);
					if(adjNode.isEmpty())	source.setAdjNodes(null);
					else source.setAdjNodes(adjNode);
				}
			}
			if(source.getAdjNodes() != null && directed)
				source.setOutDegree(source.getAdjNodes().getLength());
			else source.setOutDegree(0);
		}
		
		return true;
	}
	
	public String toString(){
		String str = "(" + vertices + ", ";
		if(getDirected())
			str += edges.toString() + ")";
		else{
			LinkedList<Edge<V>> edgeVisited = new LinkedList();
			for(int i=0; i<edges.getLength();i++){
				Edge<V> edge = edges.get(i);
				if(!edgeVisited.isExist(new Edge(edge.getTarget(), edge.getSource())))
						edgeVisited.add(edge);
				else
					continue;
			}
			str += edgeVisited.toString() + ")";
		}
		return str;
	}

}
