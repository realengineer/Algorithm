import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			DSLR(sc.nextInt(), sc.nextInt());
		}
	}

	public static void DSLR(int num1, int num2) {
		String[] result= new String[10001];
		Queue<Integer> queue = new LinkedList<Integer>();
		result[num1] = "";
		queue.add(num1);

		while (!queue.isEmpty()) {
			int now = queue.peek();
			String order = result[now];
			queue.poll();
			if (now == num2) {
				System.out.println(order);
				break;
			}
			if (result[(now * 2) % 10000] == null) {
				queue.add((now * 2) % 10000);
				result[(now * 2) % 10000] = order + "D";
			}
			if (result[(now + 9999) % 10000] == null) {
				queue.add((now + 9999) % 10000);
				result[(now + 9999) % 10000] = order + "S";
			}
			if (result[(now % 1000) * 10 + now / 1000] == null) {
				queue.add((now % 1000) * 10 + now / 1000);
				result[(now % 1000) * 10 + now / 1000] = order + "L";
			}
			if (result[(now % 10) * 1000 + now / 10] == null) {
				queue.add((now % 10) * 1000 + now / 10);
				result[(now % 10) * 1000 + now / 10] = order + "R";

			}
		}
	}
}
