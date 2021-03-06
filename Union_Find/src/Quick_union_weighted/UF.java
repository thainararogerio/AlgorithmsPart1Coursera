package Quick_union_weighted;

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
	
	public void union(int p, int q) {
		long start = System.nanoTime(); 
		
		int root_p = p;
		while(id[root_p] != root_p) {
			root_p = id[root_p];
		}
		
		int root_q = q;
		while(id[root_q] != root_q) {
			root_q = id[root_q];
		}
		
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
		int root_p = p;
		while(id[root_p] != root_p) {
			root_p = id[root_p];
		}
		
		int root_q = q;
		while(id[root_q] != root_q) {
			root_q = id[root_q];
		}
		
		return (root_p == root_q);
	}

	@Override
	public String toString() {
		return "UF [id=" + Arrays.toString(id) + "]";
	}
	
	
}
