import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int size = input.nextInt();
		int[] array = new int[1001];
		int[] dp = new int[1001];
		for (int i = 1; i <= size; i++) {
			array[i] = input.nextInt();
		}

		for (int i = 1; i <= size; i++) {
			dp[i] = 1;
			for (int j = 1; j < i; j++) {
				if (array[i] > array[j] && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
				}
			}

		}
		
		int max = 0;
		for (int i = 1; i <= size; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.print(max);
		input.close();
	}
}