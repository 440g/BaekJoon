import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> {
			int n1 = Math.abs(o1);
			int n2 = Math.abs(o2);
			
			if(n1==n2)
				return o1 > o2 ? 1 : -1; 
			return n1 - n2;
		});
		
		for(int i=0; i<num; i++) {
			int value = Integer.parseInt(br.readLine());
			if(value == 0) {
				if(heap.isEmpty()) {
					System.out.println(0);
					continue;
				}
				System.out.println(heap.poll());
				continue;
			}
			heap.add(value);
		}
		
				
		br.close();
	}

}