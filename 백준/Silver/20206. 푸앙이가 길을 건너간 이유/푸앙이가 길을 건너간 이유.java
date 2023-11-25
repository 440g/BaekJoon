import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int Z = Integer.parseInt(st.nextToken());
		if(Y<0)
			{X = -X;	Y = -Y;		Z = -Z;}
		int[] rect = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++)
			rect[i] = Integer.parseInt(st.nextToken());
		
		
		if(X>=0) {
			int val1 = (Y*rect[2]) + (X*rect[0]) + Z;
			int val2 = (Y*rect[3]) + (X*rect[1]) + Z;
			
			if(val1>=0 || val2<=0)
				System.out.print("Lucky");
			else
				System.out.print("Poor");
		}
		else {
			int val1 = (Y*rect[3]) + (X*rect[0]) + Z;
			int val2 = (Y*rect[2]) + (X*rect[1]) + Z;
			
			if(val1<=0 || val2>=0)
				System.out.print("Lucky");
			else
				System.out.print("Poor");
		}
		
		
		br.close();
	}

}
