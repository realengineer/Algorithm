import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {

		class Point {
			int x;
			int y;

			Point(int x, int y) {
				this.x = x;
				this.y = y;
			}
		}

		int[] moveX = { 1, -1, 0, 0 };
		int[] moveY = { 0, 0, 1, -1 };

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = in.readLine().split(" ");
		int n = Integer.parseInt(arr[0]);
		int m = Integer.parseInt(arr[1]);

		int[][] map = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			String[] arr2 = in.readLine().split("");
			for (int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(arr2[j - 1]);
			}
		}
		int[][] visited = new int[n + 1][m + 1];
		Queue<Point> queue = new LinkedList<Point>();

		Point p = new Point(1, 1);
		queue.offer(p);
		visited[p.x][p.y] = 1;

		while (!queue.isEmpty()) {
			Point start = queue.poll();

			for (int j = 0; j < 4; j++) {
				int nx = start.x + moveX[j];
				int ny = start.y + moveY[j];

				if (nx < 1 || nx > n || ny < 1 || ny > m) {
					continue;
				}

				if (map[nx][ny] == 1 && visited[nx][ny] == 0) {
					visited[nx][ny] = visited[start.x][start.y] + 1;
					Point next = new Point(nx, ny);
					queue.offer(next);
				}
			}
		}
		System.out.print(visited[n][m]);
	}
}
