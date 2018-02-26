
//알고스팟-다익스트
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static int map[][], column, row;
	public static final int[] dx = { 0, 0, -1, 1 };
	public static final int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int i, j;
		String line = in.readLine();
		String[] arr = line.split(" ");
		column = Integer.parseInt(arr[0]);
		row = Integer.parseInt(arr[1]);
		map = new int[row + 1][column + 1];
		for (i = 0; i < row; i++) {
			line = in.readLine();
			for (j = 0; j < column; j++)
				map[i][j] = Integer.parseInt(line.substring(j, j + 1));
		}
		System.out.print(String.valueOf(dijkstra(0, 0)));
		in.close();
	}

	private static int dijkstra(int s, int e) {
		int dist[][] = new int[102][102];
		init(dist, Integer.MAX_VALUE);
		dist[s][e] = map[s][e];
		PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
			public int compare(Point o1, Point o2) {
				return Integer.compare(o1.w, o2.w);
			}
		});

		pq.offer(new Point(s, e, dist[s][e]));
		int i, x, y, w, ax, ay;
		while (!pq.isEmpty()) {
			x = pq.peek().x;
			y = pq.peek().y;
			w = pq.poll().w;
			for (i = 0; i < 4; i++) {
				ax = x + dx[i];
				ay = y + dy[i];
				if (isInRange(ax, ay)) {
					if (w + map[ax][ay] < dist[ax][ay]) {
						dist[ax][ay] = w + map[ax][ay];
						pq.offer(new Point(ax, ay, dist[ax][ay]));
					}
				}
			}
		}
		return dist[row - 1][column - 1];
	}

	private static void init(int map[][], int val) {
		for (int i = 0; i < row; i++)
			for (int j = 0; j < column; j++)
				map[i][j] = val;
	}

	private static boolean isInRange(int x, int y) {
		return (0 <= x && x < row) && (0 <= y && y < column);
	}
}

class Point {
	int x, y, w;

	public Point(int x, int y, int w) {
		this.x = x;
		this.y = y;
		this.w = w;
	}
}
