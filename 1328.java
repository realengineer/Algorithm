import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();
		int r = sc.nextInt();

		long[][][] dp = new long[102][102][102];

		dp[1][1][1] = 1L;
		//dp[2][2][1] = 1L;
		//dp[2][1][2] = 1L;

		int i, j, k;
		long MOD = 1000000007;

		for (i = 1; i < n; i++) {
			for (j = 1; j <= l; j++) {
				for (k = 1; k <= r; k++) {
					dp[i+1][j+1][k] += dp[i][j][k]; dp[i+1][j+1][k] %= MOD;
					dp[i+1][j][k+1] += dp[i][j][k]; dp[i+1][j][k+1] %= MOD;
					dp[i+1][j][k] += dp[i][j][k] * (i-1); dp[i+1][j][k] %= MOD;
				}
			}
		}

		System.out.print(dp[n][l][r]);
	}
}
