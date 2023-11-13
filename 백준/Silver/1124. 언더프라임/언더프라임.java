import java.io.*;
import java.util.Scanner;

public class Main {
	static boolean []prime;
	static void isPrime(int B) {
		prime = new boolean [B+1];
		
		for(int i=0; i<prime.length; i++) {
			prime[i] = true;
		}
		
		prime[0] = prime[1] = false;
		
		for(int i=0; i*i<=B;i++) {
			if(prime[i]) {
				for(int j=i*i; j<=B; j+=i)
					prime[j] = false;
			}
		}
	}
	static int factorization(int n) {
		int fact = 0;
		for(int i=2; i<=n; i++) {
			while(n!=0 && n%i==0) {
				n/=i;
				if(prime[i])
					fact++;
			}
		}
		return fact;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int A = s.nextInt();
		int B = s.nextInt();
		isPrime(B);
		int uP=0;
		
		
		for(int i=A; i<B+1;i++) {
			if(!prime[i]) {
				if(prime[factorization(i)]) 
					uP++;
			}
		}
		System.out.print(uP);
		
		
		s.close();
	}
	

}
