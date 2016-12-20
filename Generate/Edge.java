package Generate;

import Util.LinkedList;

public class Edge<V extends Comparable> {
	
	private Vertix to, from;


	public Edge(Vertix<V> from, Vertix<V> to){
		this.to = to;
		this.from = from;
	}
	
	public Edge(Edge edge){
		Vertix<V> source = new Vertix(edge.getSource());
		Vertix<V> target = new Vertix(edge.getTarget());
		this.from = source;
		this.to = target;
	}
	
	public Vertix getSource() {
		return from;
	}

	public Vertix getTarget() {
		return to;
	}
	
	public Vertix getTo() {
		return to;
	}

	public void setTo(Vertix to) {
		this.to = to;
	}


	public String toString() {
		return "{" + from + ", " + to + "}";
	}
	
	public boolean equals(Object obj) {
		if(obj == null)
			throw new NullPointerException();
		else if(!(obj instanceof Edge))
			throw new ClassCastException();
		Edge other = (Edge) obj;
		if(from.equals(other.from))
			return to.equals(other.to);
		
		return false;
	}
	
	
}
