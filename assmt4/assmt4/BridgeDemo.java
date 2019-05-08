package assmt4;

/**
 * Bridge pattern demonstration, with the two layers of abstraction
 * being ArraySort and SortInterface.
 * 
 * @author jameswhite
 *
 */
public class BridgeDemo {
	
	public static void main(String[] args) {

		// Insertion sort.
		SortInterface<Integer> is = ob -> {
			int n = ob.size(); 
			for (int i = 1; i < n; i++) { 
				int key = ob.get(i); 
				int j = i - 1; 
				while (j >= 0 && ob.get(j) > key) { 
					ob.set(j+1,ob.get(j)); 
					j = j - 1; 
				} 
				ob.set(j+1,key); 
			} 
		};
		
		// Bubble sort.
		SortInterface<Integer> bs = ob -> {
			 int n = ob.size(); 
		        for (int i = 0; i < n-1; i++) 
		            for (int j = 0; j < n-i-1; j++) 
		                if (ob.get(j) > ob.get(j+1)) { 
		                    int temp = ob.get(j); 
		                    ob.set(j,ob.get(j+1)); 
		                    ob.set(j+1,temp); 
		                } 
		};
		
		// Class local to this method.
		final class IntArraySort extends ArraySort {
			public IntArraySort(int i, SortInterface<?> s) {
				super(i, s);
			}

			public void printArray() {
				System.out.print("[");
				for (Integer i : internal)
					System.out.print(" "+i);
				System.out.println("]");
			}

			public void sort() {
				s.sort(internal);
			}
		};
		
		// Actual demonstration of bridge pattern.
		ArraySort t = new IntArraySort(16, is);
		
		t.printArray();
		t.sort();
		t.printArray();

		t = new IntArraySort(21, bs);
		
		t.printArray();
		t.sort();
		t.printArray();

	}
}