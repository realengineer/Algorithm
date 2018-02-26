import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		String[] str;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		str = in.readLine().split(" ");
		int x = Integer.parseInt(str[0]);
		int y = Integer.parseInt(str[1]);
		int m = Integer.parseInt(in.readLine());
		int[][] map = new int[n + 1][n + 1];

		for (int i = 0; i < m; i++) {
			str = in.readLine().split(" ");
			map[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = 1;
			map[Integer.parseInt(str[1])][Integer.parseInt(str[0])] = 1;
		}

		int visited[] = new int[n + 1];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(x);

		while (!queue.isEmpty()) {
			int next = queue.poll();

			for (int i = 1; i <= n; i++) {
				if (map[next][i] == 1 && visited[i] == 0) {
					visited[i] = visited[next] + 1;
					queue.add(i);
				}
			}
		}
		
		if (visited[y] == 0)
			System.out.print(-1);
		else
			System.out.print(visited[y]);
	}

}
