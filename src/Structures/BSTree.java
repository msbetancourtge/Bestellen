package Structures;
import java.io.Serializable;

public class BSTree<T extends Serializable> implements Comparable<T>, Serializable  {

	private static final long serialVersionUID = 1L;
	
	private TreeNode<T> root;
	public BSTree() {
		this.root = null;
	}
	
	public void makeEmpty() {
		this.root=null;
	}
	public boolean isEmpty() {
		return this.root == null;
	}
	public T findMin() throws Exception {
		if (isEmpty()) throw new Exception();
		
		return findMin(root).data;
	}
	private TreeNode<T> findMin(TreeNode<T> root) {
		if (root==null) return null;
		else if (root.left==null) return root;
		return findMin(root.left);
	}
	
	public T findMax() throws Exception {
		if (isEmpty()) throw new Exception();
		
		return findMax(root).data;
	}
	private TreeNode<T> findMax(TreeNode<T> root) {
		if (root==null) return null;
		else if (root.right==null) return root;
		return findMax(root.right);
	}
	
	private int height(TreeNode<T> root) {
		if(root==null) return -1;
		else return 1+ Math.max(height(root.left), height(root.right));
	}
	
	public boolean contains(T data) {
		return contains(root, data);
	}
	private boolean contains(TreeNode<T> root, T data) {
		if (root==null) return false;
		
		int compare = ((Comparable<T>) data).compareTo(root.data);
		
		if (compare<0) return contains(root.left, data);
		else if(compare>0) return contains(root.right, data);
		else return true;
	}
	
	public void insert(T data)  { 
		root = insert(root, data); 
	}
	private TreeNode<T> insert(TreeNode<T> root, T data){
		
		if (root==null) return new TreeNode<T> (data);
		
		int compare = ((Comparable<T>) data).compareTo(root.data);
		
		if (compare < 0) root.left = insert(root.left, data);
		else if(compare > 0) root.right = insert(root.right, data);
		else ;
		
		return root;
	}
	
	
	public void remove(T data)  { 
		root = remove(root, data); 
	}
	private TreeNode<T> remove(TreeNode<T> root, T data){
		
		if (root==null) return root;
		
		int compare = ((Comparable<T>) data).compareTo(root.data);
		
		if (compare < 0) root.left = remove(root.left, data);
		else if(compare > 0) root.right = remove(root.right, data);
		else if (root.left != null && root.right != null) {
			root.data = findMin(root.right).data;
			root.right = remove(root.right, root.data);
		}
		else 
			root = (root.left!=null) ? root.left : root.right;
		
		return root;
	}
	
	public void print() {
		if (isEmpty()) {
			System.out.println("No hay información almacenada");
		}
		else print(root);
	}
	private void print(TreeNode<T> root) {
		if(root != null) {
			print(root.left);
			System.out.println(root.data);
			print(root.right);
		}
	}
	
	

	@Override
	public int compareTo(T o) {
		
		
		
		
		// TODO Auto-generated method stub
		return 0;
	} 
}

