import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while (tc-- > 0) {
			int n = sc.nextInt();
			int arr[][] = new int[3][n + 1];
			int dp[][] = new int[3][n + 1];

			for (int i = 1; i <= 2; i++) {
				for (int j = 1; j <= n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			dp[1][1] = arr[1][1];
			dp[2][1] = arr[2][1];

			for (int i = 2; i <= n; i++) {
				dp[1][i] = Math.max(dp[1][i - 1], arr[1][i] + dp[2][i - 1]);
				dp[2][i] = Math.max(dp[2][i - 1], arr[2][i] + dp[1][i - 1]);
			}
			System.out.println(Math.max(dp[1][n], dp[2][n]));
		}
		sc.close();
	}
}
