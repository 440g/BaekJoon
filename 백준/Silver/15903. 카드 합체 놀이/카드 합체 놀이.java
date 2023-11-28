import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue <Long> pq = new PriorityQueue<>();
		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) 
			pq.add( Long.parseLong(st.nextToken()));
		
		for(int i=0; i<m; i++) {
			long val = pq.poll() + pq.poll();
			pq.add(val); pq.add(val);
		}
		
		long sum=0;
		while(!pq.isEmpty()) {
			sum += pq.poll();
		}
		
		System.out.print(sum);
			
		br.close();
	}
}