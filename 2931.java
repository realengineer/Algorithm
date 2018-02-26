import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		class Point {
			int x;
			int y;

			Point(int x, int y) {
				this.x = x;
				this.y = y;
			}
		}

		int[] moveX = { 1, -1, 0, 0 };
		int[] moveY = { 0, 0, 1, -1 };
		int[] moveX2 = { 0, 1, 0, -1 };
		int[] moveY2 = { 1, 0, -1, 0 };
		int startN = 0, startM = 0, arrN = 0, arrM = 0;

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = in.readLine().split(" ");
		int n = Integer.parseInt(arr[0]);
		int m = Integer.parseInt(arr[1]);

		String[][] map = new String[27][27];

		for (int i = 1; i <= n; i++) {
			String[] arr2 = in.readLine().split("");
			for (int j = 1; j <= m; j++) {
				map[i][j] = arr2[j - 1];
				if (arr2[j - 1].equals("M")) {
					startN = i;
					startM = j;
				}
				if (arr2[j - 1].equals("Z")) {
					arrN = i;
					arrM = j;
				}
			}
		}

		int[][] visited = new int[27][27];
		Queue<Point> queue = new LinkedList<Point>();
		int nextN = 0;
		int nextM = 0;

		for (int j = 0; j < 4; j++) {
			int nx = startN + moveX[j];
			int ny = startM + moveY[j];

			if (nx < 1 || nx > n || ny < 1 || ny > m) {
				continue;
			}

			if (map[nx][ny].equals("|") || map[nx][ny].equals("-") || map[nx][ny].equals("+") || map[nx][ny].equals("1")
					|| map[nx][ny].equals("2") || map[nx][ny].equals("3") || map[nx][ny].equals("4")) {
				nextN = nx;
				nextM = ny;
				break;
			}
		}
		if (nextN == 0 && nextM == 0) {
			for (int j = 0; j < 4; j++) {
				int nx = arrN + moveX[j];
				int ny = arrM + moveY[j];

				if (nx < 1 || nx > n || ny < 1 || ny > m) {
					continue;
				}

				if (map[nx][ny].equals("|") || map[nx][ny].equals("-") || map[nx][ny].equals("+")
						|| map[nx][ny].equals("1") || map[nx][ny].equals("2") || map[nx][ny].equals("3")
						|| map[nx][ny].equals("4")) {
					nextN = nx;
					nextM = ny;
					break;
				}
			}
		}

		if (nextN == 0 && nextM == 0) {
			System.out.print("1 2 -");
		} else {
			Point p = new Point(nextN, nextM);
			queue.offer(p);
			visited[p.x][p.y] = 1;

			int resultN = 0;
			int resultM = 0;
			while (!queue.isEmpty()) {
				Point start = queue.poll();

				if (map[start.x][start.y].equals("+")) {
					Loop: for (int j = 0; j < 4; j++) {
						int nx = start.x + moveX[j];
						int ny = start.y + moveY[j];

						if (nx < 1 || nx > n || ny < 1 || ny > m) {
							continue;
						}

						if (!map[nx][ny].equals(".") && visited[nx][ny] == 0) {
							visited[nx][ny] = 1;
							Point next = new Point(nx, ny);
							queue.offer(next);
						}
						if (map[nx][ny].equals(".") && visited[nx][ny] == 0) {
							resultN = nx;
							resultM = ny;
							break Loop;
						}
					}
				} else if (map[start.x][start.y].equals("-")) {
					Loop: for (int j = 2; j < 4; j++) {
						int nx = start.x + moveX[j];
						int ny = start.y + moveY[j];

						if (nx < 1 || nx > n || ny < 1 || ny > m) {
							continue;
						}

						if (!map[nx][ny].equals(".") && visited[nx][ny] == 0) {
							visited[nx][ny] = 1;
							Point next = new Point(nx, ny);
							queue.offer(next);
						}
						if (map[nx][ny].equals(".") && visited[nx][ny] == 0) {
							resultN = nx;
							resultM = ny;
							break Loop;
						}
					}
				} else if (map[start.x][start.y].equals("|")) {
					Loop: for (int j = 0; j < 2; j++) {
						int nx = start.x + moveX[j];
						int ny = start.y + moveY[j];

						if (nx < 1 || nx > n || ny < 1 || ny > m) {
							continue;
						}

						if (!map[nx][ny].equals(".") && visited[nx][ny] == 0) {
							visited[nx][ny] = 1;
							Point next = new Point(nx, ny);
							queue.offer(next);
						}
						if (map[nx][ny].equals(".") && visited[nx][ny] == 0) {
							resultN = nx;
							resultM = ny;
							break Loop;
						}
					}
				} else if (map[start.x][start.y].equals("2")) {
					Loop: for (int j = 1; j < 3; j++) {
						int nx = start.x + moveX[j];
						int ny = start.y + moveY[j];

						if (nx < 1 || nx > n || ny < 1 || ny > m) {
							continue;
						}

						if (!map[nx][ny].equals(".") && visited[nx][ny] == 0) {
							visited[nx][ny] = 1;
							Point next = new Point(nx, ny);
							queue.offer(next);
						}
						if (map[nx][ny].equals(".") && visited[nx][ny] == 0) {
							resultN = nx;
							resultM = ny;
							break Loop;
						}
					}
				} else if (map[start.x][start.y].equals("3")) {
					Loop: for (int j = 2; j < 4; j++) {
						int nx = start.x + moveX2[j];
						int ny = start.y + moveY2[j];

						if (nx < 1 || nx > n || ny < 1 || ny > m) {
							continue;
						}

						if (!map[nx][ny].equals(".") && visited[nx][ny] == 0) {
							visited[nx][ny] = 1;
							Point next = new Point(nx, ny);
							queue.offer(next);
						}
						if (map[nx][ny].equals(".") && visited[nx][ny] == 0) {
							resultN = nx;
							resultM = ny;
							break Loop;
						}
					}
				} else if (map[start.x][start.y].equals("1")) {
					Loop: for (int j = 0; j < 2; j++) {
						int nx = start.x + moveX2[j];
						int ny = start.y + moveY2[j];

						if (nx < 1 || nx > n || ny < 1 || ny > m) {
							continue;
						}

						if (!map[nx][ny].equals(".") && visited[nx][ny] == 0) {
							visited[nx][ny] = 1;
							Point next = new Point(nx, ny);
							queue.offer(next);
						}
						if (map[nx][ny].equals(".") && visited[nx][ny] == 0) {
							resultN = nx;
							resultM = ny;
							break Loop;
						}
					}
				} else if (map[start.x][start.y].equals("4")) {
					Loop: for (int j = 1; j < 3; j++) {
						int nx = start.x + moveX2[j];
						int ny = start.y + moveY2[j];

						if (nx < 1 || nx > n || ny < 1 || ny > m) {
							continue;
						}

						if (!map[nx][ny].equals(".") && visited[nx][ny] == 0) {
							visited[nx][ny] = 1;
							Point next = new Point(nx, ny);
							queue.offer(next);
						}
						if (map[nx][ny].equals(".") && visited[nx][ny] == 0) {
							resultN = nx;
							resultM = ny;
							break Loop;
						}
					}
				}

			}

			boolean nor = false, sou = false, eas = false, wes = false;
			if (resultN - 1 >= 1) {
				if (map[resultN - 1][resultM].equals("1") || map[resultN - 1][resultM].equals("4")
						|| map[resultN - 1][resultM].equals("+") || map[resultN - 1][resultM].equals("|")
						|| map[resultN - 1][resultM].equals("Z") || map[resultN - 1][resultM].equals("M"))
					wes = true;
			}
			if (resultM - 1 >= 1) {
				if (map[resultN][resultM - 1].equals("-") || map[resultN][resultM - 1].equals("+")
						|| map[resultN][resultM - 1].equals("1") || map[resultN][resultM - 1].equals("2")
						|| map[resultN][resultM - 1].equals("Z") || map[resultN][resultM - 1].equals("M"))
					sou = true;
			}
			if (resultM + 1 <= m) {
				if (map[resultN][resultM + 1].equals("-") || map[resultN][resultM + 1].equals("+")
						|| map[resultN][resultM + 1].equals("3") || map[resultN][resultM + 1].equals("4")
						|| map[resultN][resultM + 1].equals("Z") || map[resultN][resultM + 1].equals("M"))
					nor = true;
			}
			if (resultN + 1 <= n) {
				if (map[resultN + 1][resultM].equals("2") || map[resultN + 1][resultM].equals("3")
						|| map[resultN + 1][resultM].equals("+") || map[resultN + 1][resultM].equals("|")
						|| map[resultN + 1][resultM].equals("Z") || map[resultN + 1][resultM].equals("M"))
					eas = true;
			}

			if (wes && eas && !sou && !nor) System.out.print(resultN + " " + resultM + " |");
			if (sou && nor && !wes && !eas) System.out.print(resultN + " " + resultM + " -");
			if (sou && wes && eas && nor) System.out.print(resultN + " " + resultM + " +");
			if (nor && eas && !wes && !sou) System.out.print(resultN + " " + resultM + " 1");
			if (wes && nor && !sou && !eas) System.out.print(resultN + " " + resultM + " 2");
			if (wes && sou && !nor && !eas) System.out.print(resultN + " " + resultM + " 3");
			if (sou && eas && !wes && !nor) System.out.print(resultN + " " + resultM + " 4");
		}
	}
}