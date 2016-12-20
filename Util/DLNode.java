package Util;

public class DLNode<T> {
	T info;
	DLNode next;
	DLNode previous;
	double priority;
	
	public DLNode(){
		info = null;
		next = null;
		previous = null;
		priority = 0;
	}
	
	public DLNode(T info, DLNode next, DLNode previous){
		this(info,next,previous,0);
	}
	
	public DLNode(T info, DLNode next, DLNode previous, double priority){
		this.info = info;
		this.next = next;
		this.previous = previous;
		this.priority = priority;
	}
	
	public String toString(){
		return info.toString();
	}
}
