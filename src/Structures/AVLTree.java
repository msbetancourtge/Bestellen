package Structures;
import java.io.Serializable;


public class AVLTree<T extends Comparable<? super T>> implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	private int size;
	private TreeNode<T> root;
	
	public TreeNode<T> getRoot() {
		return root;
	}
	public AVLTree() {
		this.root = null;
	}
	public void makeEmpty() {
		this.root=null;
		size=0;
	}
	public int getSize() {
		return this.size;
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
	int balance(TreeNode<T> root) {
        if (root == null) return -1;
 
        return height(root.left) - height(root.right);
    }
	public boolean contains(T data) {
		return contains(root, data);
	}
	private boolean contains(TreeNode<T> root, T data) {
		if (root==null) return false;
		
		int compare = data.compareTo(root.data);
		
		if (compare<0) return contains(root.left, data);
		else if(compare>0) return contains(root.right, data);
		else return true;
	}
	private TreeNode<T> rotateLeft(TreeNode<T> root) {
        
    	TreeNode<T> temp = root.left;
    	root.left = temp.right;
        temp.right = root;

        root.h = height(root);
        if(temp.left !=null)
        temp.left.h = height(temp.left);
        return temp;
    }
    private TreeNode<T> rotateRight(TreeNode<T> root) {
        
    	TreeNode<T> temp = root.right;
    	root.right = temp.left;
        temp.left = root;

        root.h = height(root);
        if(temp.right !=null)
        temp.right.h = height(temp.left);
        return temp;
    }
	public void insert(T data)  { 
		size++;
		root = insert(root, data);
	}
	private TreeNode<T> insert(TreeNode<T> root, T data){
		
		if (root==null) {
			System.out.println("Insertado el valor: " + size);
			return new TreeNode<T> (data);}
		
		int compare = data.compareTo(root.data);
		if (compare < 0) root.left = insert(root.left, data);
		else if(compare > 0) root.right = insert(root.right, data);
		else return root;
		root.h = 1 + Math.max(height(root.left), height(root.right));
		
		int b = balance(root);
		int compare1=0, compare2=0;
		if (root.left !=null) compare1 = data.compareTo(root.left.data);
		if (root.right!=null) compare2 = data.compareTo(root.right.data);
		
		if (b > 1 && compare1<0) return rotateLeft(root);
		else if (b < -1 && compare2>0) return rotateRight(root);
		else if (b > 1 && compare1>0) {
            root.left = rotateRight(root.left);
            return rotateLeft(root);
        }else if (b < -1 && compare2<0) {
            root.right = rotateLeft(root.right);
            return rotateRight(root);
        }else ;
        return root;
	}
	public void remove(T data)  { 
		size--;
		root = remove(root, data); 
	}
	private TreeNode<T> remove(TreeNode<T> root, T data){
		
		if (root==null) return root;
		
		int compare = data.compareTo(root.data);
		
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
		if (isEmpty())
			System.out.println("\n-------No hay información almacenada-------\n");
		else print(root);
	}
	private void print(TreeNode<T> root) {
		if(root != null) {
			print(root.left);
			System.out.println(root.data);
			print(root.right);
		}
	}
}

