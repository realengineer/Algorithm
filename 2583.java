import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer token = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());
		int k = Integer.parseInt(token.nextToken());
		boolean visit[][] = new boolean[n][m];

		int[][] map = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = 1;
			}
		}

		for (int i = 0; i < k; i++) {
			token = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(token.nextToken());
			int y1 = Integer.parseInt(token.nextToken());
			int x2 = Integer.parseInt(token.nextToken());
			int y2 = Integer.parseInt(token.nextToken());
			for (int p = y1; p < y2; p++) {
				for (int q = x1; q < x2; q++) {
					map[p][q] = 0;
				}
			}
		}

//		for (int i = 0; i < n; i++) {
//			System.out.println();
//			for (int j = 0; j < m; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//		}
		Queue<Point> queue = new LinkedList<Point>();

		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		int cx = 0, cy = 0;
		int nx = 0, ny = 0;

		int cnt = 0;
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 0 && !visit[i][j]) {
					int sum = 1;
					cnt++;
					queue.offer(new Point(i, j));
					visit[i][j] = true;
					
					while (!queue.isEmpty()) {
						cx = queue.peek().x;
						cy = queue.poll().y;

						for (int d = 0; d < 4; d++) {
							nx = cx + dx[d];
							ny = cy + dy[d];

							if (nx < 0 || nx >= n || ny < 0 || ny >= m)
								continue;
							if (!visit[nx][ny] && map[nx][ny] != 0) {
								visit[nx][ny] = true;
								queue.offer(new Point(nx, ny));
								sum++;
							}
						}
					} // end queue while
					res.add(sum);
				}
			} // end j
		} // end i
		Collections.sort(res);
		System.out.println(cnt);
		for (int a : res)
			System.out.print(a + " ");
	} // end while

}
