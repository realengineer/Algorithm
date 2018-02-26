import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(in.readLine());
		long dp[] = new long[1001];
		dp[1] = 1; dp[2] = 2;
		for(int i = 3; i <= num; i++)
			dp[i] = (dp[i-1] + dp[i-2]) %10007;
		
		System.out.print(dp[num]);
	}

}
