import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		TreeSet<Integer> hs = new TreeSet<Integer>();
		for (int i = 0; i < n; i++) {
			hs.add(Integer.parseInt(st.nextToken()));
		}

		for(int i : hs)
			System.out.print(i + " ");
	}
}