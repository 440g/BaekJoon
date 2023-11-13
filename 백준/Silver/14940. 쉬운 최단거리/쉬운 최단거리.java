import java.io.*;
import java.util.*;


class pos{
	int r, c;
	pos(int r, int c){
		this.r = r; this.c = c;
	}
}

public class Main {
	public static int dx[] = {0,0,1,-1};
	public static int dy[] = {1,-1,0,0};

	public static void bfs(int [][] maze, pos pos) {
		Queue<pos> q = new LinkedList<>();
		q.removeAll(q);
		pos nowpos = new pos(pos.r, pos.c);
		int n=0;
		
		q.add(nowpos);
		
		while(!q.isEmpty()) {
			nowpos = q.poll();
			
			for(int i=0; i<4; i++) {
				int nextX = nowpos.r + dx[i];
				int nextY = nowpos.c + dy[i];
				
		                if (nextX < 0 || nextY < 0 || nextX >= maze.length || nextY >= maze[0].length)
                		    continue;
        		        if (maze[nextX][nextY] != 1)
                    		continue;
                    
        		        
		                q.add(new pos(nextX, nextY));
		                maze[nextX][nextY] = maze[nowpos.r][nowpos.c] + 1;
			}
		}
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		pos pos = new pos(0,0);

		int [][] maze = new int [N][M];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				maze[i][j] = str.charAt(j*2)-'0';
				if (maze[i][j]==2)
					pos= new pos(i,j);
			}
		}
		
		
		bfs(maze, pos);
		
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(maze[i][j] != 0) {
					System.out.print(maze[i][j]-2 + " ");
					continue;
				}
				System.out.print(0 + " ");
			}
			System.out.println();
		}
		
		br.close();
	}


}