package Structures;

import java.io.Serializable;

public class HashEntry <T> implements Serializable{

	private static final long serialVersionUID = 1L;
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
