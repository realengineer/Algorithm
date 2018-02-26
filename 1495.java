import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n, start, max;
	static int[][] dp;
	static int[] volume;

	public static void main(String[] args) throws IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		String a = sc.readLine();
		String[] aarr = a.split(" ");
		n = Integer.parseInt(aarr[0]);
		start = Integer.parseInt(aarr[1]);
		max = Integer.parseInt(aarr[2]);
		String b = sc.readLine();
		String[] barr = b.split(" ");
		volume = new int[n];
		dp = new int[n][max + 1];

		for (int i = 0; i < n; i++)
			volume[i] = Integer.parseInt(barr[i]);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= max; j++)
				dp[i][j] = -1;
		}

		int ans = volume(0, start);

		if (ans < 0)
			System.out.print("-1");
		else
			System.out.print(ans);
	}

	public static int volume(int here, int val) {
		if (val < 0 || val > max)
			return -987654321;
		if (here == n)
			return val;
		if (dp[here][val] != -1)
			return dp[here][val];

		return dp[here][val] = Math.max(volume(here + 1, val + volume[here]), volume(here + 1, val - volume[here]));
	}
}
