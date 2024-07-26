package assignment1;

public class DLinkedList<E> {
		
	private class Node<E> {
		
		 E data;
		 Node<E> next;
		 Node<E> prev;
		
		 Node(E data) { this(data, null, null);}
		
		 Node(E data, Node<E> next) { this(data, next, null);}
		
		 Node(E data, Node<E> next, Node<E> prev) { 
			this.data=data;
			this.next=next;
			this.prev=prev;
		}

	}
	
	private Node<E> head;
	private Node<E> tail;
	
	public DLinkedList() {
		this(null,null);
	}
	
	public DLinkedList(E headData){
		if(headData==null) {
			head=null;
			tail=null;
		}else{
		Node<E> newHead=new Node<E>(headData);
		head=newHead;
		tail=head;
		}
	}
	
	public DLinkedList(E headData, E tailData){
		this(headData);
		if(tailData == null) {
			tail = null;
		}else{
			Node<E> newTail=new Node<E>(tailData);
			
			if(headData!=null) { 
				
				head.next = newTail;
			}else{
				head=newTail;
			}
			tail=newTail;
		}
	}
	
	public Node<E> getHead(){
		return head;
	}
	
	public void setHead(Node<E> head) {
		this.head=head;
	}
	
	public Node<E> getTail(){
		return tail;
	}
	
	public void setTail(Node<E> tail) {
		this.tail=tail;
	}
	
	public boolean isEmpty() {
		return head==null;
	}
	
	public int size(){
		int size = 0;
		Node<E> node = head;
		while(node != null){
			size++;
			node = node.next;
		}
		return size;
	}
	
	public void addBack(E tailData) {
		if(isEmpty()){
			tail = new Node<E>(tailData);
			head = tail;
		}else{
			tail.next = new Node<E>(tailData, null, tail); 
			tail = tail.next; 
				}
	}
	
	public void addFront(E data) {
		Node<E> newNode = new Node<E>(data);
		if(head != null) {
			newNode.next = head;
			newNode.prev=null;
			head.prev=newNode;
		}
		head=newNode;
		if(tail == null) {
			tail = newNode;
		}
	}
	public void addAfter(E data, int index) {
		if(index <= this.size() && index>=0){
			
			if(isEmpty()){
				
				Node<E> newNode = new Node<E>(data);
				head = newNode;
				tail = newNode;
				
			}else if(index==0) {
				
				addFront(data);
				
			}else if(index==(size())){
				
				addBack(data);
				
			}else {	
				Node<E> newNode = new Node<E>(data);
				Node<E> ref = head;
				for (int i = 1; i < index; i++) { 
					ref = ref.next;
				}
				newNode.next = ref.next;
				ref.next = newNode;
				newNode.prev = ref;
				newNode.next.prev = newNode;	
			}
			
		}else {
			addBack(data);
		}
		
	}
	
	public E removeFirst(){
		//make data of the head equal to a new data variable
		E data = head.data;
		//make head equal to the node after head
		head = head.next; 
		//make node before head null
		head.prev=null;
		
		if(head == null) {
			
		    tail = null;
		    
		}
		//return data 
		return data;

		 
	}
	
	public E removeLast() {
		E data = tail.data;
		Node<E> node = tail.prev;
		tail = node;
		tail.next = null;
		return data;
	}
	
	public boolean remove(E data) {
		if(isEmpty()) {
			return false;
		}
		if(data==head.data) {
			removeFirst();
			return true;
		} else if (data==tail.data) {
			removeLast();
			return true;
		} else {
			Node<E> node = head;
			
			Node<E> nodeNext = head.next;
			
			while(nodeNext != null && !nodeNext.data.equals(data)){
				node = nodeNext;
				nodeNext = node.next;
			} 
			if(nodeNext != null){ // This means we found the node.
				node.next = nodeNext.next;
				node.prev=nodeNext.prev;
				return true; // The remove operation was a success!
			}
		}
		return false;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		Node<E> p=head;
		
	while(p!=null) {
		str.append(p.data+ " ");
		p=p.next;
	}
		return str.toString();
	}
	
}
