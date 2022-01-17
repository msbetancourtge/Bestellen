package Structures;

import java.io.Serializable;

public class NodoArbol<T extends Serializable> implements Serializable  {
	T data; 
    NodoArbol left, right; 
    int key;
   
    public NodoArbol(T info,int Key){ 
        data = info; 
        left = right = null; 
        key = Key;
    } 

}
