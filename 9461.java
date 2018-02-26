import java.util.Scanner;
 
public class Main{
    static int M,N;
    static int[][] wall;
    static int[][] visited;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        wall = new int[52][52];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                wall[i][j] = sc.nextInt();
            }
        }
        visited = new int[52][52];
        int[] space = new int[10001];
        int max = 0;
        int room = 0;
        int tmp = 0;
        int total = 0;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                tmp = 0;
                if(visited[i][j] == 0){
                    room += 1;
                    tmp = BFS(visited,i,j,room);
                    if(tmp > max)
                        max = tmp;
                    space[room] = tmp;
                     
                }
            }
        }
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(wall[i][j] != 0){
                    //동
                    if((wall[i][j] & 4) == 4){
                        if(visited[i][j] != visited[i][j+1]){
                            if(total < space[visited[i][j]] + space[visited[i][j+1]])
                                total = space[visited[i][j]] + space[visited[i][j+1]];
                        }
                    }
                    //서
                    if((wall[i][j] & 1) == 1){
                        if(visited[i][j] != visited[i][j-1]){
                            if(total < space[visited[i][j]] + space[visited[i][j-1]])
                                total = space[visited[i][j]] + space[visited[i][j-1]];
                        }
                    }
                    //남
                    if((wall[i][j] & 8) == 8){
                        if(visited[i][j] != visited[i+1][j]){
                            if(total < space[visited[i][j]] + space[visited[i+1][j]])
                                total = space[visited[i][j]] + space[visited[i+1][j]];
                        }
                    }
                    //북
                    if((wall[i][j] & 2) == 2){
                        if(visited[i][j] != visited[i-1][j]){
                            if(total < space[visited[i][j]] + space[visited[i-1][j]])
                                total = space[visited[i][j]] + space[visited[i-1][j]];
                        }
                    }
                     
                }
            }
        }
 
        System.out.println(room);
        System.out.println(max);
        System.out.println(total);
 
        sc.close();
    }
 
    static int BFS(int[][] visited,int startX,int startY,int number){
        Queue q = new Queue(20001);
        visited[startX][startY] = number;
        q.push(startX);
        q.push(startY);
        int cnt = 1;
         
        while(!q.isEmpty()){
            int newX = q.pop();
            int newY = q.pop();
             
            int direction = (byte)wall[newX][newY] ^ (byte)15;
            //System.out.println(direction);
            //서
            if(((byte)direction & (byte)1) == 1 && newY - 1 > 0 && visited[newX][newY-1] == 0){
                visited[newX][newY-1] = number;
                cnt += 1;
                q.push(newX);
                q.push(newY-1);
            }
            //북
            if(((byte)direction & (byte)2) == 2 && newX - 1 > 0 && visited[newX-1][newY] == 0){
                visited[newX-1][newY] = number;
                cnt += 1;
                q.push(newX-1);
                q.push(newY);
            }
            //동
            if(((byte)direction & (byte)4) == 4 && newY + 1 <= M && visited[newX][newY+1] == 0){
                visited[newX][newY+1] = number;
                cnt += 1;
                q.push(newX);
                q.push(newY+1);
            }
            //남
            if(((byte)direction & (byte)8) == 8 && newX + 1 <= N && visited[newX+1][newY] == 0){
                visited[newX+1][newY] = number;
                cnt += 1;
                q.push(newX+1);
                q.push(newY);
            }
        }
         
        return cnt;
    }
}
class Queue{
    private int front;
    private int rear;
    private int[] arr;
     
    public Queue(int size){
        front = -1;
        rear = -1;
        arr = new int[size];
    }
    public void push(int item){
        arr[++rear] = item;
    }
    public int pop(){
        return arr[++front];
    }
    public boolean isEmpty(){
        return(front==rear);
    }
}