import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int size = input.nextInt();
		int[] word = new int[2009];
		int[][] dp = new int[2009][2009];

		for (int i = 1; i <= size; i++) {
			word[i] = input.nextInt();
		}

		int number = input.nextInt();

		int[] inputArray = new int[2 * number + 1];

		for (int i = 0; i < number * 2; i++) {
			inputArray[i] = input.nextInt();
		}

		for (int i = size; i >= 1; i--) {
			for (int j = i; j <= size; j++) {
				if (i == j)
					dp[i][j] = 1;
				else if (i == j - 1 && word[i] == word[j])
					dp[i][j] = 1;
				else if (dp[i + 1][j - 1] == 1 && word[i] == word[j])
					dp[i][j] = 1;
				else
					dp[i][j] = 0;
			}
		}

		for (int i = 0; i < number; i++) {
			System.out.println(dp[inputArray[2*i]][inputArray[2*i+1]]);
		}
		
		input.close();

	}
}
