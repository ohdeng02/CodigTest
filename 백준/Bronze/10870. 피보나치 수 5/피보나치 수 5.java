import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
 
		int[] fibonacci = new int[N + 1];	// F(0) 부터 시작하므로 N + 1 크기 생성
 
		for(int i = 0; i < fibonacci.length; i++) {
			// F(0) 과 F(1) 은 각각 0 과 1 로 초기화
			if(i == 0) fibonacci[0] = 0;
			else if(i == 1) fibonacci[1] = 1;            
			else fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
		}
        
		System.out.println(fibonacci[N]);
 
	}
}