import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		int[][] table = new int[1001][1001];

		Scanner input = new Scanner(System.in);
		String str1, str2;
		
		str1 = input.nextLine();
		str2 = input.nextLine();

		input.close();

		int maxLen = 0;
		for (int i = 1; i <= str1.length(); i++) {

			for (int j = 1; j <= str2.length(); j++) {
				if ((str1.charAt(i - 1) == str2.charAt(j - 1))) {
					table[i][j] = table[i - 1][j - 1] + 1;
					if (table[i][j] > maxLen)
						maxLen = table[i][j];

				} else 
					table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);			
			}
		} 
		System.out.print(maxLen);
	}
}
