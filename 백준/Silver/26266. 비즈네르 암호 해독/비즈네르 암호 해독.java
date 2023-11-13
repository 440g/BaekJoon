import java.util.*;

public class Main {
			public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		StringBuffer 평문 = new StringBuffer(s.next());
		StringBuffer 암호 = new StringBuffer(s.next());
		StringBuffer key = new StringBuffer();
		String a="";
		int n, size, cut=0;
		boolean isequal;
		int j=99;
		
		for(int i=0; i<평문.length(); i++) {
			n = (int)암호.charAt(i)-평문.charAt(i);
			if(n<=0)
				n +=26;
			key.insert(i, (char)(n+'A'-1));
		}//키 뽑아옴
		key.append(' ');
		
		n=0;
		for(int i=0; i<key.length()-1; i++) {
			if(((key.length()-1)%(i+1))==0) {
				size=i+1;
				n=(key.length()-1)/size;
				//System.out.println((i+1)+"개로 끊음," + n+"조각");
				//System.out.println("a0:"+key.substring(0, size));
				for(j=1; j<n; j++) {
					a = key.substring(size*j, size*(j+1));
					//System.out.println("a"+j+":"+a);
					isequal = (a.equals(key.substring(0, size)));
					if(!isequal) {	j=n+1;	cut=0;}
					else {cut=1;}
				}
				if(cut==1) {
					System.out.print(a);
					break;
				}
			}
		}
		if(cut==0)
			System.out.print(key);

		s.close();
	}

}