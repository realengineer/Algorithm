import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		int row = input.nextInt();
		int column = input.nextInt();

		int matrix[][] = new int[1001][1001];

		//String a[] = new String[row + 1];
		for (int i = 1; i <= row; i++) {
			String[] a = input.nextLine().split("");
			for (int j = 1; j <= column; j++)
				matrix[i][j] = Integer.parseInt(a[j-1]);
		}

		for (int i = 2; i <= row; i++) {
			for (int j = 2; j <= column; j++) {
				if (matrix[i][j] == 1)
					matrix[i][j] = Math.min(matrix[i - 1][j - 1], Math.min(matrix[i][j - 1], matrix[i - 1][j])) + 1;
			}
		}

		int max = matrix[0][0];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] > max)
					max = matrix[i][j];
			}
		}

		System.out.print(max * max);

		input.close();
	}
}
