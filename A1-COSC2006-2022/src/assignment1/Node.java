package assignment1;

public class Node<E> {
	
	private E data;
	private Node<E> next;
	private Node<E> prev;
	
	public Node(E data) { this(data, null, null);}
	
	public Node(E data, Node<E> next) { this(data, next, null);}
	
	public Node(E data, Node<E> next, Node<E> prev) { 
		this.data=data;
		this.next=next;
		this.prev=prev;
	}
	
	public E getData() {return data;}
	public void setData(E data) {this.data=data;}
	
	public Node<E> getNext() {return next;}
	public void setNext(Node<E> next) {this.next=next;}
	
	public Node<E> getPrevious() {return prev;}
	public void setPrevious(Node<E> prev) {this.prev=prev;}

}
