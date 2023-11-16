import java.util.*;
import java.io.*;

class pos{
	int r, c;
	pos(int r, int c){
		this.r = r; this.c = c;
	}
}

public class Main {
	public static int dx[] = {0,0,1,-1};
	public static int dy[] = {1,-1,0,0};
	public static Queue<pos> q = new LinkedList<>();

	public static void bfs(int [][] tomato) {
		int max=0;
		pos nowpos;
		
		while(!q.isEmpty()) {
			nowpos = q.poll();
			for(int i=0; i<4; i++) {
				int nextX = nowpos.r + dx[i];
				int nextY = nowpos.c + dy[i];
				
		                if (nextX < 0 || nextY < 0 || nextX >= tomato.length || nextY >= tomato[0].length)
                		    continue;
        		        if (tomato[nextX][nextY] != 0 )
                    		continue;
        		        if(tomato[nowpos.r][nowpos.c]==0)
        		        {
        		        	q.add(new pos(nextX, nextY));
        		        	continue;
        		        }
        		        
		                q.add(new pos(nextX, nextY));
		                tomato[nextX][nextY] = tomato[nowpos.r][nowpos.c]+1;
		 
			}
		}
		
		for(int i=0; i<tomato.length; i++) {
			for(int j=0; j<tomato[0].length; j++) {
				if (tomato[i][j] == 0) {
					System.out.print(-1);
					return;
				}
				if(tomato[i][j]>max) {
					max = tomato[i][j];
				}
			}
		}
		System.out.print(max-1);
		
	}
	

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
 		
		int[][] tomato = new int[r][c];
		for(int i=0; i<r; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<c; j++) {
				tomato[i][j] = Integer.parseInt(st2.nextToken());
				if(tomato[i][j]==1)
					q.add(new pos(i,j));
			}
		}

		
		bfs(tomato);
		
		br.close();
	}

}
