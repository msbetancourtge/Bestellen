package Structures;

import java.io.Serializable;

class Node<T extends Serializable> implements Serializable {

	private static final long serialVersionUID = 1L;
	// Data members
	// 1. Storing value of node
	T data;
	// 2. Storing address of next node
	Node<T> next;

	Node(T data){
		this.data = data;
		this.next = null;
	}
}