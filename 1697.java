import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = in.readLine().split(" ");
		int n = Integer.parseInt(arr[0]);
		int k = Integer.parseInt(arr[1]);

		int[] visited = new int[111111];
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.offer(n);
		visited[n] = 1;

		int next = 0;
		int x = 0;
		if (n == k)
			System.out.print(0);
		else {
			while (true) {
				int start = queue.poll();

				x = start + 1;
				if (x >= 0 && x <= 100000) {
					if (visited[x] == 0) {
						visited[x] = visited[start] + 1;
						if (x == k)
							break;
						next = x;
						queue.offer(next);
					}
				}

				x = start - 1;
				if (x >= 0 && x <= 100000) {
					if (visited[x] == 0) {
						visited[x] = visited[start] + 1;
						if (x == k)
							break;
						next = x;
						queue.offer(next);
					}
				}

				x = start * 2;

				if (x >= 0 && x <= 100000) {
					if (visited[x] == 0) {
						visited[x] = visited[start] + 1;
						if (x == k)
							break;
						next = x;
						queue.offer(next);
					}

				}
			}
			System.out.print(visited[k]-1);
		}
	}

}
