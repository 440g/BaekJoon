import java.io.*;
import java.util.*;


class ListGraph{
	private ArrayList<ArrayList<Integer>> listGraph;
	
	public ListGraph (int initSize) {
		this.listGraph = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<initSize+1; i++) {
			listGraph.add(new ArrayList<Integer>());
		}
	}
	
	public ArrayList<ArrayList<Integer>> getGraph(){
		return this.listGraph;
	}
	
	public void putpos (int x) {
		listGraph.get(x).add(x+1);
		listGraph.get(x).add(x-1);
		listGraph.get(x).add(x*2);
	}
	
	public void bfs(int N) {
		Queue<Integer> q = new LinkedList<>();
		q.removeAll(q);
		int pos = N;
		int [] visited = new int [listGraph.size()*2];
		
		for(int i=0; i<visited.length; i++) {
			visited[i] = 0;
		}
		
		visited[pos] = 1;
		q.add(pos);
		while(!q.isEmpty()) {
			pos = q.poll();
			
			if(pos == listGraph.size()-1) {
				break;
			}
			
			if(pos+1<visited.length && visited[pos+1]==0)
			{
				q.add(pos+1);
				visited[pos+1] += visited[pos]+1;
			}
			if(pos-1 > -1 && visited[pos-1]==0)
			{
				q.add(pos-1);
				visited[pos-1] += visited[pos]+1;
			}
			if(pos*2<visited.length && visited[pos*2]==0)
			{
				q.add(pos*2);
				visited[pos*2] += visited[pos]+1;
			}
		}
		System.out.print(visited[pos]-1);
	}
}

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int tmp;
		
		if(N>=K) {
			System.out.print(N-K);
		}
		else {
			ListGraph g = new ListGraph(K);
			
			for(int i=0; i<g.getGraph().size(); i++) {
				g.putpos(i);
			}
		
			g.bfs(N);	
		}
		br.close();

		br.close();
	}

}