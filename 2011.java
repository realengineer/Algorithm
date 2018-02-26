import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] number = br.readLine().split("");
		int n = number.length;
		int[] dp = new int[n + 1];
		int temp;

		dp[0] = dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			if (Integer.parseInt(number[i - 2]) == 0) {
				dp[i] = dp[i - 1];
			} else {
				temp = Integer.parseInt(number[i - 2] + number[i - 1]);
				if (temp <= 26) {
					if (Integer.parseInt(number[i - 1]) == 0) {
						dp[i] = dp[i - 2];
					} else {
						dp[i] = dp[i - 1] + dp[i - 2];   
					}
				} else {
					dp[i] = dp[i - 1];
				}
			}
			dp[i] %= 1000000;
		}
		if (n == 1 && Integer.parseInt(number[0]) == 0)
			System.out.println(0);
		else
			System.out.println(dp[n]);

	}
}