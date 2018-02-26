import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int m;
	static int[] num;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = in.readLine().split(" ");
		n = Integer.parseInt(arr[0]);
		m = Integer.parseInt(arr[1]);
		num = new int[1000];
		dp = new int[1000][1000];
		
		for (int i = 0; i < n; i++)
			num[i] = Integer.parseInt(in.readLine());
		
		dp = new int[n+1][n+1];
		  for(int i=0; i<=n; i++)
		   for(int j=0; j<=n; j++)
		    dp[i][j] = -1;
		  
		  System.out.println(minLen(0,-1));
		  
	}
	public static int minLen(int line, int last) // n: 총 사람수, m: 노트의 총 가로 폭,  **노트의  세로폭 제한은 없다.
	 {
	  if(last >= n-1) return 0;	
  if(last>0 && dp[line][last]!=-1) return dp[line][last]; 
	  int len=0;
	  int subAnswer = 90000000;
	  for(int next=last+1; next<n ||  ( (m-len)<=num[next]&&(m-len)>=1 ) ; next++) // 다음 라인에 대한 부분해 
	  {
	   if(next==n-1)  return 0; //문제에서 마지막 줄(마지막 이름이 들어간 줄)의 여백은 제외하기로 했다
	   len += num[next];  	
	   subAnswer = Math.min( minLen(line+1, next) + (m-len)*(m-len), subAnswer );
	   if( (m-len-1) < num[next+1] ) //그다음을 수용할 수 없다면
	    break;
	   else
	    len++;  
	  }

	  if(last>0) dp[line][last] = subAnswer;
	  return  subAnswer;
	 }
}