package Structures;

import java.io.Serializable;

public class TreeNode<T> implements Serializable  {

	private static final long serialVersionUID = 1L;
	T data; 
    TreeNode<T> left, right; 
    int h;
   
    public TreeNode(T info){ 
        this.data = info; 
        this.left = this.right = null; 
    }
}