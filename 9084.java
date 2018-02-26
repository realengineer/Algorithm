import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(in.readLine());
		while (tc-- > 0) {
			int n = Integer.parseInt(in.readLine());
			int[] money = new int[n + 1];
			String[] arr = in.readLine().split(" ");
			int cost = Integer.parseInt(in.readLine());
			int[] dp = new int[cost + 1];
			dp[0] = 1;
			for (int i = 1; i <= n; i++)
				money[i] = Integer.parseInt(arr[i - 1]);

			for (int j = 1; j <= cost; j++) {
			for (int i = 1; i <= n; i++) {
					if (j - money[i] >= 0)
						dp[j] += dp[j - money[i]];
				}
			}

			System.out.println(dp[cost]);
		}
	}
	
}
