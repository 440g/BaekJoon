import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int[][] mat = getMatrix();
		
		floyd(mat);
		
		sort(mat);
	}
	
	public static int[][] getMatrix() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] mat = new int[N][N];
		
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
				mat[i][j] = N*N;
		
		for(int i=0; i<M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st2.nextToken())-1;
			int c = Integer.parseInt(st2.nextToken())-1;
			mat[r][c] = mat [c][r] = 1;
		}
		
		br.close();
		return mat;
	}
	
	public static void floyd(int [][] mat) {
		int k, i, j;
		int size = mat.length;
		
		for(k=0; k<size; k++) {
			for(i=0; i<size; i++) {
				for(j=0; j<size; j++) {
					if(mat[i][j]==mat.length*mat.length && ((mat[i][k]>=1 && mat[k][j]>=1)))
						mat[i][j] = mat[i][k]+mat[k][j];
					if(mat[i][j]!=mat.length*mat.length && (mat[i][k]+mat[k][j] < mat[i][j]) && (mat[i][k]>=1 && mat[k][j]>=1))
						mat[i][j] = mat[i][k]+mat[k][j];
				}
			}
		}
	}

	public static void sort(int[][]mat) {
		double min = Double.POSITIVE_INFINITY;
		int val = 0;
		int index = 0;
		
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat.length; j++) {
				val += mat[i][j];
				
			}
			if(min>val) {
				min = val;
				index = i;
			}
			val=0;
		}
		
		System.out.print(index+1);
	}
	
}