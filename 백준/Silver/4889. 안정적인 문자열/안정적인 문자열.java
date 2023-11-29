import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int result = 0;
		int n = 1;
		while(true) {
			String str = br.readLine();
			
			if(str.contains("-"))
				break;
			
			Stack <Character> stack = new Stack<>();
			for(char c : str.toCharArray()) {
				if(c=='{')
					stack.push(c);
				else if(c=='}' && (stack.isEmpty() || stack.peek()!='{'))
					stack.push(c);
				else if(c=='}' && stack.peek()=='{')
					stack.pop();
			}
			if(!stack.isEmpty()) {
				int open=0, close=0;
				for(char c : stack) {
					if(c=='{')
						open++;
					else
						close++;
				}
				
				if(open%2==0)
					result += stack.size()/2;
				else
					result += 1 + stack.size()/2;
			}
			
			bw.append(Integer.toString(n) + ". " + Integer.toString(result));
			bw.newLine();
			n++; result=0;
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}