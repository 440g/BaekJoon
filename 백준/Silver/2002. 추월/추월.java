import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap <String, Integer> map = new HashMap<>();
		int result=0;
		int carN = Integer.parseInt(br.readLine());
		for(int i=0; i<carN; i++) {
			map.put(br.readLine(), i);
		}
		int []out = new int[carN];
		for(int i=0; i<carN; i++) 
			out[i] = map.get(br.readLine());
		
		for(int i=0; i<carN-1; i++) {
			for(int j=i+1; j<carN; j++) {
				if(out[j]<out[i])
					{result++; break;}
			}
		}
		System.out.print(result);
		
		br.close();
	}
}