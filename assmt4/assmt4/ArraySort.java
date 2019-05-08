package assmt4;

import java.util.ArrayList;

public abstract class ArraySort {

    protected SortInterface<?> s;
    protected ArrayList<Integer> internal;

    public ArraySort (int i, SortInterface<?> s) {
    	this.s = s;
    	internal = new ArrayList<Integer>();
    	for (int a=i-1;a>=0;a--)
    		internal.add(a);
    }
    
    public abstract void sort(); 
       
    public abstract void printArray();

}