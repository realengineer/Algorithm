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
			int dir;

			Point(int x, int y, int dir) {
				this.x = x;
				this.y = y;
				this.dir = dir;
			}
		}

		int[] moveX = { 1, -1, 0, 0 };
		int[] moveY = { 0, 0, 1, -1 };

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = in.readLine().split(" ");
		int n = Integer.parseInt(arr[0]);
		int m = Integer.parseInt(arr[1]);
		String[][] map = new String[n + 1][m + 1];
		int rx = 0, ry = 0, bx = 0, by = 0, ox = 0, oy = 0;

		for (int i = 1; i <= n; i++) {
			String[] arr2 = in.readLine().split("");
			for (int j = 1; j <= m; j++) {
				map[i][j] = arr2[j - 1];
				if (map[i][j].equals("R")) {
					rx = i;
					ry = j;
				}
				if (map[i][j].equals("O")) {
					ox = i;
					oy = j;
				}
				if (map[i][j].equals("B")) {
					bx = i;
					by = j;
				}
			}
		}
		int startDir = 0;
		for (int j = 0; j < 4; j++) {
			int nx = rx + moveX[j];
			int ny = ry + moveY[j];

			if (map[nx][ny].equals("."))
				startDir = j;
		}
		int[][] visited = new int[n + 1][m + 1];
		Queue<Point> queue = new LinkedList<Point>();
		Point p = new Point(rx, ry, startDir);
		queue.offer(p);
		visited[p.x][p.y] = 1;
		int result = 0;
		int nx = 0, ny = 0;
		boolean check = false;
		for (int i = 0; i < 4; i++) {
			nx = rx + moveX[i];
			ny = ry + moveY[i];

			if (nx <= 1 || nx >= n || ny <= 1 || ny >= m) {
				continue;
			}

			if (map[nx][ny].equals("O")) {
				check = true;
				result++;
				break;
			}
		}
		if (!check) {
			result++;
			while (!queue.isEmpty()) {
				Point start = queue.poll();
				//System.out.println(start.x + " " + start.y + " " + start.dir);
				if (map[start.x + moveX[start.dir]][start.y + moveY[start.dir]].equals("O"))
					break;
				if (!map[start.x + moveX[start.dir]][start.y + moveY[start.dir]].equals(".")) {
					for (int i = 0; i < 4; i++) {
						nx = start.x + moveX[i];
						ny = start.y + moveY[i];

						if (nx <= 1 || nx >= n || ny <= 1 || ny >= m) {
							continue;
						}
						if ((map[nx][ny].equals(".") || map[nx][ny].equals("O")) && visited[nx][ny] == 0) {
							visited[nx][ny] = visited[start.x][start.y] + 1;
							Point next = new Point(nx, ny, i);
							queue.offer(next);
							if (i != start.dir)
								result++;
						}

					}
				} else {
					nx = start.x + moveX[start.dir];
					ny = start.y + moveY[start.dir];
					if (nx <= 1 || nx >= n || ny <= 1 || ny >= m) {
						continue;
					}
					if ((map[nx][ny].equals(".") || map[nx][ny].equals("O")) && visited[nx][ny] == 0) {
						visited[nx][ny] = visited[start.x][start.y] + 1;
						Point next = new Point(nx, ny, start.dir);
						queue.offer(next);
					}
				}
			}
		}
		System.out.println(result);
	}
}
