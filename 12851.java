import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
	int x;
	int y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = in.readLine().split(" ");
		int n = Integer.parseInt(arr[0]);
		int k = Integer.parseInt(arr[1]);
		int[] count = new int[200001];
		int[] visited = new int[200001];
		Queue<Pair> q = new LinkedList<Pair>();

		Pair p = new Pair(0, n);
		q.offer(p);
		visited[n] = 1;
		int min = Integer.MAX_VALUE;
		if (n == k){
			System.out.println(0);
			System.out.print(1);
		}else {
			while (!q.isEmpty()) {
				Pair start = q.poll();
				int now = start.y;
				int cost = start.x;

				visited[now] = 1;

				if (now == k){
					min = Math.min(min, cost);
					count[cost]++;
					continue;
				}
				if (now * 2 <= 100000 && now * 2 >= 0 && visited[now * 2] == 0) {
					Pair pair = new Pair(cost + 1, now * 2);
					q.offer(pair);
				}
				if (now - 1 >= 0 && now - 1 <= 100000 && visited[now - 1] == 0) {
					Pair pair = new Pair(cost + 1, now - 1);
					q.offer(pair);
				}
				if (now + 1 <= 100000 && now + 1 >= 0 && visited[now + 1] == 0) {
					Pair pair = new Pair(cost + 1, now + 1);
					q.offer(pair);
				}
			}
			System.out.println(min);
			System.out.print(count[min]);
		}
	}

}