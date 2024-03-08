import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		int[][] loc = new int[100][100];
		int res=0;
		
		for(int i=0; i<num; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int j=y; j<y+10; j++) {
				for(int k=x; k<x+10; k++) {
					loc[j][k] = 1;
				}
			}
		}
		
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(loc[i][j]==1) res+=1;
			}
		}
		System.out.println(res);
	}
}