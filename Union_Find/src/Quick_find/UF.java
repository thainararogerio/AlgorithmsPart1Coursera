package Quick_find;
import java.util.Arrays;
import Utils.StdOut;

public class UF {
	private int[] id;
	
	public UF(int N) {
		id = new int[N];
		
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
		return "UF [ids=" + Arrays.toString(id) + "]";
	}
	
	
}
