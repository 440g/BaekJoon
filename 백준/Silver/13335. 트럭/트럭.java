import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int []truck = new int [n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			truck[i] = Integer.parseInt(st.nextToken());
		}
		int sum=0, time = 0;
		Queue <Integer> queue = new LinkedList<>();
		for(int i=0; i<w; i++) {
			queue.add(0);
		}
		int i=0;
		while(!queue.isEmpty()) {
			int poll = queue.poll(); time++;
			sum -= poll; 
			//System.out.println("time "+time +" poll "+poll);
			
			
			while(i<n && sum+truck[i]>L) {
				queue.add(0);
				poll = queue.poll(); time++; 
				//System.out.println("time "+time +" poll "+poll);
				sum -= poll;
			}
			
			if(i<n)
				{queue.add(truck[i]); sum+=truck[i]; i++;}
				//System.out.println("time "+(time) +" add "+truck[i-1]+" sum "+sum);}
		}
		
		System.out.print(time);
		br.close();
	}
}