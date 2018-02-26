import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] dp = new int[100010][3];

	public static void main(String[] args) throws IOException {
		dp[1][0] = dp[1][1] = dp[1][2] = 1;

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		in.close();

		for (int i = 2; i <= n + 1; i++) {
			dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
			dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
			dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
		}

		System.out.print(dp[n + 1][0]);
	}
}
