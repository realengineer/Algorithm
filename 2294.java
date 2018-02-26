import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] input = in.readLine().split(" ");
		int num = Integer.parseInt(input[0]);
		int cost = Integer.parseInt(input[1]);

		int coin[] = new int[num + 1];
		int dp[] = new int[cost + 1];

		for (int i = 1; i <= num; i++)
			coin[i] = Integer.parseInt(in.readLine());

		for (int i = 1; i <= cost; i++)
			dp[i] = 100001;

		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= cost; j++) {
				if (j - coin[i] >= 0)
					dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1); //최소땐 최대값 넣어주기 
			}
		}

		if (dp[cost] == 100001)
			System.out.print(-1);
		else
			System.out.println(dp[cost]);
	}
}
