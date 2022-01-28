package Structures;

import java.io.Serializable;

public class NodoArbol<T extends Serializable> implements Serializable  {

	private static final long serialVersionUID = 1L;
	T data; 
    NodoArbol<T> left, right; 
    int key;
   
    public NodoArbol(T info, int Key){ 
        data = info; 
        left = right = null; 
        key = Key;
    }
    
    

}
