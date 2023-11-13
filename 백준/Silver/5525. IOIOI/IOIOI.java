import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		String S = s.next();
		
		int k=0;
		int count = 0;
		
		for (int i = 0; i < M; i++)
		{
			if (S.charAt(i) == 'I') {
				while (i < M-2 && S.charAt(i+1) == 'O' && S.charAt(i+2) == 'I') {
						k++;
						if (k == N)
						{
							k--;
							count++;
						}	
						i += 2;
				}
				k = 0;
			}
		}	
		System.out.print(count);
	}
}