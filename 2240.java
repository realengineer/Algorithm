import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int second = Integer.parseInt(s[0]);
		int move = Integer.parseInt(s[1]);
		int[] tree = new int[second + 1];
		for (int i = 1; i <= second; i++) {
			String str = br.readLine();
			tree[i] = Integer.parseInt(str);
		}

		int[][][] dp = new int[3][second + 1][move + 1];						
		
		for (int i = 1; i <= second; i++) {
			for (int j = 1; j <= move + 1; j++) { //0일때가 포함이 안돼서 
				if (tree[i] == 1) {
					dp[1][i][j] = Math.max(dp[1][i - 1][j], dp[2][i - 1][j - 1]) + 1;
					dp[2][i][j] = Math.max(dp[1][i - 1][j - 1], dp[2][i - 1][j]);
				} else {
					dp[1][i][j] = Math.max(dp[1][i - 1][j], dp[2][i - 1][j - 1]);
					dp[2][i][j] = Math.max(dp[1][i - 1][j - 1], dp[2][i - 1][j]) + 1;
				}
			}
		}
		
		int max = 0;
		for (int i = 1; i <= move + 1; i++)
			max = Math.max(dp[1][second][i], dp[2][second][i]);
		System.out.println(max);
	}

}