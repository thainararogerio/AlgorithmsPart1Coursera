package Quick_union_improvements;
import Utils.StdIn;
import Utils.StdOut;

public class Main {
	public static void main(String[] args) {
		StdOut.println("Quick-union-weighted");
		int N = StdIn.readInt();
		UF uf = new UF(N);
		
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			
			if (!uf.connected(p, q)) {
				uf.union(p, q);
				//StdOut.println(p + " " + q);
				StdOut.println(uf);
			}
		}
		
		
	}
}
