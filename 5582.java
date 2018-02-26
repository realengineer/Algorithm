import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String a = in.readLine();
		String b = in.readLine();
		int aSize = a.length();
		int bSize = b.length();

		int dp[][] = new int[aSize + 1][bSize + 1];
		for (int i = 1; i <= aSize; i++) {
			for (int j = 1; j <= bSize; j++) {
				if (a.charAt(i-1) == b.charAt(j-1)) 
					dp[i][j] += dp[i - 1][j - 1] + 1;
			}
		}
		int max = 0;
		for (int i = 1; i <= aSize; i++) {
			for (int j = 1; j <= bSize; j++) {
				if (dp[i][j] > max)
					max = dp[i][j];
			}
		}

		System.out.print(max);
	}
}
