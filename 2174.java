import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		class Pair {
			int x;
			int y;
			int dir;

			Pair(int x, int y, int dir) {
				this.x = x;
				this.y = y;
				this.dir = dir;
			}
		}

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(in.readLine());

		String[] arr = in.readLine().split(" ");
		int a = Integer.parseInt(arr[0]);
		int b = Integer.parseInt(arr[1]);
		arr = in.readLine().split(" ");
		int n = Integer.parseInt(arr[0]);
		int m = Integer.parseInt(arr[1]);
		LinkedList<Pair> list = new LinkedList<Pair>();
		for (int i = 1; i <= n; i++) {
			arr = in.readLine().split(" ");
			Pair pair;
			if (arr[2].equals("E")) {
				pair = new Pair(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), 1);
				list.add(pair);
			}
			if (arr[2].equals("W")) {
				pair = new Pair(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), 2);
				list.add(pair);
			}
			if (arr[2].equals("S")) {
				pair = new Pair(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), 3);
				list.add(pair);
			}
			if (arr[2].equals("N")) {
				pair = new Pair(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), 4);
				list.add(pair);
			}
		}
		boolean check = false;
		Loop : for (int i = 0; i < m; i++) {
			arr = in.readLine().split(" ");
			for (int j = 0; j < Integer.parseInt(arr[2]); j++) {
				Pair next = new Pair(0,0,0);
				Pair start = list.get(Integer.parseInt(arr[0]) - 1);
				if (arr[1].equals("F") && start.dir == 1) {
					next = new Pair(start.x + 1, start.y, start.dir);
					list.remove(Integer.parseInt(arr[0]) - 1);
					list.add(Integer.parseInt(arr[0]) - 1, next);
				}
				if (arr[1].equals("F") && start.dir == 2) {
					next = new Pair(start.x - 1, start.y, start.dir);
					list.remove(Integer.parseInt(arr[0]) - 1);
					list.add(Integer.parseInt(arr[0]) - 1, next);
				}
				if (arr[1].equals("F") && start.dir == 3) {
					next = new Pair(start.x, start.y - 1, start.dir);
					list.remove(Integer.parseInt(arr[0]) - 1);
					list.add(Integer.parseInt(arr[0]) - 1, next);
				}
				if (arr[1].equals("F") && start.dir == 4) {
					next = new Pair(start.x, start.y + 1, start.dir);
					list.remove(Integer.parseInt(arr[0]) - 1);
					list.add(Integer.parseInt(arr[0]) - 1, next);
				}
				if (arr[1].equals("L") && start.dir == 1) {
					next = new Pair(start.x, start.y, 4);
					list.remove(Integer.parseInt(arr[0]) - 1);
					list.add(Integer.parseInt(arr[0]) - 1, next);
				}
				if (arr[1].equals("L") && start.dir == 2) {
					next = new Pair(start.x, start.y, 3);
					list.remove(Integer.parseInt(arr[0]) - 1);
					list.add(Integer.parseInt(arr[0]) - 1, next);
				}
				if (arr[1].equals("L") && start.dir == 3) {
					next = new Pair(start.x, start.y, 1);
					list.remove(Integer.parseInt(arr[0]) - 1);
					list.add(Integer.parseInt(arr[0]) - 1, next);
				}
				if (arr[1].equals("L") && start.dir == 4) {
					next = new Pair(start.x, start.y, 2);
					list.remove(Integer.parseInt(arr[0]) - 1);
					list.add(Integer.parseInt(arr[0]) - 1, next);
				}
				if (arr[1].equals("R") && start.dir == 1) {
					next = new Pair(start.x, start.y, 3);
					list.remove(Integer.parseInt(arr[0]) - 1);
					list.add(Integer.parseInt(arr[0]) - 1, next);
				}
				if (arr[1].equals("R") && start.dir == 2) {
					next = new Pair(start.x, start.y, 4);
					list.remove(Integer.parseInt(arr[0]) - 1);
					list.add(Integer.parseInt(arr[0]) - 1, next);
				}
				if (arr[1].equals("R") && start.dir == 3) {
					next = new Pair(start.x, start.y, 2);
					list.remove(Integer.parseInt(arr[0]) - 1);
					list.add(Integer.parseInt(arr[0]) - 1, next);
				}
				if (arr[1].equals("R") && start.dir == 4) {
					next = new Pair(start.x, start.y, 1);
					list.remove(Integer.parseInt(arr[0]) - 1);
					list.add(Integer.parseInt(arr[0]) - 1, next);
				}
				if(next.x < 1 || next.y < 1 || next.x > a || next.y >b){
					System.out.println("Robot " + arr[0] + " crashes into the wall");
					check = true;
					break Loop;
				}
				for(int k = 0; k < n; k++){
					if(k != Integer.parseInt(arr[0])-1){
						if(next.x == list.get(k).x && next.y == list.get(k).y){
							System.out.println("Robot " + arr[0] + " crashes into robot " + (k+1));
							check = true;
							 break Loop;
						}
					}
				}
				if(check == true)
					break;
			}
		}
		if(!check)
			System.out.println("OK");
	}
}
