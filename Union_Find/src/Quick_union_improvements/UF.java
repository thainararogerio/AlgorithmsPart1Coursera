package Quick_union_improvements;

import java.util.Arrays;

import Utils.StdOut;

public class UF {
	private int[] id;
	private int[] sizes;
	
	public UF(int N) {
		id = new int[N];
		sizes = new int[N];
		
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
			sizes[i] = 1;
		}
	}
	
	private int root(int i) {
		while(id[i] != i) {
			//Path compression:
			id[i] = id[id[i]]; //make the actual receive it's parent's parent.
			//to make the tree flat.
			
			i = id[i];
		}
		return i;
	}
	
	public void union(int p, int q) {
		//get the root of the component containing the first item and
		//make that a child of the root of the component containing 
		//the second item
		long start = System.nanoTime(); 
		
		int root_p = root(p);
		int root_q = root(q);
		
		if(root_p == root_q) {
			return;//they are already connected
		}
		
		if (sizes[root_p] < sizes[root_q]) {
			id[root_p] = root_q;
			sizes[root_q] += sizes[root_p];
		} else {
			id[root_q] = root_p;
			sizes[root_p] += sizes[root_q];
		}
		
		long elapsedTime = System.nanoTime() - start;
		StdOut.println("union execution time: " + elapsedTime);
	}
	
	public boolean connected(int p, int q) {
		return (root(p) == root(q));
	}

	@Override
	public String toString() {
		return "UF [id=" + Arrays.toString(id) + "]";
	}
	
	
}
