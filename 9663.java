import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int count = 0;
	static int[] a = new int[15];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		nqueen(-1);
		System.out.print(count);
	}

	public static boolean check(int cur) {
		for (int i = 0; i < cur; i++) {
			if (a[i] == a[cur] || cur - i == Math.abs(a[cur] - a[i]))
				return false;
		}
		return true;
	}

	public static void nqueen(int cur) {
		if (cur == n - 1) {
			count++;
		} else {
			for (int i = 0; i < n; i++) {
				a[cur + 1] = i;
				if (check(cur + 1))
					nqueen(cur + 1);
			}
		}
	}
}
