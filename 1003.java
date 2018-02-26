import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] dp1;
	static int[] dp2;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(in.readLine());
		while (tc-- > 0) {
			int input = Integer.parseInt(in.readLine());
			dp1 = new int[input + 1];
			dp2 = new int[input + 1];
			fibonacci(input);
		}
	}

	public static void fibonacci(int n) {
		if (n == 0) {
			dp1[0] = 1;
			dp2[0] = 0;
		} else if (n == 1) {
			dp1[1] = 0;
			dp2[1] = 1;
		} else {
			dp1[0] = 1;
			dp2[0] = 0;
			dp1[1] = 0;
			dp2[1] = 1;

			for (int i = 2; i <= n; i++) {
				dp2[i] = dp2[i - 2] + dp2[i - 1];
				dp1[i] = dp1[i - 2] + dp1[i - 1];
			}
		}
		System.out.println(dp1[n] + " " + dp2[n]);

	}
}
