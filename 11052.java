import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(in.readLine());
		int[] dp = new int[num + 1];
		int[] arr = new int[num + 1];

		String input[] = in.readLine().split(" ");

		for (int i = 1; i <= num; i++)
			arr[i] = Integer.parseInt(input[i - 1]);

		dp[1] = arr[1];
		
		for (int i = 2; i <= num; i++) {
			for (int j = 1; j < i; j++) {
					dp[i] = Math.max(dp[i], dp[i - j] + arr[j]);
			}
		}
		
		System.out.print(dp[num]);
	}
}