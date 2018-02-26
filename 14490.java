import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] str = in.readLine().split(":");
		int a = Integer.parseInt(str[0]), b = Integer.parseInt(str[1]);
	
		int temp = 0;
		int tempb = b;
		int tempa = a;
		
		while(a != 0) {
			if( a < b) {
				temp = a;
				a = b;
				b = temp;
			}
			a = a - b;
		}
		System.out.print(tempa/b + ":" + tempb/b);
	}

}