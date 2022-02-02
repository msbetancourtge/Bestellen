package Structures;

import java.io.Serializable;

public class QPHashTable<T extends Serializable> implements Serializable{


	private static final long serialVersionUID = 1L;
	private HashEntry<T> [] array;
	private int size, ocupado;
	private static final int DEFAULT_TABLE_SIZE = 101;
	
	public QPHashTable() {
		this(DEFAULT_TABLE_SIZE);
	}
	
	public QPHashTable(int size) {
		allocateArray(size);
		doClear();
	}
	public boolean insert(T data, String key) {
		
		int curr = findPos(key);
		if (isActive(curr)) return false;
		array [curr] = new HashEntry<>(data, true, key);
		size++;
		if(++ocupado>array.length/2) rehash();
		return true;
	}
	private void rehash() {
		HashEntry<T> [] older= array;
		allocateArray(2*older.length);
		ocupado=0;
		size=0;
		
		for (HashEntry<T> entry:older) {
			if (entry!=null && entry.isActive) insert(entry.data, entry.key);
		}
		
	}
	
	private int findPos(String key) {
		int offset = 1;
		int curr = hashing(key, size+1);
		
		while(array[curr] !=null && !array[curr].key.equals(key)) {
			curr+=offset;
			offset+=2;
			if(curr>=array.length) curr-=array.length;
		}
		return curr;
	}
	
	public boolean remove(String key) {
		int curr = findPos(key);
		if(isActive(curr)) {
			array[curr].isActive = false;
			size--;
			return true;
		}else return false; 	
			}
	
	public int size() {
		return size;
	}
	
	public int capacity() {
		return array.length;
	}
	
	public boolean contains(String key) {
		int curr = findPos(key);
		return isActive(curr);
	}
	
	private boolean isActive(int pos) {
		return array[pos] != null && array[pos].isActive;
	}
	
	public void makeEmpty() {
		doClear();
	}
	
	private void doClear() {
		ocupado=0;
		for (int i=0; i<array.length;i++) {
			array[i]=null;
		}
	}
	
	private int hashing(String key, int size) {
		int hashVal =0;
		for(int i=0; i<key.length(); i++) {
		hashVal=37*hashVal+key.charAt(i);
		}
		hashVal%=size;
		if (hashVal<0) hashVal+=size;
		
		return hashVal;
		
	}
	
	public void printAll() {
		for(HashEntry<T> data:array) {
			System.out.println("\n# de orden: "+data.key+ '\n');
			System.out.println(data.data.toString());
		}
	}
	
	private void allocateArray(int size) {
		array = new HashEntry[nextPrime(size)];
	}
	
	private static int nextPrime(int n) {
		if (n%2==0)n++;
		for(;!isPrime(n); n+=2);
		return n;
	}
	
	private static boolean isPrime(int n) {
		if(n==2 || n==3) return true;
		if(n==1 || n%2==0) return false;
		for(int i=3; i*i<=n; i+=2) {
			if(n%i==0)return false;
		}
		return true;
	}
	
	
}
