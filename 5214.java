import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = in.readLine().split(" ");
		int n = Integer.parseInt(arr[0]);
		int k = Integer.parseInt(arr[1]);
		int m = Integer.parseInt(arr[2]);
		int i, j, nn;

		Node[] N = new Node[n + m + 1];
		for (i = 1; i <= n + m; i++)
			N[i] = new Node();
		for (i = 1; i <= m; i++) {
			arr = in.readLine().split(" ");
			for (j = 0; j < k; j++) {
				nn = Integer.parseInt(arr[j]);
				N[nn].adj.add(n + i);
				N[n + i].adj.add(nn);
			}
		}
		int[] visited = new int[200000];
		Queue<Integer> q = new LinkedList<Integer>();

		q.offer(1);
		visited[1] = 1;
		boolean check = false;
		while (!q.isEmpty()) {
			int start = q.poll();

			if (start == n) {
				System.out.println(visited[start] + "");
				check = true;
				return;
			}
			for (int next : N[start].adj) {
				if (visited[next] != 0)
					continue;
				// next > n ==> 하이퍼튜브, 역에서 하이퍼튜브로 이동할 때는 경로+1
				// next <= n ==> 역, 하이퍼튜브에서 역으로 이동할 떄는 경로+0
				if (next > n)
					visited[next] = visited[start];
				else
					visited[next] = visited[start] + 1;
				q.offer(next);
			}
		}
		if (!check)
			System.out.print(-1);
	}
}

class Node { // 인접 쌍 클래스

	ArrayList<Integer> adj;

	Node() {
		adj = new ArrayList<Integer>();
	}
}
