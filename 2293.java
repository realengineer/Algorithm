import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int coinCount = sc.nextInt();
		int cost = sc.nextInt();
		int[] coin = new int[coinCount + 1];
		int[] dp = new int[cost + 1];
		
		for(int i = 1; i <= coinCount; i++)
			coin[i] = sc.nextInt();
		
		dp[0] = 1;
		for (int i = 1; i <= coinCount; ++i) {
			for (int j = 1; j <= cost; ++j) {
				if (j  >= coin[i])
					dp[j] += dp[j - coin[i]];
			}
		}
		
		System.out.print(dp[cost]);
	}
}
