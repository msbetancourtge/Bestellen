package Structures;

public class HashEntry <T>{
	
	public T data;
	public String key;
	public boolean isActive;
	
	public HashEntry(T data, String key) {
		this(data, true, key);
	}
	
	public HashEntry(T data, boolean iA, String key) {
		this.data=data;
		this.isActive=iA;
		this.key=key;
	}

}
