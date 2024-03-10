import java.io.*;
import java.util.Arrays;
 
public class Main {
	public static void main(String[] args) throws IOException {
    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
 
		Arrays.sort(numbers);
		for(int n: numbers) {
			sb.append(n).append('\n');
		}
		System.out.println(sb);
	}
}