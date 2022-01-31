package Structures;

import java.io.Serializable;

public class TreeNode<T> implements Serializable  {

	private static final long serialVersionUID = 1L;
	T data; 
    TreeNode<T> left, right; 
    int h;
    
    
    
    public T getData() {
		return data;
	}

	public TreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}

	public TreeNode<T> getRight() {
		return right;
	}

	public void setRight(TreeNode<T> right) {
		this.right = right;
	}

	public TreeNode(T info){ 
        this.data = info; 
        this.left = this.right = null; 
    }
}