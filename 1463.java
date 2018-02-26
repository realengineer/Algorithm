import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] dp = new int[n + 1];
		if (n == 1) {
			System.out.print(0);
		} else if (n == 2) {
			System.out.print(1);

		} else if (n == 3) {
			System.out.print(1);
		} else {
			dp[1] = 0;
			dp[2] = 1;
			dp[3] = 1;

			for (int i = 4; i <= n; i++) {
				if (i % 2 == 0 && i % 3 != 0) {
					dp[i] = Math.min(dp[i - 1] + 1, dp[i / 2] + 1);
				} else if (i % 3 == 0 && i % 2 != 0) {
					dp[i] = Math.min(dp[i - 1] + 1, dp[i / 3] + 1);

				} else if (i % 2 == 0 && i % 2 == 0) {
					dp[i] = Math.min(Math.min(dp[i - 1] + 1, dp[i / 3] + 1), dp[i / 2] + 1);
				} else
					dp[i] = dp[i - 1] + 1;
			}

			System.out.println(dp[n]);
		}
	}

}
