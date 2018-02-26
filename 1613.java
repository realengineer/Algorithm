import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static int map[][], n, m;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String a = in.readLine();
		String[] aarr = a.split(" ");
		n = Integer.parseInt(aarr[0]);
		m = Integer.parseInt(aarr[1]);
		map = new int[n + 1][n + 1];

		String line[];
		for (int i = 0; i < m; i++) {
			line = in.readLine().split(" ");
			map[Integer.parseInt(line[0])][Integer.parseInt(line[1])] = 1;
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (map[i][k] == 1 && map[k][j] == 1)
						map[i][j] = 1;
				}
			}
		}

		int count = Integer.parseInt(in.readLine());
		for (int i = 0; i < count; i++) {
			line = in.readLine().split(" ");
			if (map[Integer.parseInt(line[0])][Integer.parseInt(line[1])] == 1)
				System.out.println(-1);
			else if (map[Integer.parseInt(line[1])][Integer.parseInt(line[0])] == 1)
				System.out.println(1);
			else
				System.out.println(0);
		}
		in.close();
	}

}
