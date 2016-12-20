package Util;

import Generate.Edge;
import Generate.Vertix;

public class testLinkedList {
	public static void main(String[] args) {
		LinkedList<Vertix<Character>> list = new LinkedList();
		for(int i = 1; i<=5;i++ )
			list.add2tail(new Vertix('A'));
		
		
		
		LinkedList<Edge<Character>> list1 = new LinkedList<>();
		list1.add(new Edge(new Vertix('A'), new Vertix('B')));
		list.get(0).setAdjNodes(list1);
		
		System.out.println("AdjNode of list " + list.get(0).getAdjNodes());
		LinkedList<Vertix<Character>> list2 = new LinkedList(list);
		list2.get(0).setAdjNodes(null);
		
		list.deleteFromTail();
		System.out.println("List1 >> " + list);
		System.out.println(list.getLength());
		System.out.println("List2>> " + list2);
		System.out.println(list2.getLength());
		
		System.out.println("AdjNode of list " + list.get(0).getAdjNodes());
		System.out.println("AdjNode of list2 " + list2.get(0).getAdjNodes());
		
		/*for(int i = 0; i<list.getLength(); i ++ ){
			
			System.out.println("Element at " + i + " = " + list.get(i));
			list.delete(list.get(i));
			System.out.println(list);
		}*/
		
		
	}
}
