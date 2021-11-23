package Structures;

import java.io.Serializable;

//el ultimo a�adido es el primero que se saca
public class Stack <T extends Serializable> implements Serializable {
	// Generic node instance
    node<T> head;
    
    public Stack() { this.head = null; }
    
    
	void push( T data)
	{
		// Temporary node that stores previous head
        // value
        node<T> temp = head;

        // New valued node stored in head
        head = new node<T>(data);

        // New head node pointing to old head node
        head.next = temp;

        return;
    }
	void pop() 
	{
		// Dummy node with null value
        node<T> prev = new node<>(null);
 
        if (head!=null){
        	prev=head;
        	head = head.next;
        	prev=null;
        }
        
	}
	String top() 
	{
		node<T> temp = head;
		return String.valueOf(temp.data);
	}
		
}







