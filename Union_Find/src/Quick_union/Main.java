package Quick_union;
import Utils.StdIn;
import Utils.StdOut;

public class Main {
	public static void main(String[] args) {
		StdOut.println("Quick-union");
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
