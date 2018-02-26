import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int row = input.nextInt();
		int column = input.nextInt();
		int map[][] = new int[row + 1][column + 1];
		int maxValue[][] = new int[row + 1][column + 1];
		int tmp[][] = new int[2][column + 2];

		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= column; j++) {
				map[i][j] = input.nextInt();
			}
		}
		input.close();

		maxValue[1][1] = map[1][1];
		for (int i = 2; i <= column; i++) {
			maxValue[1][i] = maxValue[1][i - 1] + map[1][i];
		}

		for (int i = 2; i <= row; i++) {
			tmp[0][0] = maxValue[i - 1][1];
			for (int j = 1; j <= column; j++)
				tmp[0][j] = Math.max(tmp[0][j - 1], maxValue[i - 1][j]) + map[i][j];

			tmp[1][column + 1] = maxValue[i - 1][column];
			for (int j = column; j >= 1; j--)
				tmp[1][j] = Math.max(tmp[1][j + 1], maxValue[i - 1][j]) + map[i][j];

			for (int j = 1; j <= column; j++)
				maxValue[i][j] = Math.max(tmp[0][j], tmp[1][j]);
		}
		System.out.println(maxValue[row][column]);
	}
}
