package Util;


public class Node<T> {
	T info;
	Node next;
	
	public Node(){
		info = null;
		next = null;
	}
	
	public Node(Node<T> node){
		this.info = node.getInfo();
		this.next = new Node(node.getNext());
	}
	
	public Node getNext(){
		return next;
	}
	
	public T getInfo(){
		return info;
	}
	
	public void setInfo(T info){
		this.info = info;
	}
	
	public void setNext(Node<T> next){
		this.next = next;
	}
	
	public Node(T info, Node next){
		this.info = info;
		this.next = next;
	}
	
	public String toString(){
		return info.toString();
	}
}
