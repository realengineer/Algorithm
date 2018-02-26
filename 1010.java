import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(in.readLine());
		while (tc-- > 0) {
			String[] str = in.readLine().split(" ");
			int n = Integer.parseInt(str[0]);
			int m = Integer.parseInt(str[1]);

			System.out.println(func(n, m));
		}
	}

	private static int func(int n, int m) {
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 0; i <= m; i++)
			dp[0][i] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (i == 1)
					dp[i][j] = j;
				else if (i == j)
					dp[i][j] = 1;
				else
					dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
			}
		}
		return dp[n][m];
	}

}
