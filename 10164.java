import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String[] inputArray;
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();

		inputArray = input.split(" ");

		int[][] table = new int[16][16];

		for (int n = 0; n < 15; n++) {
			table[0][n] = 1;
			table[n][0] = 1;
		}

		for (int i = 1; i < 15; i++) {
			for (int j = 1; j < 15; j++) {
				table[i][j] = table[i][j - 1] + table[i - 1][j];
			}
		}
		
		if (Integer.parseInt(inputArray[2]) != 0) {
			int a = ((Integer.parseInt(inputArray[2]) - 1) / Integer.parseInt(inputArray[1])) + 1;
			int b = ((Integer.parseInt(inputArray[2]) - 1) % Integer.parseInt(inputArray[1])) + 1;

			System.out.print(table[a - 1][b - 1]
					* table[(Integer.parseInt(inputArray[1]) - b)][(Integer.parseInt(inputArray[0]) - a)]);
		} else {
			System.out.print(table[Integer.parseInt(inputArray[0]) - 1][Integer.parseInt(inputArray[1]) - 1]);
		}
		scan.close();
	}
}