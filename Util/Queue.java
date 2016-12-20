package Util;

public class Queue <T> {
	
	private DLNode<T> top, back;
	
	public Queue(){
		top = back = null;
	}
	
	public void clear(){
		top = back = null;
	}
	
	public boolean isEmpty(){
		return top == null && back == null;
	}
	

	public int enqueue(T element){
		if(isEmpty()){
			DLNode<T> node = new DLNode<>(element,null,null);
			top = back = node;
			return 0;
		}
		else{
			DLNode<T> node = new DLNode<T>(element, null, back);
			back.next = node;
			back = node;
			return 0;
		}
	}
	
	public T dequeue(){
		if(isEmpty())
			return null;
		
		DLNode<T> tmp = top;
		if(top == back){
			top = back = null;
			return tmp.info;
		}

		top = top.next;
		top.previous = null;
		
		return tmp.info;
	}
	
	public String toString(){
		String str = "[";
		DLNode<T> tmp = top;
		while(tmp != null){
			str += tmp.info + " ";
			tmp = tmp.next;
		}
		str += "]";
		return str;
	}
	
	public void ReverseQueue(){
		if(isEmpty())
			return;
		else{
			T n = dequeue();
			ReverseQueue();
			enqueue(n);
		}
	}
	
	
}
