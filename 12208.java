import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(in.readLine());

		int test = 0;
		while (test != testCase) {
			String a = in.readLine();
			String aarr[] = a.split(" ");
			int n = Integer.parseInt(aarr[0]);
			String order = aarr[1];
			test++;
			int[][] result = new int[n][n];
			if (order.equals("right")) {
				for (int i = 0; i < n; i++) {
					int count = 0;

					String b = in.readLine();
					String[] barr = b.split(" ");
					Stack<Integer> stack = new Stack<>();
					for (int j = 0; j < n; j++) {
						if (Integer.parseInt(barr[j]) != 0) {
							stack.push(Integer.parseInt(barr[j]));
						}
					}

					while (!stack.isEmpty()) {
						int number = stack.pop();
						if (stack.isEmpty()) {
							result[i][n - count - 1] = number;
							break;
						}
						if (number == stack.peek()) {
							result[i][n - count - 1] = number * 2;
							stack.pop();
							count++;
						} else {
							result[i][n - count - 1] = number;
							count++;
						}
					}
				}
			} else if (order.equals("left")) {
				for (int i = 0; i < n; i++) {
					int count = 0;

					String b = in.readLine();
					String[] barr = b.split(" ");
					Queue<Integer> queue = new LinkedList<Integer>();
					for (int j = 0; j < n; j++) {
						if (Integer.parseInt(barr[j]) != 0) {
							queue.add(Integer.parseInt(barr[j]));
						}
					}

					while (!queue.isEmpty()) {
						int number = queue.poll();
						if (queue.isEmpty()) {
							result[i][count] = number;
							break;
						}
						if (number == queue.peek()) {
							result[i][count] = number * 2;
							queue.poll();
							count++;
						} else {
							result[i][count] = number;
							count++;
						}
					}
				}
			} else {
				int[][] map = new int[n][n];
				for (int i = 0; i < n; i++) {
					String b = in.readLine();
					String[] barr = b.split(" ");
					for (int j = 0; j < n; j++) {
						map[i][j] = Integer.parseInt(barr[j]);
					}
				}
				if (order.equals("up")) {

					for (int i = 0; i < n; i++) {
						int count = 0;
						Queue<Integer> queue = new LinkedList<Integer>();
						for (int j = 0; j < n; j++) {
							if (map[j][i] != 0) {
								queue.add(map[j][i]);
							}
						}

						while (!queue.isEmpty()) {
							int number = queue.poll();
							if (queue.isEmpty()) {
								result[count][i] = number;
								break;
							}
							if (number == queue.peek()) {
								result[count][i] = number * 2;
								queue.poll();
								count++;
							} else {
								result[count][i] = number;
								count++;
							}
						}
					}
				} else {

					for (int i = 0; i < n; i++) {
						int count = 0;
						Stack<Integer> stack = new Stack<>();
						for (int j = 0; j < n; j++) {
							if (map[j][i] != 0) {
								stack.push(map[j][i]);
							}
						}

						while (!stack.isEmpty()) {
							int number = stack.pop();
							if (stack.isEmpty()) {
								result[n - count - 1][i] = number;
								break;
							}
							if (number == stack.peek()) {
								result[n - count - 1][i] = number * 2;
								stack.pop();
								count++;
							} else {
								result[n - count - 1][i] = number;
								count++;
							}
						}
					}
				}
			}
			System.out.println("Case #" + test + ":");

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(result[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
