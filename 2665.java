import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

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

		int[][] map = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			String[] arr2 = in.readLine().split("");
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(arr2[j - 1]);
			}
		}
		int[][] visited = new int[n + 1][n + 1];
		Deque<Point> queue = new LinkedList<Point>();

		Point p = new Point(1, 1);
		queue.offer(p);
		visited[p.x][p.y] = 1;
		while (!queue.isEmpty()) {
			Point start = queue.poll();

			for (int j = 0; j < 4; j++) {
				int nx = start.x + moveX[j];
				int ny = start.y + moveY[j];
				if (nx < 1 || nx > n || ny < 1 || ny > n) {
					continue;
				}

				if (map[nx][ny] == 1 && visited[nx][ny] == 0) {
					visited[nx][ny] = visited[start.x][start.y];
					Point next = new Point(nx, ny);
					queue.addFirst(next);
				}
				if (map[nx][ny] == 0 && visited[nx][ny] == 0) {
					visited[nx][ny] = visited[start.x][start.y] + 1;
					Point next = new Point(nx, ny);
					queue.addLast(next);
				}
			}
		}
		System.out.print(visited[n][n]-1);
	}
}