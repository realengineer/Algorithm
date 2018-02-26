import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int[][] visited;
	static Queue<Pair> q;
	static int[] px = {1,-1,0,0};
	static int[] py = {0,0,1,-1};
	static int n;
	static int m;
	static int count;
	static int ice;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n+2][m+2];
		visited = new int[n+2][m+2];
		q = new LinkedList<Pair>();
		for(int i = 0; i <n+2; i++)
		{
			Arrays.fill(map[i], -1);
		}
		for(int i = 1; i < n+1; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < m+1; j++)
			{
				int v = Integer.parseInt(st.nextToken());
				if(v>0){
					q.offer(new Pair(i,j,0));
					visited[i][j] = 1;
				}
				map[i][j] = v;
			}
		}
		count=1;
		int year = 0;
		while(count==1)
		{
			bfs(year);
			year++;
		}
		if(count == 0)
		{
			System.out.println(0);
		}
		else
		{
			System.out.println(year);
		}
	}
	public static void bfs(int _year)
	{
		while(!q.isEmpty())
		{
			int temp = q.peek().getCount();
			if(_year!=temp){
				visited = new int[n+2][m+2];
				count = 0;
				for(int i = 1; i<n+1; i++)
				{
					for(int j = 1; j<m+1; j++)
					{
						if(map[i][j]!= 0&&visited[i][j]==0)
						{
							bfs2(i,j);
							count++;
						}
					}
				}
				break;
			}
			Pair current = q.poll();
			int x = current.getX();
			int y = current.getY();
			int year = current.getCount();
			for(int i = 0; i<4; i++)
			{
				if(map[x+px[i]][y+py[i]]==0&&visited[x+px[i]][y+py[i]]==0)
				{
					map[x][y]--;
				}
			}
			if(map[x][y]<=0){
				map[x][y] = 0;
			}
			q.offer(new Pair(x,y,year+1));
			
		}
	}
	public static void bfs2(int _x, int _y)
	{
		 Queue<Pair> que = new LinkedList<Pair>();
		 que.offer(new Pair(_x, _y,0));
		 visited[_x][_y] = 1;
		 while(!que.isEmpty())
		 {
			 Pair current = que.poll();
			 int x = current.getX();
			 int y = current.getY();
			 for(int i = 0; i<4; i++)
			 {
				 if(map[x+px[i]][y+py[i]]!=0 && visited[x+px[i]][y+py[i]]!=1)
				 {
					 visited[x+px[i]][y+py[i]] = 1;
					 que.offer(new Pair(x+px[i],y+py[i],0));
				 }
			 }
		 }
	}
	
	static class Pair
	{
		int x;
		int y;
		int count;
		public Pair(int _x, int _y, int _count)
		{
			this.x = _x;
			this.y = _y;
			this.count = _count;
		}
		public int getX()
		{
			return this.x;
		}
		public int getY()
		{
			return this.y;
		}
		public int getCount()
		{
			return this.count;
		}
		
	}

}
