import java.util.*;
import java.io.*;

public class Main {
	
	public static int getN(ArrayList <String> x) {
		HashSet<String> X = new HashSet<>();
		
		for(String s : x) {
			if(s.equals(x.get(0)))
			{X.add(s); continue;}
			
			boolean flag = false;
			for(String s2 : X) 
				if(s.startsWith(s2))
					{X.remove(s2);	break;}
			
			if(!flag)
				X.add(s);	
		}
		return X.size();
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList <String> x = new ArrayList<>();
		
		for(int i=0; i<n; i++) 
			x.add(br.readLine());

		Collections.sort(x, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				// TODO Auto-generated method stub
				return s1.length()-s2.length();
			}
		});

		System.out.print(getN(x));

		br.close();
	}
}
