import java.io.*;

class Node{
	int key;
	int left;
	int right;

	Node(int key, int left, int right){
		this.key = key; this.left=left; this.right=right;
	}

}
public class Main {
	public static Node[] nodeArr = new Node[27];
	
	static void VLR(Node node) {
		if(node==null) return;
		System.out.print((char)(node.key+'A'));
		VLR(nodeArr[node.left]);
		VLR(nodeArr[node.right]);
	}
	static void LVR(Node node) {
		if(node==null) return;
		LVR(nodeArr[node.left]);
		System.out.print((char)(node.key+'A'));
		LVR(nodeArr[node.right]);
	}
	static void LRV(Node node) {
		if(node==null) return;
		LRV(nodeArr[node.left]);
		LRV(nodeArr[node.right]);
		System.out.print((char)(node.key+'A'));
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int key, left, right;
		String str;
		int n26 = (int)('.'-'A');
			
		for(int i=0; i<n; i++) {
			str = br.readLine();
			key = (int)(str.charAt(0)-'A');
			left = (int)(str.charAt(2)-'A');
			if(left == n26)
				left=26;
			right = (int)(str.charAt(4)-'A');
			if(right == n26)
				right=26;
			nodeArr[key] = new Node(key, left, right);
		}
		
		VLR(nodeArr[0]);
		System.out.println();
		LVR(nodeArr[0]);
		System.out.println();
		LRV(nodeArr[0]);
		
		br.close();
	}

}