import java.io.*;
import java.util.*;
class pos{
	int r, c;
	pos(int r, int c){
		this.r = r; this.c = c;
	}
}

public class Main {


	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		
		
		int [][] maze = new int [N][M];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				maze[i][j] = str.charAt(j)-'0';
			}
		}
		
		bfs(maze);
		System.out.print(maze[N-1][M-1]);
		
		br.close();
	}
	public static void bfs(int [][] maze) {
		Queue<pos> q = new LinkedList<>();
		q.removeAll(q);
		pos nowpos = new pos(0,0);
		

		int n=1;
		maze[0][0]=1;
		q.add(nowpos);
		while(!q.isEmpty()) {
			nowpos = q.poll();
			
			if(nowpos.r == maze.length-1 && nowpos.c == maze[0].length-1)
				break;
			
			if(nowpos.r+1<maze.length && maze[nowpos.r+1][nowpos.c]==1) {
				q.add(new pos(nowpos.r+1, nowpos.c));
				maze[nowpos.r+1][nowpos.c]=maze[nowpos.r][nowpos.c]+1;
			}
			if(nowpos.c+1<maze[0].length && maze[nowpos.r][nowpos.c+1]==1) {
				q.add(new pos(nowpos.r, nowpos.c+1));
				maze[nowpos.r][nowpos.c+1]=maze[nowpos.r][nowpos.c]+1;
			}
			if(nowpos.c-1>-1 && maze[nowpos.r][nowpos.c-1]==1) {
				q.add(new pos(nowpos.r, nowpos.c-1));
				maze[nowpos.r][nowpos.c-1]=maze[nowpos.r][nowpos.c]+1;
			}
			if(nowpos.r-1>-1 && maze[nowpos.r-1][nowpos.c]==1) {
				q.add(new pos(nowpos.r-1, nowpos.c));
				maze[nowpos.r-1][nowpos.c]=maze[nowpos.r][nowpos.c]+1;
			}
			
		}
	}

}