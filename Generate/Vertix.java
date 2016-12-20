package Generate;

import Util.*;

public class Vertix <V extends Comparable> {
	V data;
	LinkedList<Edge<V>> adjNodes;
	private boolean isVisited;
	private int inDegree;
	private int outDegree;
	private double currDistance;
	private Vertix<V> predecessor;
	private int color;//0 white
					  //1 gray
					  //-1 black
	public int getColor(){
		return color;
	}
	
	public void setColor(int color){
		this.color = color;
	}
	
	public Vertix(){
		this(null, null);
		color = 0; //white
	}
	
	public Vertix(V data){
		this.data = data;
		adjNodes = null;
		isVisited = false;
	}
	//Copy Constructor
	public Vertix(Vertix<V> ver){
		this.data = ver.getData();
		this.isVisited = false;
		this.inDegree = ver.getInDegree();
		this.outDegree = ver.getOutDegree();
		this.adjNodes = new LinkedList<Edge<V>>(ver.getAdjNodes());
		/*adjNodes = new LinkedList<>();
		LinkedList<Edge<V>> list = ver.getAdjNodes();
		for(int i=0; i<list.getLength(); i++){
			Edge<V> edge = new Edge(list.get(i));
			adjNodes.add(edge);
		}*/
		
	}
	
	public Vertix(V data, LinkedList<Edge<V>> adjNodes) {
		this.data = data;
		this.adjNodes = adjNodes;
		isVisited = false;
	}
	
	public V getData() {
		return data;
	}
	public void setData(V data) {
		this.data = data;
	}
	public LinkedList<Edge<V>> getAdjNodes() {
		return adjNodes;
	}
	public void setAdjNodes(LinkedList<Edge<V>> adjNodes) {
		this.adjNodes = adjNodes;
		if(adjNodes == null)	return;
		outDegree = adjNodes.getLength();
	}
	
	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public int getInDegree() {
		return inDegree;
	}

	public void setInDegree(int inDegree) {
		
		if(inDegree < 0)
			throw new IllegalArgumentException("Indegree cannot be less than 0");
		this.inDegree = inDegree;
	}

	public int getOutDegree() {
		return outDegree;
	}

	public void setOutDegree(int outDegree) {
		this.outDegree = outDegree;
	}

	public double getCurrDistance() {
		return currDistance;
	}

	public void setCurrDistance(double currDistance) {
		this.currDistance = currDistance;
	}

	public Vertix<V> getPredecessor() {
		return predecessor;
	}

	public void setPredecessor(Vertix<V> predecessor) {
		this.predecessor = predecessor;
	}

	public boolean equals(Object obj){
		if(obj == null)
			throw new NullPointerException();
		else if(!(obj instanceof Vertix))
			throw new ClassCastException();
		Vertix ver = (Vertix) obj;
		return ver.data.equals(data);
	}
	
	public String toString(){
		return data + "";
	}
	
}
