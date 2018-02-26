import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

		int[] visited = new int[111111];
		Queue<Pair> q = new LinkedList<Pair>();

		Pair p = new Pair(0, n);
		q.offer(p);
		visited[n] = 1;
		int min = Integer.MAX_VALUE;
		int[] where = new int[111111];
		if (n == k) {
			System.out.println(0);
			System.out.print(n);
		} else {
			while (true) {
				Pair start = q.poll();
				int now = start.y;
				int cost = start.x;

				if (now == k) {
					min = Math.min(min, cost);
					System.out.println(min);
					break;
				}

				if (now * 2 <= 100000 && now * 2 >= 0 && visited[now * 2] == 0) {
					Pair pair = new Pair(cost + 1, now * 2);
					where[now * 2] = now;
					visited[now * 2] = 1;
					q.offer(pair);
				}
				if (now - 1 >= 0 && now - 1 <= 100000 && visited[now - 1] == 0) {
					Pair pair = new Pair(cost + 1, now - 1);
					visited[now - 1] = 1;
					where[now - 1] = now;
					q.offer(pair);
				}
				if (now + 1 <= 100000 && now + 1 >= 0 && visited[now + 1] == 0) {
					Pair pair = new Pair(cost + 1, now + 1);
					visited[now + 1] = 1;
					where[now + 1] = now;
					q.offer(pair);
				}
			}

			Stack<Integer> s = new Stack<>();
			s.add(k);
			while (where[k] != n) {
				k = where[k];
				s.add(k);
			}
			s.add(n);
			
			while (!s.isEmpty())
				System.out.print(s.pop() + " ");
		}
	}
}