import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	static int INF = 100000001; // 무한대 값

		public static void main(String[] args) throws Exception {
			BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

			String read[] = sc.readLine().split(" ");
			int i, from, to, way, maxDist = 0;
			int vert = Integer.parseInt(read[0]);
			int line = Integer.parseInt(read[1]);
			int arrival = Integer.parseInt(read[2]) - 1;

			int[][] map = new int[vert][vert], revMap = new int[vert][vert];
			int[] dist = new int[vert], revDist = new int[vert];

			for (i = 0; i < vert; i++) {
				dist[i] = revDist[i] = INF;
				for (int j = 0; j < vert; j++) {
					map[i][j] = revMap[i][j] = INF;
				}
			}

			for (i = 0; i < line; i++) {
				read = sc.readLine().split(" ");
				from = Integer.parseInt(read[0]) - 1;
				to = Integer.parseInt(read[1]) - 1;
				way = Integer.parseInt(read[2]);
				map[from][to] = revMap[to][from] = way;
			}

			dijkstra(arrival, map, dist, vert); // 목적지에서 각 마을로 가는 최단 거리 탐색
			dijkstra(arrival, revMap, revDist, vert); // 각 마을에서 목적지로 돌아오는 최단 거리 탐색

			for (i = 0; i < vert; i++) // 최대값 탐색
				if (maxDist < dist[i] + revDist[i])
					maxDist = dist[i] + revDist[i];

			System.out.print(String.valueOf(maxDist));
			sc.close();
		}

		private static void dijkstra(int start, int map[][], int dist[], int vert) {
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			pq.offer(start);
			map[start][start] = 0;
			dist[start] = 0;

			while (!pq.isEmpty()) {
				int arrival = pq.poll();
				for (int i = 0; i < vert; i++)
					if (dist[i] > map[arrival][i] + dist[arrival]) {
						dist[i] = map[arrival][i] + dist[arrival];
						pq.offer(i);
					}
			}
		}

}
