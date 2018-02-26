import java.util.Scanner;

public class Main { //메모

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int row = input.nextInt();
		int column = input.nextInt();

		int[][] map = new int[row+1][column+1];

		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= column; j++)
				map[i][j] = input.nextInt();
		}
		input.close();
		
		for(int i = 1; i <= row; i ++) {
			for(int j = 1; j <= column; j++){
				map[i][j] = Math.max(map[i-1][j], Math.max(map[i-1][j-1], map[i][j-1])) + map[i][j];
			}
		}
		System.out.print(map[row][column]);
	}

}
