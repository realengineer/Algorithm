import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		boolean check = false;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = in.readLine().split(" ");
		int n = Integer.parseInt(arr[0]);
		int m = Integer.parseInt(arr[1]);
		int x = 0; int y = 0; int dir = 1;
		for(int i = 0; i< m; i++){
			arr = in.readLine().split(" ");
			if(dir == 1 && arr[0].equals("MOVE")){
				x += Integer.parseInt(arr[1]);
				if (x < 0 || x > n || y < 0 || y > n){
					System.out.print(-1);
					check = true;
					break;
				}
				continue;
			}
			if(dir == 2 && arr[0].equals("MOVE")){
				x -= Integer.parseInt(arr[1]);
				if (x < 0 || x > n || y < 0 || y > n){
					System.out.print(-1);
					check = true;
					break;
				}
				continue;
			}
			if(dir == 3 && arr[0].equals("MOVE")){
				y -= Integer.parseInt(arr[1]);
				if (x < 0 || x > n || y < 0 || y > n){
					System.out.print(-1);
					check = true;
					break;
				}
				continue;
			}
			if(dir == 4 && arr[0].equals("MOVE")){
				y += Integer.parseInt(arr[1]);
				if (x < 0 || x > n || y < 0 || y > n){
					System.out.print(-1);
					check = true;
					break;
				}
				continue;
			}
			if(dir == 1 && arr[0].equals("TURN") && arr[1].equals("0")){
				dir = 4;
				continue;
			}
			if(dir == 1 && arr[0].equals("TURN") && arr[1].equals("1")){
				dir = 3;
				continue;
			}
			if(dir == 2 && arr[0].equals("TURN") && arr[1].equals("0")){
				dir = 3;
				continue;
			}
			if(dir == 2 && arr[0].equals("TURN") && arr[1].equals("1")){
				dir = 4;
				continue;
			}
			if(dir == 3 && arr[0].equals("TURN") && arr[1].equals("0")){
				dir = 1;
				continue;
			}
			if(dir == 3 && arr[0].equals("TURN") && arr[1].equals("1")){
				dir = 2;
				continue;
			}
			if(dir == 4 && arr[0].equals("TURN") && arr[1].equals("0")){
				dir = 2;
				continue;
			}
			if(dir == 4 && arr[0].equals("TURN") && arr[1].equals("1")){
				dir = 1;
				continue;
			}
		}
		if(!check)
			System.out.print(x + " " + y);
	}
}
