import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int value = Integer.parseInt(br.readLine());
		int div=1000000;
		long result = 0;

		while(value>=0){
			result+=(value/2+1)%div;
			value-=3;
		}
		result%=div;
		System.out.print(result);
		
		
		br.close();
	}
}