import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		long[] dp = new long[n + 1];

		if (n == 1)
			System.out.print(1);
		else if (n == 2)
			System.out.print(1);
		else {
			dp[1] = 1;
			dp[2] = 1;

			for (int i = 3; i <= n; i++)
				dp[i] = dp[i - 1] + dp[i - 2];

			System.out.print(dp[n]);
		}
	}
}
