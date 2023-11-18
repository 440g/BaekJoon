import java.io.*;
import java.util.*;

class numArray{
	int [] numAt;
	int length;
	int intVal;

	numArray(int n){
		String str = Integer.toString(n);
		this.numAt = new int[str.length()];
		for(int i=0; i<str.length(); i++)
			this.numAt[i] = str.charAt(i) - '0';
		
		this.length = str.length();
		
		this.intVal = Integer.parseInt(str);

	}
}

public class Main {
	public static void findChannel() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		numArray channel = new numArray(Integer.parseInt(br.readLine()));
		
		
		//1.	+-버튼으로만 찾는 경우
		int min = Math.abs(channel.intVal - 100);
		
		
		//1-1.	언제나 +-버튼으로 찾는 값이 더 작거나 같은 경우
		if(channel.intVal>=98 && channel.intVal<=103) {
			System.out.print(min);
			br.close();
			return;
		}
		
		int brokenNum = Integer.parseInt(br.readLine());
		//1-2.	버튼이 전부 고장난 경우
		if(brokenNum==10){
			System.out.print(min);
			br.close();
			return;
		}
		
		//2.	버튼 입력으로 찾는 경우
		//2-1.	버튼이 전부 고장나지 않은 경우
		if(brokenNum==0){
			min = channel.length;
			System.out.print(min);
			br.close();
			return;
		}
		
		//2-2.	버튼이 고장난 경우
		boolean find = true;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		boolean [] broken = {false,false,false,false,false,false,false,false,false,false};
		while(st.hasMoreTokens())
			broken[Integer.parseInt(st.nextToken())] = true;
		
		for(int i=0; i<channel.length; i++) {
			if(broken[channel.numAt[i]]){
				find = false;
		//2-2-1.	목표값보다 큰 수 중에 더 가까운 수가 있는 경우 탐색
				int upper = findUChannel(channel, broken, min, 1);
				if(upper != -1) //존재하면==기존 최솟값보다 작으면 -> 최솟값 변경
					min = upper;
				
		//2-2-2.	목표값보다 작은 수중에 더 가까운 수가 있는 경우 탐색
				int under = findUChannel(channel, broken, min, -1);
				if(under != -1) //존재하면==기존 최솟값보다 작으면 -> 최솟값 변경
					min = under;
	
				break;
			}
		}
		
        //2-2-3.	써야 할 버튼이 고장나지 않은 경우 저장
		if(find)
			min = channel.length;
		
		System.out.print(min);

		br.close();
	}
	
	public static int findUChannel(numArray channel, boolean[] broken, int min, int u) {

		//더 작은 최솟값 못 찾은 경우 -1 리턴
		int rv = -1;
		int i, n=0;
		
		numArray val = new numArray(channel.intVal+(0*u));
		for(i=1; i+val.length<=min; i++) {
			//못 찾은 경우 -1 리턴
			if(channel.intVal+(i*u) < 0)
				return rv;
			
			//더 작은 최솟값 찾은 경우 저장
			boolean find = true;
			val = new numArray(channel.intVal+(i*u));
			for(int j=0; j<val.length; j++) {
				if(broken[val.numAt[j]]) 
				{
					find = false;
					break;
				}
			}
			if(find) {
				rv = i + val.length;
				break;
			}
			
		}
		return rv;
	}

	public static void main(String[] args) throws IOException{
		findChannel();
	}

}
