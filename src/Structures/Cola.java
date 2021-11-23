package Structures;

import java.io.Serializable;

public class Cola<T extends Serializable> implements Serializable {
	node<T> head;
	
	public Cola() { this.head = null; }
	
	void enqueue(T data)
	{

	    // Creating new node with given value
	    node<T> temp = new node<>(data);

	    // Checking if list is empty
	    // and assigning new value to head node
	    if (this.head == null) {
	        head = temp;
	    }

	    // If list already exists
	    else {

	        // Temporary node for traversal
	        node<T> X = head;

	        // Iterating till end of the List
	        while (X.next != null) {
	            X = X.next;
	        }

	        // Adding new valued node at the end of the list
	        X.next = temp;
	    }
	}
	void dequeue() 
	{
		// Dummy node with null value
	    node<T> prev = new node<>(null);

	    if (head!=null){
	    	prev=head;
	    	head = head.next;
	    	prev=null;
	    }
	    
	}
	String peek() 
	{
		node<T> temp = head;
		return String.valueOf(temp.data);
	}


}
