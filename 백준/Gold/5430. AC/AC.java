import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		ArrayDeque<Integer> array;
		
		
		boolean isReverse=false, error=false;
		int n;
		
		int num = Integer.parseInt(br.readLine());
		while(num-->0) {
			String str=br.readLine();
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), "[],");
			isReverse=false;
			error=false;
			
			array = new ArrayDeque<Integer>();
			for(int i=0; i<n; i++)
				array.add(Integer.parseInt(st.nextToken()));
			
			for(char op : str.toCharArray()) {
				if(op=='R') {
					isReverse=!isReverse;
					continue;
				}
				else if(op=='D') {
				if(!isReverse) 
					{if(array.pollFirst()==null) {sb.append("error\n"); error=true;break;}}
				else 
					{if(array.pollLast()==null) {sb.append("error\n"); error=true; break;}}
				}
			}
			if(!error)
				makeString(array, isReverse);
		}
		System.out.println(sb);
		br.close(); 
	}
	static void makeString(ArrayDeque<Integer>array, boolean isReverse) {
		sb.append('[');
		if(array.size()>0) {
			if(!isReverse) {
				sb.append(array.pollFirst());
				while(!array.isEmpty())
					sb.append(',').append(array.pollFirst());
			}
			else {
				sb.append(array.pollLast());
				while(!array.isEmpty())
					sb.append(',').append(array.pollLast());
			}
		}
		sb.append("]\n");
	}

}