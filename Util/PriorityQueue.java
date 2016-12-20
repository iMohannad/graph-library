package Util;

public class PriorityQueue<T> {
	private DLNode<T> top, back;
	
	public PriorityQueue(){
		top = back = null;
	}
	
	public void clear(){
		top = back = null;
	}
	
	public boolean isEmpty(){
		return top == null && back == null;
	}
	
	public int enqueue(T element, double priority){
		if(isEmpty()){
			DLNode<T> node = new DLNode<>(element,null,null, priority);
			top = back = node;
			return 0;
		}
		else{
			DLNode<T> previousNode = null;
			DLNode<T> tmp = top;
			DLNode<T> pnode = null;
			
			while(tmp != null){
				if(tmp.priority > priority){
					if(top == tmp){
						pnode = new DLNode<T>(element, top, null, priority);
						top = pnode;
					}else if(back == tmp){
						pnode = new DLNode<T>(element, back, previousNode, priority);
					}
					else{
						pnode = new DLNode<T>(element, tmp, previousNode, priority);
					}
					//Updating (next) and (previous) of pnode
					if(previousNode != null ) previousNode.next = pnode;
					tmp.previous = pnode;
					break;
				}
				//updating the loop
				previousNode = tmp;
				tmp = tmp.next;
			}
			if(tmp == null){
				pnode = new DLNode<T>(element, null, back, priority);
				back.next = pnode;
				back = pnode;
			}
			return 0;
		}
	}
	
	//This method go over the queue and if it finds the element it will return true
	public boolean isExist(T element){
		if(isEmpty())	return false;
		DLNode<T> tmp = top;
		while(tmp != null){
			if(tmp.info.equals(element))
				return true;
			tmp = tmp.next;
		}
		return false;
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
	
}
