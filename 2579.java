import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(in.readLine());
		int[] arr = new int[size + 1];
		int[] dp = new int[size + 1];
		for (int i = 1; i <= size; i++)
			arr[i] = Integer.parseInt(in.readLine());

		dp[1] = arr[1];
		dp[2] = arr[1] + arr[2];
		dp[3] = Math.max(arr[1] + arr[3], arr[2] + arr[3]);


		for (int i = 4; i <= size; i++) {
			dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]);
		}

		// for (int i = 3; i <= size; i++) {
		// dp[i] = Math.max(dp[i - 1] + arr[i], dp[i - 2] + arr[i]);
		// }

		System.out.print(dp[size]);
	}

}
