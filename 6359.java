import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		while (tc-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int res = 0;
			boolean room[] = new boolean[n + 1];
			for (int round = 1; round <= n; round++) {
				for (int door = round; door <= n; door++) {
					if (door % round == 0) {
						if (room[door] == false) {
							res++;
							room[door] = true;
						} else {
							res--;
							room[door] = false;
						}
					}
				}
			}
			System.out.println(res);
		}
	}
}