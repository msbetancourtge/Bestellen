package Structures;

import java.io.Serializable;


public class Stack <T extends Serializable> implements Serializable {

	private static final long serialVersionUID = 1L;
	// Generic node instance
    Node<T> head;
    
    public Stack() { 
    	this.head = null; 
    	}
    
	public void push( T data){
		// Temporary node that stores previous head
        // value
        Node<T> temp = head;

        // New valued node stored in head
        head = new Node<T>(data);

        // New head node pointing to old head node
        head.next = temp;

        return;
    }
	public Object pop() {
		// Dummy node with null value
        String temp = top();
        if (head!=null){
        	head = head.next;
        }
	return temp;
	}
	public String top() {
		Node<T> temp = head;
		return String.valueOf(temp.data);
	}
		
}







