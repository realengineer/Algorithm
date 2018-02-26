import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int INF = Integer.MAX_VALUE;
	static int n;
	static int[][] dp = new int[501][501];
	static int[] idx = new int[501];
	static int[] sum = new int[501];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(in.readLine());
		for (int t = 0; t < testCase; t++) {
			n = Integer.parseInt(in.readLine());
			String a = in.readLine();
			String[] aarr = a.split(" ");
			for (int i = 1; i <= n; i++)
				idx[i] = Integer.parseInt(aarr[i - 1]);

			sum[0] = 0;
			for (int i = 1; i <= n; i++)
				sum[i] = sum[i - 1] + idx[i];

			for (int i = 1; i <= n; i++)
				for (int j = 1; j <= n; j++)
					dp[i][j] = INF;
			System.out.println(solve(1, n));
		}
	}

	public static int solve(int p, int q) {
		if (p == q)
			return 0;
		if (p + 1 == q)
			return idx[p] + idx[q];
		if (dp[p][q] != INF)
			return dp[p][q];

		for (int i = p; i < q; i++) {
			dp[p][q] = Math.min(dp[p][q], solve(p, i) + solve(i + 1, q) + sum[q] - sum[p - 1]);
		}
		return dp[p][q];
	}
}
