import java.util.Scanner;

public class Main {
	public static int row;
	public static int column;
	public static int[][] map = new int[502][502];
	public static int[][] DP = new int[502][502];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		row = sc.nextInt();
		column = sc.nextInt();
		
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= column; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		DP[1][1] = 1;

		sc.close();
		System.out.print(dp(row, column));
	}

	public static int dp(int i, int j) {

		if (DP[i][j] != 0)
			return DP[i][j];
		if (i > row || i<=0 || j > column || j<= 0)
			return 0;
		
		if (map[i - 1][j] > map[i][j])
			DP[i][j] += dp(i - 1, j);
		if (map[i][j + 1] > map[i][j])
			DP[i][j] += dp(i, j + 1);
		if (map[i + 1][j] > map[i][j])
			DP[i][j] += dp(i + 1, j);
		if (map[i][j - 1] > map[i][j])
			DP[i][j] += dp(i, j - 1);
		
		return DP[i][j];
		}
	}
