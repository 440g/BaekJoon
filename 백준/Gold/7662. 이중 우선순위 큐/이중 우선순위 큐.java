import java.util.*;
import java.io.*;

class  DoubleEndedPriorityQueue {
	PriorityQueue <Integer> minHeap = new PriorityQueue<>();
	PriorityQueue <Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
	HashMap <Integer, Integer> element = new HashMap<>();
	
	public int delete(int val) {
		if(element.size()==0) 
			return 0;
		
		int e=0;
		if(val==-1) 
			e = minHeap.poll();
		else if(val==1) 
			e = maxHeap.poll();
		
		int ecnt = element.getOrDefault(e, 0);
			
		if(ecnt == 0) {return this.delete(val);}
		if(ecnt == 1) {element.remove(e); return e;}
			
		element.put(e, element.get(e)-1);
		return e;
	}
	
	public void insert(int val) {
		minHeap.add(val);
		maxHeap.add(val);
		
		element.put(val, element.getOrDefault(val, 0)+1);		
	}

	@Override
	public String toString() {
		if(element.size()==0)
			return "EMPTY";
		int max = delete(1), min = max;
		if(element.size()>0)
			min = delete(-1);
		return max + " " + min;
	}	
}

public class Main{

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());	//테스트 케이스 수 
		
		for(int i=0; i<T; i++) {
			int k = Integer.parseInt(br.readLine());	//각 테스트 케이스의 연산 갯수
			DoubleEndedPriorityQueue depq = new DoubleEndedPriorityQueue();
			
			for(int j=0; j<k; j++) {
				StringTokenizer st= new StringTokenizer(br.readLine(), " ");
				char O = st.nextToken().charAt(0); //연산 종류
				int val = Integer.parseInt(st.nextToken()); //값
				
				if(O=='D')
					depq.delete(val);
				if(O=='I')
					depq.insert(val);
			}
			System.out.println(depq);
		}
		
		br.close();
	}

}
