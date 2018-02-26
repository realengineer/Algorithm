import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static boolean[] visit;
	static int n, m;
	static int[][] matrix;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str[] = in.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		visit = new boolean[n+1];
		matrix = new int[n+1][n+1];
		for (int i = 0; i < m; i++) {
			String str2[] = in.readLine().split(" ");
			matrix[Integer.parseInt(str2[0])][Integer.parseInt(str2[1])] = 1;
			matrix[Integer.parseInt(str2[1])][Integer.parseInt(str2[0])] = 1;
		}

		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (!visit[i]) {
				count++;
				dfs(i);
			}
		}

		System.out.print(count);
	}

	public static void dfs(int x) {
		visit[x] = true;
		for (int i = 1; i <= n; i++) {
			if (matrix[x][i] == 1 && !visit[i]) {
				dfs(i);
			}
		}
	}
}