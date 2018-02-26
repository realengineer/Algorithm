import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[][] map = new int[size + 1][size + 1];
		int[][] newMap = new int[size + 1][size + 1];

		long[][] dp = new long[size + 1][size + 1];
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		sc.close();
		newMap[1][1] = map[1][1];
		dp[1][1] = 1;
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				if (newMap[i][j] != 0) {
					if (j + map[i][j] <= size) {
						newMap[i][j + map[i][j]] = map[i][j + map[i][j]];
						dp[i][j + map[i][j]] += dp[i][j];
					}
					if (i + map[i][j] <= size) {
						newMap[i + map[i][j]][j] = map[i + map[i][j]][j];
						dp[i + map[i][j]][j] += dp[i][j];
					}
				}
			}
		}

		System.out.print(dp[size][size]);
	}
}
