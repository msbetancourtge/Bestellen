package Structures;

import java.io.Serializable;

public class BinarySearchTree<T extends Serializable> implements Serializable  {
	private NodoArbol<T> root;
	public void BinarySearchTree() {
		this.root = null;
	}
	//delete a node from BST
	void deleteKey(int key) { 
		root = delete_Recursive(root, key); 
	} 

	//recursive delete function
	NodoArbol<T> delete_Recursive(NodoArbol<T> root, int key)  { 
		//tree is empty
		if (root == null)  return root; 

		//traverse the tree
		if (key < root.key)     //traverse left subtree 
			root.left = delete_Recursive(root.left, key); 
		else if (key > root.key)  //traverse right subtree
			root.right = delete_Recursive(root.right, key); 
		else  { 
			// node contains only one child
			if (root.left == null) 
				return root.right; 
			else if (root.right == null) 
				return root.left; 

			// node has two children; 
			//get inorder successor (min value in the right subtree) 
			root.key = minValue(root.right); 

			// Delete the inorder successor 
			root.right = delete_Recursive(root.right, root.key); 
		} 
		return root; 
	} 
	int minValue(NodoArbol<T> root)  { 
		//initially minval = root
		int minval = root.key; 
		//find minval
		while (root.left != null)  { 
			minval = root.left.key; 
			root = root.left; 
		} 
		return minval; 
	} 

	// insert a node in BST 
	void insert(int key, T data)  { 
		root = insert_Recursive(root, key, data); 
	} 

	//recursive insert function
	NodoArbol<T> insert_Recursive(NodoArbol<T> root, int key, T data) { 
		//tree is empty
		if (root == null) { 
			root = new NodoArbol<T>(data,key); 
			return root; 
		} 
		//traverse the tree
		if (key < root.key)     //insert in the left subtree
			root.left = insert_Recursive(root.left, key, data); 
		else if (key > root.key)    //insert in the right subtree
			root.right = insert_Recursive(root.right, key, data); 
		// return pointer
		return root; 
	} 
	boolean search(int key, T data)  { 
		root = search_Recursive(root, key, data); 
		if (root!= null)
			return true;
		else
			return false;
	} 

	//recursive insert function
	NodoArbol<T> search_Recursive(NodoArbol<T> root, int key, T data)  { 
		// Base Cases: root is null or key is present at root 
		if (root==null || root.key==key) 
			return root; 
		// val is greater than root's key 
		if (root.key > key) 
			return search_Recursive(root.left, key, data); 
		// val is less than root's key 
		return search_Recursive(root.right, key, data); 
	} 
}
