import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = in.readLine().split(" ");
		int n = Integer.parseInt(arr[0]);
		int k = Integer.parseInt(arr[1]);
		long[][] dp = new long[n + 1][k + 1];

		for (int i = 1; i <= k; i++) {
			dp[0][i] = 1;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000000;
			}
		}

		System.out.print(dp[n][k]);
	}
}
