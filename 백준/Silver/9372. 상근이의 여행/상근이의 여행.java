import java.io.*;
import java.util.*;

public class Main {
	static int T;
	static ArrayList<ArrayList<Integer>> graph;	
	public static void main(String[] args) throws Exception {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());

		for(int i=0; i<T; i++) {
        	graph = new ArrayList<>();
			st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			for(int j=0; j<=N; j++) 
				graph.add(new ArrayList<>());

			for(int j=0; j<M; j++) {
				st = new StringTokenizer(br.readLine()," ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph.get(a).add(b);
				graph.get(b).add(a);
			}
			bw.write((N-1) + "\n");	
		}
		bw.flush();		
		bw.close();
		br.close();
	}
}