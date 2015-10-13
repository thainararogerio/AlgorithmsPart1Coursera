package Quick_find;
import java.sql.Time;
import java.util.Arrays;
import java.util.Timer;

import Utils.StdOut;

public class UF {
	private int[] id;
	private int increment_id;
	
	public UF(int N) {
		id = new int[N];
		increment_id = 1;
		
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
		}
	}
	
	public void union(int p, int q) {
		long start = System.nanoTime();    
		
		int id_p = id[p];
		int id_q = id[q];
		
			for (int i = 0; i < id.length; i++) {
				if (id[i] == id_p) {
					id[i] = id_q;
				}
			}
			
		long elapsedTime = System.nanoTime() - start;
		StdOut.println("union execution time: " + elapsedTime);
	}
	
	public boolean connected(int p, int q) {
		return (id[p] == id[q]);
	}

	@Override
	public String toString() {
		return "UF [ids=" + Arrays.toString(id) + ", increment_id=" + increment_id + "]";
	}
	
	
}
