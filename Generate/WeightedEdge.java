package Generate;

public class WeightedEdge<V extends Comparable> extends Edge{
	

	private double weight;
	
	public WeightedEdge(Vertix from, Vertix to) {
		super(from, to);
		weight = 0; //Default Weight
	}
	
	public WeightedEdge(Vertix to, Vertix from, double weight){
		super(to, from);
		this.weight = weight;
	}
	
	public WeightedEdge(WeightedEdge edge){
		super(edge);
		this.setWeight(edge.getWeight());
	}
	
	public void setWeight(double weight){
		this.weight = weight;
	}
	
	public double getWeight(){
		return weight;
	}
	
}
