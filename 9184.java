import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][][] dp = new int[21][21][21];
	public static final int[] dx = {0, 0, 0, -1, 1 };
	public static final int[] dy = {0, 1, -1, 0, 0 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

		int[][][] dp = new int[22][22][22];;

		for (int i = 0; i <= 20; i++){
			for (int j = 0; j <= 20; j++){
				for (int k = 0; k <= 20; k++){
					if (i == 0 || j == 0 || k == 0)
						dp[i][j][k] = 1;
					else
						dp[i][j][k] = 0;
				}
			}
		}
		for (int i = 1; i <= 20; i++){
			for (int j = 1; j <= 20; j++){
				for (int k = 1; k <= 20; k++){
					if (i < j && j < k)
						dp[i][j][k] = dp[i][j][k - 1] + dp[i][j - 1][k - 1] - dp[i][j - 1][k];
					else
						dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1] - dp[i - 1][j - 1][k - 1];
				}
			}
		}
		
		while (true) {
			String str = sc.readLine();
			String[] arr = str.split(" ");
			int i = Integer.parseInt(arr[0]);
			int j = Integer.parseInt(arr[1]);
			int k = Integer.parseInt(arr[2]);

			if (i == -1 && j == -1 && k == -1){
				break;
			}else if (i <= 0 || j <= 0 || k <= 0){
				System.out.println("w(" + i + ", " + j + ", " + k + ")" + " = 1");
			}
			else if (i > 20 || j > 20 || k > 20){
				System.out.println("w(" + i + ", " + j + ", " + k + ")" + " = " + dp[20][20][20]);
			}
			else
				System.out.println("w(" + i + ", " + j + ", " + k + ")" + " = " + dp[i][j][k]);
		}
	}
}

