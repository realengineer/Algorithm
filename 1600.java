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
			int knight;

			Point(int x, int y, int knight) {
				this.x = x;
				this.y = y;
				this.knight = knight;
			}
		}

		int[] knightX = { -2, -2, -1, 1, 2, 2, 1, -1 };
		int[] knightY = { -1, 1, 2, 2, 1, -1, -2, -2 };
		int[] X = { 1, -1, 0, 0 };
		int[] Y = { 0, 0, 1, -1 };

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(in.readLine());
		String[] arr = in.readLine().split(" ");
		int n = Integer.parseInt(arr[1]);
		int m = Integer.parseInt(arr[0]);
		int[][] map = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			String[] arr2 = in.readLine().split(" ");
			for (int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(arr2[j - 1]);
			}
		}
		boolean check = false;
		int[][] result = new int[n + 1][m + 1];
		int[][][] visited = new int[n + 1][m + 1][k + 1];
		Queue<Point> queue = new LinkedList<Point>();

		Point p = new Point(1, 1, k);
		queue.offer(p);
		visited[p.x][p.y][k] = 1;

		while (!queue.isEmpty()) {
			Point start = queue.poll();

			if (start.x == n && start.y == m) {
				System.out.print(result[start.x][start.y]);
				check = true;
				break;
			}

			for (int j = 0; j < 4; j++) {
				int nx = start.x + X[j];
				int ny = start.y + Y[j];

				if (nx < 1 || nx > n || ny < 1 || ny > m) {
					continue;
				}

				if (map[nx][ny] == 0 && visited[nx][ny][start.knight] == 0) {
					visited[nx][ny][start.knight] = 1;
					result[nx][ny] = result[start.x][start.y] + 1;
					Point next = new Point(nx, ny, start.knight);
					queue.offer(next);
				}

			}

			if (start.knight != 0) {
				for (int j = 0; j < 8; j++) {
					int nx = start.x + knightX[j];
					int ny = start.y + knightY[j];

					if (nx < 1 || nx > n || ny < 1 || ny > m) {
						continue;
					}

					if (map[nx][ny] == 0 && visited[nx][ny][start.knight - 1] == 0) {
						visited[nx][ny][start.knight - 1] = 1;
						result[nx][ny] = result[start.x][start.y] + 1;
						Point next = new Point(nx, ny, start.knight - 1);
						queue.offer(next);
					}
				}
			}
		}
		if (!check)
			System.out.print(-1);

	}
}
