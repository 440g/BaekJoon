import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, Stack<Integer>> guitar = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int move = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			Integer line = Integer.parseInt(st.nextToken());
			if(guitar.get(line)==null)
				guitar.put(line, new Stack<Integer>());
			
			Integer fret = Integer.parseInt(st.nextToken());
			
			//손가락 떼기
			while(!guitar.get(line).isEmpty() && guitar.get(line).peek()>fret) {
				move++;	
				guitar.get(line).pop();
			}
			
			//손가락 누르기
			if(guitar.get(line).isEmpty() || guitar.get(line).peek()<fret){
				move++; 
				guitar.get(line).push(fret); 
			}
			
		}
		
		System.out.print(move);
		
		br.close();
	}

}