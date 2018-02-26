import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
		public static void main(String[] args) throws NumberFormatException, IOException {
			// TODO Auto-generated method stub
			BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
			StringTokenizer token = new StringTokenizer( br.readLine() );
			int start = Integer.parseInt( token.nextToken() );
			int end = Integer.parseInt( token.nextToken() );
			StringBuffer sb = new StringBuffer();

			int[] num = new int[end+1];
			
			num[1] = 1;
			for(int i = 2; i <= end; i++){
				for(int j = 2; i * j <= end; j++)
					num[i * j] = 1;
			}
			
			for(int i = start; i <= end; i++)
				if(num[i] == 0)
					sb.append( i + "\n" );
			
			System.out.print( sb.toString() );

			
	}
}
