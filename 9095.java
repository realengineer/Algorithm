import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(in.readLine());
		
		while (tc-- > 0) {
			int n = Integer.parseInt(in.readLine());
			int[] dp = new int[n + 2];
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			
			for (int i = 4; i <= n; i++) {
				dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
			}

			System.out.println(dp[n]);
		}
	}

}
