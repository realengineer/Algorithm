import java.util.Scanner;

public class Main {
	static int[] number;
	static int[][] dp;

	public static void main(String args[]) {

		Scanner input = new Scanner(System.in);
		int n = input.nextInt();

		number = new int[n + 1];
		dp = new int[n + 1][n + 1];

		for (int i = 1; i < n + 1; i++) {
			number[i] = input.nextInt();
		}

		input.close();
		
		System.out.print(palindrome(1, n));
	}

	public static int palindrome(int a, int b) {
		if (a >= b) // 정중앙 두개가 같을때 0 리턴 
			return 0;
		if (number[a] == number[b])
			return palindrome(a + 1, b - 1);

		return dp[a][b] = Math.min(palindrome(a + 1, b) + 1, palindrome(a, b - 1) + 1);
	}
}