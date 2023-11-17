import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		int[][] graph = getGraph();
		
		floyd(graph);
		
	}
	
	public static int[][] getGraph() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		int [][] graph = new int [N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		br.close();
		
		return graph;
	}
	
	public static void printArray(int[][] graph) {
		for(int i=0; i<graph.length; i++) {
			for(int j=0; j<graph[0].length; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void floyd(int[][] graph) {
		int i, j, k;
		int size = graph.length;
		
		for(k=0; k<size; k++) 
			for(i=0; i<size; i++) 
				for(j=0; j<size; j++)
					if(graph[i][k]==1 && graph[k][j]==1)
						graph[i][j] = 1;

		printArray(graph);
		
	}	
}