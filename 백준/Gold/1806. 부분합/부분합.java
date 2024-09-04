import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		int N = Integer.parseInt(st.nextToken()); 
		int S = Integer.parseInt(st.nextToken()); 
		int[] array = new int[N];
		
        st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0, right = 0, sum = 0;
		int MAX = 100000001;
		int result = MAX;
		
		while(left<=right) {
			if(sum >= S) {
				result = Math.min(result, right-left);
				sum -= array[left++];
			}else if(right==N) break;
			else{
				sum += array[right++];
			}
		}
        
		System.out.println(result==MAX?0:result);
	}
}