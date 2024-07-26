package assignment1;

public class DLinkedListTester {
	public static void main(String[] args){

	DLinkedList<Integer> numList = new DLinkedList<Integer>(5, 10); 
	System.out.println(numList);
	numList.addBack(8);
	System.out.println(numList);
	System.out.println("Our Linked List is " + numList.size() + " elements big.");
	numList.addFront(4);
	System.out.println(numList);
	System.out.println("Our Linked List is " + numList.size() + " elements big.");
	numList.addAfter(6,3); // Adding 7 at index 2
	System.out.println(numList);
	System.out.println("Our Linked List is " + numList.size() + " elements big.");
	numList.addAfter(9, 5); // Adding 9 at index 12
	System.out.println(numList);
	System.out.println("Our Linked List is " + numList.size() + " elements big.");
	System.out.println(numList.removeFirst()); // Returns a 4
	System.out.println(numList);
	System.out.println(numList.removeLast()); // Returns a 9
	System.out.println(numList);
	System.out.println(numList.remove(10));
	System.out.println(numList);
	System.out.println(numList.remove(5));
	System.out.println(numList);
	System.out.println(numList.remove(8));
	numList.addFront(2);
	numList.addFront(4);
	numList.addFront(99);
	System.out.println(numList);
	System.out.println(numList.remove(4));
	System.out.println(numList);
	System.out.println(numList.remove(6));
	System.out.println(numList);


	}

}
