import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] dp;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		arr = new int[n + 1];
		dp = new int[n + 1];
		String[] input = in.readLine().split(" ");
		for (int i = 0; i < n; i++)
			arr[i + 1] = Integer.parseInt(input[i]);

		System.out.print(go(n));
	}

	public static int go(int x) {
		if (x < 1)
			return 0;
		if (dp[x] != 0)
			return dp[x];
		for (int i = 1; i <= x; i++) {
			dp[x] = Math.max(dp[x], go(x - i) + arr[i]);
		}

		return dp[x];
	}
}
