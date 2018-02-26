import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] dp;
	static int[] coke;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		coke = new int[n + 1];
		String[] arr = in.readLine().split(" ");
		for (int i = 1; i <= n; i++)
			coke[i] = Integer.parseInt(arr[i - 1]);

		dp = new int[n + 1][n + 1];
		for(int i = 0; i <= n; i++){
			for(int j = 0; j <= n; j++)
				dp[i][j] = -1;
		}
		System.out.print(dp(1, n));
	}

	public static int dp(int i, int j) {
		if (i >= j)
			return 0;
		if (dp[i][j] != -1)
			return dp[i][j];
		dp[i][j] = dp(i + 1, j);
		for (int k = i+1; k <= j; k++) {
			if (coke[i] == coke[k]) {
				int cur = dp(i + 1, k - 1) + dp(k + 1, j) + 1;
				dp[i][j] = Math.max(cur, dp[i][j]);
			}
		}
		return dp[i][j];
	}
}
