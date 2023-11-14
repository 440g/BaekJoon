import java.io.*;
import java.util.*;
public class Main {
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static int findZ(int r, int c, int N) {
		int n=0;
		
		if(N==1)
			return 0;
		
	//2사분면: 0(N/2)*(N/2)
		if(r<N/2 && c<N/2) 
			n = findZ(r, c, N/2) + 0*(N/2)*(N/2);
		
	//1사분면: 1(N/2)*(N/2)
		else if(r<N/2 && c>=N/2) 
			n = findZ(r, c-N/2, N/2) + 1*(N/2)*(N/2);
		
	//3사분면: 2(N/2)*(N/2)
		else if(r>=N/2 && c<N/2) 
			n = findZ(r-N/2, c, N/2) + 2*(N/2)*(N/2);
		
	//4사분면: 3(N/2)*(N/2)
		else if(r>=N/2 && c>=N/2) 
			n = findZ(r-N/2, c-N/2, N/2) + 3*(N/2)*(N/2);
			
		return n;	
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		
		int N, r, c;
		
		N = Integer.parseInt(st.nextToken());
		N = (int) Math.pow(2, N);
		r= Integer.parseInt(st.nextToken());
		c= Integer.parseInt(st.nextToken());
		
		System.out.print(findZ(r, c, N));
		
		br.close();
	
	}
}
