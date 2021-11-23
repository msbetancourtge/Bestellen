package Structures;

import java.io.Serializable;

import Data.Restaurante;

public class LinkedList<T extends Serializable> implements Serializable {
	 

	private static final long serialVersionUID = 1L;
	
	// Generic node instance
    node<T> head;
    // Data member to store length of list
    private int length = 0;
 
    // Default constructor
    public LinkedList() { this.head = null; }
    // Method
    // To add node at the end of List
    public void add(T data)
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
 
        // Increasing length after adding new node
        length++;
    }
 
    // Method
    // To add new node at any given position
   public void add(int position, T data)
    {
 
        // Checking if position is valid
        if (position > length + 1) {
 
            // Display message only
            System.out.println(
                "Position Unavailable in LikedList");
            return;
        }
 
        // If new position is head then replace head node
        if (position == 1) {
 
            // Temporary node that stores previous head
            // value
            node<T> temp = head;
 
            // New valued node stored in head
            head = new node<T>(data);
 
            // New head node pointing to old head node
            head.next = temp;
 
            return;
        }
 
        // Temporary node for traversal
        node<T> temp = head;
 
        // Dummy node with null value that stores previous
        // node
        node<T> prev = new node<T>(null);
        // iterating to the given position
        while (position - 1 > 0) {
            // assigning previous node
            prev = temp;
            // incrementing next node
            temp = temp.next;
            // decreasing position counter
            position--;
        }
        // previous node now points to new value
        prev.next = new node<T>(data);
        // new value now points to former current node
        prev.next.next = temp;
    }
    // Method
    // To remove a node from list
   public void remove(T key)
    {
 
        //  NOTE
        // dummy node is used to represent the node before
        // the current node Since in a Singly Linked-List we
        // cannot go backwards from a node, we use a dummy
        // node to represent the previous node. In case of
        // head node, since there is no previous node, the
        // previous node is assigned to null.
 
        // Dummy node with null value
        node<T> prev = new node<>(null);
 
        // Dummy node pointing to head node
        prev.next = head;
 
        // Next node that points ahead of current node
        node<T> next = head.next;
 
        // Temporary node for traversal
        node<T> temp = head;
 
        // Boolean value that checks whether value to be
        // deleted exists or not
        boolean exists = false;
 
        // If head node needs to be deleted
        if (head.data == key) {
            head = head.next;
 
            // Node to be deleted exists
            exists = true;
        }
 
        // Iterating over LinkedList
        while (temp.next != null) {
 
            // We convert value to be compared into Strings
            // and then compare using
            // String1.equals(String2) method
 
            // Comparing value of key and current node
            if (String.valueOf(temp.data).equals(
                    String.valueOf(key))) {
 
                // If node to be deleted is found previous
                // node now points to next node skipping the
                // current node
                prev.next = next;
                // node to be deleted exists
                exists = true;
 
                // As soon as we find the node to be deleted
                // we exit the loop
                break;
            }
 
            // Previous node now points to current node
            prev = temp;
 
            // Current node now points to next node
            temp = temp.next;
 
            // Next node points the node ahead of current
            // node
            next = temp.next;
        }
 
        // Comparing the last node with the given key value
        if (exists == false
            && String.valueOf(temp.data).equals(
                String.valueOf(key))) {
 
            // If found , last node is skipped over
            prev.next = null;
 
            // Node to be deleted exists
            exists = true;
        }
 
        // If node to be deleted exists
        if (exists) {
 
            // Length of LinkedList reduced
            length--;
        }
 
        // If node to be deleted does not exist
        else {
 
            // Print statement
            System.out.println(
                "Given Value is not present in linked list");
        }
    }
 
    // Method
    // To clear the entire LinkedList
    public void clear()
    {
 
        // Head now points to null
        head = null;
        // length is 0 again
        length = 0;
    }
 
    // Method
    // Returns whether List is empty or not
    boolean empty()
    {
 
        // Checking if head node points to null
        if (head == null) {
            return true;
        }
        return false;
    }
    // Method
    // Returning the size of LinkedList
    public int size() { return this.length; }
 
    // Method
    // To display the LinkedList
    // @Override
    public String toString()
    {
 
        String S = "{ ";
 
        node<T> X = head;
 
        if (X == null)
            return S + " }";
 
        while (X.next != null) {
            S += String.valueOf(X.data) + " -> ";
            X = X.next;
        }
 
        S += String.valueOf(X.data);
        return S + " }";
    }
	public  T get(int i) {
		node<T> current = head;
	        int count = 0; /* index of Node we are
	                          currently looking at */
	        while (current != null)
	        {
	            if (count == i)
	                return current.data;
	            count++;
	            current = current.next;
	        }
	 
	        /* if we get to this line, the caller was asking
	        for a non-existent element so we assert fail */
	        assert (false);
	        return null;
	}

}
