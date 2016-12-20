package Util;

public class LinkedList<T> {
	Node<T> head;
	
	public LinkedList(){
		head = null;
	}
	
	public LinkedList(LinkedList<T> list) {
		//Get the first node
		Node<T> node = list.head;
		
		Node<T> newNode = new Node();
		this.head = newNode;
		
		// Go through old list, copy data, create new nodes for this list.
		while(node != null){
			newNode.setInfo(node.getInfo());
			node = node.getNext();
			if(node != null){
				newNode.setNext(new Node());
				newNode = newNode.getNext();
			}
		}
	
	}

	public void clear(){
		head = null;
	}
	
	public boolean isEmpty(){
		return head == null;
	}
	
	public int add(T element){	return add2tail(element);}
	
	public int add2head(T element){
		//Case1 : Empty List
		if(isEmpty()){
			Node<T> node = new Node(element,null);
			head = node;
			return 0;
		}else if(!isEmpty()){
			//Case2 : At least one element in the list
			Node<T> node = new Node(element, head);
			head = node;
			return 0;
		}else{ //Not expected to reach
			return -1;
		}
	}
	
	public int add2tail(T element){
		//Case1 : Empty List
		if(isEmpty()){
			return add2head(element);
		}else{
			Node<T> tmp = head;
			
			while(tmp.next != null)
				tmp = tmp.next;
			
			Node<T> node = new Node(element, null);
			tmp.next = node;
			return 0;
		}
	}	
	
	/*Empty >> return -1
	 *Not found >> return -2
	 *Found (Success) |>> return 0 */
	public int addBefore(T element, T before){
		
		if(isEmpty()){
			return -1;
		}
		//The before element is the head item
		if(head.info.equals(before)){
			return add2head(element);
		}
		//case3:
		Node<T> tmp = head;
		Node<T> previous = head;
		
		while((tmp != null) && (!tmp.info.equals(before))){
			previous = tmp;
			tmp = tmp.next; //increment
		}
		
		//Case3 : Before item not found
		if(tmp == null)		
			return -2;
		
		//Case4 : (before) element is found
		Node<T> node = new Node(element, tmp);
		previous.next = node;
		
		return 0;

	}

	/*Empty >> return -1
	 *Not found >> return -2
	 *Found (Success) |>> return 0 */
	public int addAfter(T element, T after){
		if(isEmpty()){
			return -1;
		}
		if(head.info.equals(after)){
			return add2head(element);
		}
		
		Node<T> tmp = head;
		
		while(tmp != null && !tmp.info.equals(after))
			tmp = tmp.next;
		
		if(tmp == null)
			return -2;
		
		Node<T> node = new Node(element, tmp.next);
		tmp.next = node;
		
		return 0;
		
	}
	
	
	public T deleteFromHead(){
		if(isEmpty())
			return null;
		/*else if(head.next == null){
			Node<T> tmp = head;
			head = null;
			return tmp.info; 
		}*/
		else{
			Node<T> tmp = head;
			head = head.next;
			return tmp.info;
		}
	}
	
	public T deleteFromTail(){
		if(isEmpty())
			return null;
		else if(head.next == null){
			Node<T> tmp = head;
			head = null;
			return tmp.info; 
		}
		else{
			Node<T> tmp = head;
			Node<T> previous = head;
			
			while(tmp.next != null){
				previous = tmp;
				tmp = tmp.next;
			}
			
			previous.next = null;
			return tmp.info;
		}
	}
	
	public T delete(T element){
		if(isEmpty())
			return null;
		else{
		
			Node<T> tmp = head;
			Node<T> previous = head;
			
			while(tmp != null && !tmp.info.equals(element)){
				previous = tmp;
				tmp = tmp.next;
			}
			
			if(tmp == null){
				return null;
			}
			
			if(tmp == head)
				deleteFromHead();
			
			previous.next = tmp.next;
			
			return tmp.info;
		}
	}
	
	public T get(int index){
		int length = this.getLength();
		if(length == 0)	return null;
		Node<T> tmp = head;
		int count = 0;
		while(tmp != null){
			if(count == index)
				return tmp.info;
			tmp = tmp.next;
			count++;
		}
		
		return null;
			
	}
	
	public boolean isExist(T element){
		if(isEmpty())	return false;
		Node<T> tmp = head;
		while(tmp != null && !tmp.info.equals(element))
			tmp = tmp.next;
		
		if(tmp == null)
			return false;
		
		return true;
	}
	
	public T find(T element){
		if(isEmpty())	return null;
		Node<T> tmp = head;
		while(tmp != null && !tmp.info.equals(element))
			tmp = tmp.next;
		
		if(tmp == null)
			return null;
		
		return tmp.info;
	}
	
	
	public String toString(){
		String str = "[";
		Node<T> tmp = head;
		while(tmp != null){
			str += tmp.info + " ";
			tmp = tmp.next;
		}
		str += "]";
		return str;
	}
	
	public int getLength(){
		return getLength(head);
	}
	
	public int getLength(Node<T> tmp){
		if(tmp == null)
			return 0;
		else
			return 1 + getLength(tmp.next);
	}
	

	
	
}
