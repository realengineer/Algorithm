import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(in.readLine());
		int[] input = new int[num + 1];
		String str[] = in.readLine().split(" ");
		for (int i = 1; i <= num; i++)
			input[i] = Integer.parseInt(str[i - 1]);

		System.out.print(Jump(input, num));
	}

	public static int Jump(int[] arr, int num) {
		int[] dp = new int[num + 1];
		dp[1] = 1;
		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= arr[i]; j++) {
				if (i + j <= num && dp[i] != 0)
					dp[i + j] = dp[i] + 1;
			}
		}

		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= arr[i]; j++) {
				if (i + j <= num)
					dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
			}
		}

		if (num == 1)
			return 0;
		else if (dp[num] == 0)
			return -1;
		else
			return dp[num] - 1;
	}
}
