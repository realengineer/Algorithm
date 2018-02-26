import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int arr[][] = new int[n + 1][n + 1];

		String[] str;
		for (int i = 1; i <= n; i++) {
			str = in.readLine().split(" ");
			for (int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(str[j - 1]);
			}
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (arr[i][k] == 1 && arr[k][j] == 1) {
						arr[i][j] = 1;
					}
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}