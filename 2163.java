import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = in.readLine().split(" ");
		int a = Integer.parseInt(arr[0]);
		int b = Integer.parseInt(arr[1]);
		int n, m;
		if (a <= b) {
			n = a;
			m = b;
		} else {
			n = b;
			m = a;
		}

		int[][] dp = new int[n + 1][m + 1];
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				dp[i][j] = i * j - 1;
			}
		}

		System.out.println(dp[n][m]);
	}

}
